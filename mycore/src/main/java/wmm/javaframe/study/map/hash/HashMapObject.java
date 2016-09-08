package wmm.javaframe.study.map.hash;

import wmm.javaframe.study.core.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/10.
 * //先判断hash值
 * int hash = hash(key.hashCode());
 int i = indexFor(hash, table.length);
 //ranhou kan f[hash]上是否有值
 for (Entry<K,V> e = table[i]; e != null; e = e.next) {
 Object k;
 //有的情况下比对key值以及地址值
 if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
 //相同的话覆盖掉
 V oldValue = e.value;
 e.value = value;
 e.recordAccess(this);
 return oldValue;
 }
 }

//获取现有的值
 Entry<K,V> e = table[bucketIndex];
 //用新的对象替换旧的对象  新的对象的next指向旧的对象
 table[bucketIndex] = new Entry<>(hash, key, value, e);

 final K key;                        //用来存储Key
 V value;                            //用来存储Value
 Entry<K,V> next;                  //用来指向:相同hashCode的Key,但是不同Key对象
 int hash;                           //Key对象的hashCode值
 */
public class HashMapObject {

    public static void main(String[] args) {
        User u1=new User();
        u1.setName("1");
        User u2=new User();
        u2.setName("1");
        HashMap<Object,User> users=new HashMap<Object, User>();
        users.put(u1,u1);
        users.put(u2,u2);
        users.put("as",u2);
        users.put(u1,u2);
        //users.
        System.out.println(users.get(u1).hashCode());
        System.out.println(users.get(u2).hashCode());
        System.out.println(users.get("as").hashCode());
        System.out.println(users.get(u1)==(users.get(u2)));

        HashSet<Object> asd=new HashSet<Object>();
        asd.add("asd");
        asd.iterator();
    }


}
