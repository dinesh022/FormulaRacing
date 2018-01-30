package com.niit.model;
 
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
 
@Entity
@Component
public class Category 
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int catId;
     

	@NotNull(message="please enter the username")
	@Size(min=5,max=10)
    String catName;
	
	
	
    String catDesc;
 
    public int getCatId() {
        return catId;
    }
 
    public void setCatId(int catId) {
        this.catId = catId;
    }
 
    public String getCatName() {
        return catName;
    }
 
    public void setCatName(String catName) {
        this.catName = catName;
    }
 
    public String getCatDesc() {
        return catDesc;
    }
 
    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }
     
     
}