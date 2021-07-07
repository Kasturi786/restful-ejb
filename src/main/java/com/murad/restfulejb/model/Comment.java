package com.murad.restfulejb.model;

import org.codehaus.jackson.annotate.JsonBackReference;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "commentpost")
public class Comment implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "review")
    private String review;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "postId")
    @JsonBackReference
    private Post post;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getReview() {
        return this.review;
    }
    
    public void setReview(final String review) {
        this.review = review;
    }
    
    public int getPost() {
        return this.post.getId();
    }
    
    public void setPost(final Post post) {
        this.post = post;
    }
    
    public String getPostName() {
    	return this.post.getName();
    }
    
    
}
