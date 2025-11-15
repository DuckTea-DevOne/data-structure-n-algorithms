package DataStructures;

public class JArray <T> implements ArrayInterface<T>{

    private Object[] array;
    private int capacity;
    private int size;

    public JArray(int initialSize) {
        if (initialSize <= 0) {
            initialSize = 1;  // avoid 0-capacity bug
        }
        this.array = new Object[initialSize];
        this.capacity = initialSize;
        this.size = 0;
    }

    public JArray() {
        this(1);
    }


    @Override
    public void add(T element) {
        if (size == capacity) {
            grow();
        }
        array[size++] = element;
    }

    @Override
    public T get (int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds | Size : " + this.size + " | Index : " + index);
        }
        return (T) this.array[index];
    }

    @Override
    public int size () {
        return this.size;
    }

    public int containerSize () {
        return this.capacity;
    }

    private void grow() {
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, capacity);
        array = newArray;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        JArray<Integer> arr = new JArray(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
