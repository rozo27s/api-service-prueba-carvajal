package com.api.assessment.module.publication.api;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.assessment.framework.constants.ConfigurationConstants;
import com.api.assessment.framework.dto.PublicationDTO;
import com.api.assessment.framework.util.ValidUtil;
import com.api.assessment.module.publication.controller.PublicationController;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/** @author ajrozo */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(
        value = ConfigurationConstants.REQUEST_PUBLICATION,
        produces = { MediaType.APPLICATION_JSON_VALUE })
public class PublicationWebApi {

  private final PublicationController controller;

  @ApiOperation(value = "",
                nickname = "",
                notes = "",
                response = ResponseEntity.class)
  @GetMapping()
  public ResponseEntity<Object> getPublicationsProfile(
      final @RequestParam Long idProfile) {
    return ResponseEntity.ok(controller.getPublicationsByProfile(idProfile));
  }

  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @PostMapping()
  public ResponseEntity<Object> createProfile(
      @Valid final @RequestBody PublicationDTO publicationDTO,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    return ResponseEntity.ok(controller.createPublications(publicationDTO));
  }
}
