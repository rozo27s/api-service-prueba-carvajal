package com.api.assessment.module.comment.api;

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
import com.api.assessment.framework.dto.CommentDTO;
import com.api.assessment.framework.util.ValidUtil;
import com.api.assessment.module.comment.controller.CommentController;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/** @author ajrozo */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(
        value = ConfigurationConstants.REQUEST_COMMENT,
        produces = { MediaType.APPLICATION_JSON_VALUE })
public class CommentWebApi {

  private final CommentController controller;

  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @PostMapping()
  public ResponseEntity<Object> createProfile(
      @Valid final @RequestBody CommentDTO commentDTO,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    return ResponseEntity.ok(controller.createComment(commentDTO));
  }

}
