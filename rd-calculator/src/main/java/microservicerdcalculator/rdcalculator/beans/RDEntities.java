package microservicerdcalculator.rdcalculator.beans;

public class RDEntities {

    long amount;
    int years;
    float interestRate;

    public RDEntities(long amount, int years, float interestRate) {
        this.amount = amount;
        this.years = years;
        this.interestRate = interestRate;
    }

    public double getMaturityAmount(){
        double tempVar = 1 + (interestRate/100);
        return amount * Math.pow(tempVar, years);
    }
}
