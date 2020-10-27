public class Problem9 {
    private static void recursiveSelectionSort(int[] array, int unsortedIndex, int size) {
        int min = findMinIndex(array, unsortedIndex, size, unsortedIndex);
        int temp = array[min];
        array[min] = array[unsortedIndex];
        array[unsortedIndex] = temp;
        unsortedIndex++;
        if(unsortedIndex < size)
            recursiveSelectionSort(array, unsortedIndex, size);
    }

    private static int findMinIndex(int[] array, int index, int size, int tempMinIndex) {
        if(index == size)
            return tempMinIndex;
        if(array[tempMinIndex] > array[index])
            return findMinIndex(array, index + 1, size, index);
        else
            return findMinIndex(array, index + 1, size, tempMinIndex);
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        recursiveSelectionSort(array, 0, array.length);
        for(int i: array){
            System.out.print(i + " ");
        }
    }
}
