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
@Table(name = "TSEMTBC_PRUEBA")
@AttributeOverride(name = "id", column = @Column(name = "I_IDEPRUEBA"))
public class Test extends IdentityEntity<Long> {

    

}
