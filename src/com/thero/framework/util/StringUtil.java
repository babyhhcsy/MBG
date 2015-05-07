package com.thero.framework.util;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
/**
 * 字符串操作的工具类
 * @author yzp
 *
 */
public class StringUtil {
	/**
	 * 构造器私有
	 */
	private StringUtil(){}
	/**
	 * 字符串数字转整型
	 * 异常不处理，抛给上层
	 * @param str 字符串参数
	 * @return 字符串对一个的数字
	 */
	public static Integer toInt(String str){
		return Integer.valueOf(str);
	}

	/**
	 * 判断字符串是否为Null或者空串
	 * @param str 字符串参数
	 * @return 判断结果
	 */
	public static boolean isNullString(String str){
		return (str == null || "".equals(str)) ? true : false;
	}
	
	
	/**
	 * 判断字符串是否为Null或者空串
	 * @param str 字符串参数
	 * @return 判断结果
	 */
	public static boolean isNotNullString(String str){
		return (str == null || "".equals(str)) ? false : true;
	}

	/**
	 * 生成唯一的UUid
	 * @return 唯一的UUid
	 */
	public static String UUid(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 
	 * 描述：获取当前时间戳
	 *
	 * @return
	 */
	public static Timestamp getCurrentTimestamp(){
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

	/**
	 * 
	 * 描述：判断字符串是否是数字
	 *
	 * @param str 字符串数字
	 */
	public static boolean isInt(String str){
		return !isNullString(str) && str.matches("^[1-9]\\d*$");
	}
	
	/**
	 * 判断对应的参数是否为空
	 * @param str
	 * @return
	 */
	public static String getString(String str){
		
		if(null==str||str.equals("")||str.equals("null")){
			
			return "";
		}else{
			
			return str;
		}
	}
	
	/**
	 * 判断对应的参数是否为空
	 * @param str
	 * @return
	 */
	public static String getObjectString(Object str){
		
		if(null==str||str.equals("")||str.equals("null")){
			
			return "";
		}else{
			
			return str.toString();
		}
	}
	
	/**
	 * 判断对应的参数是否为空
	 * @param str
	 * @return
	 */
	public static Integer getStringToInteger(String str){
		
		if(null==str||str.equals("")||str.equals("null")){
			
			return 0;
		}else{
			
			return Integer.parseInt(str);
		}
	}

	/**
	 * 
	 * 描述：随机生成4位数字
	 *
	 * @return
	 */
	public static String randomFourDigits(){
		String[] randomNums = new String[] { "0", "1", "2", "3", "4", "5", "6",
				"7", "8", "9" };
		List<String> randomNumList = Arrays.asList(randomNums);
		// 随机排列
		Collections.shuffle(randomNumList);
		StringBuilder randomNum = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			randomNum.append(randomNumList.get(i));
		}
		return randomNum.toString();
	}

	/**
	 * 
	 * 描述：随机生成8位字母数字组合
	 *
	 * @return
	 */
	public static String randomCharacter(int bit){
		String[] randomChars = new String[] { "0", "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i",
				"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
				"v", "w", "x", "y", "z" };
		List<String> randomCharList = Arrays.asList(randomChars);
		// 随机排列
		Collections.shuffle(randomCharList);
		StringBuilder randomChar = new StringBuilder();
		for (int i = 0; i < bit; i++) {
			randomChar.append(randomCharList.get(i));
		}
		return randomChar.toString();
	}


	/**
	 * 
	 * 描述：将GBK文件转为UTF8文件
	 *
	 */
	public static void fileGBK2UTF8(){
		//GBK编码格式源码路径
		String srcDirPath = "D:/SWorkspace/Sulai-framework-build/src/sulai-alipaydirect/src/main/java/com/alipay/";
		//转为UTF-8编码格式源码路径
		String utf8DirPath = "D:/SWorkspace/Sulai-framework-build/src/sulai-alipaydirect/src/main/java/com/alipay/";

		//获取所有java文件
		Collection<File> javaGbkFileCol =  FileUtils.listFiles(new File(srcDirPath), new String[]{"java"}, true);
		for (File javaGbkFile : javaGbkFileCol) {
		    String utf8FilePath = utf8DirPath+javaGbkFile.getAbsolutePath().substring(srcDirPath.length());
		    //使用GBK读取数据，然后用UTF-8写入数据
		    try {
				FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * 描述：精确四舍五入
	 *
	 * @param doubleValue
	 * @param scale
	 * @return
	 */
	public static Double round(Double doubleValue, int scale) {
		Double flag = null;
		if (doubleValue == null) {
			doubleValue = 0.0;
		}
		String text = doubleValue.toString();
		BigDecimal bd = new BigDecimal(text).setScale(scale, BigDecimal.ROUND_HALF_UP);
		flag = bd.doubleValue();
		return flag;
	}

	/**
	 * 
	 * 描述：将数字格式化为两位小数显示
	 * 精确的四舍五入
	 *
	 * @return
	 */
	public static String formatNumber(Number num){
		if (num == null) {
			num = 0d;
		}
		Double result = round((Double) num, 2);
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(result);
	}
	/**
	 * 
	 * 描述:字符串截取
	 * 
	 * @param target 目标字符串 如: "a,b,c,d..."
	 * @param length 截取长度 3
	 * @param separator ","
	 * @return 结果  a,b,c""
	 */
	public static String substringArr(String target, Integer length, String separator){
		String result = "";
		if("".equals(target)){
			return result;
		}
		String[] arr = target.split(separator);
		if(arr.length <= length){
			return target;
		}else{
			for(int i=0;i<length;i++){
				if(i != length -1)
					result += arr[i] + ",";
				else
					result += arr[i] + "...";
			}
		}
		return result;
	}

	/**
	 * 
	 * 描述：验证字符串是否为手机号码
	 *
	 * @param cellphone
	 * @return
	 */
	public static boolean isCellphoneNo(String cellphone){
		if(isNullString(cellphone)){
			return false;
		}
		if(isInt(cellphone)){
			return cellphone.matches("^1[3|4|5|8][0-9]\\d{8}$");
		}
		return false;
	}

	public static String intToRMB(int orig){
		String singleBit = "零壹贰叁肆伍陆柒捌玖整分角元拾佰仟万拾佰仟亿拾佰仟万";
		String origStr = orig + "";
		int L = origStr.length(); // 整数部分长度
		boolean Z = false, zL;
		zL = Long.valueOf(origStr.substring(0, L)) == 0; // 整数部分是否为零
		if (zL)
			return "零"; // 零值退出
		char s0, s1;
		StringBuffer sL = new StringBuffer(); // 转换后的整数串
		int n;
		for (int i = 0; i < L; i++) // 整数部分
		{
			s0 = 0;
			s1 = 0;
			n = origStr.charAt(L - i - 1) - '0'; // 数值
			if (!(n == 0 && (Z || i == 8 || i == 4 || i == 0) || zL)) // Z：前一个字符是否为0
				s0 = singleBit.charAt(n); // 值字符
			if (!(n == 0 && (i != 8 && i != 4 && i != 0 || Z && i == 1) || zL))
				s1 = singleBit.charAt(i + 13); // 单位字符
			if (s1 > 0)
				sL.insert(0, s1);
			if (s0 > 0)
				sL.insert(0, s0);
			Z = n == 0; // 当前处理的字符是否为0
		}
		int pos = sL.indexOf("亿万"); // 是否有"亿万"
		if (pos > 0)
			sL.deleteCharAt(pos + 1); // 如有则删除
		return sL.toString().substring(0, sL.length()-1);
	}
	
	/**
	 * 描述:开通字母大写
	 * @param src
	 * @return
	 */
	public static String changeFirstChar(String src) {   
        if (src != null) {   
            StringBuffer sb = new StringBuffer(src);   
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));   
            return sb.toString();   
        } else {   
            return null;   
        }   
    } 
	public static void main(String[] args) {
		/*//System.out.println(UUid());
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
        try {
        	FileInputStream fr = new FileInputStream("D:/1.txt");
        	InputStreamReader is = new InputStreamReader(fr,"gbk");
            reader = new BufferedReader(is);
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
            	sb.append("'").append(tempString).append("',");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        System.out.println(sb);*/
		System.out.println((float)10/100);
	}
	
	
	/**
	 * 去除Html标签
	 * @param htmlStr
	 * @return
	 */
	public static String delHTMLTag(String htmlStr){ 
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
        
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
        
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
        
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

       return htmlStr.trim(); //返回文本字符串 
    } 
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder())
					.append(Character.toLowerCase(s.charAt(0)))
					.append(s.substring(1)).toString();
	}

	// 首字母转大写
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder())
					.append(Character.toUpperCase(s.charAt(0)))
					.append(s.substring(1)).toString();
	}

}
