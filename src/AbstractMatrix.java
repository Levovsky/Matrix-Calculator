/**
 * Абстрактный класс представляющий сущность матрицы и дающий базовый функционал.
 */
public abstract class AbstractMatrix {
    protected double[][] matrixArray;
    protected int rows;
    protected int cols;
    protected TransporeMatrix transpore;


    public AbstractMatrix(int rows, int cols) {
        this(new double[rows][cols]);
    }

    public AbstractMatrix(double[][] matrixArray)
    {
        this.rows = matrixArray.length;
        this.cols = matrixArray[0].length;
        this.matrixArray = matrixArray.clone();
        this.transpore = new TransporeMatrix(matrixArray);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double[][] getMatrixArray() {
        return matrixArray;
    }

    public double getElement(int rowPos, int colPos) {
        return this.matrixArray[rowPos][colPos];
    }

}
