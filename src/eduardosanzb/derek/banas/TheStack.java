package eduardosanzb.derek.banas;

public class TheStack {
  private String[] theStack;
  private int top;
  private int arraySize;

  public TheStack(int size){
    this.theStack = new String[size];
    for (int i = 0; i < size; i++ ) {
      theStack[i] = "-1";
    }

    this.top = -1;
    this.arraySize = size;

  } 

  public void push(String line){
    if(top + 1 > arraySize){
      System.out.println("Sorry, but the Stack is full");
    } else {
      top++;
      theStack[top] = line;
    }
  }

  public void printStack(){
    System.out.println("---------");
    for(int i = arraySize-1; i >= 0; i--){
      System.out.print("| " + i + "|");
      if(theStack[i] == "-1") System.out.println(" |" + "  " + "|");
      else System.out.println(" |" + theStack[i] + "|");
      
    }
    System.out.println("---------");
  }

  public void pop(){
    if(top >= 0 ){

      System.out.println("The value " + theStack[top] + " was removed from the stack");
      theStack[top] = "-1";
      top--;
      printStack();
    } else System.out.println("The stack is empty");
  }

  public void peek(){
    System.out.println("The peek value is " + theStack[top] + " at index " + top);
  }

  public void popAll(){
    if(top >= 0 ){

      System.out.println("The Stack will be emptied");
      for (int i = 0; i < arraySize; i++) {
        pop();
      }

    } else {System.out.println("The stack is empty");}
  }

  public void pushMany(String line){
    String [] temp = line.split(" ");;
    for(int i = 0; i < temp.length; i++){
      push(temp[i]);
    }
  }


  public static void main(String[] args) {
      TheStack stack = new TheStack(10);

      stack.push("14");
      stack.push("3");
      stack.push("15");
      stack.printStack();
      stack.peek();
      stack.pop();
      stack.peek();
      stack.popAll();
      stack.pushMany("D E L I R I U M");
      stack.printStack();
    }
}
