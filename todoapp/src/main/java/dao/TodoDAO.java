package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Todo;

public class TodoDAO {
	// DBとの接続を保持するインスタンス
	private Connection db;
	// SQL文を保持するインスタンス
	private PreparedStatement ps;
	// 結果セットを保持するインスタンス
	private ResultSet rs;

	// 接続共通処理
	private void connect() throws NamingException, SQLException {
		// コンテキストインスタンスの取得
		Context context = new InitialContext();
		// 接続情報を持つデータソースインスタンスの作成
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsp");
		// DBに接続する処理
		this.db = ds.getConnection();
	}

	// 切断共通処理
	private void disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Todo> findAll() {
		List<Todo> list = new ArrayList<>();
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM todo ORDER BY degree desc");
			rs = ps.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				int degree = rs.getInt("degree");
				int id = rs.getInt("id");
				list.add(new Todo(id, title, degree));
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
		}
		return list;
	}

	public void insertOne(Todo todo) {
		try {
			this.connect();
			ps = db.prepareStatement("INSERT INTO todo(title,degree) VALUES(?,?)");
			ps.setString(1, todo.getTitle());
			ps.setInt(2, todo.getDegree());
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
		}
	}
	public Todo findOne(int id) {
		Todo todo = null;
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM todo WHERE id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title =rs.getString("title");
				int degree = rs.getInt("degree");
				todo = new Todo(id, title, degree);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return todo;
	}
}