package com.meritco.utils.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.StringUtils;

/**
 * @author liuxiaogang
 * @version 创建时间：2016年6月3日 下午12:35:16 类说明
 */
public class MainTest {
	public static void main(String[] args) throws Exception {
		Map<String, Set<String>> result = new HashMap<String, Set<String>>();
		
		Integer[] array = new Integer[2];
		array[0] = 0;
		array[1] = 0;
		
		
		Set<String> set = new HashSet<>();
		
		for(String value : result.get("test")){
			System.out.println(value);
		}
		
	}
	
	public static void add(Map<String, Integer[]> result, String key){
		result.get(key)[1]++;
	}

	private static byte[] serialize(Writable writable) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DataOutputStream dataOut = new DataOutputStream(out);

		writable.write(dataOut);
		dataOut.close();

		return out.toByteArray();
	}

	private static void deserialize(Writable writable, byte[] bytes) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		DataInputStream dataIn = new DataInputStream(in);

		writable.readFields(dataIn);
		dataIn.close();
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

	public static boolean binarySearch(int[] array, int key) {
		int start = 0;
		int middle = 0;
		int end = array.length - 1;

		while (start <= end) {
			middle = (start + end) / 2;
			if (array[middle] <= key && array[middle] >= key - 2) { // 找到,返回下标索引值
				return true;
			} else if (array[middle] > key) { // 查找值在低半区
				end = middle - 1;
			} else { // 查找值在高半区
				start = middle + 1;
			}
		}
		return false; // 找不到
	}
}
