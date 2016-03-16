package lukasz;

import lukasz.Type;
/**
 * Created by LouL on 16.03.2016.
 */
public class Data {

    private double requestedCreditAmount;
    private int installmentsNumber;
    private double rateOfInterest;
    private double fixedFee;
    private Type Type;

    public static final String requestedCreditAmountKey = "requestedCreditAmount";
    public static final String installmentsNumberKey = "installmentsNumber";
    public static final String rateOfInterestKey = "rateOfInterest";
    public static final String fixedFeeKey = "fixedFee";
    public static final String installmentsTypeKey = "installmentsType";


    public Data() { }

    public Data(double requestedCreditAmount, int installmentsNumber, double rateOfInterest, double fixedFee) {
        this.requestedCreditAmount = requestedCreditAmount;
        this.installmentsNumber = installmentsNumber;
        this.rateOfInterest = rateOfInterest;
        this.fixedFee = fixedFee;

    }

    public double getRequestedCreditAmount() {
        return requestedCreditAmount;
    }

    public void setRequestedCreditAmount(double requestedCreditAmount) {
        this.requestedCreditAmount = requestedCreditAmount;
    }

    public int getInstallmentsNumber() {
        return installmentsNumber;
    }

    public void setInstallmentsNumber(int installmentsNumber) {
        this.installmentsNumber = installmentsNumber;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(double fixedFee) {
        this.fixedFee = fixedFee;
    }

    public Type getInstallmentsType() {
        return Type;
    }

    public void setInstallmentsType(Type installmentsType) {
        this.Type = installmentsType;
    }
}


