package wmm.javaframe.study.map.hash;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2016/8/10.
 *
 * private void remove() {
 before.after = after;  //相当于上图中的操作 1
 after.before = before; //相当于上图中的操作 3
 }

 private void addBefore(Entry<K,V> existingEntry) {
 after  = existingEntry;         //相当于上图中的操作 1
 before = existingEntry.before;  //相当于上图中的操作 3
 before.after = this;            //相当于上图中的操作 4
 after.before = this;            //相当于上图中的操作 2
 }


 void createEntry(int hash, K key, V value, int bucketIndex) {
 HashMap.Entry<K,V> old = table[bucketIndex];
 Entry<K,V> e = new Entry<>(hash, key, value, old);
 table[bucketIndex] = e;
 //和hashMap相比多了一个链表指向的动作，实现有序
 e.addBefore(header);
 size++;
 }
 */
public class LinkedHashMapObject {

    public static void main(String[] args) {
        LinkedHashMap<String,String> asd=new LinkedHashMap<String, String>();
        asd.put("asd","2");
        asd.put("as","1");

        asd.put("asd6","2");
        asd.put("asd4","2");
        asd.put("asd3","2");
        asd.put("asd7","2");
        asd.put("asd5","2");


    }
}
