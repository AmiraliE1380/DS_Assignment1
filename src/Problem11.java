public class Problem11 {
    private int[] array = {1, 3, 2, 16, 4, 6, 5, 7, 9, 9, 1, 12, 11, 13, 12, 55};
    private int[] peaksIndex;
    private int numOfPeaks = 0;
    private int n;

    public static void main(String[] args) {
        new Problem11().run();
    }

    private void run() {
        n = array.length;
        findPeaks(0);
        if(numOfPeaks <= Math.sqrt(n)) {
            InsertionSort.sort(array, n);
        } else if(numOfPeaks <= Math.pow(n, 0.75)) {

        }
        print(array);
    }

    private void findPeaks(int searchForPeaksFromThisIndex) {
        peaksIndex = new int[n];
        for(int i = searchForPeaksFromThisIndex; i < n; i++) {
            if(i == 0) {
                if(array[i] >= array[i + 1]) {
                    found(i);
                }
            }else if(i == n - 1) {
                if(array[i] >= array[i - 1]) {
                    found(i);
                }
            } else if(array[i] >= array[i - 1] && array[i] >= array[i + 1]) {
                found(i);
            }
        }
    }

    private void found(int index) {
        peaksIndex[numOfPeaks] = index;
        numOfPeaks++;
    }

    private void print(int[] array) {
        for(int i : array)
            System.out.print(i + " ");
    }
}
