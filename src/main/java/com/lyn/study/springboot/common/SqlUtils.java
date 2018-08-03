package com.lyn.study.springboot.common;

public class SqlUtils {
	
	public static String likeOpt(String var) {
		if(var != null) { 
			if(!var.trim().equals("")) {
				return "%" + var.trim() + "%";
			}
		}
		return "";
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

}
