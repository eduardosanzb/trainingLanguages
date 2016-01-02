package eduardosanzb.derek.banas;

public class ArrayStructures{
    
    private  int[] theArray = new int [50];
    private  int arraySize = 10;

    public void generateRandomArray(){
      for (int i=0; i < arraySize ; i++) {
        theArray[i] = (int)(Math.random()*10)+10;
      }
    }

    public void printArray(){
      System.out.println("----------");
      for (int i = 0; i < arraySize; i++) {
       System.out.print("| " + i + " |");
       System.out.println(theArray[i] + "|");
      }
      System.out.println("----------");
    }

      public int getValueAtIndex(int index){
        if(index < arraySize){
          return theArray[index];
        }
        return 0;
      }

      public boolean doesArrayContainsThisValue(int value){
        for (int i = 0; i < arraySize; i++) {
          if (theArray[i] == value) {
              return true;
          }
          return false;
        }
        return false;
      }

      public void deleteAtIndex(int index){
        if (index < arraySize) {
          for (int i = index; i < arraySize-1;i++) {
            theArray[i] = theArray[i+1];
          }
          arraySize--;
        }
      }

      public  void insertValue(int value){
        if (arraySize < 50) {
          theArray[arraySize] = value;
          arraySize++;
        } else {
          System.out.println("There are no more space in the Array.");
        }
      }

      public void insertValueAtIndex(int index, int value){
        if (arraySize < 50) {
          if (index < arraySize) {
            arraySize++;
            for (int i = arraySize-1; i > index ; i--) {
              theArray[i] = theArray[i-1];
            }
            theArray[index] = value;
          } else {
            theArray[arraySize] = value;
            arraySize++;
          }
        }else {
          System.out.println("There are no more space in the Array.");
        }
      }

      public void linearSearch(int value){
         boolean doesExist = false;
        System.out.print("Linear: The " + value + " is found in the index: ");
        for (int i = 0; i < arraySize; i++) {
          if (theArray[i] == value) {
            doesExist = true;
            System.out.print(i + ", ");
          }
        }
        System.out.println();

        if(!doesExist){
          System.out.println("Linear: value does not exist in the Array.");
        }
      }

      public void bubbleSort(String order){
        if (order.equals("desc")) {
          for (int i = arraySize-1; i > 1; i-- ) {
            for (int j = 0; j < i; j++) {
              if (theArray[j] > theArray[j+1]) {
                swapValues(j,j+1);
              }
            }
          }
        }else{
          for (int i = arraySize-1; i > 1; i-- ) {
            for (int j = 0; j < i; j++) {
              if (theArray[j] < theArray[j+1]) {
                swapValues(j,j+1);
              }
            }
          }

        }
      }

      public void binarySearch(int value){
        int minIndex = 0;
        int maxIndex = arraySize-1;
        while(minIndex <= maxIndex){
          int midIndex = ( maxIndex + minIndex ) / 2;
          if( theArray[midIndex] == value || midIndex == 0){
            if ( theArray[midIndex] == value ) System.out.println("\n Binary: The value is at the index: " + midIndex);
            else System.out.println("\n Binary: The value is not in the array."); 
            minIndex = maxIndex + 100;
          }
          else if(theArray[midIndex] < value ) minIndex = midIndex +  1;
          else if(theArray[midIndex] > value) maxIndex = midIndex - 1;
        }
      }

      public void selectionSort(){
        for (int i = 0; i < arraySize ; i++ ) {
          int lower = i;
          for (int j = i; j < arraySize; j++) {
            if( theArray[lower] > theArray[j]) lower = j;
            swapValues(i, lower);
          }
        }
      }

      public void insertSort(){
          for (int i = 1; i < arraySize; i++) {
            int j = i;
            int insertTo = theArray[i];
            while(j > 0 && theArray[j-1] > insertTo){
              theArray[j] = theArray[j-1];
              j--;
            }
            theArray[j] = insertTo;

          }
      }
    
    public void swapValues(int i, int j){
      int temp = theArray[i];
      theArray[i] = theArray[j];
      theArray[j] = temp;
    }
    public static void main(String[] args){
      ArrayStructures newArray = new ArrayStructures();
      newArray.generateRandomArray();
      newArray.printArray();
      System.out.println(newArray.getValueAtIndex(6));
      System.out.println(newArray.doesArrayContainsThisValue(20));
      newArray.deleteAtIndex(6);
      newArray.printArray();
      newArray.insertValue(22);
      newArray.printArray();

      newArray.insertValueAtIndex(1,100);
      newArray.printArray();
      newArray.linearSearch(12);
      //newArray.bubbleSort("desc");
      //newArray.printArray();
      ///newArray.binarySearch(9);

      newArray.insertSort();
      newArray.printArray();

    }
}