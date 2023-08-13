package com.api.assessment.module.publication.service;

import java.util.List;

import com.api.assessment.framework.dto.PublicationDTO;

/**
 * Interfaz para IActionRulesDataProvider
 *
 * @author Carvajal
 * @version 1.0
 *
 */

public interface PublicationService {

  public List<PublicationDTO> findPublicationsByProfile(Long idprofile);
  public PublicationDTO createPublication(PublicationDTO publicationDTO);
  public PublicationDTO updatePublication(PublicationDTO publicationDTO);
  public PublicationDTO deletePublication(PublicationDTO publicationDTO);
 
}
