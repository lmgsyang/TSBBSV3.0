package com.ts.bbs.util;

import java.text.SimpleDateFormat;

public class TimeUtil {
   public static String getCurrentTime(){
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   return sdf.format(new java.util.Date());
   }
}
