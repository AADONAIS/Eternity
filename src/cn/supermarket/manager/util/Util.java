package cn.supermarket.manager.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str.equals("")||null==str?true:false;
	}
	
	/**
	 * 判断是否是字符串
	 * @param str
	 * @return
	 */
	public static boolean isString(String str){
		return str instanceof String ?true:false;
	}
	/**
	 * 判断字符串是否含有数字
	 * @param str
	 * @return
	 */
	public static boolean isContainNumber(String str){
		Pattern pattern=Pattern.compile("[0-9]");
		Matcher matcher=pattern.matcher(str);
		if(matcher.find()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断字符串是否是纯数字
	 */
	public static boolean isAllDigit(String str){
		Pattern pattern=Pattern.compile("[0-9]{1,}");
		Matcher matcher=pattern.matcher((CharSequence)str);
		if(matcher.matches()==true){
			return true;
		}
		return false;
	}
}
