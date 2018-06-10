package FirstSemTasks;

public class RationalNumber {
    private int numerator, denominator;

    public RationalNumber(){
        setNumerator(1);
        setDenominator(1);
        simplfy();
    }

    public RationalNumber(int numerator, int denominator){
        setNumerator(numerator);
        setDenominator(denominator);
        simplfy();
    }

    //Getter and setters

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    //end of getters and setter


    //set the greatest common denominator
    static int gcd(int x, int y){
        int r;
        while (y != 0) {
            r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    //breaking the fraction down to its simplest form
    public void simplfy(){
        int divisor;
        divisor = RationalNumber.gcd(numerator, denominator);
        numerator = numerator / divisor;
        denominator = denominator / divisor;
    }

    //Adding two rational number objects
    public RationalNumber addTwoNumbers(RationalNumber a){
        int LCM = this.denominator * a.denominator; //a.get
        int newDenominator = LCM;
        int newNumerator = (this.numerator * a.denominator) + (a.numerator * this.denominator);

        return new RationalNumber(newNumerator, newDenominator);
    }

    //Subtracting two rational number objects
    public RationalNumber subtractTwoNumbers(RationalNumber a){
        int LCM = this.denominator * a.denominator;
        int newDenominator = LCM;
        int newNumerator;
        if (this.numerator > a.numerator){
            newNumerator = (this.numerator * a.denominator) - (a.numerator * this.denominator);
        }
        else {
            newNumerator = (a.numerator * this.denominator) - (this.numerator * a.denominator);
        }
        return new RationalNumber(newNumerator, newDenominator);
    }

    //Multiplying two rational number objects
    public RationalNumber multipleTwoNumbers(RationalNumber a){
        int newNumerator = a.numerator * this.numerator;
        int newDenominator = a.denominator * this.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    //Diving two rational number objects
    public RationalNumber divideTwoNumbers(RationalNumber a){
        int newDenominator = a.numerator * this.denominator;
        int newNumerator = a.denominator * this.numerator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public double convertToDouble(){
        return (double)numerator/denominator;
    }

    public String toString(){
        if (denominator == 1){
            return numerator + "";
        }else{
            return numerator + "/" + denominator;
        }
    }

    public void print(){
        System.out.println(toString());
    }
}
