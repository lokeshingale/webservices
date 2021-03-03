package com.dev.service;

import java.util.List;

import com.dev.dto.StudentDTO;

public interface IStudentService {
public int regStudent(StudentDTO dto) throws Exception;
public List<StudentDTO> getStudentList() throws Exception;
public int deleteStudent(int studentNo) throws Exception;
}
