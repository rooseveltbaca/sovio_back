package io.vimero.sovio.entity;

import io.vimero.persistence.IdentityEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "TSOVTBC_EVALUACION")
@AttributeOverride(name = "id", column = @Column(name = "N_EVALUACIONID"))
public class Evaluation extends IdentityEntity<Long> {

    @Column(name = "V_DESCRIPCION")
    private String description;

    @Column(name = "V_TITULO")
    private String title;

    @Column(name = "V_INSTRUCCION")
    private String instruccions;

}
