package lukasz;

/**
 * Created by LouL on 16.03.2016.
*/
public class Item {

    private int installmentNumber;
    private double capitalAmount;
    private double interestAmount;
    private double fixedFee;
    private double totalPaymentsAmount;

    public Item() { }

    public Item(int installmentNumber, double capitalAmount, double interestAmount, double fixedFee, double totalPaymentsAmount) {
        this.installmentNumber = installmentNumber;
        this.capitalAmount = capitalAmount;
        this.interestAmount = interestAmount;
        this.fixedFee = fixedFee;
        this.totalPaymentsAmount = totalPaymentsAmount;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public double getCapitalAmount() {
        return capitalAmount;
    }

    public void setCapitalAmount(double capitalAmount) {
        this.capitalAmount = roundDouble(capitalAmount);
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = roundDouble(interestAmount);
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(double fixedFee) {
        this.fixedFee = roundDouble(fixedFee);
    }

    public double getTotalPaymentsAmount() {
        return totalPaymentsAmount;
    }

    public void setTotalPaymentsAmount(double totalPaymentsAmount) {
        this.totalPaymentsAmount = roundDouble(totalPaymentsAmount);
    }

    private double roundDouble(double variable) {
        return Math.round(variable * 100.0) / 100.0;
    }
}
