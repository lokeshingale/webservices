package com.dev.dao;

import java.util.List;

import com.dev.bo.StudentBO;

public interface IStudentDao {
public int saveStudent(StudentBO bo) throws Exception;
public List<StudentBO> getStudent() throws Exception;
public int removeStudent(int studentNo)throws Exception;
public int updateStudent(StudentBO bo)throws Exception;
}
