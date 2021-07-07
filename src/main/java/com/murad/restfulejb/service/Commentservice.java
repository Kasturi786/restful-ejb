package com.murad.restfulejb.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import java.util.List;
import javax.ws.rs.Produces;

import com.murad.restfulejb.manytoonecontroller.Commentdao;
import com.murad.restfulejb.model.Comment;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ejb.EJB;
import javax.ws.rs.Path;

@Path("comments")
public class Commentservice
{
    @EJB
    private Commentdao dao;
    
    @GET
    @Path("{id}")
    @Produces({ "application/json" })
    public Comment getComment(@PathParam("id") final int id) {
        return this.dao.getComment(id);
    }
    
    @GET
    @Produces({ "application/json" })
    public List<Comment> getAllComment() {
        return this.dao.getAllComment();
    }
    
    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Comment addComment(final Comment comment) {
        return this.dao.addComment(comment);
    }
    
    public Comment updateComment(final Comment comment) {
        return null;
    }
    
    public boolean deleteComment(final int id) {
        return false;
    }
}