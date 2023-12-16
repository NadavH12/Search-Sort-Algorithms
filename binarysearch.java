public class binarysearch {

     public static int binarySearch(int[] searchArray, int target){// target = element we are trying to find in the sorted array 
          int lowIndex = 0;
          int highIndex = searchArray.length - 1;        //Array must be sorted in order to use binary search
                                                     
          while(lowIndex <= highIndex){                            
               int middleIndex = lowIndex + (highIndex - lowIndex) / 2;      // Calculate middleIndex

               if (target < searchArray[middleIndex])                    // If target is smaller than middle element, our new high is middle - 1
                    highIndex = target - 1;
               else if (target > searchArray[target])               // If target is larger than middle element, our new low is middle + 1
                    lowIndex = target + 1;
               else 
                    return target;                       // middle must be = target so we return the index of target (middle) 
          }
          return -1; // Key doesn't reside in array, we return -1
     }






     public int recursive_search(int arr[], int key) {
          return recursive_search(arr, key, 0, arr.length - 1);
     }

     public int recursive_search(int arr[], int key, int low, int high) {
          if(low > high)
               return -1;

          int middle = (low + high) / 2;

          if(arr[middle] == key)
               return middle;
          if(arr[middle] < key)
               return recursive_search(arr, key, middle + 1, high);  // low = middle + 1; jmp recursive_search
          else
               return recursive_search(arr, key, low, middle -1);
     }

     public void recursive_search(int arr[]) {
          recursive_selection_sort(arr, 0, arr.length - 1);
     }

     public void recursive_selection_sort(int arr[], int low, int high) {
          if (low == high)
               return;

          int min = arr[low];
          
          for(int i=min+1; i <= high; i++)
               if(arr[min] > arr[i])
                    min = i;
          
          int t = arr[low];
          arr[low] = arr[min];
          arr[min] = t;

          recursive_selection_sort(arr, low+1, high);
     }
}


     

