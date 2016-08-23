package wmm.javaframe.study.map.hash;

import wmm.javaframe.study.core.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/10.
 */
public class HashMapObject {

    public static void main(String[] args) {
        User u1=new User();
        u1.setName("1");
        User u2=new User();
        u2.setName("2");
        HashMap<Object,User> users=new HashMap<Object, User>();
        users.put(u1,u1);
        users.put(u2,u2);
        users.put("as",u2);
        //users.
        System.out.println(users.get(1).hashCode());
        System.out.println(users.get(u2).hashCode());

        HashSet<Object> asd=new HashSet<Object>();
        asd.add("asd");
        asd.iterator();
    }


}
