package com.api.assessment.module.login.api;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.assessment.framework.constants.ConfigurationConstants;
import com.api.assessment.framework.dto.Login;
import com.api.assessment.framework.dto.UpdatePassword;
import com.api.assessment.framework.util.ValidUtil;
import com.api.assessment.module.login.controller.LoginController;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/** @author ajrozo */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(
        value = ConfigurationConstants.REQUEST_LOGIN,
        produces = { MediaType.APPLICATION_JSON_VALUE })
public class LoginWebApi {

  private final LoginController loginController;

  @ApiOperation(value = "",
                nickname = "",
                notes = "",
                response = ResponseEntity.class)
  @PostMapping()
  public ResponseEntity<Object> login(
      @Valid final @RequestBody Login login,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    return ResponseEntity.ok(loginController.loginProfile(login));
  }

  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @PutMapping("/update-pass")
  public ResponseEntity<Object> updatePassword(
      @Valid final @RequestBody UpdatePassword updatePassword,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    loginController.updatePasswordProfile(updatePassword);
    return ResponseEntity.ok(null);
  }
  
  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @GetMapping("/token")
  public ResponseEntity<Object> generatetoken() {
    return ResponseEntity.ok(loginController.token());
  }
}
