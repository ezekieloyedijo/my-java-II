package com.easyconcept.session1.solution1.service;

import com.easyconcept.session1.solution1.dto.ResponseDto;
import com.easyconcept.session1.solution1.dto.StudentDto;
import com.easyconcept.session1.solution1.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    ResponseDto createStudent(StudentDto dto);
    List<Student> getAllStudents();
    Student getStudentByName(String name);
    ResponseDto updateStudentAge(UUID id, int newAge);
    ResponseDto deleteStudent(UUID id);
}
