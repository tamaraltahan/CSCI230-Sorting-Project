import java.util.Comparator;

public class TypeComparator<E> implements Comparator<E> {

    @Override
    public int compare(E a, E b) {
        return ((Comparable<E>) a).compareTo(b);
    }
}
