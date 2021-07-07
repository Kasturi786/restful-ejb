package com.murad.restfulejb.onetomanycontroller;

import javax.ejb.EJBException;
import java.util.List;

import javax.persistence.Persistence;
import com.murad.restfulejb.model.Post;

import javax.persistence.EntityTransaction;
import javax.persistence.EntityManager;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Postdao implements Dao
{
    private EntityManager em;
    private EntityTransaction tr;
    
    public Postdao() {
        this.em = Persistence.createEntityManagerFactory("restfulejb").createEntityManager();
        this.tr = this.em.getTransaction();
    }
    
    @Override
    public Post getPost(final int id) {
        return this.em.find(Post.class, id);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Post> getAllPost() {
        return this.em.createQuery("Select p from Post p").getResultList();
    }
    
    @Override
    public Post addPost(final Post post) {
        final Post newpost = new Post();
        newpost.setName(post.getName());
        post.getComments().stream().forEach(c -> newpost.addComment(c));
        this.tr.begin();
        this.em.persist(newpost);
        this.tr.commit();
        return newpost;
    }
    
    @Override
    public Post updatePost(final Post post) {
        if (post.getId() != 0) {
            final Post update = this.getPost(post.getId());
            update.setName(post.getName());
            post.getComments().stream().forEach(c -> update.addComment(c));
            this.tr.begin();
            this.em.merge((Object)update);
            this.tr.commit();
            return update;
        }
        return post;
    }
    
    @Override
    public boolean deletePost(final int id) {
        boolean bool = false;
        final Post post = this.getPost(id);
        if (post != null) {
            try {
                this.tr.begin();
                this.em.remove((Object)post);
                bool = true;
                this.tr.commit();
            }
            catch (Exception e) {
                throw new EJBException(e);
            }
        }
        return bool;
    }
}