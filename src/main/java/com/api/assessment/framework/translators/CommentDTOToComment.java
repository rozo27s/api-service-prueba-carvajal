package com.api.assessment.framework.translators;

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
@Qualifier("commentDTOToComment")
public class CommentDTOToComment implements Translator<CommentDTO, Comment> {


  @Qualifier("profileDTOToProfile")
  private final Translator<ProfileDTO, Profile> profileDTOToProfile;
  @Qualifier("reactionDTOToReaction")
  private final Translator<ReactionDTO, Reaction> reactionDTOToReaction;
  
  @Override
  public Comment to(CommentDTO input) {
    return input != null ? Comment.builder()
        .commentId(input.getCommentId())
        .profileComment(profileDTOToProfile.to(input.getProfileComment()))
        .detailComment(input.getDetailComment())
        .reaction(reactionDTOToReaction.to(input.getReaction()))
        .build() : null;
  }
}
