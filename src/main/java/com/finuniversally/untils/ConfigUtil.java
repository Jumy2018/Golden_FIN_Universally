package com.finuniversally.untils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	
	public static final String INIT_SOCKETDATA_RECEIVE_LISTENER_ENABLE = "InitSocketDataReceiveListenerEnable"; 
	
	private static Properties properties;

	private static String value = null;
	
	static {
		InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
		properties = new Properties();
		try {
			 properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}

	}
	public static String getValue(String key) {
		if(properties.containsKey(key)) {
			return properties.get(key).toString();
		}
		return null;
	}
	public static boolean getBoolValue(String key) {
		return ((value = getValue(key)) == null) ? false : Boolean.parseBoolean(value);
	}
	public static Integer getIntValue(String key) {
		return ((value = getValue(key)) == null) ? null : Integer.parseInt(value);
	}
	
}
