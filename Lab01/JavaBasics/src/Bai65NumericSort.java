import java.util.Scanner;
import java.util.Arrays;

public class Bai65NumericSort {
    // Merge sort
    void merge(int array[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        // fill the left and right array
        for (int i = 0; i < n1; i++)
            L[i] = array[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = array[q + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) // ascending order
            {
                array[k] = L[i];
                i++;
            } else {
                array[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
    }

    // Divide the array into two sub arrays, sort them and merge them
    void mergeSort(int array[], int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            // recursive call to each sub arrays
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted sub arrays
            merge(array, left, mid, right);
        }
    }

    // Main method
    public static void main(String args[]) {

        Scanner key = new Scanner(System.in);
        // int[] array = { 15, 33, 132, 10, 9, 1, 5, 4 };

        System.out.println("Enter how many elements is in the array");
        int n = Integer.valueOf(key.nextLine());

        int[] arr = new int[n];

        System.out.println("Enter the array, each element is separated with a ' '(space):");
        

        for (int i = 0; i < arr.length; i++) {
            arr[i] = key.nextInt();
        }

        Bai65NumericSort merge_sort = new Bai65NumericSort();

        // Call mergeSort()
        merge_sort.mergeSort(arr, 0, arr.length - 1);

        //sum using Arrays.stream()
        int sum = Arrays.stream(arr).sum();

        // average
        int ave = sum / n; 


        // Output
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
        System.out.println("The sum of the array is "+sum+", average is "+ave);
        key.close();
    }
}
