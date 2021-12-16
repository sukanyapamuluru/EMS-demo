package com.ciq.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ciq.sms.model.Student;
import com.ciq.sms.quries.StudentQueries;
import com.ciq.sms.util.Connection_Util_Java;



public class StuDaoImp implements StuDao {
	
	public void insert(Student student) {
		
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		try {
			connection= Connection_Util_Java.getConnection();

			preparedStatement= connection.prepareStatement(StudentQueries.STUDENT_INSERT_QUERY);
			preparedStatement.setInt(1, student.getSID());
			preparedStatement.setString(2, student.getSNAME());
			preparedStatement.setDouble(3, student.getSFEE());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		}
	
	public void update(Student student) {
		
		Connection connection=null;
		PreparedStatement preparedstatement= null;
		
		try {
			connection = Connection_Util_Java.getConnection();

			preparedstatement= connection.prepareStatement(StudentQueries.STUDENT_UPDATE_QUERY);
			preparedstatement.setString(1, student.getSNAME());
			preparedstatement.setDouble(2, student.getSFEE());
			preparedstatement.setInt(3, student.getSID());

			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	public void delete(int  SID) {
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		
		try {
			
			connection= Connection_Util_Java.getConnection();
			preparedStatement= connection.prepareStatement(StudentQueries.STUDENT_DELETE_QUERY);
			preparedStatement.setInt(1, SID);
			preparedStatement.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	 
	public Student findById(int SID) {
		
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet=null;
		Student student= null;
		
		
		
		try {
			connection= Connection_Util_Java.getConnection();

			preparedStatement= connection.prepareStatement(StudentQueries.STUDENT_FINDBY_ID_QUERY);
			preparedStatement.setInt(1, student.getSID());
			resultSet= preparedStatement.executeQuery();
			if (resultSet.next()) {
				student.setSID(resultSet.getInt("SID"));
				student.setSNAME(resultSet.getString("SNAME"));
				student.setSFEE(resultSet.getDouble("SFEE"));
				
		}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connection_Util_Java.close(resultSet, preparedStatement, connection);;
		}  return student;
		
		
	}
	
	public List<Student> findByName (String SNAME) {
		
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet=null;
		List <Student> students= null;
		
		try {
			connection= Connection_Util_Java.getConnection();

			preparedStatement= connection.prepareStatement(StudentQueries.STUDENT_FINDBY_NAME_QUERY);
			preparedStatement.setString(1, SNAME);
			resultSet= preparedStatement.executeQuery() ;
			students=new ArrayList<>();
			
			if (resultSet.next()) {
				Student student= new Student();
				student.setSID(resultSet.getInt("SID"));
				student.setSNAME(resultSet.getString("SNAME"));
				student.setSFEE(resultSet.getDouble("SFEE"));
				students.add(student);
				
			
		} 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return students;

		
		
	}

	public List<Student> findAll(){
		
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet= null;
		List<Student> students= null;
		try {
			connection= Connection_Util_Java.getConnection();

			preparedStatement= connection.prepareStatement(StudentQueries.STUDENT_FINDALL_QUERY);
			resultSet=preparedStatement.executeQuery();
			students= new ArrayList<Student>();
			while (resultSet.next()) {
				Student student= new Student();
				student.setSID(resultSet.getInt("SID"));
				student.setSNAME(resultSet.getString("SNAME"));
				student.setSFEE(resultSet.getDouble("SFEE"));
				students.add(student);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connection_Util_Java.close(resultSet, preparedStatement, connection);
		}
		return students;
		

		
	}


	}


