package com.api.assessment.module.reaction.controller;

import org.springframework.stereotype.Service;

import com.api.assessment.framework.dto.ReactionDTO;
import com.api.assessment.module.reaction.service.ReactionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author ajrozo
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class ReactionController {
  
  private final ReactionService reactionService;

  public ReactionDTO createReaction(ReactionDTO reactionDTO) {
    log.info("createReaction");
    return reactionService.createReaction(reactionDTO);    
  }

}