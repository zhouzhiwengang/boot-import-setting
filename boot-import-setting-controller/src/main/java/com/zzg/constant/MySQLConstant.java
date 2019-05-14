package com.zzg.constant;

import java.util.HashMap;
import java.util.Map;

// mysql 数据库支持数据类型
public class MySQLConstant {
	
	public static final String VARCHAR ="varchar";
	public static final String INTEGER ="integer";
	public static final String BLOB ="blob";
	public static final String BIT ="bit";
	public static final String BIGINT ="bigint";
	public static final String FLOAT ="float";
	public static final String DOUBLE ="double";
	public static final String DECIMAL ="decimal";
	public static final String DATETIME ="datetime";
	public static final String LONG ="long";
	
	public static Map getMySQLDataType(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("字符串", VARCHAR);
		map.put("整型", INTEGER);
		map.put("大文本", BLOB);
		map.put("位", BIT);
		map.put("长整型", BIGINT);
		map.put("单精度", FLOAT);
		map.put("双精度", DOUBLE);
		map.put("多精度", DECIMAL);
		map.put("日期类型", DATETIME);
		map.put("长整型", LONG);
		return map;
	}
}
