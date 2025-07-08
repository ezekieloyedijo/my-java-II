package com.easyconcept.session1.solution1.serviceImpl;

import com.easyconcept.session1.solution1.dto.ResponseDto;
import com.easyconcept.session1.solution1.dto.StudentDto;
import com.easyconcept.session1.solution1.entity.Student;
import com.easyconcept.session1.solution1.repository.StudentRepository;
import com.easyconcept.session1.solution1.service.StudentService;

import java.util.*;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository = new StudentRepository();

    @Override
    public ResponseDto createStudent(StudentDto dto) {
        Student student = new Student(UUID.randomUUID(), dto.name, dto.age);
        repository.save(student);
        return new ResponseDto(true, "Student registered successfully!");
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    @Override
    public ResponseDto updateStudentAge(UUID id, int newAge) {
        Optional<Student> optionalStudent = repository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setAge(newAge);
            return new ResponseDto(true, "Student age updated.");
        }
        return new ResponseDto(false, "Student not found.");
    }

    @Override
    public ResponseDto deleteStudent(UUID id) {
        if (repository.findById(id).isPresent()) {
            repository.delete(id);
            return new ResponseDto(true, "Student deleted.");
        }
        return new ResponseDto(false, "Student not found.");
    }
}
