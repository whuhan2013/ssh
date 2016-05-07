package cn.itcast.spring.extend;

public class PersonDao extends CommonDao{
	public void show(){
		System.out.println(this.getS());
	}
}
