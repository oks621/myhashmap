package main.java;


public class MyHashMap<K, V> {
    private Node<K, V>[] hashTable = new Node[16];
    private int size;

    public MyHashMap() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < hashTable.length; ++i) {
            if (hashTable[i] != null) {
                sb.append(i + " " + hashTable[i] + "\n");
            } else {
                sb.append(i + " null\n");
            }
        }

        return sb.toString();
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % hashTable.length;
        Node<K, V> node = hashTable[hash];
        if (node == null) {
            hashTable[hash] = new Node(key, value);
        } else {
            while (true) {
                if (node.next == null) {
                    if (node.getKey() == key) {
                        node.setValue(value);
                        return;
                    }

                    node.next = new Node(key, value);
                }

                if (node.getKey() == key) {
                    node.setValue(value);
                    return;
                }

                node = node.next;
            }
        }

        size++;
    }

    public V get(K key) {
        int hash = key.hashCode() % hashTable.length;
        Node<K, V> node = hashTable[hash];
        if (node == null) {
            return null;
        } else {
            while (node != null) {
                if (node.getKey() == key) {
                    return node.getValue();
                }

                node = node.next;
            }

            return null;
        }
    }

    public Node<K, V> remove(K key) {
        int hash = key.hashCode() % hashTable.length;
        Node<K, V> node = hashTable[hash];

        if (node == null) {
            return null;
        }

        if (node.getKey() == key) {
            hashTable[hash] = node.next;
            node.next = null;
            return node;
        }

        Node<K, V> prev = node;
       node = node.next;

        while (node != null) {
            if (node.getKey() == key) {
                prev.next = node.next;
                node.next = null;
                return node;
            }
            prev = node;
           node = node.next;
        }

        return null;
    }

        public void clear () {
            MyHashMap.Node[] tab = this.hashTable;

            for (int i = 0; i < tab.length; ++i) {
                tab[i] = null;
            }

        }

        public int size () {
            return this.size;
        }

        private class Node<K, V> {
            private K key;
            private V value;
            private Node<K, V> next;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return this.key;
            }

            public V getValue() {
                return this.value;
            }

            public String toString() {
              Node<K, V> map = this;

                StringBuilder sb;
                for (sb = new StringBuilder(); map != null; map = map.next) {
                    sb.append(map.key + " ->" + map.value + ",");
                }

                return sb.toString();
            }

            public V setValue(V newValue) {
                V oldValue = this.value;
                this.value = newValue;
                return oldValue;
            }
        }
    }


