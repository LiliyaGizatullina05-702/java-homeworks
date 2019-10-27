public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,4};
        mergeSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) { //копируем левую часть массива
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) { //копируем правую часть массива
            right[i - mid] = arr[i];
        }
        mergeSort(left, mid); //применяем эту функцию для левой половины массива (рекурсия)
        mergeSort(right, n - mid); //применяем эту функцию для правой половины массива

        merge(arr, left, right, mid, n - mid); // сливаем 2 отсортированных массива в 1
    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) { //функция для слияния двух массивов

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            }
            else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < left) {
            arr[k++] = leftArr[i++];
        }
        while (j < right) {
            arr[k++] = rightArr[j++];
        }
    }
}
