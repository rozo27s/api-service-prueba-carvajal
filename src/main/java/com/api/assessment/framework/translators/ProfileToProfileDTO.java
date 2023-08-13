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
@Qualifier("profileToProfileDTO")
public class ProfileToProfileDTO implements Translator<Profile, ProfileDTO> {

  @Override
  public ProfileDTO to(Profile input) {
    return input != null ? ProfileDTO.builder()
        .profileId(input.getProfileId())
        .name(input.getName())
        .lastname(input.getLastname())
        .email(input.getEmail())
        .creationDate(input.getCreationDate())
        .build() : null;
  }
}
