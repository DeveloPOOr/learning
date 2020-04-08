package exaple;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] mas = new Throwable().getStackTrace();
        String mass = "";
        if(mas.length < 3) {
            mass = null;
        }else {
            mass = mas[1].getClassName() + "#" + mas[2].getMethodName();
        }


        return mass; // your implementation here
    }
}
