package production;

public class Tuple<K, V> {

    private final K k;
    private final V v;

    public Tuple(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getFst() {
        return k;
    }

    public V getSnd() {
        return v;
    }
}
