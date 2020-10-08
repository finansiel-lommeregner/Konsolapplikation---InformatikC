
package models;
public class FinancialModels {

    public double calculateInterest(double futureCapital, double presentCapital, double periods) {
        return -1+Math.pow((futureCapital/presentCapital),(1/periods));       
        /* r = (K_n/K_0)^(1/n) - 1 */
    }   
    
    public double calculatePresentCapital(double futureCapital, double interest, double periods) {
        double result = futureCapital/Math.pow((1+interest),periods);
        return result;
        /* 𝐾_0 =(K_n)/((1+r)^n)*/
    }
    
    public double calculateFutureCapital(double presentCapital, double interest, double periods) {
        double result = presentCapital*Math.pow((1+interest),periods);
        return result;
        /* 𝐾_n = K_0 *(1+r)^n*/
    }
    
    public double calculatePeriods(double futureCapital, double presentCapital, double interest) {
        double result;
        result = (Math.log(futureCapital/presentCapital))/(Math.log(1+interest));
        return result;
        /* n = (ln(K_n/K_0))/ln(1+r)*/
    }    
    
    public double calculateAnnuitetsopsparing(double payRate, double interest, double periods) {
        double result;
        result = payRate*((Math.pow((1+interest),periods) - 1)/interest);
        return result;
        /* A_n = y*((1+r)^n - 1)/r) */
    }    
}
