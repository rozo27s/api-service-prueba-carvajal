package com.api.assessment.module.profile.service.impl;


import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.api.assessment.framework.dto.Login;
import com.api.assessment.framework.dto.ProfileDTO;
import com.api.assessment.framework.dto.UpdatePassword;
import com.api.assessment.framework.exception.BadRequestException;
import com.api.assessment.framework.jpa.crudrepository.ProfileRepository;
import com.api.assessment.framework.jpa.entity.Profile;
import com.api.assessment.framework.pattern.Translator;
import com.api.assessment.module.profile.service.ProfileService;

import lombok.RequiredArgsConstructor;

/**
 * Logica para la conexion a tabla permite metodos crud
 *
 * @author Carvajal
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

  private final Translator<ProfileDTO, Profile> profileDTOToProfile;
  private final Translator<Profile, ProfileDTO> profileToProfileDTO;
  private final ProfileRepository profileRepository;
  
  @Override
  public void createProfile(ProfileDTO profileDTO) {
    Profile profileEsist = profileRepository.findByEmail(profileDTO.getEmail());
    if (profileEsist != null) {
      throw new BadRequestException("Email ya registrdo");
    }
    Profile profile = profileDTOToProfile.to(profileDTO);
    profile.setCreationDate(LocalDateTime.now());
    profileRepository.save(profile);
  }

  @Override
  public ProfileDTO findLogin(Login profile) {
    return profileToProfileDTO.to(profileRepository.findByEmailAndPassword(
        profile.getEmail(),
        profile.getPassword()));
  }

  @Override
  public void updatepassword(UpdatePassword updatePassword) {
    Profile profile = profileRepository.findByEmail(updatePassword.getEmail());
    if (profile == null) {
      throw new BadRequestException("El perfil no existe");
    }
    profile.setPassword(updatePassword.getPassword());
    profileRepository.save(profile);
  }

}
