import java.util.Arrays;
public class QuickSort {

    public static void main(String[] args){
        int[] array ={17,4,18,3,8,1,10,7,2};
        int lowIndex = 0;
        int highIndex = array.length - 1; 
        sort(array, lowIndex, highIndex);
        System.out.println(Arrays.toString(array));
    }


    public static void sort(int[] array, int low, int high){
        if(low < high){

            // swapping low and high pointer values until low and high pointers meet
            // the location where the low and high pointers meet is partitionIndex 
            int partitionIndex = partition(array, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            sort(array, low, partitionIndex-1);
            sort(array, partitionIndex+1, high);
        }
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */

    //Finds the right location of the pivot element, and places all smaller elements before it sorted   
    public static int partition(int array[], int low, int high){
        int pivot = array[high];
        int i = (low-1); // index of smaller element

        for (int j=low; j<high; j++){
            // If current element is smaller than or
            // equal to pivot, swap array[i] and array[j]
            if (array[j] <= pivot){
                i++;    
                exchange(array,i,j);
            }
        }
    
        // swap arr[i+1] and arr[high] (or pivot)
        exchange(array,i+1,high);
        return i+1;
    }




    public static void exchange(int array[], int a, int b){
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
}











