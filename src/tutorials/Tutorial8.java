package tutorials;

public class Tutorial8 {
    public static void main(String[] args) {

    }
}


/*
  Linked Lists - this is a  collection of values of similar data type consisting of nodes and pointers
*     Node - is a data you want to store in the collection
      pointer - is the reference to the next item in the collection
      head node - is the starting or first node in the linked list
      tail node - is the last node pointing to null in the list
                                                            n
   Singly linked list -> 1,2,3,4,5 =>   1 -> 2 -> 4 -> 5 -> 6 -> 7      //ind2 -> 4, Node next = 5
   Doubly linked list -> 1,2,3,4,5 =>   null <- 1 -> <- 2 -> 4 -> 5 -> null

   val = 0 -> 1
   [1 -> null]

   Types of LinkedLists
   1. Singly linked  lists -> one-directional
   2. Doubly linked lists -> bi-directional

 */

class Node {
    int value;
    Node next;
    Node prev;
}

