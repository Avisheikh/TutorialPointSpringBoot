//package com.example.DTO.services;
//
//import com.example.DTO.dto.StudentDto;
//import com.example.DTO.entites.StudentEntity;
//import com.example.DTO.mapper.StudentMapper;
//import com.example.DTO.repo.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StudentService
//{
//    @Autowired
//    private StudentRepo studentRepo;
//
//    private StudentMapper studentMapper;
//
//    public List<StudentDto> getStudent()
//    {
//        List<StudentEntity> studentEntityList = studentRepo.findAll();
//        List<StudentDto> studentDtoList = studentMapper.entityListToDtoList(studentEntityList);
//        return studentDtoList;
//    }
//}
