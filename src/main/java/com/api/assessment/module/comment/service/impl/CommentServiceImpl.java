package com.api.assessment.module.comment.service.impl;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.api.assessment.framework.dto.CommentDTO;
import com.api.assessment.framework.jpa.crudrepository.CommentRepository;
import com.api.assessment.framework.jpa.entity.Comment;
import com.api.assessment.framework.pattern.Translator;
import com.api.assessment.module.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

/**
 * Logica para la conexion a tabla permite metodos crud
 *
 * @author Carvajal
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  private final CommentRepository publicationRepository;

  @Qualifier("commentDTOToComment")
  private final Translator<CommentDTO, Comment> commentDTOToComment;
  @Qualifier("commentToCommentDTO")
  private final Translator<Comment, CommentDTO> commentToCommentDTO;

  @Override
  public CommentDTO createComment(CommentDTO commentDTO) {
    return commentToCommentDTO.to(publicationRepository.save(commentDTOToComment.to(commentDTO)));
  }
}
