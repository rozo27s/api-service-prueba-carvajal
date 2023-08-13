package com.api.assessment.module.comment.controller;

import org.springframework.stereotype.Service;

import com.api.assessment.framework.dto.CommentDTO;
import com.api.assessment.module.comment.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author ajrozo
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class CommentController {
  
  private final CommentService commentService;

  public CommentDTO createComment(CommentDTO commentDTO) {
    log.info("createComment");
    return commentService.createComment(commentDTO);    
  }

}