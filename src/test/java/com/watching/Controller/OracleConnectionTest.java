package com.watching.Controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {

	private static final Logger logger = LoggerFactory.getLogger(OracleConnectionTest.class);
	
	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    private static final String USER = "watching";
    private static final String PW = "watching";
    
    @Test //JUnit가 테스트 하는 코드
    public void testConnection() throws Exception{
        Class.forName(DRIVER);
        //try ~ with 문 (java 버전이 1.7 이상이 되야 에러가 나지 않는다)(finally 절이 필요 없음)
        //try 옆에 ()안에 커넥션이 들어있기 때문에 con.clo
        try (Connection conn = DriverManager.getConnection(URL, USER, PW)) 
        {
            System.out.println("오라클에 연결되었습니다.");
            logger.info("오라클에 연결되었습니다.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
