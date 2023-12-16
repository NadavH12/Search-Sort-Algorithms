import java.util.Arrays;
public class InsertionSort {

    public static void main(String[] args){
        int[] unsortedArray = {10,9,8,15, 7,6,5,4,3,2,1,0};
        unsortedArray = insertionSort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
    }

    //Assume array with no duplicates
    //Starting from a subarray of size = 1,
    //we swap adjacent elements until we see that the previous element is smaller than our current element
    //After that we break and then increment our subarray bounds until our subarray becomes the entire array
    public static int[] insertionSort(int[] array){

        for(int i = 0; i < array.length; i++){
            for (int j = i; j > 0; j--){                    //keep swapping adjacent elements while j > 0 and array[j] < array[j-1]

                if(array[j] < array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                } 
                
                
                else
                    break;
            }
        }
        return array;
    }
    
}
