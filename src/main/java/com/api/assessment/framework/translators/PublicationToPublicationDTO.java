package com.api.assessment.framework.translators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.api.assessment.framework.dto.PublicationDTO;
import com.api.assessment.framework.dto.ReactionDTO;
import com.api.assessment.framework.jpa.entity.Publication;
import com.api.assessment.framework.jpa.entity.Reaction;
import com.api.assessment.framework.pattern.Translator;

import lombok.RequiredArgsConstructor;

/**
 * @author ajrozo
 */
@Component
@RequiredArgsConstructor
@Qualifier("publicationToPublicationDTO")
public class PublicationToPublicationDTO implements Translator<Publication, PublicationDTO> {


  @Qualifier("reactionToReactionDTO")
  private final Translator<Reaction, ReactionDTO> reactionDTOToReaction;
  
  @Override
  public PublicationDTO to(Publication input) {
    
    if (input == null) {
      return null;
    }
    
    List<ReactionDTO> reactions = new ArrayList<>();
    if (input.getReactions() != null && !input.getReactions().isEmpty()) {
      for (Reaction reaction : input.getReactions()) {
        reactions.add(reactionDTOToReaction.to(reaction));
      }
    }
    return PublicationDTO.builder()
        .publicationId(input.getPublicationId())
        .reactions(reactions)
        .detailPublication(input.getDetailPublication())
        .active(input.isActive())
        .build();
  }
}
