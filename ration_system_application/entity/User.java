package com.example.ration_system_application.ration_system_application.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
	public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String rationCardNumber;
	    private String mobileNumber;
	    private String email;
	    private String status;  // ACTIVE, DEACTIVATED

	    @OneToMany(mappedBy = "user")
	    private List<RationRequest> rationRequests;

	    @OneToMany(mappedBy = "user")
	    private List<Grievance> grievances;

	    
	}



