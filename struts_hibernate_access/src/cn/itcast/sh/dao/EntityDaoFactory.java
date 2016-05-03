package cn.itcast.sh.dao;

public class EntityDaoFactory {
	public static <T> T getInstance(Class<T> t) throws Exception{
		return (T) t.newInstance();
	}
}
