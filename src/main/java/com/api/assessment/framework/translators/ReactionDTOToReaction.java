package com.api.assessment.framework.translators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.api.assessment.framework.dto.ProfileDTO;
import com.api.assessment.framework.dto.PublicationDTO;
import com.api.assessment.framework.dto.ReactionDTO;
import com.api.assessment.framework.jpa.entity.Profile;
import com.api.assessment.framework.jpa.entity.Publication;
import com.api.assessment.framework.jpa.entity.Reaction;
import com.api.assessment.framework.pattern.Translator;

import lombok.RequiredArgsConstructor;

/**
 * @author ajrozo
 */
@Component
@RequiredArgsConstructor
@Qualifier("reactionDTOToReaction")
public class ReactionDTOToReaction implements Translator<ReactionDTO, Reaction> {

  @Qualifier("profileDTOToProfile")
  private final Translator<ProfileDTO, Profile> profileDTOToProfile;
  @Qualifier("publicationDTOToPublication")
  private final Translator<PublicationDTO, Publication> publicationDTOToPublication;
  
  @Override
  public Reaction to(ReactionDTO input) {
    
    if (input == null) {
      return null;
    }

    return Reaction.builder()
        .reactionId(input.getReactionId())
        .detailReaction(input.getDetailReaction())
        .profileReaction(profileDTOToProfile.to(input.getProfileReaction()))
        .publication(publicationDTOToPublication.to(input.getPublication()))
        .build();
  }
}
