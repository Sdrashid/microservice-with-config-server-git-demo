package microservicefdcalculator.fdcalculator.beans;

public class FDEntities {

    long amount;
    int years;
    float interestRate;

    public FDEntities(long amount, int years, float interestRate) {
        this.amount = amount;
        this.years = years;
        this.interestRate = interestRate;
    }

    public double getMaturityAmount(){
        double tempVar = 1 + (interestRate/100);
        double t = Math.pow(tempVar, years);
        return amount * t;
    }
}
