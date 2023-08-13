package com.api.assessment.module.reaction.service.impl;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.api.assessment.framework.dto.ReactionDTO;
import com.api.assessment.framework.jpa.crudrepository.ReactionRepository;
import com.api.assessment.framework.jpa.entity.Reaction;
import com.api.assessment.framework.pattern.Translator;
import com.api.assessment.module.reaction.service.ReactionService;

import lombok.RequiredArgsConstructor;

/**
 * Logica para la conexion a tabla permite metodos crud
 *
 * @author Carvajal
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {

  private final ReactionRepository publicationRepository;

  @Qualifier("reactionDTOToReaction")
  private final Translator<ReactionDTO, Reaction> reactionDTOToReaction;
  @Qualifier("reactionToReactionDTO")
  private final Translator<Reaction, ReactionDTO> reactionToReactionDTO;

  @Override
  public ReactionDTO createReaction(ReactionDTO reactionDTO) {
    return reactionToReactionDTO.to(publicationRepository.save(reactionDTOToReaction.to(reactionDTO)));
  }
}
