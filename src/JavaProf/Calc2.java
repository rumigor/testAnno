package JavaProf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calc2 {
    static int a;
    static int b;
    static BufferedReader reader;
    @BeforeSuite
    public static void initialize() throws IOException {
        reader = new BufferedReader(new FileReader("C:\\Users\\LEP\\Documents\\Java\\testAnno\\src\\test.txt"));
        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());
    }
    @AfterSuite
    public static void finish() throws IOException {
        reader.close();
    }
    @Test(rating = 7)
    public static void minus() {
        System.out.println(a-b);
    }
    @Test(rating = 11)
    public static void multiply(){
        System.out.println(a*b);
    }
    @Test(rating = 4)
    public static void division(){
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("деление на ноль запрещено!");
        }
    }
    @Test(rating = 1)
    public static void power(){
        System.out.println(Math.pow(a, b));
    }

    @Test(rating = 7)
    public static void sqrtPlus(){
        System.out.println(Math.sqrt(a+b));
    }
}
