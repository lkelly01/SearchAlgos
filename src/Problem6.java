import java.util.Random;

public class Problem6 {
  
  public static void main(String[] args) {
    int[] randomArray = generateRandomArray();
    printArray(randomArray);
    int randomKey=generateRandomKey();
    System.out.println("The random key is " + randomKey);
    linearSearch(randomArray, randomKey);
    int[] sortedArray = selectionSort(randomArray);
    binarySearch(sortedArray, randomKey);
  }

    // random array
    public static int[] generateRandomArray() {
      Random random = new Random();
      int min = 1;
      int max = 50;
      int length = 20;
      int[] arr = new int[20];

      for(int i = 0; i<length;i++){
        arr[i]= random.nextInt(max-min) + min;
      }

      return arr;
    }

    // random key
    public static int generateRandomKey() {
      Random random = new Random();
      int min = 1;
      int max = 50;
      int key = random.nextInt(max-min) + min;

      return key;
    }

    // print array
    public static void printArray(int arr[]) {
      for(int i = 0; i < arr.length;i++){
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }

    // binary search
    public static int binarySearch(int[] list, int key) {
      int min = 0;
      int max = list.length - 1;
      while(max >= min){
          int mid = min+((max - min) / 2);
          if(list[mid] < key){
            min = mid + 1;
          } else if (list[mid] > key){
            max = mid - 1;
          } else if (list[mid] == key){
            System.out.println("Using binary search, the key " + key + " was found at index " + mid);
            return list[mid];
            
          }
      }
      System.out.println("Using binary search, the key " + key + " was not found in the array");
      return 0;
    }

    // linear search
    public static int linearSearch(int[] list, int key) {
     for(int i =0; i < list.length;i++){
        if(key == list[i]){
          System.out.println("Using linear search, the key " + key + " was found at index " + i);
          return list[i];
        }
     }
     System.out.println("Using linear search, the key " + key + " was not found in the array");
     return 0;
    }

    // selection sort
    public static int[] selectionSort(int arr[]) {
      for(int i =0; i < arr.length;i++){
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
          if(arr[minIndex]>arr[j]){
            minIndex = j;
          }
        }
        int smallTemp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = smallTemp;
     }
     return arr;
    }
}
