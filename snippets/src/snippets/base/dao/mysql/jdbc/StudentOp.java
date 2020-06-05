package snippets.base.dao.mysql.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import snippets.base.model.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Random;

public class StudentOp {
    // JDBC连接的URL, 不同数据库有不同的格式:
    String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/sample?useSSL=false&characterEncoding=utf8";
    String JDBC_USER = "dev";
    String JDBC_PASSWORD = "123456";

    DataSource ds = null;

    public StudentOp() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(JDBC_USER);
        config.setPassword(JDBC_PASSWORD);
        config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
        config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
        config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10

        // 创建DataSource也是一个非常昂贵的操作
        // 所以通常DataSource实例总是作为一个全局变量存储，并贯穿整个应用程序的生命周期
        ds = new HikariDataSource(config);
    }

    public void query() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "select * from students";
            // 1.通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询
            try (Statement stmt = connection.createStatement()) {
                // 2. 执行Statement对象提供的executeQuery("SELECT * FROM students")并传入SQL语句，
                // 执行查询并获得返回的结果集，使用ResultSet来引用这个结果集
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        long id = rs.getLong(1);  // 注意：索引从1开始
                        String name = rs.getString(2);
                        short gender = rs.getShort(3);
                        int grade = rs.getInt(4);
                        int score = rs.getInt(5);

                        System.out.println("id: " + id + ", name: " + name + ", gender" + gender + ", grade: " + grade
                                + ", score:" + score);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void querySafe() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "select * from students where gender=? and grade=?";
            // 1.通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setObject(1, 1);
                ps.setObject(2, 3);
                // 2. 执行Statement对象提供的executeQuery("SELECT * FROM students")并传入SQL语句，
                // 执行查询并获得返回的结果集，使用ResultSet来引用这个结果集
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        long id = rs.getLong("id");  // 注意：索引从1开始
                        String name = rs.getString("name");
                        short gender = rs.getShort("gender");
                        int grade = rs.getInt("grade");
                        int score = rs.getInt("score");

                        System.out.println("id: " + id + ", name: " + name + ", gender" + gender + ", grade: " + grade
                                + ", score:" + score);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insert() {
        String sql = "insert into students (name, gender, grade, score) values (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, "测试用户");    // 注意：索引从1开始
                ps.setObject(2, 1);
                ps.setObject(3, 2);
                ps.setObject(4, 96);

                int n = ps.executeUpdate();
                System.out.println(n + " records inserted");

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        long id = rs.getLong(1);  // 注意：索引从1开始
                        System.out.println("generated key: " + id);
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update() throws SQLException {
        String sql = "update students set name=? where id=?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setObject(1, "被修改的名字");
                ps.setObject(2, 3);
                int n = ps.executeUpdate();
                System.out.println(n + " records updated");
            }
        }
    }

    public void delete(boolean throwException) throws Exception {
        String sql = "delete from students where id=?";
        if (throwException)
            throw new Exception("something wrong in delete");
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setObject(1, 1);
                int n = ps.executeUpdate();
                System.out.println(n + " records deleted");
            }
        }
    }

    public void transaction() throws Exception {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            // 设定隔离级别为READ COMMITTED,MySQL的默认隔离级别是REPEATABLE READ
            // conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            conn.setAutoCommit(false);
            String sqlInsert = "insert into students (name, gender, grade, score) values (?,?,?,?)";
            try (PreparedStatement ps = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, "测试用户");    // 注意：索引从1开始
                ps.setObject(2, 1);
                ps.setObject(3, 2);
                ps.setObject(4, 96);

                int n = ps.executeUpdate();
                System.out.println(n + " records inserted");
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        long id = rs.getLong(1);  // 注意：索引从1开始
                        System.out.println("generated key: " + id);
                    }
                }
            }
            String sqlDelete = "delete from students where id=?";
            try (PreparedStatement ps = conn.prepareStatement(sqlDelete)) {
                ps.setObject(1, 1);
                int n = ps.executeUpdate();
                System.out.println(n + " records deleted");
                throw new Exception("something wrong in delete");
            }

        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    public void batchInsert() {
        String sqlInsert = "insert into students (name, gender, grade, score) values (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
                for (int i = 0; i < 10; i++) {
                    ps.setObject(1, "批量插入测试" + i);
                    ps.setObject(2, i % 2 == 0 ? 1 : 0);
                    ps.setObject(3, 1);
                    ps.setObject(4, (int) (Math.random() * 100));
                    ps.addBatch();
                }
                int ns[] = ps.executeBatch();
                for (int n : ns) {
                    System.out.println(n + " inserted");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
