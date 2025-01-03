package tutorials;


//    *
//     * Definition for singly-linked list.

public class LinkedList {
    private Node<Integer> head;
    private Node<Integer> tail;
    private int size;


    public int size(){
        return size;
    }

//    insert at front of the linked list
    public void insertFirst(int val) {
        Node<Integer> node = new Node<>(val); //create a node with the value you want to insert
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }

//    insert at tail
    public void insertLast(int val) {
        if(tail == null){
            insertFirst(val);  //O(1)
            return;
        }

        Node<Integer> node = new Node<>(val); //O(1)
        tail.next = node;
        tail = node;
        size++;
    }

    //insert at particular index
    public void insert(int val, int index) {
        if(index == 0){
            insertFirst(val); //O(1)
            return;
        }if(index == size){
           insertLast(val); //O(1)
           return;
        }

        Node temp = head;  //O(n) where n is the size of the linked list - 1
        for (int i = 1; i < index && temp != null; i++) {
            temp = temp.next;
        }

        assert temp != null;
        Node node = new Node(val, temp.next); //O(1)
        temp.next = node;
        size++;
    }

    public void insertRecursive(int val, int index){
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    public int deleteFirst(){
        int val = head.val;
        head = head.next;

        if(head == null){
            tail = null;
        }
        size--;

        return val;
    }

    public int deleteLast(){
        if(size <= 1) return deleteFirst();

        Node secondLast = get(size - 2);   //node points to the second last item in the ist
        int val = tail.val;
        tail = secondLast;
        tail.next = null;

        return val;
    }

    public int delete(Integer index){
        if(index == 1) return deleteFirst();
        if(index == size - 1) return deleteLast();

        Node<Integer> previous = get(index - 1);   //node points to the previous index before the index in the ist
        Integer val = (Integer) previous.next.val;
        previous.next = previous.next.next;

        return val;
    }

    public Node get(int index){   //gets the node at any index.
       Node node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }


    public Node<Integer> find(int val){   //gets the node at any index.
        Node<Integer> node = head;

        while(node != null){
            if(node.val == val){
                return node;
            }

            node = node.next;
        }

        return null;
    }

//   display the linkedList
    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
