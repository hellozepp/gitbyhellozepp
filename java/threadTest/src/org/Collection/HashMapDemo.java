//package org.Collection;
//import java.util.*;
//
///**
// * Created by Hello Zepp on 2016/8/2 0002.
// */
//public class HashMapDemo<K,V> {
//    static final int MAX_CAPACITY = 1 << 30;//最大容量
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;//默认初始容量
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;//默认读取元素
//    int threshold;
//    transient int size;
//    final float loadFactor;
//    public HashMapDemo() {
//        thisDemo(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
//    }
//    public HashMapDemo(int initialCapacity, float loadFactor) {
//        if (initialCapacity < 0)
//            throw new IllegalArgumentException("Illegal initial capacity: " +
//                    initialCapacity);
//        if (initialCapacity > MAX_CAPACITY )
//            initialCapacity = MAX_CAPACITY ;
//        if (loadFactor <= 0 || Float.isNaN(loadFactor))
//            throw new IllegalArgumentException("Illegal load factor: " +
//                    loadFactor);
//
//        thisDemo.loadFactor = loadFactor;
//        threshold = initialCapacity;
//        init();
//    }  static final Entry<?,?>[] EMPTY_TABLE = {};
//    transient Entry<K,V>[] table = (Entry<K,V>[]) EMPTY_TABLE;
//
//
//    void init() {
//    }
//    public int size() {
//        return size;
//    }
//    public boolean add(K k,V v) {
//        return HashMapDemo.put(K,V)==null;
//    }
//    public static V put(K key, V value) {
//        if (table == EMPTY_TABLE) {
//            inflateTable(threshold);
//        }
//        if (key == null)
//            return putForNullKey(value);
//        int hash = hash(key);
//        int i = indexFor(hash, table.length);
//        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
//            Object k;
//            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
//                V oldValue = e.value;
//                e.value = value;
//                e.recordAccess(thisDemo);
//                return oldValue;
//            }
//        }
//
//        modCount++;
//        addEntry(hash, key, value, i);
//        return null;
//    }
//    static class Entry<K,V> implements Map.Entry<K,V> {
//        final K key;
//        V value;
//        Entry<K,V> next;
//        int hash;
//
//        /**
//         * Creates new entry.
//         */
//        Entry(int h, K k, V v, Entry<K,V> n) {
//            value = v;
//            next = n;
//            key = k;
//            hash = h;
//        }
//
//        public final K getKey() {
//            return key;
//        }
//
//        public final V getValue() {
//            return value;
//        }
//
//        public final V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        public final boolean equals(Object o) {
//            if (!(o instanceof Map.Entry))
//                return false;
//            Map.Entry e = (Map.Entry)o;
//            Object k1 = getKey();
//            Object k2 = e.getKey();
//            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
//                Object v1 = getValue();
//                Object v2 = e.getValue();
//                if (v1 == v2 || (v1 != null && v1.equals(v2)))
//                    return true;
//            }
//            return false;
//        }
//
//        public final int hashCode() {
//            return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
//        }
//
//        public final String toString() {
//            return getKey() + "=" + getValue();
//        }
//
//        /**
//         * This method is invoked whenever the value in an entry is
//         * overwritten by an invocation of put(k,v) for a key k that's already
//         * in the HashMap.
//         */
//        void recordAccess(HashMap<K,V> m) {
//        }
//
//        /**
//         * This method is invoked whenever the entry is
//         * removed from the table.
//         */
//        void recordRemoval(HashMap<K,V> m) {
//        }
//    }
//}
//
//
