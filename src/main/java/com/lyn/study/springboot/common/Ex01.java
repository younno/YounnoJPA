package com.lyn.study.springboot.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex01 {

	public static void main(String[] ar) {
		System.out.println(LocalDate.parse("20180102",DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay());
	}
}
