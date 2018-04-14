import java.util.Comparator;

public class TypeComparator<E> implements Comparator<E> {
    @Override
    public int compare(E a, E b) {
        if(a instanceof String){
            int x = Integer.parseInt(a.toString());
            int y = Integer.parseInt(b.toString());
            if(x > y){
                return 1;
            }
            else if(x < y){
                return -1;
            }
            else{
                return 0;
            }
        }
        else {
            return ((Comparable<E>) a).compareTo(b);
        }
    }
}
