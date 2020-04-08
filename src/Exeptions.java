import java.util.Arrays;

class MyExceptions {
    public static double sqrt(double x) throws java.lang.IllegalArgumentException {

        if (x < 0) {
            throw new java.lang.IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x);
    }

}




