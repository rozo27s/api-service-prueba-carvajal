package com.api.assessment.framework.translators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.api.assessment.framework.dto.ProfileDTO;
import com.api.assessment.framework.dto.PublicationDTO;
import com.api.assessment.framework.jpa.entity.Profile;
import com.api.assessment.framework.jpa.entity.Publication;
import com.api.assessment.framework.pattern.Translator;

import lombok.RequiredArgsConstructor;

/**
 * @author ajrozo
 */
@Component
@RequiredArgsConstructor
@Qualifier("publicationDTOToPublication")
public class PublicationDTOToPublication implements Translator<PublicationDTO, Publication> {

  @Qualifier("profileDTOToProfile")
  private final Translator<ProfileDTO, Profile> profileDTOToProfile;
  
  @Override
  public Publication to(PublicationDTO input) {
    
    if (input == null) {
      return null;
    }

    return Publication.builder()
        .publicationId(input.getPublicationId())
        .profile(profileDTOToProfile.to(input.getProfile()))
        .detailPublication(input.getDetailPublication())
        .active(true)
        .build();
  }
}
