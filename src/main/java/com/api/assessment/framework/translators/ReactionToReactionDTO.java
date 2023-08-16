package com.api.assessment.framework.translators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.api.assessment.framework.dto.CommentDTO;
import com.api.assessment.framework.dto.ProfileDTO;
import com.api.assessment.framework.dto.ReactionDTO;
import com.api.assessment.framework.jpa.entity.Comment;
import com.api.assessment.framework.jpa.entity.Profile;
import com.api.assessment.framework.jpa.entity.Reaction;
import com.api.assessment.framework.pattern.Translator;

import lombok.RequiredArgsConstructor;

/**
 * @author ajrozo
 */
@Component
@RequiredArgsConstructor
@Qualifier("reactionToReactionDTO")
public class ReactionToReactionDTO implements Translator<Reaction, ReactionDTO> {

  @Qualifier("commentToCommentDTO")
  private final Translator<Comment, CommentDTO> commentToCommentDTO;
  @Qualifier("profileToProfileDTO")
  private final Translator<Profile, ProfileDTO> profileToProfileDTO;
  
  @Override
  public ReactionDTO to(Reaction input) {
    
    if (input == null) {
      return null;
    }
    
    List<CommentDTO> coments = new ArrayList<>();
    if (input.getComments() != null && !input.getComments().isEmpty()) {
      for (Comment comment : input.getComments()) {
        coments.add(commentToCommentDTO.to(comment));
      }
    }
    return ReactionDTO.builder()
        .reactionId(input.getReactionId())
        .comments(coments)
        .detailReaction(input.getDetailReaction())
        .profileReaction(profileToProfileDTO.to(input.getProfileReaction()))
        .build();
  }
}
