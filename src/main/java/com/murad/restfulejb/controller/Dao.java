package com.murad.restfulejb.controller;

import java.util.List;
import com.murad.restfulejb.model.Student;

public interface Dao
{
    Student getStudent(final int p0);
    
    List<Student> getAllStudents();
    
    Student addStudent(final Student p0);
    
    Student updateStudent(final Student p0);
    
    boolean deleteStudent(final int p0);
}