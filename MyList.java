import java.util.Arrays;

class MyArray {
    private int length;
    private Object[] data;

    public MyArray() {
        this.length = 0;
        this.data = new Object[10];
    }

    public Object get(int index) {
        if (index >= 0 && index < length) {
            return data[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(Object item) {
        if (length == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[length] = item;
        length++;
    }

    public Object remove() {
        if (length == 0) {
            throw new IllegalStateException("Array vazio");
        }
        Object lastItem = data[length - 1];
        data[length - 1] = null;
        length--;
        return lastItem;
    }

    public Object remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        Object item = data[index];
        shiftItems(index);
        return item;
    }

    private void shiftItems(int index) {
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[length - 1] = null;
        length--;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, length));
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.add("teste");
        myArray.add("10");
        myArray.add(20);
        myArray.remove();
        myArray.remove(0);
        System.out.println(myArray);
    }
}
