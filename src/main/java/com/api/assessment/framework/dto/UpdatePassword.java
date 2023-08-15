package com.api.assessment.framework.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.api.assessment.framework.constants.ConfigurationConstants;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** @author ajrozo */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdatePassword implements Serializable {

    @NotNull
    @NotBlank
    @Pattern(regexp = ConfigurationConstants.REGEX_EMAIL, message = "No es un correo")
    private String email;

    private static final long serialVersionUID = 8094153480314794704L;

}
