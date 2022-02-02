/**
 * Класс представляющий методы для транспорнированя матриц по разным осям
 */
public class TransporeMatrix {
    private final double[][] matrix;

    public TransporeMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Транспорнирование матрицы по главной диагонали.
     * @return - транспорнированя матрица.
     */
    public Matrix mainDiagonal() {
        double[][] transporedMatrix = new double[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                transporedMatrix[col][row] = matrix[row][col];
            }
        }
        return new Matrix(transporedMatrix);
    }

    public Matrix sideDiagonal() {
        double[][] transporedMatrix = new double[matrix.length][matrix[0].length];

        for (int row = matrix.length - 1, h = 0; row >= 0; h++, row--) {
            for (int col = matrix.length - 1, v = 0; col >= 0; v++, col--) {
                transporedMatrix[h][v] = matrix[col][row];
            }
        }

        return new Matrix(transporedMatrix);
    }

    public Matrix verticalDiagonal() {
        double[][] transporedMatrix = new double[matrix.length][matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = matrix.length - 1, v = 0; col >= 0; v++, col--) {
                transporedMatrix[row][v] = matrix[row][col];
            }
        }

        return new Matrix(transporedMatrix);
    }

    public Matrix horizontalLine() {
        double[][] transporedMatrix = new double[matrix.length][matrix.length];

        for (int row = matrix.length - 1, h = 0; row >= 0; h++, row--) {
            for (int col = 0; col < matrix.length; col++) {
                transporedMatrix[h][col] = matrix[row][col];
            }
        }

        return new Matrix(transporedMatrix);
    }
}
