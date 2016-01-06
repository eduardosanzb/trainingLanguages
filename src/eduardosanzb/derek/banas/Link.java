package eduardosanzb.derek.banas;

public class Link {

  public Link next; //This Link to the next is always null
  public String bookName;
  public int millionSold;

  public Link(String bookName, int millionSold){
    this.bookName = bookName;
    this.millionSold = millionSold;
  }

  public void display(){
    System.out.println("The book: " + bookName + " was sold: " + millionSold + "000,000 times.");
  }

  public String toString(){
    return bookName;
  }

  /*With this main we are going to be testing and playing with the LinkedList in this tutorial*/
  public static void main(String[] args) { 
    LinkedList theLinkedList = new LinkedList();

    theLinkedList.insertfirstLink("Don Quixote", 500);
    theLinkedList.insertfirstLink("A Tale of Two Cities", 200);
    theLinkedList.insertfirstLink("The Lord of the Rings", 150);
    theLinkedList.insertfirstLink("Harry Potter and the Sorcerer's Stone", 107);
     
    theLinkedList.display();

    System.out.println("Value of first in LinkedList " + theLinkedList.firstLink + "\n");

    theLinkedList.removefirstLink();
    theLinkedList.display();
    theLinkedList.removeLink("A Tale of Two Cities");
    System.out.println("\nA Tale of Two Cities Removed\n");
    theLinkedList.display();

  }

}

/*This LinkedList will insert the new Link as the firstLink, so the last Link will be always pushed.*/
class LinkedList{
  public Link firstLink;

  public LinkedList(){
    this.firstLink = null;
  }

  public boolean isEmpty(){
    return( firstLink == null );
  }

  public void insertfirstLink(String bookName, int millionSold){
    Link newLink = new Link(bookName, millionSold);
    newLink.next = firstLink;
    firstLink = newLink;
  }

  public void removefirstLink(){
    if(!isEmpty()){
      firstLink = firstLink.next;
    } else {
      System.out.println("The LinkedList is Empty");
    }
  }

  public void display(){
    Link currentLink = firstLink;

    while(currentLink != null){
      currentLink.display();
      currentLink = currentLink.next;
    }
  }

  public Link find(String bookName){
    Link currentLink = firstLink;

    if (!isEmpty()) {
      while(currentLink.bookName != bookName){
        // Is this the last Link?
        if (currentLink.next == null) {
          return null;
        } else {
          currentLink = currentLink.next;
        }
      }
    } else {
      System.out.println("The LinkedList is Empty");
    }

    return currentLink;

  }

  public Link removeLink(String bookName){
    Link currentLink = firstLink;
    Link previousLink = firstLink;
    //We are gonna loop the whole LL
    while(currentLink.bookName != bookName){
      if(currentLink.next == null) return null;
      else {
        previousLink = currentLink;
        currentLink = currentLink.next;
      }
    }
    // If u are here is because the MATCH was in the firstLink
    if(currentLink == firstLink) firstLink = firstLink.next;
    else{
      previousLink.next = currentLink.next;
    }
      
    return currentLink;
    }
}