package DataStructures;

public class JArray <T> {

    private Object [] array;
    private int size;
    private final Object [] EMPTY_ARRAY = {};
    private int currentIndex = -1;

    public JArray (int initialSize) {
        if (initialSize > 0) {
            this.array = new Object[initialSize];
            this.size = initialSize;
        } else {
            this.array = EMPTY_ARRAY;
        }
        this.currentIndex = 0;
    }

    public JArray () {
        this.array = EMPTY_ARRAY;
        this.size = 0;
        this.currentIndex = 0;
    }

    public void add (T element) {
        this.array[this.currentIndex] = element;
        this.currentIndex++;
        this.checkGrow();
        element = null;
    }

    public T get (int index) {
        if (index >= currentIndex) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds | Size : " + this.currentIndex);
        }
        return (T)this.array[index];
    }

    public int size () {
        return this.currentIndex;
    }

    public int containerSize () {
        return this.size;
    }

    private void checkGrow () {
        if (this.currentIndex > this.size * 0.8) {
            this.grow();
        }
    }

    private void grow () {
        Object [] newArray = new Object[2*this.size];
        System.arraycopy(this.array,0,newArray,0,this.size);
        this.array = null;
        this.array = newArray;
        this.size *= 2;
    }

    public static void main(String[] args) {
        JArray<Integer> arr = new JArray(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        for (int i = 0; i <= arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
