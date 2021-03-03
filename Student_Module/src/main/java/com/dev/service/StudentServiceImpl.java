package com.dev.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.dev.bo.StudentBO;
import com.dev.dao.IStudentDao;
import com.dev.dto.StudentDTO;

public class StudentServiceImpl implements IStudentService {
	@Inject
	private IStudentDao dao;
	@Override
	public int regStudent(StudentDTO dto) throws Exception {
		int result=0;
		StudentBO bo=new StudentBO();
		bo.setName(dto.getName());
		//bo.setDob(java.sql.Date.);
		//bo.setDoj(java.sql.Date.valueOf(dto.getDoj()));
		result=dao.saveStudent(bo);
		return result;
	}
	@Override
	public List<StudentDTO> getStudentList() throws Exception {
		List<StudentDTO> listDto=new ArrayList<>();
		List<StudentBO> listBo=null;
		
		listBo=dao.getStudent();
		listBo.forEach(bo->{
			StudentDTO dto=new StudentDTO();
		dto.setStudent_No(bo.getStudent_No());
		dto.setName(bo.getName());
		//LocalDate d= LocalDate.parse(new SimpleDateFormat("yyyy-mm-dd").format(bo.getDob()));
		dto.setDob(bo.getDob());
		//LocalDate d1= LocalDate.parse(new SimpleDateFormat("yyyy-mm-dd").format(bo.getDob()));
		dto.setDoj(bo.getDoj());
		dto.setSerialNo(listDto.size()+1);
		listDto.add(dto);
		});
		return listDto;
	}
	@Override
	public int deleteStudent(int studentNo) throws Exception {
		int result=0;
		result=dao.removeStudent(studentNo);
		return result;
	}

}
