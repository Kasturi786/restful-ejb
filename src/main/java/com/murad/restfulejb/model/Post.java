package com.murad.restfulejb.model;

import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonManagedReference;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "post")
public class Post implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "post", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    List<Comment> comments;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    @JsonManagedReference
    public List<Comment> getComments() {
        return this.comments;
    }
    
    public void setComments(final List<Comment> comments) {
        this.comments = comments;
    }
    
    public void addComment(final Comment comment) {
        if (this.comments == null) {
            this.comments = new ArrayList<Comment>();
        }
        this.comments.add(comment);
        comment.setPost(this);
    }
}