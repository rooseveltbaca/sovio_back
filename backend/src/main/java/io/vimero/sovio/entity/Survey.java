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
@Table(name = "TSEMTBC_ENCUESTA")
@AttributeOverride(name = "id", column = @Column(name = "I_IDEENCUESTA"))
public class Survey extends IdentityEntity<Long> {

    @Column(name = "V_NOMENCUESTA")
    private String name;

    @Column(name = "V_DESENCUESTA")
    private String description;

}
