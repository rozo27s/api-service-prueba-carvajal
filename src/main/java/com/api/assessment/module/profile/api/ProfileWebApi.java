package com.api.assessment.module.profile.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.assessment.framework.constants.ConfigurationConstants;

/** @author ajrozo */
@RestController
@CrossOrigin("*")
@RequestMapping(
        value = ConfigurationConstants.REQUEST_CARDS,
        produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProfileWebApi {

    
}
