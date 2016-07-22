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
 * @version ����ʱ�䣺2016��6��3�� ����12:26:18 ��˵��
 */
public class DealHdfsFile {
	public static void main(String[] args) throws Exception {
		// ��ȡhadoop�ļ�ϵͳ������
		Configuration conf = new Configuration();

		String uri = "hdfs://192.168.0.33:9000/user/jiuqian/lxg/url/test/";

		// ��ȡHDFS��conf
		// ��ȡHDFS�ϵ��ļ�ϵͳ
		FileSystem hdfs = FileSystem.get(conf);

		if (!hdfs.exists(new Path(uri))) {
			return;
		}

		InputStream in = null;
		// ʹ�û����������а��ж�ȡ�Ĺ���
		BufferedReader br = null;
		// ��ȡ��־�ļ��ĸ�Ŀ¼
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
