package main.java;

public class MyHashMaps {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap();
        hashMap.put(0, "0");
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");
        hashMap.put(4, "4");
        hashMap.put(5, "5");
        hashMap.put(6, "6");
        hashMap.put(7, "7");
        hashMap.put(8, "8");
        hashMap.put(9, "9");
        hashMap.put(10, "10");
        hashMap.put(11, "11");
        hashMap.put(12, "12z");
        hashMap.put(13, "13");
        hashMap.put(14, "14");
        hashMap.put(1, "15");
        hashMap.put(16, "16");
        hashMap.put(17, "17");
        hashMap.put(17, "18");
        System.out.println(hashMap);
        System.out.println(hashMap.size());
        System.out.println((String)hashMap.get(12));
        hashMap.remove(2);
        hashMap.clear();
        System.out.println(hashMap);
    }
}


