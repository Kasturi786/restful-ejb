package com.murad.restfulejb.onetomanycontroller;

import java.util.List;

import com.murad.restfulejb.model.Post;

public interface Dao
{
    Post getPost(final int p0);
    
    List<Post> getAllPost();
    
    Post addPost(final Post p0);
    
    Post updatePost(final Post p0);
    
    boolean deletePost(final int p0);
}