Based on [a tutorial by Suyash Sonawane](https://towardsdatascience.com/understanding-and-implementing-neural-networks-in-java-from-scratch-61421bb6352c), credit goes to her for most of the AI code.

# Matrix.java

Matrix.java is a Matrix class, with helper functions for adding, multiplying, subtracting, and running a sigmoid function, and a couple others. Matrices are essential to building neural networks, and Java doesn't natively have them

|Variable|Description|
|---|---|
|`double[][] data`|Stores the data in the matrix as a 2D array|
|`int rows`|The amount of rows in the matrix|
|`int cols`|The amount of columns in the matrix|

|Function|Description|
|---|---|
|`Matrix(int rows, int cols)`|Creates a new Matrix with the given amount of rows and columns. Creates random doubles in each position|
|`void add(Matrix m)`|Adds together the corresponding value in `m` and stores the result in the Matrix. Prints "Shape Mismatch" if the Matrices are not of the same size|
|`static Matrix subtract(Matrix a, Matrix b)`|Returns a Matrix of the result of all values of a - the corresponding value in b|
|`static Matrix transpose(Matrix a)`|Returns a copy of the given Matrix a|
|`static Matrix multiply(Matrix a, Matrix b)`|Returns the result of [multiplying together the two matrices](https://www.mathsisfun.com/algebra/matrix-multiplying.html)|
|`void multiply(Matrix a)`|[Multiply the matrix](https://www.mathsisfun.com/algebra/matrix-multiplying.html) by a|
|`void multiply(double a)`|[Multiply the matrix](https://www.mathsisfun.com/algebra/matrix-multiplying.html) by the given number a|
|`void sigmoid()`|Applies a sigmoid function to the matrix|
|`Matrix dsigmoid()`|Returns the result of a sigmoid function on the matrix|
|`static Matrix fromArray(double[] x)`|Returns a single-column matrix from the given array|
|`List<Double> toArray()`|Returns the Matrix as a `List<Double>`|

# NeuralNetwork.java

NeuralNetwork.java is a class for creating a neural network.

|Variable|Description|
|---|---|
|`Matrix weight_ih`|Weight matrix for the input to hidden layers|
|`Matrix weight_ho`|weight matrix for the hidden to output layers|
|`Matrix bias_h`|Bias for hidden layer|
|`Matrix bias_o`|Bias for output layer|
|`double l_rate`|The learning rate, a hyperparameter used to control the learning steps during optimization of weights|

|Function|Description|
|---|---|
|`NeuralNetwork(int i, int h, int o)`|Creates a new `NeuralNetwork`, with the size of the input layer being `i`, the size of the hidden layer being `h`, and the size of the output layer being `o`|
|`List<Double> predict(double[] X)`|Runs the given input array `X` through the neural network, returning the output layer as an array|
|`void train(double[] X, double[] Y)`|Trains the `NeuralNetwork` by giving it the input `X` and the desired output `Y`|
|void fit(double[][] X, double[][] Y, int epochs)|Trains the network the number of times given in epoch over random input `X`/output `Y` combos from the dataset, allows the neural network to take an average and train it down until it becomes incredibly precise|
