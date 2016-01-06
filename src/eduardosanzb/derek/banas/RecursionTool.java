//package eduardosanzb.derek.banas;

public class RecursionTool {

    public static void main(String[] args) {
      RecursionTool recursion = new RecursionTool();

      System.out.println(recursion.getTriangularNumberR(6));
    }

    public void getTriangularNumber(int number){

    }

    public int getTriangularNumberR(int number){
      if( number == 1 ) return 1;
      else{
        return number + getTriangularNumberR(number - 1);
      } 
    }
}
