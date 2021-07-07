package com.murad.restfulejb.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import com.murad.restfulejb.model.Post;
import javax.ws.rs.PathParam;
import javax.ejb.EJB;
import com.murad.restfulejb.onetomanycontroller.Postdao;
import javax.ws.rs.Path;

@Path("posts")
public class Postservice
{
    @EJB
    private Postdao dao;
    
    @GET
    @Path("{id}")
    @Produces({ "application/json" })
    public Post getComment(@PathParam("id") final int id) {
        return this.dao.getPost(id);
    }
    
    @GET
    @Produces({ "application/json" })
    public List<Post> getAllComment() {
        return this.dao.getAllPost();
    }
    
    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Post addComment(final Post post) {
        return this.dao.addPost(post);
    }
    
    @PUT
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Post updateComment(final Post post) {
        return this.dao.updatePost(post);
    }
    
    @DELETE
    @Path("{id}")
    @Produces({ "application/json" })
    public boolean deleteComment(@PathParam("id") final int id) {
        return this.dao.deletePost(id);
    }
}