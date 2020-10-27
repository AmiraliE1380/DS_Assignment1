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
        int[][] matrix = new int[0][];
        return matrix;
    }
}
