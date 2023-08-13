package com.api.assessment.module.publication.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.assessment.framework.dto.PublicationDTO;
import com.api.assessment.module.publication.service.PublicationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author ajrozo
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class PublicationController {
  
  private final PublicationService publicationService;
  
  public List<PublicationDTO> getPublicationsByProfile(Long idProfile) {
    log.info("getPublicationsByProfile");
    return publicationService.findPublicationsByProfile(idProfile);    
  }
  
  public PublicationDTO createPublications(PublicationDTO publicationDTO) {
    log.info("createPublications");
    return publicationService.createPublication(publicationDTO);    
  }
  
  public PublicationDTO updatePublications(PublicationDTO publicationDTO) {
    log.info("updatePublications");
    return publicationService.updatePublication(publicationDTO);    
  }
  
  public void deletePublications(Long publicationId) {
    log.info("deletePublications");
     publicationService.deletePublication(publicationId);    
  }

}