package com.lyn.study.springboot.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.SneakyThrows;

public class SqlUtils {
	
	public static String likeOpt(String var) {
		if(var != null) { 
			if(!var.trim().equals("")) {
				return "%" + var.trim() + "%";
			}
		}
		return "%%";
	}
	
	public static String likeLeftOpt(String var) {
		if(var != null) { 
			if(!var.trim().equals("")) {
				return "%" + var.trim();
			}
		}
		return "";
	}
	
	public static String likeRightOpt(String var) {
		if(var != null) { 
			if(!var.trim().equals("")) {
				return var.trim()+"%";
			}
		}
		return "";
	}
	
	public static String trimVal(String var) {
		if(var != null) { 
			return var.trim();
		}
		return "";
	}
	
	@SneakyThrows(Exception.class)
	public static Date stringToDate(String var) {
		if(var != null) { 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			return sdf.parse(var);
		}
		return null;
	}

}
