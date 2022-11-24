import java.util.LinkedList;
import java.util.ArrayList;

public class HashMap<K, V> {
    LinkedList<Entry>[] hashMap = new LinkedList[2];
    int size = 0;

    public HashMap() {
    }

    public void put(K key, V value) {
        if (size >= hashMap.length) {
            resize();
        }

        int index = getIndex(key) % hashMap.length;

        if (hashMap[index] == null) {
            hashMap[index] = new LinkedList<>();
            hashMap[index].add(new Entry(key, value));
            size++;
            return;
        } else {
            for (Entry entry : hashMap[index]) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    size++;
                    return;
                }
            }

            hashMap[index].add(new Entry(key, value));
            size++;
            return;
        }
    }

    public V get(K key) {
        int index = getIndex(key) % hashMap.length;

        if (hashMap[index] == null)
            return null;

        for (Entry<K, V> entry : hashMap[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }

        int index = getIndex(key) % hashMap.length;

        if (hashMap[index] == null)
            return;

        Entry<K, V> toRemove = null;

        for (Entry<K, V> entry : hashMap[index]) {
            if (entry.key.equals(key)) {
                toRemove = entry;
            }
        }

        if (toRemove == null)
            return;

        hashMap[index].remove(toRemove);
    }

    public boolean containsKey(K key) {
        if (key == null)
            return false;

        int index = getIndex(key) % hashMap.length;

        if (hashMap[index] == null) {
            return false;
        }
        return false;
    }

    public void resize() {
        LinkedList<Entry>[] oldHashMap = hashMap;
        hashMap = new LinkedList[size * 2];
        size = 0;

        for (int i = 0; i < oldHashMap.length; i++) {
            if (oldHashMap[i] == null)
                continue;
            for (Entry<K, V> entry : oldHashMap[i]) {
                put(entry.key, entry.value);
            }
        }

    }

    public int getIndex(K key) {
        return key.hashCode();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < hashMap.length; i++) {
            if (hashMap[i] != null) {    
                for (Entry<K, V> entry : hashMap[i]) {
                    entry.value = null;
                    entry.key = null;
                }
            }
        }
        size = 0;
    }

    public ArrayList<K> keySet() {
        
        if (isEmpty()) {
            return null;
        }
        ArrayList<K> keySet = new ArrayList<>();
        for (int i = 0; i < hashMap.length; i++) {
            if (hashMap[i] == null) continue;
            for (Entry<K, V> entry : hashMap[i]) {
                keySet.add(entry.key);
            }
        }
        return keySet;
    }

    public ArrayList<V> values() {
        
        if (isEmpty()) {
            return null;
        }
        ArrayList<V> values = new ArrayList<>();
        for (int i = 0; i < hashMap.length; i++) {
            if (hashMap[i] == null) continue;
            for (Entry<K, V> entry : hashMap[i]) {
                values.add(entry.value);
            }
        }
        return values;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("{}");
        }
        else{
            for (int i = 0; i < hashMap.length; i++) {
                if (hashMap[i] != null){ 
                    for (Entry<K, V> entry : hashMap[i]) {
                        System.out.println(entry.key + ": " + entry.value);
                    }
                }
            }
        }
    }


}
