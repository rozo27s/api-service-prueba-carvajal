package com.api.assessment.framework.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 * @author ajrozo
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigurationConstants {

    public static final String SPRING_DATASOURCE = "spring.datasource";
    public static final String SPRING_DATASOURCE_BEAN = "datasource-spring-config";
    public static final String REQUEST_PROFILE= "profile";
    public static final String REQUEST_LOGIN= "login";
    public static final String REQUEST_PUBLICATION= "publication";
    public static final String REQUEST_REACTION= "reaction";
    public static final String REQUEST_COMMENT = "comment";
    public static final String RESPONSE_STATUS = "responseStatus";
    public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";
    public static final String SIMPLE_DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String REGEX_EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String REGEX_PASS = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
    public static final String REQUEST_NOTIFICATION = "notification";

    /** environments*/
    public static final String EMAIL_HOST = "${spring.mail.host}";
    public static final String EMAIL_PORT = "${spring.mail.port}";
    public static final String EMAIL_USER = "${spring.mail.username}";
    public static final String EMAIL_PASS = "${spring.mail.password}";
    public static final String DATASOURSE_URL = "${spring.datasource.url}";
    public static final String SECRET_KEY = "${config.jwt.secretkey}";
    

}
