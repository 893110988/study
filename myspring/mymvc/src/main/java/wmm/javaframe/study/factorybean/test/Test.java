package wmm.javaframe.study.factorybean.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wmm.javaframe.study.factorybean.bean.MyFactory;


public class Test {

	public static void main(String[] args) {
		Test t=new Test();
		String xmlUrl=t.getClass().getResource("/").getFile().toString()+"/factorybean/factorybean.xml";
		ApplicationContext factory=new ClassPathXmlApplicationContext("factorybean/factorybean.xml");
		MyFactory me=(MyFactory)factory.getBean("myFactoryBean");
		System.out.println("Son's name:"+me.getName());
	}

}


