package com.murad.restfulejb.manytoonecontroller;

import java.util.List;
import com.murad.restfulejb.model.Comment;

public interface Dao
{
    Comment getComment(final int p0);
    
    List<Comment> getAllComment();
    
    Comment addComment(final Comment p0);
    
    Comment updateComment(final Comment p0);
    
    boolean deleteComment(final int p0);
}