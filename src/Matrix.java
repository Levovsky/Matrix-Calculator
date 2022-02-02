public class Matrix extends AbstractMatrix {

    public Matrix(int rows, int cols) {
        super(rows, cols);
    }

    public Matrix(double[][] matrixArray) {
        super(matrixArray);
    }


    /**
     * Метод складывает две квадратные матрицы поэлементно.
     * Если матрица не является квадртаной выпадет исключение.
     * @param secondMatrix матрица с которой складывает
     * @return результат вычисления
     */
    public Matrix addMatrices(Matrix secondMatrix) {
        if (this.rows != secondMatrix.rows && this.cols != secondMatrix.cols) {
            throw new IllegalArgumentException("Размеры матриц не совпадают.");
        }

        var res = new double[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                res[row][col] = this.matrixArray[row][col] + secondMatrix.matrixArray[row][col];
            }
        }

        return new Matrix(res);
    }

    public Matrix subMatrices(Matrix secondMatrix) {
        var res = new double[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                res[row][col] = this.matrixArray[row][col] - secondMatrix.matrixArray[row][col];
            }
        }

        return new Matrix(res);
    }
    /**
     * Умножает матрицу на целочисленную константу.
     * @param constant целочисленная константа на которую надо умножить матрицу.
     * @return результат вычисления
     */
    public Matrix multiplyMatrixByConst(int constant) {
        var res = new double[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                res[row][col] = this.matrixArray[row][col] * constant;
            }
        }

        return new Matrix(res);
    }

    /**
     * Умножает матрицу на матрицу.
     * <p>
     *     Произведение матрицы A and B состоит из всех возможных комбинаций скалярных произведений вектор-строк
     *     и вектор столбцев.
     * </p>
     * @param otherMatrix - матрица на которую умножают
     * @return результат вычесления.
     */
    public Matrix multiplyMatrixByMatrix(Matrix otherMatrix) {
        if (this.cols != otherMatrix.rows) {
            throw new IllegalArgumentException("Количество столбцев первой матрицы не равны количеству строк второй");
        }

        var res = new double[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                res[row][col] = multiplyMatrixCell(otherMatrix, row, col);
            }
        }

        return new Matrix(res);
    }

    public double det() {
        if (this.matrixArray.length == this.matrixArray[0].length)
            return calcDet(this);

        return -1;
    }

    private double calcDet(Matrix matrix) {
        if (matrix.matrixArray.length == 2)
            return matrix.matrixArray[0][0] * matrix.matrixArray[1][1] - matrix.matrixArray[0][1] * matrix.matrixArray[1][0];

        double det = 0;
        for (int i = 0; i < matrix.matrixArray.length; i++) {
            if (i % 2 == 0)
                det += matrix.matrixArray[0][i] * calcDet(minor(matrix, i));
            else
                det -= matrix.matrixArray[0][i] * calcDet(minor(matrix, i));
        }

        return det;
    }

    private Matrix minor(Matrix matrix, int cols) {
        double[][] tmp = new double[matrix.matrixArray.length - 1][matrix.matrixArray.length - 1];

        int itmp = 0;
        int jtmp = 0;

        for (int row = 0; row < matrix.matrixArray.length; row++) {
            for (int col = 0; col < matrix.matrixArray.length; col++) {
                if (row != 0 && col != cols) {
                    tmp[itmp][jtmp] = matrix.matrixArray[row][col];
                    jtmp++;
                }
            }
            jtmp = 0;
            if (row != 0)
                itmp++;
        }

        return new Matrix(tmp);
    }

    /**
     * последовательное умножение каждого элемента каждой строки первой матрицы
     * на каждый элемент каждого столбца второй матрицы и сумма этих произведений.
     * @param secondMatrix вторая матрица
     * @param row количество строк матрицы
     * @param col количество столбцев матрицы
     * @return сумма произведений.
     */
    private double multiplyMatrixCell(Matrix secondMatrix, int row, int col) {
        double cell = 0;
        for (int j = 0; j < secondMatrix.getRows(); j++) {
            cell += this.matrixArray[row][j] * secondMatrix.getElement(j, col);
        }

        return cell;
    }



    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (var row : matrixArray) {
            for (var cell : row) {
                sb.append(String.format("%.2f", cell)).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }


}
