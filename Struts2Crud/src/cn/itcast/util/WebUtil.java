package cn.itcast.util;

import java.io.File;

public class WebUtil {

	public static String makeDirs(String storePath, String filename) {
		
		int hashCode = filename.hashCode();
		int dir1 = hashCode&0xf;//最低四位
		int dir2 = (hashCode&0xf0)>>4;//其余四位
		
		String newPath = dir1+"\\"+dir2;
		File file = new File(storePath,newPath);
		if(!file.exists())
			file.mkdirs();
		return newPath;
	}

}
