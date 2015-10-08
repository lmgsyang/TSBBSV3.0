package com.ts.bbs.util;

public class StringUtil {
	/**
	 * 过滤HTML代码
	 * @param value
	 * @return
	 */
	public static String filterHTML(String value){
		value = value.replaceAll("&", "&amp;");
		value = value.replaceAll("<", "&lt;");
		value = value.replaceAll(">", "&gt;");
		value = value.replaceAll(" ", "&nbsp;");
		value = value.replaceAll("'", "&#39;");
		value = value.replaceAll("\"", "&quot;");
		value = value.replaceAll("\n", "<br>");
		return value;
	}
}
