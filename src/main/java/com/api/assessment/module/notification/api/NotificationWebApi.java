package com.api.assessment.module.notification.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.assessment.framework.constants.ConfigurationConstants;
import com.api.assessment.framework.dto.Notification;
import com.api.assessment.framework.util.ValidUtil;
import com.api.assessment.module.notification.service.EmailService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/** @author ajrozo */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(value = ConfigurationConstants.REQUEST_NOTIFICATION,
                produces = { MediaType.APPLICATION_JSON_VALUE })
public class NotificationWebApi {
  
  private final EmailService emailService;

  @ApiOperation(value = "",
                nickname = "",
                notes = "",
                response = ResponseEntity.class)
  @PostMapping(name = "")
  public ResponseEntity<Object> createCard(
      @Valid final @RequestBody Notification notification,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    emailService.send(notification.getFrom(),
                      notification.getTo(),
                      notification.getSubject(),
                      notification.getDetail());
    return ResponseEntity.status(HttpStatus.CREATED).body("");
  }
}