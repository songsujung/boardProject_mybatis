package com.example.boardsj;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class BoardsjApplicationTests {

	@Test
	void contextLoads() {
	}

	    @Autowired
    private DataSource dataSource;

    @Test
    public void connectionTest() {
        try (Connection connection = dataSource.getConnection()){
            log.info("연결 성공......");    
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
