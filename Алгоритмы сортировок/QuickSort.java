public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,4};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public static void quickSort(int[] array, int first, int last) {
        if (array == null || array.length == 0) return;

        if(first >= last) return;

        int midIndex = first + (last - first)/2;
        int midEl = array[midIndex];

        int i = first;
        int j = last;

        while (i <= j) {
            while (array[i] < midEl) { i++; }

            while (array[j] > midEl) { j--; }

            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }


        if (first < j) quickSort(array, first, j);
        if (last > i) quickSort(array, i, last);
    }
}
