package wmm.javaframe.study.hash;

import wmm.javaframe.study.core.model.BaseModel;

/**
 * 
     * Title: User.java    
     * Description: 测试hashMap的存储特性
     * @author mengmengwang       
     * @created 2016-7-8 上午11:41:10
 */
public class UserHash extends BaseModel{
	
	
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
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
