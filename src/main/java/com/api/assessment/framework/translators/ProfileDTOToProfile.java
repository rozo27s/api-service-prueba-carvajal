package com.api.assessment.framework.translators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.api.assessment.framework.dto.ProfileDTO;
import com.api.assessment.framework.jpa.entity.Profile;
import com.api.assessment.framework.pattern.Translator;

/**
 * @author ajrozo
 */
@Component
@Qualifier("profileDTOToProfile")
public class ProfileDTOToProfile implements Translator<ProfileDTO, Profile> {

  @Override
  public Profile to(ProfileDTO input) {
    return input != null ? Profile.builder()
        .profileId(input.getProfileId())
        .name(input.getName())
        .lastname(input.getLastname())
        .email(input.getEmail())
        .password(input.getPassword())
        .build() : null;
  }
}
