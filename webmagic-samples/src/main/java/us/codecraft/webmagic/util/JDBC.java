package us.codecraft.webmagic.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private static Connection conn;
	private static Statement stmt;

	public JDBC() {
		final String driver = ConfigReader.getConfig("MYSQL_SERVER");
		final String url = ConfigReader.getConfig("MYSQL_URL");
		final String user = ConfigReader.getConfig("MYSQL_USER");
		final String password = ConfigReader.getConfig("MYSQL_PASSWORD");
		try {
			// 加载驱动
			Class.forName(driver);
			// 连接数据库
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("The database connection is successful!");
		} catch (Exception e) {
			logger.error("mysql操作异常", e);
		}
	}

	// 插入语句
	public void insert(String sql) {
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			logger.error("mysql操作异常", e);
		}
	}

	// 查询语句
	public ResultSet select(String sql) {
		try {
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			logger.error("mysql操作异常", e);
		}
		return null;
	}

	/**
	 * 关闭数据库
	 */
	public void close() {
		try {
			if (null != conn)
				conn.close();
			System.out.println("Close the database connection successfully!");
		} catch (SQLException e) {
			logger.error("mysql操作异常", e);
		}
	}

	public static void main(String[] args) {
		JDBC jdbc = new JDBC();
		jdbc.insert("INSERT INTO cellphoneInfo(id,name) VALUES('123', '小米5'),('1234','小米6')");
		jdbc.close();
	}
}