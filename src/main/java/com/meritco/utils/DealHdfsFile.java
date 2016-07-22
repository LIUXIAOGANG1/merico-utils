package com.meritco.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.CompressionInputStream;

/**
 * @author liuxiaogang
 * @version 创建时间：2016年6月3日 下午12:26:18 类说明
 */
public class DealHdfsFile {
	public static void main(String[] args) throws Exception {
		// 读取hadoop文件系统的配置
		Configuration conf = new Configuration();

		String uri = "hdfs://192.168.0.33:9000/user/jiuqian/lxg/url/test/";

		// 获取HDFS的conf
		// 读取HDFS上的文件系统
		FileSystem hdfs = FileSystem.get(conf);

		if (!hdfs.exists(new Path(uri))) {
			return;
		}

		InputStream in = null;
		// 使用缓冲流，进行按行读取的功能
		BufferedReader br = null;
		// 获取日志文件的根目录
		Path rootPaht = new Path(uri);

		FileStatus[] stats = hdfs.listStatus(rootPaht);
		
		try {
			for (int i = 0; i < stats.length; i++) {
				Path path = new Path(stats[i].getPath().toString());

				CompressionCodecFactory factory = new CompressionCodecFactory(conf);
				CompressionCodec codec = factory.getCodec(path);

				in = hdfs.open(path);

				if (codec == null) {
					InputStreamReader is = new InputStreamReader(in, "utf-8");
					br = new BufferedReader(is);
				} else {
					CompressionInputStream comInputStream = codec.createInputStream(in);
					InputStreamReader is = new InputStreamReader(comInputStream, "utf-8");
					br = new BufferedReader(is);
				}

				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
			in.close();
		}
	}
}
