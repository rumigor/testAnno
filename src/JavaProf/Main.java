package JavaProf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        start(new Calculator(3, 5));
        start(Calc2.class.getName());
    }

    private static void start(Object o) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = o.getClass().getDeclaredMethods();
        List<Method> methodList = new ArrayList<>();
        int bfs = 0;
        int afs = 0;
        for (Method m : methods) {
            if (m.getAnnotation(BeforeSuite.class) != null){
                bfs++;
            }
            else if (m.getAnnotation(AfterSuite.class) != null){
                afs++;
            }
            else methodList.add(m);
        }
        if (afs > 1 || bfs > 1) throw new RuntimeException();
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {method.invoke(o);}
        }
        boolean isSorted = false;
        Method buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < methodList.size()-1; i++) {
                if(methodList.get(i).getAnnotation(Test.class).rating() > methodList.get(i+1).getAnnotation(Test.class).rating()){
                    isSorted = false;
                    buf = methodList.get(i);
                    methodList.set(i, methodList.get(i+1));
                    methodList.set(i+1,buf);
                }
            }
        }
        for (Method method : methodList) {
            System.out.println(method.getName() + " rating " + method.getAnnotation(Test.class).rating());
            method.invoke(o);
        }
    }

    private static <T> void start(String className) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Method [] methods = Class.forName(className).getDeclaredMethods();
        List<Method> methodList = new ArrayList<>();
        int bfs = 0;
        int afs = 0;
        for (Method m : methods) {
            if (m.getAnnotation(BeforeSuite.class) != null){
                bfs++;
            }
            else if (m.getAnnotation(AfterSuite.class) != null){
                afs++;
            }
            else methodList.add(m);
        }
        if (afs > 1 || bfs > 1) throw new RuntimeException();
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {method.invoke(null);}
        }
        boolean isSorted = false;
        Method buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < methodList.size()-1; i++) {
                if(methodList.get(i).getAnnotation(Test.class).rating() > methodList.get(i+1).getAnnotation(Test.class).rating()){
                    isSorted = false;
                    buf = methodList.get(i);
                    methodList.set(i, methodList.get(i+1));
                    methodList.set(i+1,buf);
                }
            }
        }
        for (Method method : methodList) {
            System.out.println(method.getName() + " rating " + method.getAnnotation(Test.class).rating());
            method.invoke(null);
        }
        for (Method method : methods) {
            if (method.getAnnotation(AfterSuite.class) != null) {method.invoke(null);}
        }
    }
}
