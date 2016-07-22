package com.meritco.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * @author liuxiaogang
 * @version 创建时间：2016年5月20日 上午10:21:10 类说明
 */
public class Regular {

	public static void main(String[] args) {
		// String regex = "\\d*\\[a-zA-Z0-9]\\d*\\[a-zA-Z0-9]\\d*";
		// String regex = "[a-zA-Z]{0,2}[0-9]{4,6}";
		String regex = ".+";

		String target = "==.";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);

		if (matcher.matches()) {
			System.out.println("ok");
		} else {
			System.out.println("not ok");
		}

		// // TODO ok
		String urlId = "http://item.jumeiglobal.com/\\w+p(\\d+)[a-zA-Z0-9\\&%_.=]*";
		String ok = "http://item.jumei.com/\\w+p(\\d+)[a-zA-Z0-9\\&%_.=]*";
		String ok2 = "http://item.jumei.com/(\\d+)\\.html";
		String ok1 = "http://item.meilishuo.com/[a-zA-Z0-9\\&%/_.]*/(\\w+)\\?([a-zA-Z0-9\\&%_.=]*)";

		String test2 = "http://item.jumei.com/892053.html";

		String test = "http://item.jd.com/1369408834.html";

		// String ok = "(\\w+)";
		// String test = "海飞丝hs";

		String test1 = "http://item.meilishuo.com/h5sdf/asef/detail/1fu75zm?acm=1.ms.1.0.5800.yUhpNqFjeic.0";
		//
		// System.out.println(getMatcher(ok2, test));

		// System.out.println(getUrlId("http://ietem.meilishuo.com/h5/detail/1fu75zm?acm=1.ms.1.0.5800.yUhpNqFjeic.0"));
	}

	public static String getMatcher(String regex, String source) {
		String result = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(source);

		while (matcher.find()) {
			result = matcher.group(1);// 只取第一组
		}
		return result;
	}

	public static String getUrlId(String source) {
		String regex1 = "http://item.jumeiglobal.com/\\w+p(\\d+)[a-zA-Z0-9\\&%_.=]*";
		String regex2 = "http://item.jumei.com/\\w+p(\\d+)[a-zA-Z0-9\\&%_.=]*";
		String regex3 = "http://item.jumei.com/(\\d+)\\.html";
		String regex4 = "http://item.meilishuo.com/[a-zA-Z0-9\\&%/_.]*/(\\w+)\\?([a-zA-Z0-9\\&%_.=]*)";

		String result = "";

		result = getMatcher(regex1, source);
		if (StringUtils.isNotBlank(result)) {
			return result;
		} else {
			result = getMatcher(regex2, source);
			if (StringUtils.isNotBlank(result)) {
				return result;
			} else {
				result = getMatcher(regex3, source);
				if (StringUtils.isNotBlank(result)) {
					return result;
				} else {
					result = getMatcher(regex4, source);
					return result;
				}
			}
		}
	}
}
