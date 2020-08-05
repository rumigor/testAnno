package JavaProf;


public class Calculator {
    int a;
    int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Test(rating = 3)
    public void add() {
        System.out.println(a+b);
    }
    @Test(rating = 1)
    public void multiply(){
        System.out.println(a*b);
    }
    @Test(rating = 2)
    public void division(){
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("деление на ноль запрещено!");
        }
    }
    @Test(rating = 4)
    public void power(){
        System.out.println(Math.pow(a, b));
    }


}
