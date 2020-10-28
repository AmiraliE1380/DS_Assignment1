import java.util.Scanner;

public class MatrixPeakFinder {
    private final Scanner scanner;
    private int[][] matrix;
    private int size;
    private long startTime;

    public MatrixPeakFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        new MatrixPeakFinder(new Scanner(System.in)).run();
    }

    private void run() {
        matrix = DataGenerator.generateMatrix();
                // DataGenerator.generateMatrix();
        int rows = matrix.length;
        int columns = matrix[0].length;
        System.out.println("1.Linear search for peak\n2.Binary search for peak");
        int method = Integer.parseInt(scanner.nextLine());
        startTime = System.currentTimeMillis();
        if(method == 1)
            linearSearch(rows, columns);
        else
            binarySearch(rows, columns, columns / 2, 0, columns);

    }

    private void linearSearch(int rows, int columns) {
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++) {
                if((i == 0 && matrix[i][j] >= matrix[i + 1][j]) || (i == rows - 1 && matrix[i][j] >=
                        matrix[i - 1][j])) {
                    if (j == 0 && matrix[i][j] >= matrix[i][j + 1])
                        found(i, j);
                    else if (j == columns - 1 && matrix[i][j] >= matrix[i][j - 1])
                        found(i, j);
                    else if (matrix[i][j] >= matrix[i][j + 1] && matrix[i][j] >= matrix[i][j - 1])
                        found(i, j);
                } else if((j == 0 && matrix[i][j] >= matrix[i][j + 1]) || j == columns - 1 &&
                        matrix[i][j] >= matrix[i][j - 1]) {
                    if(matrix[i][j] >= matrix[i + 1][j] && matrix[i][j] >= matrix[i - 1][j])
                        found(i, j);
                } else if(i == 0 || i == rows - 1 || j == 0 || j == columns - 1) {
                    continue;
                } else {
                    if(matrix[i][j] >= matrix[i + 1][j] && matrix[i][j] >= matrix[i - 1][j] &&
                            matrix[i][j] >= matrix[i][j - 1] && matrix[i][j] >= matrix[i][j + 1])
                        found(i, j);
                }
            }
        }
    }

    private void found(int i, int j) {
        i++;
        j++;
        long spentTime = System.currentTimeMillis() - startTime;
        System.out.println("row = " + i + " column = " + j + "\nSpent time = " + spentTime);
        System.exit(0);
    }
    //All the methods below, belong to the binarySearch solution:
    private void binarySearch(int rows, int columns, int middle, int firstIndex, int lastIndex) {
        int maxMidIndex = findMaxInColumn(rows, middle, 0);
        if(middle == 0 || middle == columns - 1)
            found(maxMidIndex, middle);
        else if(matrix[maxMidIndex][middle] >= matrix[maxMidIndex][middle - 1] &&
                matrix[maxMidIndex][middle] >= matrix[maxMidIndex][middle + 1])
            found(maxMidIndex, middle);
        else if(matrix[maxMidIndex][middle] < matrix[maxMidIndex][middle - 1])
            binarySearch(rows, columns, (firstIndex + middle - 1) / 2, firstIndex, middle - 1);
        else
            binarySearch(rows, columns, (middle + lastIndex + 1) / 2, middle + 1, lastIndex);
    }
    private int findMaxInColumn(int rows, int column, int max) {
        int maxIndex = 0;
        for(int i = 0; i < rows; i++) {
            if(matrix[i][column] > max) {
                max = matrix[i][column];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
