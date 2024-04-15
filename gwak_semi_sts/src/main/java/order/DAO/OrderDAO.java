package order.DAO;

import order.DTO.OrderDTO;
import order.service.OrderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO implements OrderService {
    private static Log log = LogFactory.getLog(OrderDAO.class);

    @Override
    public ArrayList<OrderDTO> orderSelectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<OrderDTO> orderList = new ArrayList<OrderDTO>();

        try {
            // 데이터베이스 연결
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();

            // SQL 문 실행
            String sql = "SELECT * FROM orderlist";
            log.info("SQL 확인 - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            // 결과 처리
            while (resultSet.next()) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setOrderlist_num(resultSet.getString("orderlist_num"));
                orderDTO.setOrderlist_amount(resultSet.getInt("orderlist_amount"));
                orderDTO.setOrderlist_status(resultSet.getInt("orderlist_status"));
                orderDTO.setOrderlist_date(resultSet.getString("orderlist_date"));
                orderDTO.setOrder_id(resultSet.getString("order_id"));
                orderList.add(orderDTO);
            }
            resultSet.getRow();
            if (resultSet.getRow() == 0) {
                log.info("등록된 주문내역이 없습니다. 주문을 해주세요.");
            }
        } catch (Exception e) {
            log.error("전체 주문내역 조회 실패: " + e);
        } finally {
            // 연결 종료
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return orderList;
    }

    @Override
    public OrderDTO orderSelect(String orderlist_num) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        OrderDTO orderDTO = new OrderDTO();

        try {
            // 데이터베이스 연결
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();

            // SQL 문 실행
            String sql = "SELECT * FROM orderlist WHERE orderlist_num = ?";
            log.info("SQL 확인 - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orderlist_num);
            resultSet = preparedStatement.executeQuery();

            // 결과 처리
            while (resultSet.next()) {
                orderDTO.setOrderlist_num(resultSet.getString("orderlist_num"));
                orderDTO.setOrderlist_amount(resultSet.getInt("orderlist_amount"));
                orderDTO.setOrderlist_status(resultSet.getInt("orderlist_status"));
                orderDTO.setOrderlist_date(resultSet.getString("orderlist_date"));
                orderDTO.setOrder_id(resultSet.getString("order_id"));
            }

        } catch (Exception e) {
            log.error("특정 주문내역 조회 실패: " + e);
        } finally {
            // 연결 종료
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return orderDTO;
    }

    @Override
    public OrderDTO orderInsert(OrderDTO orderDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 데이터베이스 연결
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();
            // SQL 문 실행
            String sql = "INSERT INTO orderlist (orderlist_num, orderlist_amount, orderlist_status, orderlist_date, order_id) VALUES (?, ?, ?, ?, ?)";
            log.info("SQL 확인 - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orderDTO.getOrderlist_num());
            preparedStatement.setInt(2, orderDTO.getOrderlist_amount());
            preparedStatement.setInt(3, orderDTO.getOrderlist_status());
            preparedStatement.setString(4, orderDTO.getOrderlist_date());
            preparedStatement.setString(5, orderDTO.getOrder_id());

            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                connection.commit();
                log.info("커밋 되었습니다,");
            } else {
                connection.rollback();
                log.info("록백되었습니다.");
            }
        } catch (Exception e) {
            log.error("주문정보 삽입 실패: " + e);
        } finally {
            // 연결 종료
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return orderDTO;
    }

    @Override
    public OrderDTO orderUpdate(OrderDTO orderDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 데이터베이스 연결
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();


            // SQL 문 실행
            String sql = "UPDATE orderlist SET orderlist_amount=?, orderlist_status=?, orderlist_date=?, order_id=? WHERE orderlist_num=?";
            log.info("SQL 확인 - " + sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderDTO.getOrderlist_amount());
            preparedStatement.setInt(2, orderDTO.getOrderlist_status());
            preparedStatement.setString(3, orderDTO.getOrderlist_date());
            preparedStatement.setString(4, orderDTO.getOrder_id());
            preparedStatement.setString(5, orderDTO.getOrderlist_num());

            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                connection.commit(); // 커밋
                log.info("커밋 되었습니다.");
            } else {
                connection.rollback(); // 롤백
                log.error("롤백 되었습니다.");
            }
        } catch (Exception e) {
            log.error("주문 정보 업데이트 실패: " + e);
        } finally {
            // 연결 종료
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return orderDTO;
    }

    @Override
    public OrderDTO orderDelete(String orderlist_num) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 데이터베이스 연결
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
            connection = dataSource.getConnection();

            // SQL 문 실행
            String sql = "DELETE FROM orderlist WHERE orderlist_num=?";
            log.info("SQL 확인 - " + sql);

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orderlist_num);

            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                connection.commit(); // 커밋
                log.info("커밋 되었습니다.");
            } else {
                connection.rollback(); // 롤백
                log.error("롤백 되었습니다.");
            }
        } catch (Exception e) {
            log.error("주문 정보 삭제 실패: " + e);
        } finally {
            // 연결 종료
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
