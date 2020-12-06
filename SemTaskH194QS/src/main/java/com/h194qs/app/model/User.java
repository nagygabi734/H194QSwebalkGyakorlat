package com.h194qs.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "user_id")
	    private Integer id;
	   
		@Column(name = "user_name")
	    private String userName;
	   
	    @Column(name = "email")
	    private String email;
	    
	    @Column(name = "password")
	    private String password;
	    
	    @Column(name = "name")
	    private String name;
	   
	    @Column(name = "last_name")
	    private String lastName;
	   
	    @Column(name = "active")
	    private Boolean active;
	   
	    @ManyToMany(cascade = CascadeType.MERGE)
	    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles;
	    
	    public String getUserName() {
			return userName;
		}
			
		public String getPassword() {
			return password;
		}
		
		public String getName() {
			return name;
		}
		
		public Boolean getActive() {
			return active;
		}
		
		public Set<Role> getRoles() {
			return roles;
		}
		   
}