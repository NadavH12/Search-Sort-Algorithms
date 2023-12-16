import java.util.Arrays;
public class ShellSort {

    public static void main(String[] args){
        int[] unsortedArray = {10,9,8,15, 7,6,5,4,3,2,1,0};
        unsortedArray = shellSort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
    }
    

    //(this is insertion sort but with stride length h instead of 1)
    //We re-run insertion sort with smaller and smaller h until h=1 and the array is 1-sorted
    public static int[] shellSort(int[] array){
        int arrayLength = array.length;
        int h = 1;
        //Compute starting h (largest h)
        while(h < arrayLength / 3){ 
            h = 3*h + 1;
        }

        while (h >=1){

            for(int i = h; i < array.length; i++){
                for (int j = i; j >= 1*h; j = j - h){            
                    
                    if(array[j] < array[j-h]){           
                        int temp = array[j];
                        array[j] = array[j-h];
                        array[j-h] = temp;
                    } 
                    else //h sort sequence is in decreasing order, break and move on to next h sort sequence
                        break;
                }
            }

            h = h / 3; //decrement h and h-sort with new value of h
        }
        return array;
    }
}
