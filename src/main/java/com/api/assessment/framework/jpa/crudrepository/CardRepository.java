package com.api.assessment.framework.jpa.crudrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.assessment.framework.jpa.entity.Profile;

/**
 * 
 * @author ajrozo
 *
 */
@Repository
public interface CardRepository extends JpaRepository<Profile, Long> {

  Profile findByProfileId(Long pan);

}
