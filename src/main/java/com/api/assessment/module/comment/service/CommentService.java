package com.api.assessment.module.comment.service;

import com.api.assessment.framework.dto.CommentDTO;

/**
 * Interfaz para IActionRulesDataProvider
 *
 * @author Carvajal
 * @version 1.0
 *
 */

public interface CommentService {

  public CommentDTO createComment(CommentDTO commentDTO);
 
}
