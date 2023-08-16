package com.api.assessment.framework.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** @author ajrozo */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "publication", schema = "livebook")
public class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publication_id")
    private Long publicationId;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profile;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publication")
    private List<Reaction> reactions;

    @Column(name = "detail")
    private String detailPublication;
    
    @Basic(optional = false)
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    
    @Column(name = "active")
    private boolean active;

    private static final long serialVersionUID = 8094153480314794704L;

}
