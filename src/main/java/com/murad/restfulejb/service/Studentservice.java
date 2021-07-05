package com.murad.restfulejb.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.murad.restfulejb.controller.Studentdao;
import com.murad.restfulejb.model.Student;

import javax.ws.rs.GET;

import java.util.List;
import javax.ejb.EJB;

import javax.ws.rs.Path;

@Path("students")
public class Studentservice
{
    @EJB
    private Studentdao dao;
    
    @GET
    @Produces({ "application/json" })
    public List<Student> getAllStudent() {
        return this.dao.getAllStudents();
    }
    
    @GET
    @Path("{id}")
    @Produces({ "application/json" })
    public Student getStudent(@PathParam("id") final int id) {
        return this.dao.getStudent(id);
    }
    
    @POST
    @Path("create")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Student addStudent(final Student student) {
        return this.dao.addStudent(student);
    }
    
    @PUT
    @Path("update")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Student updateStudent(final Student student) {
        return this.dao.updateStudent(student);
    }
    
    @DELETE
    @Path("delete/{id}")
    public boolean deleteStudent(@PathParam("id") final int id) {
        return this.dao.deleteStudent(id);
    }
}

