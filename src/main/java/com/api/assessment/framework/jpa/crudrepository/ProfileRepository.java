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
public interface ProfileRepository extends JpaRepository<Profile, Long> {

  Profile findByEmailAndPassword(String email, String password);
  Profile findByEmail(String email);

}
