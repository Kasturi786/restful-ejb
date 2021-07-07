package com.murad.restfulejb.manytoonecontroller;

import java.util.List;
import javax.persistence.Persistence;

import com.murad.restfulejb.model.Comment;
import com.murad.restfulejb.model.Post;

import javax.persistence.EntityTransaction;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@LocalBean
@Stateless
public class Commentdao implements Dao
{
    private EntityManager em;
    private EntityTransaction tr;
    
    public Commentdao() {
        this.em = Persistence.createEntityManagerFactory("restfulejb").createEntityManager();
        this.tr = this.em.getTransaction();
    }
    
    @Override
    public Comment getComment(final int id) {
        return this.em.find(Comment.class, id);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Comment> getAllComment() {
        return this.em.createQuery("Select c from Comment c").getResultList();
    }
    
    @Override
    public Comment addComment(final Comment comment) {
    	final Comment newcomment = new Comment();
    	Post post = new Post();
    	if (comment.getPost() !=0) {
    		newcomment.setPost(em.find(Post.class, comment.getPost()));
    	} else {
    		post.setName(comment.getPostName());
    		newcomment.setPost(post);
    	}
    	
    	newcomment.setReview(comment.getReview());
    	
    	
        this.tr.begin();
        this.em.persist(newcomment);
        this.tr.commit();
        return comment;
    }
    
    @Override
    public Comment updateComment(final Comment comment) {
        return null;
    }
    
    @Override
    public boolean deleteComment(final int id) {
        return false;
    }
}