package com.api.assessment.framework.translators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.api.assessment.framework.dto.CommentDTO;
import com.api.assessment.framework.dto.ProfileDTO;
import com.api.assessment.framework.jpa.entity.Comment;
import com.api.assessment.framework.jpa.entity.Profile;
import com.api.assessment.framework.pattern.Translator;

import lombok.RequiredArgsConstructor;

/**
 * @author ajrozo
 */
@Component
@RequiredArgsConstructor
@Qualifier("commentDTOToComment")
public class CommentToCommentDTO implements Translator<Comment, CommentDTO> {


  @Qualifier("profileToCommentDTO")
  private final Translator<Profile, ProfileDTO> profileToCommentDTO;
  
  @Override
  public CommentDTO to(Comment input) {
    return input != null ? CommentDTO.builder()
        .commentId(input.getCommentId())
        .profileComment(profileToCommentDTO.to(input.getProfileComment()))
        .detailComment(input.getDetailComment())
        .build() : null;
  }
}
