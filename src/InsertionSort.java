public class InsertionSort {
    private void sort(int[] array, int size) {
        for (int i = 0, j; i < size; i++) {
            if(i != 0) {
                j = i - 1;
                while (j >= 0 && array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    j--;
                }
            }
        }
    }
}
