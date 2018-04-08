/**
 * Changed entry to class for ease of use - should only use integers and string type variables
 *
 * @param <K> Key
 * @param <V> Value
 */
public class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the key stored in this entry.
     *
     * @return the entry's key
     */
    K getKey() {
        return key;
    }

    /**
     * Returns the value stored in this entry.
     *
     * @return the entry's value
     */
    V getValue() {
        return value;
    }
}
