import java.util.Arrays;
public class SelectionSort {


    public static void main(String[] args){
        int[] unsortedArray = {10,9,8,7,6,5,4,3,2,1,0};
        unsortedArray = selectionSort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
    }

    //Assume array with no duplicates
    public static int[] selectionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int minIndex = i;
            
            //Find smallest remaining element
            for(int j = i + 1; j < array.length; j++){
                System.out.println(array[j] + " - " + array[minIndex]);
                if(array[j] < array[minIndex])
                    minIndex = j;
            }

            //Swap smallest remaining element with array[i]
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
    
}
