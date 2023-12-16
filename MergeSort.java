import java.util.Arrays;
public class MergeSort{
    public static void main(String[] args){
        int[] unsortedArray = {10,9,8,15, 7,6,5,4,3,2,1,0};
        mergeSort(unsortedArray);
        System.out.println(Arrays.toString(unsortedArray));
    }
    

    //We want to pass merge lowIndex, middleIndex, and highIndex as parameters because we do this recursivly
    //meaning that we will do it for small subarrays of the original array, so we won't be able to use
    //0 as the low index and length as the high index for each merge call, only for the last one

    //So here in array we have an array with 2 individually sorted halves
    //What we want to do is merge the 2 halves so that we have the entire array (or subarray) sorted
    public static void merge(int[] array, int[] tempArray, int lowIndex, int middleIndex, int highIndex){
        tempArray = Arrays.copyOf(array, array.length);//tempArray stores the 2 individually sorted halves
        //                                             //We will write the merged sorted array to array[] (we overwrite it's values)
        
        int leftHalfPointer = lowIndex;
        int rightHalfPointer = middleIndex + 1;


        //Merge the 2 halves by comparison and write the sorted array in order to array[]
        for(int k = lowIndex; k <= highIndex; k++){
            
            if(leftHalfPointer > middleIndex){//If the leftHalfPointer is greater than the middle index then the left half is exhausted
                array[k] = tempArray[rightHalfPointer];//Take from right half
                rightHalfPointer+=1;//Increment rightHalfPointer
            }

            else if(rightHalfPointer > highIndex){//If the rightHalfPointer is greater than the high index then the right half is exhausted
                array[k] = tempArray[leftHalfPointer];//Take from left half
                leftHalfPointer+=1;//Increment left pointer
            }

            //Both halves still have elements remaining. Take the smaller element and increment that half's pointer
            else if(tempArray[rightHalfPointer] < tempArray[leftHalfPointer]){
                array[k] = tempArray[rightHalfPointer];
                rightHalfPointer+=1;
            } else {
                array[k] = tempArray[leftHalfPointer];
                leftHalfPointer+=1;
            }
        }
    }


    public static void mergeSort(int[] array, int[] tempArray, int lowIndex, int highIndex){
        if(highIndex <= lowIndex){
            return; //return void in case of array size = 0
        }
        
        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;//Calculate middleIndex

        mergeSort(array, tempArray, lowIndex, middleIndex); //Recursively sort low half
        mergeSort(array, tempArray, middleIndex + 1, highIndex); //Recursively sort high half

        merge(array, tempArray, lowIndex, middleIndex, highIndex); //merge the halfs
    }





    //initial call to merge sort, takes array to be sorted as parameter, 
    //creates temp array, calls merge sort passing it the 2 arrays and 0 and length as the high and low pointers
    public static void mergeSort(int[] array){
        int arrayLength = array.length;
        int[] tempArray = new int[arrayLength];
        mergeSort(array, tempArray, 0, arrayLength - 1);
    }
}