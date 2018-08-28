package cn.supermarket.manager.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectFactory {
    private static Map<String,Object> objectMap=new HashMap<String,Object>();
	static {
		Properties properties=new Properties();
		try {
			properties.load(new FileInputStream("./Object.properties"));
			Enumeration<?> enumeration=properties.keys();
			while(enumeration.hasMoreElements()) {
				String key=(String) enumeration.nextElement();
				String value=properties.getProperty(key);
				objectMap.put(key, Class.forName(value).newInstance());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}	
		
	}
	public static Object getInstance(String key) {
		return objectMap.get(key);
	}
}
