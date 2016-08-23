package wmm.javaframe.study.map.tree;

import java.util.TreeMap;

/**
 * Created by Administrator on 2016/8/23.
 * 红黑树又称红-黑二叉树，它首先是一颗二叉树，它具体二叉树所有的特性。同时红黑树更是一颗自平衡的排序二叉树。
 * 1、每个节点都只能是红色或者黑色
 2、根节点是黑色
 3、每个叶节点（NIL节点，空节点）是黑色的。
 4、如果一个结点是红的，则它两个子节点都是黑的。也就是说在一条路径上不能出现相邻的两个红色结点。
 5、从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。


 public V put(K key, V value) {
 //用t表示二叉树的当前节点
 Entry<K,V> t = root;
 //t为null表示一个空树，即TreeMap中没有任何元素，直接插入
 if (t == null) {
 //比较key值，个人觉得这句代码没有任何意义，空树还需要比较、排序？
 compare(key, key); // type (and possibly null) check
 //将新的key-value键值对创建为一个Entry节点，并将该节点赋予给root
 root = new Entry<>(key, value, null);
 //容器的size = 1，表示TreeMap集合中存在一个元素
 size = 1;
 //修改次数 + 1
 modCount++;
 return null;
 }
 int cmp;     //cmp表示key排序的返回结果
 Entry<K,V> parent;   //父节点
 // split comparator and comparable paths
 Comparator<? super K> cpr = comparator;    //指定的排序算法
 //如果cpr不为空，则采用既定的排序算法进行创建TreeMap集合
 if (cpr != null) {
 do {
 parent = t;      //parent指向上次循环后的t
 //比较新增节点的key和当前节点key的大小
 cmp = cpr.compare(key, t.key);
 //cmp返回值小于0，表示新增节点的key小于当前节点的key，则以当前节点的左子节点作为新的当前节点
 if (cmp < 0)
 t = t.left;
 //cmp返回值大于0，表示新增节点的key大于当前节点的key，则以当前节点的右子节点作为新的当前节点
 else if (cmp > 0)
 t = t.right;
 //cmp返回值等于0，表示两个key值相等，则新值覆盖旧值，并返回新值
 else
 return t.setValue(value);
 } while (t != null);
 }
 //如果cpr为空，则采用默认的排序算法进行创建TreeMap集合
 else {
 if (key == null)     //key值为空抛出异常
 throw new NullPointerException();
 /* 下面处理过程和上面一样
Comparable<? super K> k = (Comparable<? super K>) key;
        do {
        parent = t;
        cmp = k.compareTo(t.key);
        if (cmp < 0)
        t = t.left;
        else if (cmp > 0)
        t = t.right;
        else
        return t.setValue(value);
        } while (t != null);
        }
        //将新增节点当做parent的子节点
        Entry<K,V> e = new Entry<>(key, value, parent);
        //如果新增节点的key小于parent的key，则当做左子节点
        if (cmp < 0)
        parent.left = e;
        //如果新增节点的key大于parent的key，则当做右子节点
        else
        parent.right = e;
            /*
             *  上面已经完成了排序二叉树的的构建，将新增节点插入该树中的合适位置
             *  下面fixAfterInsertion()方法就是对这棵树进行调整、平衡，具体过程参考上面的五种情况

        fixAfterInsertion(e);
        //TreeMap元素数量 + 1
        size++;
        //TreeMap容器修改次数 + 1
        modCount++;
        return null;
        }
        */
public class MyTreeMap {

    private static TreeMap treeMap=new TreeMap();

    public static void main(String[] args) {
        treeMap.put("1","asdf");
        treeMap.firstKey();
    }

}
