/**
 * This class implements a linked list that stores the type T.
 * @param <T> The type of data to be stored in the LinekdList
 */
public class LinkedList<T> {
    private Node<T> root;

    /**
     * Returns the number of items in the list
     * @return The number of items in the list
     */
    public int size() {
        int count = 0;
        Node<T> node = root;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    /**
     * Returns the value of the first item in the list or throws an IndexOutofBoundsException if the list is empty.
     * @return The value of the first item in the list or null.
     * @throws IndexOutOfBoundsException This exception is thrown if the list is empty.
     */
    public T getFirst() throws IndexOutOfBoundsException {
        return get(0);
    }

    /**
     * Returns the value of the last item in the list or throws an IndexOutofBoundsException if the list is empty.
     * @return The value of the last item in the list or null.
     * @throws IndexOutOfBoundsException This exception is thrown if the list is empty.
     */
    public T getLast() throws IndexOutOfBoundsException {
        return get(size()-1);
    }

    /**
     * Return the value of the item at the provided position in the list.
     * @param pos The position of the item that is to be returned.
     * @return The value of the item at position pos.
     * @throws IndexOutOfBoundsException If pos is less than ero or greater than or equal to size this method will throw an IndexOutofBoundsException
     */
    public T get(int pos) throws IndexOutOfBoundsException {
        Node<T> node = getNode(pos);
        return node.data;
    }

    /**
     * Sets/replaces the value of stored at position pos of the list.
     * @param pos The position of the item whose value is to be replaced.
     * @param value The new value of the item.
     * @return Returns the old value of the position pos item.
     * @throws IndexOutOfBoundsException If pos is less than zero or greater than or equal to size this method will throw an IndexOutOfBoundsException
     */
    public T set(int pos, T value) throws IndexOutOfBoundsException {
        Node<T> node = getNode(pos);
        T oldValue = node.data;
        node.data = value;
        return oldValue;
    }

    /**
     * Added a new item to the end of the list.
     * @param value The value to be added as a new item to the end of the list.
     */
    public void add(T value) {
        // if list is empty, we need to set the root node
        if(root==null){
            root=new Node<>(value);
        }else{
            Node<T> node = getNode(size()-1);
            Node<T> last = new Node<>(value);
            node.next = last;
        }

    }

    /**
     * Inserts a new item before the position pos.
     * @param pos The position before which to add the new item.
     * @param value The value of the item to be inserted into the list.
     * @throws IndexOutOfBoundsException If pos is less than zero or greater than or equal to size this method will throw an IndexOutOfBoundsException
     */
    public void add(int pos, T value) throws IndexOutOfBoundsException{
        // if adding to front
        if(pos == 0){
            Node<T> tmp = new Node<>(value);
            tmp.next = root;
            root = tmp;

        } else if(pos==size()) { //adding to the back
            add(value);
        } else { // adding to middle
            Node<T> prev = getNode(pos - 1);
            Node<T> curr = getNode(pos);
            Node<T> tmp = new Node<T>(value);
            tmp.next = curr;
            prev.next = tmp;
        }
    }

    /**
     * Removes the item at position pos, and returns the value of the removed item.
     * @param pos The position of the item to be removed.
     * @return The value of the item removed from the list.
     * @throws IndexOutOfBoundsException If pos is less than zero or greater than or equal to size this method will throw an IndexOutOfBoundsException
     */
    public T remove(int pos) throws IndexOutOfBoundsException{
        Node<T> node = getNode(pos);
        if(pos==0) {
            Node<T> tmp = root;
            root = tmp.next;
            tmp.next = null;
            return tmp.data;
        }else if(pos==size()-1){
            Node<T> last = node;
            Node<T> tmp = getNode(pos-1);
            tmp.next = null;
            return last.data;
        }else{
            Node<T> removed = getNode(pos);
            Node<T> before = getNode(pos-1);
            before.next = removed.next;
            removed.next = null;
            return removed.data;
        }
    }

    /**
     * Removes all the items in the list
     */
    public void clear() {
        root = null;
    }

    /**
     * Returns true if the value is contained in the list.
     * @param value The value to search the list for.
     * @return True of value is contained at least once in the list and false otherwise.
     */
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    /**
     * Returns the index of the first occurrence value in the list or -1 if value is not contained in the list.
     * @param value The value to search the list for.
     * @return The index of the first occurrence of value or -1 if the value is not found.
     */
    public int indexOf(T value) {
        for (int i = 0; i < size(); i++) {
            if(get(i) == value || get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private Node<T> getNode(int pos) throws IndexOutOfBoundsException {
        if(pos < 0 || pos >= size()){
            throw new IndexOutOfBoundsException(pos);
        }
        Node<T> node = root;
        int count = 0;
        while(count < pos) {
            node = node.next;
            count++;
        }
        return node;
    }

    @Override
    public String toString() {
        String str = "";
        if(size() > 0) {
            for(int i=1; i < size(); i++){
                str += i + ") " + get(i) + "\n";
            }
        }
        return str;
    }
}