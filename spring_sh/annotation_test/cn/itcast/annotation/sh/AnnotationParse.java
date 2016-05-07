package cn.itcast.annotation.sh;

import java.lang.reflect.Method;

import org.junit.Test;

public class AnnotationParse {
	@Test
	public void testParse(){
		Class class1 = ITCAST_SH.class;
		if(class1.isAnnotationPresent(Description.class)){
			Description description = (Description)class1.getAnnotation(Description.class);
			if(description.value().contains("传智播客")){
				System.out.println("学费减半");
			}
		}
		Method[] methods = class1.getMethods();
		for(Method method:methods){
			if(method.isAnnotationPresent(MethodDesc.class)){
				MethodDesc methodDesc = (MethodDesc)method.getAnnotation(MethodDesc.class);
				if(methodDesc.name().contains("老毕")){
					System.out.println("折上折");
				}
			}
		}
	}
}
