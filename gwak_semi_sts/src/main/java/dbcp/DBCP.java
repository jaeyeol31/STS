package dbcp;


import java.io.*;
import java.sql.*;
import javax.naming.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.commons.logging.*;

import javax.sql.DataSource;

// DBCP 서블릿 정의
@WebServlet("/DBCP")
public class DBCP extends HttpServlet {
    // 로그 객체 생성
    private static Log log = LogFactory.getLog(DBCP.class);
    // 직렬화 버전 UID
    private static final long serialVersionUID = 1L;

    // HTTP GET 요청 처리 메서드
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            // 컨텍스트 객체 생성
            Context context = new InitialContext();
            // 데이터 소스 검색
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            // 데이터베이스 연결
            connection = dataSource.getConnection();
            // 로그 출력: 데이터베이스 연결 확인
            log.info(connection);
            log.info("데이터베이스와 연결되었습니다.");
        } catch (Exception e) {
            // 로그 출력: 데이터베이스 연결 실패
            log.info("데이터베이스 연결 실패 - " + e);
        } finally {
            try {
                // 연결 닫기
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}