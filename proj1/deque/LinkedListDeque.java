package deque;

public class LinkedListDeque<T>
{



    public static class IntNode<T>
    {
        private T item;
        private IntNode prev;
        private IntNode next;

        public IntNode(IntNode p,T f, IntNode n)
        {
            item=f;
            next=n;
            prev=p;
        }
    }
    private IntNode senial;
    private int size=0;

    public LinkedListDeque()
    {
        senial=new IntNode(null,null,null);
        senial.next=senial.prev=senial;//形成环状结构防止报错

    }

    public LinkedListDeque(T x)
    {
        senial=new IntNode(null,null,null);
        IntNode tep=new IntNode(senial,x,senial);
        senial.next=senial.prev=tep;
        size++;
    }

    public void addFirst(T x)
    {
        //这样的话Node1.prev节点没有更新，而且要考虑senial是空链表next会报错
        //senial.next=new IntNode(senial,x,senial.next);

        IntNode tep=new IntNode(senial,x,senial.next);
        senial.next.prev=tep;//更新原来Node1指向senial，现在指向tmp
        senial.next=tep;

        size++;

    }

    public void addLast(T x)
    {
        //同理next节点没有更新
        //senial.prev=new IntNode(senial.prev,x,senial.next);

        IntNode tep=new IntNode(senial.prev,x,senial);
        senial.prev.next=tep;
        senial.prev=tep;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void printDeque() {
        IntNode q=senial.next;
        while (q!=senial)
        {
            System.out.println(q.item);
            q=q.next;
        }

    }


//如果你用第一个版本（带<T>声明的removeLast()），但在调用时，比如LinkedListDeque<Integer>，
//泛型T在方法被调用时没有被正确匹配或者声明，可能会导致类型不一致，或者在类型擦除后出现问题。
//而第二个版本，返回的类型是类的定义中的T，很自然和直接。
    public T removeFirst() {

        
        IntNode tep= senial.next;
        senial.next=senial.next.next;
        senial.next.prev=senial;//注意Node2.prev也要更新
        size = (size == 0) ? size : size - 1;
        return (T)tep.item;
    }

    public T removeLast() {

        IntNode tep=  senial.prev;
        senial.prev=senial.prev.prev;
        senial.prev.next=senial;
        size = (size == 0) ? size : size - 1;
        return (T)tep.item;
    }

    public <T>T get(int x)
    {

        if(x<size)
        {
            return null;
        }
        IntNode p=senial.next;
        for(int i=x;x<=0;i--)
        {
            p=p.next;
        }
        return (T)p.item;
    }



}
