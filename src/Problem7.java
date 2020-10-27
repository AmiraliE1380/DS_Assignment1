public class Problem7 {
    public static boolean find(int[] array) {
        int max = array[0], min1 = array[0], min2 = array[1], min3 = array[2], size = array.length;
        if(min1 > min2) {
            int temp = min2;
            min2 = min1;
            min1 = temp;
        }
        if(min2 > min3) {
            int temp = min2;
            min2 = min3;
            min3 = temp;
        }
        if(min1 > min2) {
            int temp = min2;
            min2 = min1;
            min1 = temp;
        }
        for(int i = 0; i < size; i++) {
            if(array[i] > max)
                max = array[i];
            if(array[i] <= min1 && i > 2) {
                int temp = min1;
                min1 = array[i];
                min3 = min2;
                min2 = temp;
            } else if(array[i] <= min2 && i > 2) {
                int temp = min2;
                min2 = array[i];
                min3 = min2;
            } else if(array[i] <= min3 && i > 2) {
                min3 = array[i];
            }
        }
        System.out.println(min1 + " " + min2 + " " + min3 + " " + max + "\n");
        return min1 + min2 + min3 < max;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{4, 4, 4, 4}));
    }
}
