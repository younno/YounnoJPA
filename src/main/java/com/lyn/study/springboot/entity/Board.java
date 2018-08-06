package com.lyn.study.springboot.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Data
@Entity
@Table(name="board")
public class Board {
	
	private static final long serialVersionUID = 1L;
	
	// 해당 칼럼이 식별키라는 것을 지정하는 것입니다. 
	@Id 
	// Mysql에서 Auto Increment, Oracle 에서는 Sequence와 동일한 일을 합니다.  
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id; 
	
	private String title; 
	private String writer; 
	private String content; 
	
	// 엔티티가 생성되는 시점의 날짜 데이터를 기록하는 설정
	@CreationTimestamp 
	private Timestamp regDate; 
	// 엔티티가 업데이트되는 시점의 날짜 데이터를 기록하는 설정
	@UpdateTimestamp 
	private Timestamp modDate;	
	
	@Transient
	private String regDate1;
	
	@Transient
	private String regDate2;

}
