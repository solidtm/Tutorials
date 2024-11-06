package tutorials;


public class Stack {
    protected class Node{
        int val;
        Node next;

        Node(int val){ this.val = val;}

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    Node topNode;
    Node bottomNode;
    int length;

    Stack(){
        this.topNode = null;
        this.bottomNode = null;
        this.length = 0;
    }

    public Node peek(){ return topNode; }

    public Stack push(int value){
        Node newNode = new Node(value);

        if (this.length == 0){
            System.out.println("Adding " + newNode.val);
            this.topNode = newNode;
            this.bottomNode = newNode;
        }else{
            System.out.println("Adding " + newNode.val);
            Node previousTop = this.topNode;
            this.topNode = newNode;
            this.topNode.next = previousTop;
        }

        this.length++;
        return this;
    }

    public Stack pop(){
//        If there is nothing in the stack, return null
        if (this.topNode == null){
            return null;
        }

//        If there is only one item in the stack
        if (this.topNode == this.bottomNode){
            System.out.println("Removing " + topNode.val);
            this.bottomNode = null;
            this.topNode = null;
            this.length--;
            return null;
        }

        System.out.println("Removing " + topNode.val);
        this.topNode = this.topNode.next;
        this.length--;
        return this;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void toStr() {
        System.out.println("Stack values: ");
        Node currNode = topNode;
        int count = 0;

        while(count != this.length){
            System.out.println(currNode.val);
            currNode = currNode.next;
            count++;
        }

        System.out.print("END\n");
    }

}
