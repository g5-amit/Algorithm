import java.util.Iterator;

public class CustomStringIterator implements Iterable<Character>{

    String str ;
    int strLen ;

    public CustomStringIterator(String str){
        this.str = str;
        this.strLen = str.length();
    }

    @Override
    public Iterator<Character> iterator() {
        return new StringIterator();
    }

    class StringIterator implements Iterator<Character>{

        int currentIndex;

            @Override
        public boolean hasNext() {
            return currentIndex < strLen;
        }

        @Override
        public Character next() {
            Character c =  str.charAt(currentIndex);
            currentIndex++;
            return c;
        }

        @Override
        public void remove() {
                throw new UnsupportedOperationException("String are immutable");
        }
    }


    public static void main(String[] args){
        CustomStringIterator itr = new CustomStringIterator("A2B3");
        for(Character c: itr){
            System.out.println("  "+c);

        }

    }
}
