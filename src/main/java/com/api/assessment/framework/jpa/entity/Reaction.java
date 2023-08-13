package com.api.assessment.framework.jpa.entity;

import java.io.Serializable;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "reaction", schema = "livebook")
public class Reaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reaction_id")
    private Long reactionId;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reaction")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profileReaction;

    @Column(name = "datail")
    private String detailReaction;    
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "publication_id", nullable = false, updatable = false)
    private Publication publication;

    private static final long serialVersionUID = 8094153480314794704L;

}
