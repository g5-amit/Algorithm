import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

    ArrayList<T> list = new ArrayList<>();
    int modCount;

    public void add(T obj){
        list.add(obj);
        modCount++;
    }

    public void remove(int index){
        if(index <= list.size()) {
            list.remove(index);
            modCount++;
        }
    }

    public void remove(T obj){
        list.remove(obj);
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(modCount);
    }


    class MyIterator<T> implements Iterator<T>{

        int expectedModCount ;
        int currentIndex ;
        MyIterator(int modCount){
            this.expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public T next() {
            if(modCount!=expectedModCount){
                throw new ConcurrentModificationException("Data operation is applied in wrong way");
            }

            Object obj = list.get(currentIndex);
            currentIndex++;
            return (T)obj;
        }

        @Override
        public void remove() {
            if(modCount!=expectedModCount){
                throw new ConcurrentModificationException("Data operation is applied in wrong way");
            }
            int lastIndex = currentIndex-1;
            if(lastIndex< 0){
                throw new IllegalStateException("list is out of index");
            }

            MyArrayList.this.remove(lastIndex);
            currentIndex = lastIndex;
            expectedModCount = modCount;
        }
    }


    public static void main(String[] args){
        MyArrayList<Integer> myList = new MyArrayList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        Iterator itr = myList.iterator();

        while(itr.hasNext()){
            int x = (Integer) itr.next();

            if(x==2){
                //myList.remove(1); will give concurrent modification
                itr.remove();
            }else{
                System.out.println(x);
            }
        }
    }
}
