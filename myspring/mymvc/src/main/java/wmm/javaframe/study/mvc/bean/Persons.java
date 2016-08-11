package wmm.javaframe.study.mvc.bean;

//beans类
public class Persons {

	private Person son;
	public Person getSon()
	{
		return this.son;
	}
	
	public void setSon(Person son)
	{
		this.son = son;
	}
	
	private Person daughter;
	public Person getDaughter()
	{
		return this.daughter;
	}
	
	public void setDaughter(Person daughter)
	{
		this.daughter = daughter;
	}
}
