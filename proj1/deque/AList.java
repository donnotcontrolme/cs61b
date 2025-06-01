package deque;

/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    /** Creates an empty list. */
    int size;
    int [] arr;

    public AList() {
        size=0;
        arr=new int[100000000];
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        arr[size]=x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return arr[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        if(i>size) {return Integer.parseInt(null);}
        return arr[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int tep=arr[size-1];
        arr[size-1]=0;
        size--;
        return tep;
    }
}