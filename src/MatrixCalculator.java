import java.util.Scanner;

public class MatrixCalculator {
    private final static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        var calculator = new MatrixCalculator();
        calculator.menu();
    }

    public void menu() {
        while (true) {
            showMenu();
            System.out.print("Your choice: ");
            var userChoice = input.nextInt();
            calculating(userChoice);
        }
    }

    private void calculating(int userChoice) {
        switch (userChoice) {
            case 1:
                Matrix addMatrices = addMatricesProcess();
                System.out.println("The addition result is: ");
                System.out.println(addMatrices);
                break;
            case 2:
                Matrix sub = subMatricesProcess();
                System.out.println("Subtraction result: ");
                System.out.println(sub);
            case 3:
                Matrix multiplyMatrixByConst = multiplyMatrixByConstProcess();
                System.out.println("The multipication by constant result is: ");
                System.out.println(multiplyMatrixByConst);
                break;
            case 4:
                Matrix multMatrixByMatrix = multiplyMatrixByOtherMatrixProcess();
                System.out.println("The multiplication matrix by matrix result is: ");
                System.out.println(multMatrixByMatrix);
                break;
            case 5:
                transparentMenu();
                break;
            case 6:
                double det = detMatrixProcess();
                System.out.print("Result: ");
                System.out.println(det);
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Нет такого пункта");
        }
    }

    private void showMenu() {
        System.out.println("1. Add matrices");
        System.out.println("2. Sub matrices");
        System.out.println("3. Multiply matrix by a constant");
        System.out.println("4. Multiply matrices");
        System.out.println("5. Transpose matrix");
        System.out.println("6. Calculate a determinant");
        System.out.println("0. Exit");
    }

    private void transparentMenu() {
        showTransparentMenu();
        System.out.print("Your choice: ");
        var userChoice = input.nextInt();
        var matrix = createMatrix();

        System.out.println("The result is: ");
        switch (userChoice) {
            case 1:
                System.out.println(matrix.transpore.mainDiagonal());
                break;
            case 2:
                System.out.println(matrix.transpore.sideDiagonal());
                break;
            case 3:
                System.out.println(matrix.transpore.verticalDiagonal());
                break;
            case 4:
                System.out.println(matrix.transpore.horizontalLine());
                break;
            default:
                System.out.println("Нет такого пункта.");
                break;

        }

    }

    private void showTransparentMenu() {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
    }

    private Matrix addMatricesProcess() {
        var firstMatrix = createMatrix();
        var secondMatrix = createMatrix();
        return firstMatrix.addMatrices(secondMatrix);
    }

    private Matrix subMatricesProcess() {
        var firstMatrix = createMatrix();
        var secondMatrix = createMatrix();
        return firstMatrix.subMatrices(secondMatrix);
    }

    private Matrix multiplyMatrixByConstProcess() {
        var firstMatrix = createMatrix();
        System.out.print("Enter multiplication number: ");
        return firstMatrix.multiplyMatrixByConst(input.nextInt());
    }

    private Matrix multiplyMatrixByOtherMatrixProcess() {
        var firstMatrix = createMatrix();
        var secondMatrix = createMatrix();

        return firstMatrix.multiplyMatrixByMatrix(secondMatrix);
    }

    private double detMatrixProcess() {
        var matrix = createMatrix();

        return matrix.det();
    }

    private static Matrix createMatrix() {
        System.out.print("Enter matrix size: ");
        int rows = input.nextInt();
        int cols = input.nextInt();
        double[][] res = new double[rows][cols];

        System.out.println("Enter matrix:");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                res[row][col] = input.nextDouble();
            }
        }

        return new Matrix(res);
    }
}
