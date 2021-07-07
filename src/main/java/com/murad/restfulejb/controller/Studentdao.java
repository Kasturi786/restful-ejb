package com.murad.restfulejb.controller;

import javax.ejb.EJBException;
import java.util.List;
import javax.persistence.Persistence;

import com.murad.restfulejb.model.Student;

import javax.persistence.EntityTransaction;
import javax.persistence.EntityManager;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Studentdao implements Dao
{
    private EntityManager em;
    private EntityTransaction tr;
    
    public Studentdao() {
    	this.em = Persistence.createEntityManagerFactory("restfulejb").createEntityManager();
    	this.tr = em.getTransaction();
    }
    
    @Override
    public Student getStudent(final int id) {
    
		final Student student = (Student)this.em.find(Student.class, id);
        return student;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Student> getAllStudents() {
        return (List<Student>)this.em.createQuery("Select s from Student s").getResultList();
    }
    
    @Override
    public Student addStudent(Student student) {
        try {
            try {
                this.tr.begin();
                this.em.persist(student);
            }
            finally {
                this.tr.commit();
            }
            this.tr.commit();
        }
        catch (Exception e) {
            throw new EJBException(e);
        }
        return student;
    }
    
    @Override
    public Student updateStudent(Student student) {
        Student record = this.getStudent(student.getId());
        if (record != null) {
            record.setCity(student.getCity());
            record.setCountry(student.getCountry());
            record.setEmail(student.getEmail());
            record.setName(student.getName());
            record.setRegion(student.getEmail());
            record.setZip(student.getZip());
            try {
                try {
                    this.tr.begin();
                    this.em.merge(record);
                }
                finally {
                    this.tr.commit();
                }
                this.tr.commit();
            }
            catch (Exception e) {
                throw new EJBException(e);
            }
        }
        return record;
    }
    
    @Override
    public boolean deleteStudent(int id) {
        boolean bool = false;
        Student student = this.getStudent(id);
        if (student != null) {
            try {
                try {
                    this.tr.begin();
                    this.em.remove(student);
                    bool = true;
                }
                finally {
                    this.tr.commit();
                }
                this.tr.commit();
            }
            catch (Exception e) {
                throw new EJBException(e);
            }
        }
        return bool;
    }
}

