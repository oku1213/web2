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

import model.Person;

public class PersonDAO {
	//DBとの接続を保持するインスタンス
	private Connection db;
	//SQL文を保持するインスタンス
	private PreparedStatement ps;
	//結果セットを保持するインスタンス
	private ResultSet rs;
	//接続共通処理
	private void connect() throws NamingException, SQLException {
		//コンテキストインスタンスの取得
		Context context = new InitialContext();
		//接続情報を持つデータソースインスタンスの作成
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsp");
		//DBに接続する処理
		this.db = ds.getConnection();
	}
	//切断共通処理
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
	public List<Person> findAll(){
		List<Person> list=new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM persons");
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				list.add(new Person(id,name,age));
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally{
			this.disconnect();
		}
		return list;
	}
	
	public void insertOne(Person person) {
		try {
			this.connect();
			ps = db.prepareStatement("INSERT INTO persons(name, age) VALUES(?, ?)");
			//1つ目の？に値をセット
			ps.setString(1,  person.getName());
			//2つ目の？に値をセット
			ps.setInt(2,  person.getAge());
			//SQLを実行
			ps.executeUpdate();
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public Person findOne(int id) {
		Person person = null;
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM persons WHERE id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				person = new Person(id, name, age);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return person;
	}
	public void updateOne(Person person) {
		try {
			this.connect();
			ps = db.prepareStatement("UPDATE persons SET name=?, age=? WHERE id=?");
			ps.setString(1, person.getName());
			ps.setInt(2, person.getAge());
			ps.setInt(3, person.getId());
			ps.executeUpdate();
			System.out.println(ps);
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public void deleteOne(int id) {
		try {
			this.connect();
			ps = db.prepareStatement("DELETE FROM persons WHERE id=?");
		    ps.setInt(1, id);
		    ps.execute();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
}