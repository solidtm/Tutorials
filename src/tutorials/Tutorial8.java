package tutorials;

public class Tutorial8 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int[] storage = new int[nums.length];
        boolean result = false;

        for(int i = 0; i < storage.length; i++){
            storage[i] = -1;
        }

        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];

            int index = isSeen(curr, storage);
            if(index != -1 && Math.abs(i - index) <= k){
                System.out.println(Math.abs(i - index));
                return true;
            }
            else storage[i] = curr;
        }

        return false;
    }

    public static int isSeen(int value, int[] storage){
        for(int i = 0; i < storage.length; i++){
            int curr = storage[i];
            if(curr == value) return i;
        }

        return -1;
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

