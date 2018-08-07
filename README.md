# YounnoJPA


JPA(+Springboot) 를 학습중입니다.

1. JPA(+Springboot) 환경 구성
- JSP
- Embeded Tomcat 8.5
- Database : H2
- Encoding Filter : UTF-8
- Build : Gradle : 4.9 
- Webjars : bower.jquery:3.3.1, bower.bootstrap:4.1.3
- Lombok : 1.18.2
- Devtools 
- SpringBootVersion = 2.0.3.RELEASE

2. 조회 기능
- 검색조건(단일,다중)
- Paging 처리
3. 등록 기능
- CrudRepository 
4. 수정 기능
- CrudRepository
5. 삭제 기능
- CrudRepository
6. 화면 처리 
- Sitemesh 3.0.1 (Java Configuration)


해야할 것들.... 
1. 검색 기능 
- 다중 테이블 조회, 조회복잡도 상향, 통계 등 
- 검색방식 : JPQL(Java Persistence Query Language), Querydsl, Criteria Query 
2. 저장/수정/삭제 기능
- 트랜잭션 처리, 복수테이블 처리 
