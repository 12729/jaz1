package lukasz;

/**
 * Created by LouL on 16.03.2016.
 */
import lukasz.Data;
import lukasz.Item;
import lukasz.Type;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public List<Item> calculate(Data Data) {
        if (Type.DECREASING.equals(Data.getInstallmentsType())) {
            return calculateDecreasingCreditInstallment(Data);
        } else {
            return calculateConstantCreditInstallment(Data);
        }
    }

    private List<Item> calculateDecreasingCreditInstallment(Data Data) {
        double balance = Data.getRequestedCreditAmount();
        List<Item> paymentsScheduleList = new ArrayList <>();
        for (int i = 0; i < Data.getInstallmentsNumber(); i++) {

            double d1 = ((((balance * Data.getRateOfInterest() * 0.01) * (Data.getInstallmentsNumber() / 12)) + Data.getRequestedCreditAmount()) / Data.getInstallmentsNumber());
            double d2 = (Data.getRequestedCreditAmount() / Data.getInstallmentsNumber());
            double d3 = (d1 - d2);
            balance -= d2;

            Item item = new Item();
            item.setInstallmentNumber(i + 1);
            item.setCapitalAmount(d2);
            item.setInterestAmount(d3);
            item.setFixedFee(Data.getFixedFee());
            item.setTotalPaymentsAmount(d1 + Data.getFixedFee());

            paymentsScheduleList.add(item);
        }

        return paymentsScheduleList;
    }

    private List<Item> calculateConstantCreditInstallment(Data Data) {
        double installment = calculateInstallment(Data.getRequestedCreditAmount(), Data.getInstallmentsNumber(), Data.getRateOfInterest());
        double capital = Data.getRequestedCreditAmount();

        List<Item> paymentsScheduleList = new ArrayList<>();
        for (int i = 0; i < Data.getInstallmentsNumber(); i++) {

            double interest = capital * Data.getRateOfInterest() * 0.01 / 12;
            capital = capital - installment + interest;

            Item item = new Item();
            item.setInstallmentNumber(i + 1);
            item.setCapitalAmount(installment - interest);
            item.setInterestAmount(interest);
            item.setFixedFee(Data.getFixedFee());
            item.setTotalPaymentsAmount(installment + Data.getFixedFee());

            paymentsScheduleList.add(item);
        }

        return paymentsScheduleList;
    }

    private double calculateInstallment(double creditAmount, int installmentsNumber, double rateOfInterest) {
        double q1 = rateOfInterest * 0.01 / 12;
        double q2 = 1;

        for (int i = 0; i < installmentsNumber; i++) {
            q2 = q2 * (1 + q1);
        }
        return creditAmount * q2 * q1 / (q2 - 1);
    }
}
