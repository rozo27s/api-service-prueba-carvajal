package com.api.assessment.module.profile.service;

import com.api.assessment.framework.dto.Login;
import com.api.assessment.framework.dto.ProfileDTO;
import com.api.assessment.framework.dto.UpdatePassword;

/**
 * Interfaz para IActionRulesDataProvider
 *
 * @author Carvajal
 * @version 1.0
 *
 */

public interface ProfileService {

  public void createProfile(ProfileDTO profileDTO);

  public ProfileDTO findLogin(Login profile);

  public void updatepassword(UpdatePassword updatePassword);
 
}
