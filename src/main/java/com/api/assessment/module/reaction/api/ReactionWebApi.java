package com.api.assessment.module.reaction.api;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.assessment.framework.constants.ConfigurationConstants;
import com.api.assessment.framework.dto.ReactionDTO;
import com.api.assessment.framework.util.ValidUtil;
import com.api.assessment.module.reaction.controller.ReactionController;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/** @author ajrozo */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(
        value = ConfigurationConstants.REQUEST_REACTION,
        produces = { MediaType.APPLICATION_JSON_VALUE })
public class ReactionWebApi {

  private final ReactionController controller;

  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @PostMapping()
  public ResponseEntity<Object> createProfile(
      @Valid final @RequestBody ReactionDTO reactionDTO,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    return ResponseEntity.ok(controller.createReaction(reactionDTO));
  }

}
