package com.meritco.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liuxiaogang
 * @version 创建时间：2016年6月3日 下午12:25:59 类说明
 */
public class DealLocalFile {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		String readPath = "D:\\read";
		String writePath = "D:\\write\\write.txt";

		File file = new File(readPath);
		if (!file.exists()) {
			file.mkdir();
		}

		Set<String> set = new HashSet<String>();
		Long count = 0L;
		String[] fileList = file.list();
		for (String fl : fileList) {
			String newPath = readPath + "\\" + fl;
			FileInputStream in = new FileInputStream(newPath);
			InputStreamReader is = new InputStreamReader(in, "UTF-8");
			BufferedReader br = new BufferedReader(is);

			String line = "";
			
			try {
				

				boolean first = true;
				while ((line = br.readLine()) != null) {
//					if(first){
//						first = false;
//						continue;
//					}
					
					count++;
					set.add(line);
					
//					String[] splited = line.split(",");
//					
//					String site = getContent(splited[1]);
//					if(!"xiaohongshu".equals(site)){
//						continue;
//					}
//					
//					String urlID = getMatcher(splited[5]);
//					String spuID = getContent(splited[6]);
//					String skuID = getContent(splited[7]);
//					
//					set.add(urlID);
//					set.add(spuID);
//					set.add(skuID);
					
//					if(splited.length != 74 && splited.length != 75){
//						System.out.println(line);
//					}
					
//					result = getMatcher(splited[0]) + "|" + getContent(splited[1]) + "|" +  getContent(splited[2]) + "|" +  getContent(splited[3]) + "|" +  getContent(splited[4]) + "|" +  getContent(splited[5]) + "|" +  getContent(splited[6]) + "|" + 
//							 getContent(splited[7]) + "|" +  getContent(splited[8]) + "|" +  getContent(splited[9]) + "|" +  getContent(splited[10]) + "|" +  getContent(splited[11]) + "|" +  getContent(splited[12]) + "|" +  getContent(splited[13]) + "|" + 
//							 getContent(splited[14]) + "|" +  getContent(splited[15]) + "|" +  getContent(splited[16]) + "|" +  getContent(splited[17]) + "|" +  getContent(splited[18]) + "|" +  getContent(splited[19]) + "|" +  getContent(splited[20]) + "|" + 
//							 getContent(splited[20]) + "|" +  getContent(splited[22]) + "|" +  getContent(splited[23]) + "|" +  getContent(splited[24]) + "|" +  getContent(splited[25]) + "|" +  getContent(splited[26]) + "|" +  getContent(splited[27]) + "|" + 
//							 getContent(splited[28]) + "|" +  getContent(splited[29]) + "|" +  getContent(splited[30]) + "|" +  getContent(splited[31]) + "|" +  getContent(splited[32]) + "|" +  getContent(splited[33]) + "|" +  getContent(splited[34]) + "|" + 
//							 getContent(splited[35]) + "|" +  getContent(splited[36]) + "|" +  getContent(splited[37]) + "|" +  getContent(splited[38]) + "|" +  getContent(splited[39]) + "|" +  getContent(splited[40]) + "|" +  getContent(splited[41]) + "|" + 
//							 getContent(splited[42]) + "|" +  getContent(splited[43]) + "|" +  getContent(splited[44]) + "|" +  getContent(splited[45]) + "|" +  getContent(splited[46]) + "|" +  getContent(splited[47]) + "|" +  getContent(splited[48]) + "|" + 
//							 getContent(splited[49]) + "|" +  getContent(splited[50]) + "|" +  getContent(splited[51]) + "|" +  getContent(splited[52]) + "|" +  getContent(splited[53]) + "|" +  getContent(splited[54]) + "|" +  getContent(splited[55]) + "|" + 
//							 getContent(splited[56]) + "|" +  getContent(splited[57]) + "|" +  getContent(splited[58]) + "|" +  getContent(splited[59]) + "|" +  getContent(splited[60]) + "|" +  getContent(splited[61]) + "|" +  getContent(splited[62]) + "|" +
//							 getContent(splited[63]) + "|" +  getContent(splited[64]) + "|" +  getContent(splited[65]) + "|" +  getContent(splited[66]) + "|" +  getContent(splited[67]) + "|" +  getContent(splited[68]) + "|" +  getContent(splited[69]) + "|" +
//							 getContent(splited[70]) + "|" +  getContent(splited[71]) + "|" +  getContent(splited[72]) + "|" +  getContent(splited[73]);
					
					 
				}
				System.out.println("文件读完毕");

				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
//		try {
//			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(writePath), "UTF-8");
//			BufferedWriter out = new BufferedWriter(write);
//			
//			for(String id : set){
//				out.write(id);
//				out.newLine();
//				out.flush(); // 把缓存区内容压入文件
//			}
//			
//			out.close(); // 最后记得关闭文件
//
//			System.out.println("文件写完毕");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		System.out.println("count = " + count + ",size = " + set.size());
	}

	private static String getString(String str) {
		String strGB2312 = "";
		String strUTF8 = "";

		try {
			strUTF8 = java.net.URLDecoder.decode(str, "UTF-8");
			strGB2312 = java.net.URLDecoder.decode(str, "gb2312");
			return strUTF8.length() < strGB2312.length() ? strUTF8 : strGB2312;
		} catch (Exception e) {
			return str;
		}
	}
	

	
	public static String getMatcher(String regex, String source) {
		String result = null;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(source);
		while (matcher.find()) {
			result = matcher.group(1);// 只取第一组
		}
		return result;
	}
	
	public static String getMatcher(String source) {
		source = source.replaceAll("\"", "");
		String regex1 = "http://item.jumeiglobal.com/\\w+p(\\d+)[a-zA-Z0-9\\&%_.=]*";
		String regex2 = "http://item.jumei.com/\\w+p(\\d+)[a-zA-Z0-9\\&%_.=]*";
		String regex3 = "http://item.jumei.com/(\\d+)\\.html";
		String regex4 = "http://item.meilishuo.com/[a-zA-Z0-9\\&%/_.]*/(\\w+)\\?([a-zA-Z0-9\\&%_.=]*)";
		
		String result = getMatcher(regex1, source);
		if(StringUtils.isNotBlank(result)){
			return result;
		}
		
		result = getMatcher(regex2, source);
		if(StringUtils.isNotBlank(result)){
			return result;
		}
		
		result = getMatcher(regex3, source);
		if(StringUtils.isNotBlank(result)){
			return result;
		}
		
		result = getMatcher(regex4, source);
		if(StringUtils.isNotBlank(result)){
			return result;
		}
		
		return "NA";
	}
	
//	public static String getMatcher(String source) {
//		String regex = ".*k(.*)";
//		
//		String result = getMatcher(regex, source.replaceAll("\"", ""));
//		if(StringUtils.isNotBlank(result)){
//			return result;
//		}
//		
//		return "NA";
//	}
	
	public static String getContent(String source){
		if(StringUtils.isNotBlank(source)){
			return source.replaceAll("\"", "");
		}
		return "NA";
	}
}
