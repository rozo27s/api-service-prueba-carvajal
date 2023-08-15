package com.api.assessment.framework.jpa.crudrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.api.assessment.framework.jpa.entity.Profile;

/**
 * 
 * @author ajrozo
 *
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
  @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
  Profile findByEmailAndPassword(String email, String password);
  
  @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
  Profile findByEmail(String email);
  
  @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
  @Query(value = "SELECT p FROM Profile p "
      + "WHERE LOWER(p.email) LIKE %:hint% "
      + "OR LOWER(p.lastname) LIKE %:hint% "
      + "OR LOWER(p.name) LIKE %:hint% ")
  List<Profile> findByHint(@Param("hint") String hint);

}
