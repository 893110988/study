package wmm.javaframe.study.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

/**
 * Created by wangmm on 2016/12/9.
 */
public class as extends SoftReference<as>{

    public as(as referent) {
        super(referent);
    }

    public static void soft() throws Exception {
        Object obj = new Object();
        ReferenceQueue refQueue = new ReferenceQueue();
        SoftReference softRef = new SoftReference(obj, refQueue);
        System.out.println(softRef.get());
        // java.lang.Object@f9f9d8
        System.out.println(refQueue.poll());
        // / null
        // 清除强引用,触发GC
        obj = null;
        System.gc();
        System.out.println(softRef.get()); Thread.sleep(200);
        System.out.println(refQueue.poll());
        }

    public static void main(String[] args) throws Exception {
        soft();

        Hashtable table =new Hashtable();
        table.put(null,"");
    }
    }
