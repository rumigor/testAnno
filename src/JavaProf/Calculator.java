package JavaProf;


public class Calculator {
    int a;
    int b;
    int addResult;
    int multiplyResult;
    int divisionResult;
    double powerResult;

    public Calculator(int a, int b, int addResult, int multiplyResult, int divisionResult, double powerResult) {
        this.a = a;
        this.b = b;
        this.addResult = addResult;
        this.multiplyResult = multiplyResult;
        this.divisionResult = divisionResult;
        this.powerResult = powerResult;
    }


    @Test(rating = 3)
    public boolean add() {
        System.out.print(a+b + " ");
        return (a+b) == addResult;
    }
    @Test(rating = 1)
    public boolean multiply(){
        System.out.print(a*b + " ");
        return (a*b) == multiplyResult;
    }
    @Test(rating = 2)
    public boolean division(){
        try {
            System.out.print(a / b + " ");
            return (a/b) == divisionResult;
        } catch (ArithmeticException e) {
            System.out.print("деление на ноль запрещено! ");
            return false;
        }
    }
    @Test(rating = 4)
    public boolean power(){
        System.out.print(Math.pow(a, b) + " ");
        return Math.abs(Math.pow(a,b) - powerResult) < 0.0001;
    }


}
