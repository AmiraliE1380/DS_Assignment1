public class DataGenerator {
    public static int[] generateArray() {
        int[] array = new int[100000001];
        for(int i = 0; i < 100000000; i++) {
            array[i] = i;
        }
        array[100000000] = 0;
        return array;
    }

    public static int[][] generateMatrix() {
        int[][] matrix = new int[10000][10000];
        int k = 0;
        for(int i = 0; i < 10000; i++) {
            for(int j = 0; j < 10000; j++) {
                matrix[i][j] = k++;
            }
        }
        matrix[9999][9999] = 0;
        matrix[9998][9998] = ++k;
        return matrix;
    }
}
