package deque;

public class ArrayDeque<T> {
    private int size;
    private T [] items;
    private int firstIndex;
    private int lastIndex;

    public ArrayDeque()
    {
        size=0;
        items=(T[]) new Object[8];
        firstIndex=3;
        lastIndex=4;
    }

    public int arrayIndex(int index)
    {
        if(index+firstIndex+1>items.length)
        {
            return index+firstIndex+1-items.length;
        }
        return firstIndex+index+1;
    }

    public void resize()
    {
        T[] tep=(T[]) new Object[items.length*2];
        for(int i=0;i<items.length;i++)
        {
            tep[items.length*2/4+i]=items[arrayIndex(i)];//将排序后原数组放扩充后数组的正中间
        }


        firstIndex=items.length*2/4-1;
        lastIndex=firstIndex+size+1;
        items=tep;

    }

    public void addFirst(T x)
    {
        if(size+1>= items.length)
        {
            resize();
        }
        items[firstIndex]=x;
        if(firstIndex==0)
        {
            firstIndex=items.length-1;
        }
        else
        {
            firstIndex--;
        }
        size++;

    }

    public void addLast(T x)
    {
        if(size+1>= items.length)
        {
            resize();
        }
        items[lastIndex]=x;
        if(lastIndex==items.length)
        {
            lastIndex=0;
        }
        else
        {
            lastIndex++;
        }
        size++;
    }

    public boolean isEmpty()
    {
        if(size==0)
        {
            return true;
        }
        return false;
    }

    public T get(int index)
    {
        int x=arrayIndex(index);
        return items[x];
    }

    public int size()
    {
        return size();
    }

    public T removeFirst()
    {
        if(size==0)
        {
            return null;
        }
        T x=items[arrayIndex(0)];
        items[arrayIndex(0)]=null;
        if(firstIndex==items.length-1)
        {
            firstIndex=0;
        }
        else
        {
            firstIndex++;
        }
        size--;
        return x;
    }

    public T removeLast()
    {
        if(size==0)
        {
            return null;
        }
        T x=items[arrayIndex(items.length-1)];
        items[arrayIndex(items.length-1)]=null;
        if(lastIndex==0)
        {
            lastIndex=items.length;
        }
        else
        {
            lastIndex--;
        }
        size--;

        return x;

    }

}


