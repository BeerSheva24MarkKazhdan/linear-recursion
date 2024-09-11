package telran.util;

public class RecursionMethods {

    public static void f(int a) {
        if (a > 3) {
            f(a - 1);
        }
    }

    public static long factorial(int n) {
        // n! = 1 * 2 * 3 *.....*n
        if (n < 0) {
            n = -n;
        }
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    /**
     * 
     * @param num    - any integer number
     * @param degree - any positive number
     * @return num ^ degree
     *         limitations:
     *         1. no cycles allowed
     *         2. arithmetic operators + ; - are allowed only
     *         3. bitwise operators like >>, <<, &&, etc disallowe
     */
    public static long pow(int num, int degree) {
        if (degree < 0) {
            throw new IllegalArgumentException();
        }
        if (degree == 0) {
            return 1;
        }
        return (degree % 2 != 0 && num < 0) ? -multiplier(num, pow(num, degree - 1))
                : multiplier(num, pow(num, degree - 1));
    }

    private static long multiplier(long a, long b) {
        long absA = Math.abs(a);
        long absB = Math.abs(b);
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return absA;
        }
        return absA + multiplier(absA, absB - 1);
    }

    public static int sum(int[] array) {
        return sum(array, array.length);
    }

    private static int sum(int[] array, int length) {
        return length == 0 ? 0 : array[length - 1] + sum(array, length - 1);
    }

    /**
     * 
     * @param x
     * @return x ^ 2
     *         limitations:
     *         1. no cycles
     *         2. arithemetic operators only + ; -
     *         3. no bitwise operators
     *         4. no standard and additional methods are allowed
     *         5. no additional fields of the class RecursionMethods are allowed
     */
    public static int square(int x) {
        int absX = x;
        if (x < 0) {
            absX = -x;
        }
        if (absX == 0) {
            return 0;
        }
        return absX + (absX - 1) + square(absX - 1);
    }

    /**
     * 
     * @param string
     * @param subString
     * @return true if subString is actually substring of the given string
     *         limitations:
     *         1. no cycles
     *         2. the allowed methods of class String are
     *         2.1 charAt(int index)
     *         2.2 length()
     *         2.3 substring(int beginIndex)
     */
    public static boolean isSubstring(String string, String subString) {
        if (subString.length() > string.length()) {
            return false;
        }
        if (startString(string, subString)) {
            return true;
        }
        return isSubstring(string.substring(1), subString);
    }

    public static boolean startString(String string, String subString) {
        if (subString.length() == 0) {
            return true;
        }
        if (string.length() < subString.length()) {
            return false;
        }
        return string.charAt(0) == subString.charAt(0)
                ? startString(string.substring(1), subString.substring(1))
                : false;
    }
}
