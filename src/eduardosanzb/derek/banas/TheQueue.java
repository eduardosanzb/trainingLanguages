package eduardosanzb.derek.banas;

import java.util.Arrays;

public class TheQueue {

  private String[] queueArray;
  private int queueSize;
  private int front, rear, numberOfItems = 0;

  public TheQueue(int size){
    queueSize = size;
    queueArray = new String[size];

    Arrays.fill(queueArray, "-1");
  }

  public void insert(String input){
    if(numberOfItems + 1 <= queueSize){
      queueArray[rear] = input;
      rear++;
      numberOfItems++;
      System.out.println("INSERT: " + input + " Was Added to the Queue");
    } else System.out.println("Sorry but the Queue is now full");
  }

  public void remove (){
    if (numberOfItems > 0) {
      System.out.println("DELETE: " + queueArray[front] + " was removed from the Queue.");
      queueArray[front] = "-1";
      front++;
      numberOfItems++;
    } else System.out.println("The Queue is empty");
  }

  public void peek(){
    System.out.println("The First element is " + queueArray[front]);
  }

  public void printQueue(){
    System.out.println("---------");
    for(int i = queueSize-1; i >= 0; i--){
      System.out.print("| " + i + "|");
      if(queueArray[i] == "-1") System.out.println(" |" + "  " + "|");
      else System.out.println(" |" + queueArray[i] + "|");
      
    }
    System.out.println("---------");
  }

  public void priorityInsert(String input){
    int i;
    if (numberOfItems == 0) {
      insert(input);
    } else {
      for (i = numberOfItems - 1; i >=0; i--) {

        if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])){

           queueArray[i + 1] = queueArray[i];

        } else break;

      }
      queueArray[i+1] = input;
      rear++;
      numberOfItems++;
    }
  }
    public static void main(String[] args) {
      TheQueue queue = new TheQueue(10);

      queue.insert("10");
      queue.insert("13");
      queue.insert("4");
      queue.priorityInsert("9");

      queue.printQueue();
      queue.peek();
      

    }
}
