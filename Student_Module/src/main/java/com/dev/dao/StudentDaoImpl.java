package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.bo.StudentBO;
import com.dev.util.ConnectionUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public int saveStudent(StudentBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count;
		try {
			con=ConnectionUtil.getCon();
			ps=con.prepareStatement("insert into student(name, dob, doj) values(?,?,?)");
			ps.setString(1, bo.getName());
			ps.setDate(2, bo.getDob());
			ps.setDate(3, bo.getDoj());
			count=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
		return count;
	}

	@Override
	public List<StudentBO> getStudent() throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<StudentBO> listbo=null;
		try {
        	con=ConnectionUtil.getCon();
        	ps=con.prepareStatement("select student_no, name, dob, doj from student");
        	rs=ps.executeQuery();
        	listbo=new ArrayList<>();
        	while(rs.next()) {
        		StudentBO bo=new StudentBO();
        		bo.setStudent_No(rs.getInt(1));
        		bo.setName(rs.getString(2));
        		bo.setDob(rs.getDate(3));
        		bo.setDoj(rs.getDate(4));
        		listbo.add(bo);
        	}
        	
        }
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return listbo;
	}

	@Override
	public int removeStudent(int studentNo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			con=ConnectionUtil.getCon();
			ps=con.prepareStatement("delete from student where student_no=?");
			ps.setInt(1, studentNo);
			count=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
		return count;
	}

	@Override
	public int updateStudent(StudentBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int message;
		try {
			con=ConnectionUtil.getCon();
			ps=con.prepareStatement("update student set ");
			ps.setString(1, bo.getName());
			ps.setDate(2, bo.getDob());
			ps.setDate(3, bo.getDoj());
			message=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
		return 0;
	}

}
