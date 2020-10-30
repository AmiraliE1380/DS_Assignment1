public class problem10 {
    private static void recursiveInsertionSort(int[] array, int size, int unsortedIndex) {
        if(unsortedIndex == size)
            return;
        shift(array, unsortedIndex);
        recursiveInsertionSort(array, size, unsortedIndex + 1);
    }

    private static void shift(int[] array, int index) {
        if(index > 0 && array[index - 1] > array[index]) {
            int temp = array[index];
            array[index] = array[index - 1];
            array[index - 1] = temp;
            shift(array, index - 1);
        }
        return;
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 87238, 92, 4, 3, 2, 1, 1, 8};
        recursiveInsertionSort(array, array.length, 0);
        for(int i : array)
            System.out.print(i + " ");
    }
}