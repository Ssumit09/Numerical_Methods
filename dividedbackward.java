import java.util.Scanner;

public class dividedbackward {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of data points: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Enter the data points (x, y):");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scanner.nextDouble();
            System.out.print("y[" + i + "]: ");
            y[i] = scanner.nextDouble();
        }

        System.out.print("Enter the value of x for which you want to find y: ");
        double targetX = scanner.nextDouble();

        double result = backwardInterpolation(x, y, targetX);

        System.out.println("Estimated value of y: " + result);
    }

    public static double backwardInterpolation(double[] x, double[] y, double targetX) {
        int n = x.length;
        double[][] dividedDifference = new double[n][n];
        double h = x[1] - x[0];

        // Fill in the divided difference table
        for (int i = 0; i < n; i++) {
            dividedDifference[i][0] = y[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = n - 1; i >= j; i--) {
                dividedDifference[i][j] = (dividedDifference[i][j - 1] - dividedDifference[i - 1][j - 1]) / (h * j);
            }
        }

        // Calculate the interpolated value
        double result = 0.0;
        double term = 1.0;
        for (int i = n - 1; i >= 0; i--) {
            result += term * dividedDifference[i][i];
            term *= (targetX - x[i]);
        }

        return result;
    }
}
