package com.easyconcept.session6;

import java.util.Optional;

// This is the class that receives the dto coming
// The class does not need to know the implementation details of the saved method in
// the repository, it just calls it to use

public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository = new StudentRepository();
    @Override
    public ResponseDto addStudent(StudentDto studentDto) {
        Student student = new Student(studentDto);
        System.out.println(student.toString());
        Optional<Student> optionalStudent = studentRepository.save(student);
        if(optionalStudent.isEmpty()) return new ResponseDto(false, "Something went wrong!!! Could not saved Student", null);
        Student savedStudent = optionalStudent.get();
        StudentResponseDto studentResponseDto = new StudentResponseDto(savedStudent);
        return new ResponseDto(true, "Student created Successfully", studentResponseDto );
    }


}
