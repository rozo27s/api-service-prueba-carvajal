package com.api.assessment.framework.jpa.crudrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.assessment.framework.jpa.entity.Comment;

/**
 * 
 * @author ajrozo
 *
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
