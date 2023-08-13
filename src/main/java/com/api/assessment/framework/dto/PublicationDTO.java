package com.api.assessment.framework.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class PublicationDTO implements Serializable {


    private Long publicationId;
    private ProfileDTO profile;
    private List<ReactionDTO> reactions;
    private String detailPublication;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime creationDate;
    private boolean active;

    private static final long serialVersionUID = 8094153480314794704L;

}
