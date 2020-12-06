package com.h194qs.app.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    
    @Column(name = "role")
    private String role;
    
	
    public String getRole() {
		return role;
	}
    
}