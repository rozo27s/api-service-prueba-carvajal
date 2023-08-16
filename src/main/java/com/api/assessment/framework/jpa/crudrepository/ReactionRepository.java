package com.api.assessment.framework.jpa.crudrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.assessment.framework.jpa.entity.Reaction;

/**
 * 
 * @author ajrozo
 *
 */
@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {

}
