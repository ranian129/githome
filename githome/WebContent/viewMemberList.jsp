<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
</head>
<body>
MEMBER 테이블의 내용
<table width="100%" border="1">
<tr>
    <td>이름</td><td>아이디</td><td>이메일</td>
</tr>
<%
  // 1. JDBC 드라이버 로딩
  Class.forName("com.mysql.jdbc.Driver");

  Connection conn = null;
  Statement stmt = null;
  ResultSet rs = null;
  
  try {
      String jdbcDriver = "jdbc:mysql://localhost:3306/jspstudydb?" + 
              "useUnicode=true&characterEncoding=utf8";
      String dbUser = "jspstudy01";
      String dbPassword = "jspstudy01";
      String query = "select * from MEMBER order by MEMBERID";
      
      // 2. DB 연결 생성
      conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPassword);
      // 3. Statment 생성
      stmt = conn.createStatement();
      // 4. 쿼리 실행
      rs = stmt.executeQuery(query);
      
      // 5. 쿼리 실행 결과 출력
      while (rs.next()) {
%>
<tr>
    <td><%=rs.getString("NAME") %></td>
    <td><%=rs.getString("MEMBERID") %></td>
    <td><%=rs.getString("EMAIL") %></td>
</tr>
<%
      }
  } catch (SQLException ex) {
      out.println(ex.getMessage());
      ex.printStackTrace();
  } finally {
      // 6. ResultSet, Statement 종료
      if (rs != null) try { rs.close(); } catch (SQLException ex) {}
      if (stmt != null) try { stmt.close(); } catch (SQLException ex) {}
      // 7. DB 연결 종료
      if (conn != null) try { conn.close(); } catch (SQLException ex) {}
  }
%>
</table>
</body>
</html>