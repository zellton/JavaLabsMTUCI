public class Main {
    public static void main(String[] args) {
        HashTable<String, String> table = new HashTable<>();

        System.out.println("isEmpty: " + table.isEmpty()); 

        table.put("name", "Gleb");
        table.put("city", "Moscow");
        table.put("lang", "Java");

        System.out.println("size: "      + table.size());        
        System.out.println("get name: "  + table.get("name"));  
        System.out.println("get city: "  + table.get("city"));   

        table.put("name", "Updated");
        System.out.println("updated: "   + table.get("name"));   

        table.remove("city");
        System.out.println("after remove: " + table.get("city"));
        System.out.println("size: "      + table.size());         
    }
}

class HashTable<K, V> {
    
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.buckets = new Node[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % buckets.length);
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> node = buckets[index];
        while (node != null) {
            if (isKeysEqual(node.key, key)) { node.value = value; return; }
            node = node.next;
        }
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> node = buckets[index];
        while (node != null) {
            if (isKeysEqual(node.key, key)) return node.value;
            node = node.next;
        }
        return null;
    }

    public boolean remove(K key) {
        int index = hash(key);
        Node<K, V> node = buckets[index], prev = null;
        while (node != null) {
            if (isKeysEqual(node.key, key)) {
                if (prev != null) prev.next = node.next;
                else buckets[index] = node.next;
                size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    public int size()      { return size; }
    public boolean isEmpty() { return size == 0; }

    private boolean isKeysEqual(K a, K b) {
        return (a == null) ? b == null : a.equals(b);
    }
}
