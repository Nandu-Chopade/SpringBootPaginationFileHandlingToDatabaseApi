package com.rest.api.interview.preapration.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private long fileSize;

    @Lob  // Binary will be convert from byte array ---> who will convert hibernate
    @Column(length = 1048760) // Adjust the length based on your requirements (e.g., 10 MB)
    private byte[] fileContent; // Store file content as a byte array

    // Constructors, getters, and setters
}
