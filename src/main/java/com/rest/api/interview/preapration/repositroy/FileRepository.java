// FileRepository.java
package com.rest.api.interview.preapration.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.interview.preapration.model.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
