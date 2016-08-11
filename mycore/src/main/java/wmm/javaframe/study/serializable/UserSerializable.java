package wmm.javaframe.study.serializable;

import wmm.javaframe.study.core.model.BaseModel;

import java.util.ConcurrentModificationException;

/**
 * 
     * Title: User.java    
     * Description: 描述
     * @author mengmengwang       
     * @created 2016-7-8 上午11:41:10
 */
public class UserSerializable extends BaseModel{
	
	
		/**  描述   (@author: mengmengwang) */      
	    
	private static final long serialVersionUID = 2092658668049014847L;

	private String name;
	
	private String password;
	
	private int age;
	
	private String detail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", password='" + password + '\'' +
				", age=" + age +
				", detail='" + detail + '\'' +
				'}';
	}

	private void writeObject(java.io.ObjectOutputStream s)
			throws java.io.IOException{
		s.defaultWriteObject();
	}

	/**
	 * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
	 * deserialize it).
	 */
	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();
	}
}
