package JavaProf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calc2 {
    static int a;
    static int b;
    static int minusResult;
    static int multiplyResult;
    static int divisionResult;
    static double powerResult;
    static double sqrtPlusResult;
    static BufferedReader reader;
    @BeforeSuite
    public static void initialize() throws IOException {
        reader = new BufferedReader(new FileReader("C:\\Users\\LEP\\Documents\\Java\\testAnno\\src\\test.txt"));
        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());
        minusResult = Integer.parseInt(reader.readLine());
        multiplyResult = Integer.parseInt(reader.readLine());
        divisionResult = Integer.parseInt(reader.readLine());
        powerResult = Double.parseDouble(reader.readLine());
        sqrtPlusResult = Double.parseDouble(reader.readLine());
    }
    @AfterSuite
    public static void finish() throws IOException {
        reader.close();
    }
    @Test(rating = 7)
    public static boolean minus() {
        System.out.print(a-b + " ");
        return (a-b) == minusResult;
    }
    @Test(rating = 11)
    public static boolean multiply(){
        System.out.print(a*b + " ");
        return (a*b) == multiplyResult;
    }
    @Test(rating = 4)
    public static boolean division(){
        try {
            System.out.print(a / b + " ");
            return (a/b) == divisionResult;
        } catch (ArithmeticException e) {
            System.out.print("деление на ноль запрещено! ");
            return false;
        }
    }
    @Test(rating = 1)
    public static boolean power(){
        System.out.print(Math.pow(a, b) + " ");
        return Math.abs(Math.pow(a,b) - powerResult) < 0.0001;
    }

    @Test(rating = 7)
    public static boolean sqrtPlus(){
        try {
            System.out.print(Math.sqrt(a + b) + " ");
            return Math.abs(Math.sqrt(a + b) - sqrtPlusResult) < 0.0001;
        } catch (ArithmeticException e) {
            System.out.print("Квадратный корень отрицательного числа не является рациональным числом! ");
            return false;
        }
    }
}
