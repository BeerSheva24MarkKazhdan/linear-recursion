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
    public static long pow(int num, int degree){
        if (degree < 0) {
			throw new IllegalArgumentException();
		}
		int res = 1;
		if (degree > 0) {
            long powIn = pow(num, degree - 1);
			res = powIn < 0 ? multiply(-num, -powIn) : multiply(num, powIn);
		}
		return res;
    }

    private static int multiply(int a, long b) {
        return b == 0 ? 0 : a + multiply(a, b - 1);
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
        int res = 0;
        if (x < 0) {
            x = -x;
        }
        if (x > 0) {
            res = x + x - 1 + square(x - 1);
        }
        return res;
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
        boolean res = false;
		if (string.length() >= subString.length()) {
			res = isSubstringAtFirstPart(string, subString) ? 
					true : isSubstring(string.substring(1), subString);
		} 

		return res;

	}

	private static boolean isSubstringAtFirstPart(String str, String substr) {
		boolean res = false;
		if (substr.length() == 0) {
			res = true;
		} else if (str.charAt(0) == substr.charAt(0)) {
			res = isSubstringAtFirstPart(str.substring(1), substr.substring(1));
		}
		
		return res;
	}
}
