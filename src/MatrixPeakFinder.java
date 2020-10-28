import java.util.Scanner;

public class MatrixPeakFinder {
    private final Scanner scanner;
    private int[][] matrix;
    private int size;

    public MatrixPeakFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        new MatrixPeakFinder(new Scanner(System.in)).run();
    }

    private void run() {
        matrix = new int[][]{
                {1, 2},
                {3, 8},
                {5, 6}
        };
                // DataGenerator.generateMatrix();
        System.out.println("1.Linear search for peak\n2.Binary search for peak");
        int method = Integer.parseInt(scanner.nextLine());
        if(method == 1)
            linearSearch();
        else
            binarySearch();

    }

    private void linearSearch() {
        int rows = matrix.length;
        int columns = matrix[0].length;
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
        System.out.println("row = " + i + " column = " + j);
        System.exit(0);
    }

    private void binarySearch() {
    }
}
