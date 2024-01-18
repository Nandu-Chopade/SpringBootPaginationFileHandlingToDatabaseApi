package com.rest.api.interview.preapration.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames="email"))
public class UserDeatils {
   

	 @Id
	 @GeneratedValue
	 private Long userId;
	 
	 @NotBlank(message ="First name is required")
	 @Size(max = 50 , message = "First name must be at most 50 charecter")
	 private String firstName;
	 
	 @NotBlank(message = "Last name is required")
	 @Size(max=50 , message = "Last name must be at most 50 charecters")
	 private String lastName;
	 
	 @NotNull(message="Mobile number is required")
	 @Pattern(regexp = "\\d{10}" , message = "Mobile number must be 10 digits" )
	 private Long mobile;
	 
	 @NotBlank(message = "Email is required")
	 @Email(message = "Invalid email format")
	 @Column(unique = true)
	 private String email;
	 
	 @NotBlank
	 @Size(min = 8 , message="Password must be at least 8 charecter")
	 private String password;
	 
	 private String Address;
	 private String role;
	 @Column(name="register_date")
	 private Date date;
	 
	 @Lob
	 @Column(name="profile_picture")
	 private Byte[] profilePic;
	 
}
