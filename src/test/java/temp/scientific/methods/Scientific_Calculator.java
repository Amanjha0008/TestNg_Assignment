package temp.scientific.methods;

public class Scientific_Calculator {
    Scientific_Calculator calc;
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
    public double squareRoot(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Can't calculate square root of a negative number");
        }
        return Math.sqrt(a);
    }

    public double power(double base, double exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be a non-negative number");
        }

        if (exponent == 0) {
            return 1; // Anything raised to the power of 0 is 1
        }
        double result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= base;  //result = result * base
            }
            base *= base;
            exponent /= 2;
        }
        return result;
    }

    public double sin(double angle) {
        angle = Math.toRadians(angle); //converting angle to radian

        double result = 0;
        int precision = 10;

        for (int i = 0; i < precision; i++) {
            result += (Math.pow(-1, i) / factorial(2 * i + 1)) * Math.pow(angle, 2 * i + 1);
        }

        return result;
    }

    public double cos(double angle) {
        // Convert angle to radians
        angle = Math.toRadians(angle);

        double result = 0;
        int precision = 10;

        for (int i = 0; i < precision; i++) {
            result += (Math.pow(-1, i) / factorial(2 * i)) * Math.pow(angle, 2 * i);
        }

        return result;
    }


    public double tan(double angle) {
        double sinValue = sin(angle);
        double cosValue = cos(angle);

        if (cosValue == 0) {
            throw new ArithmeticException("Tan is undefined for angle: " + angle);
        }

        return sinValue / cosValue;
    }

    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}


