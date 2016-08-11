package wmm.javaframe.study.mvc.test;


import wmm.javaframe.study.mvc.bean.Person;
import wmm.javaframe.study.mvc.factory.BeanFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class Test {

	public static void main(String[] args) {
		Test t=new Test();
		String xmlUrl=t.getClass().getResource("/").getFile().toString()+"/dev/IocApplication.xml";
		BeanFactory factory=new BeanFactory();
		factory.init(xmlUrl);  
		Person me=(Person)factory.getBean("daughter");
		System.out.println("Son's name:"+me.getName()); 
	}

}


