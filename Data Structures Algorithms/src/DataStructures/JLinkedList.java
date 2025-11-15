package DataStructures;

public class JLinkedList<T> implements ArrayInterface<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public JLinkedList () {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    @Override
    public T get(int index) {
        Node<T> iterNode = this.head;
        int positonPointer = 0;

        while (null != iterNode) {
            if (positonPointer == index) {
                return iterNode.getData();
            }
            iterNode = iterNode.getNext();
            positonPointer++;
        }

        throw new ArrayIndexOutOfBoundsException("Index out of bounds | Size : " + this.size);
    }

    public T peek () {
        if (null == this.tail) throw new RuntimeException("List is empty");
        return this.tail.getData();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (null != this.head) {
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else {
            this.head = newNode;
            this.tail = newNode;
        }
        size++;
        newNode = null;
    }

    public T remove (int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Unable to perform removal, Index out of bounds");
        }

        Node<T> iterNode = new Node<>(null);
        iterNode.setNext(this.head);
        int pointer = 0;
        while (pointer < index) {
            iterNode = iterNode.getNext();
            pointer++;
        }

        T value = null;
        if (iterNode.hasNext()) {
            value = iterNode.getNext().getData();
            iterNode.setNext(iterNode.getNext().getNext());
            if (index == 0) {
                this.head = this.head.getNext();
            }
        }
        this.size--;
        return value;
    }

    /***
     * removes last element of the linked list
     */
    public T pop () {
        Node<T> iterNode = this.head;

        while (iterNode.getNext().hasNext()) {
            iterNode = iterNode.getNext();
        }

        iterNode.setNext(null);
        T value = this.tail.getData();
        this.tail = iterNode;
        this.size--;
        return value;
    }
}


class Node <T> {
    T data;
    Node<T> next;

    public Node (T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext () {
        return null != this.next;
    }

    public static void main(String[] args) {
        JLinkedList<Integer> linkedList = new JLinkedList<>();

        // ---------------------- add
        for (int i = 0; i < 7; i++) {
            linkedList.add(i * 4 - 3);
        }

        // ---------------------- get
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " | ");
        }

        // ---------------------- Pop
        System.out.println("Peek :: " + linkedList.peek());
        System.out.println("Pop :: " + linkedList.pop());

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " | ");
        }

        System.out.println("Peek :: " + linkedList.peek());

        // ------------- Removal at Index
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " (" + i + ") | ");
        }

        System.out.println("Remove :: " +linkedList.remove(5));
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " (" + i + ") | ");
        }

        System.out.println("Remove :: " +linkedList.remove(0));
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " (" + i + ") | ");
        }

        // ----------------------- Illegal Removal
        try {
            System.out.println("Remove :: " + linkedList.remove(5));
        } catch (Exception e) {
            System.out.println("Error :: " + e);
        }

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " (" + i + ") | ");
        }

    }
}
