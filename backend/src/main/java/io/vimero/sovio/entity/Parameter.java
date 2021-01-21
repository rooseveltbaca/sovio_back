package io.vimero.sovio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TSEMTBC_PARAMETRO")
@IdClass(ParameterId.class)
public class Parameter {

    @Id
    @Column(name = "I_IDEPARAMETRO")
    private Integer id;

    @Id
    @Column(name = "I_IDETABLA")
    private Integer table;

    @Column(name = "V_NOMPARAM")
    private String value;

}
