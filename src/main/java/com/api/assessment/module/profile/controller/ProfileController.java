package com.api.assessment.module.profile.controller;

import org.springframework.stereotype.Service;

import com.api.assessment.framework.dto.Login;
import com.api.assessment.framework.dto.ProfileDTO;
import com.api.assessment.framework.dto.UpdatePassword;
import com.api.assessment.module.profile.service.ProfileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author ajrozo
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class ProfileController {
  
  private final ProfileService profileService;
  
  public void createProfile(ProfileDTO profileDTO) {
    log.info("createProfile -> {}", profileDTO.getEmail());
    profileService.createProfile(profileDTO);    
  }

  public ProfileDTO getLogin(Login profile) {
    return profileService.findLogin(profile);
  }

  public void updatePass(UpdatePassword updatePassword) {
    profileService.updatepassword(updatePassword);
  }

}