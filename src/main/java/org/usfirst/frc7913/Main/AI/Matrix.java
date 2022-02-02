import java.lang.Math;

class Matrix {

    double[][] data;
    int rows, cols;

    public Matrix(int r, int c) {

        data = new double[r][c];
        rows = r;
        cols = c;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //Randomizes weights and biases
                data[i][j] = Math.random() * 2 - 1;
            }
        }
    }

    public void add(double scaler) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //add scaler to every item
                this.data[i][j] += scaler;
            }
        }
    }

    public void add(Matrix m) {
        if (cols != m.cols || rows != m.rows) {
            //We can't take invalid shapes, since some things won't correspond 
            // thus throwing an index out of bounds
            System.out.println("Shape Mismatch");
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //Add corresponding value to this one
                this.data[i][j] += m.data[i][j];
            }
        }
    }

    public static Matrix subtract(Matrix a, Matrix b) {

        Matrix temp = new Matrix(a.rows, a.cols);

        for (int i = 0, i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                //Set the temp value at that position to a's value minus b's value
                temp.data[i][j] = a.data[i][j] - b.data[i][j];
            }
        }
        return temp;
    }

    //Returns a copy of the Matrix
    public static Matrix transpose (Matrix a) {
        Matrix temp = new Matrix(a.cols, a.rows);

        for (int i = 0, i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {

                temp.data[i][j] = a.data[i][j];
            }
        }
        return temp;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        Matrix temp = new Matrix(a.cols, b.rows);

        for (int i = 0; i < temp.rows; i++) {
            for (int j = 0; j < temp.cols) {

                double sum = 0;

                for (int k = 0; k < a.cols; k++) {

                    sum += a.data[i][k] * b.data[k][j];
                }
                temp.data[i][j] = sum;
            }
        }
        return temp;
    }

    public void multiply(Matrix a) {
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                this.data[i][j] *= a.data[i][j];
            }
        }
    }

    public void multiply(double a) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] *= a;
            }
        }
    }

    public void sigmoid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp.data[i][j] = this.data[i][j] * (1 - this.data[i][j]);
            }
        }
    }

    public Matrix dsigmoid() {
        Matrix temp = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp.data[i][j] = this.data[i][j] * (1 - this.data[i][j]);
            }
        }
        return temp;
    }

    public static Matrix fromArray(double[] x) {
        Matrix temp = new Matrix(x.length,1);
        for (int i = 0; i < x.length; i ++) {
            temp.data[i][0] = x[i];
        }
        return temp;
    }

    public List<Double> toArray() {
        List<Double> temp = new ArrayList<Double>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp.add(data[i][j]);
            }
        }
        return temp;
    }
}