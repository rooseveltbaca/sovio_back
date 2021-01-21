package io.vimero.sovio.entity;

import io.vimero.persistence.SequenceEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "TSEMTBC_PERSONA")
@AttributeOverride(name = "id", column = @Column(name = "I_IDEPERSONA"))
@SequenceGenerator(name = "seq_superclass", sequenceName = "SEQ_N_IDPERSONA", allocationSize = 1)
public class Person extends SequenceEntity<Long> {

    @Column(name = "V_NOMBRES")
    private String name;

    @Column(name = "V_APEMATERNO")
    private String motherLastName;

    @Column(name = "V_APEPATERNO")
    private String fatherLastName;

    @Column(name = "V_CORREO")
    private String email;

    @Column(name = "V_NUMDOCUMENTO")
    private String documentNumber;

    @Column(name = "I_TIPDOCUMENTO")
    private Integer documentType;

    @Column(name = "I_IDEOCUPACION")
    private Integer job;

    @Column(name = "I_IDEGENERO")
    private Integer gender;

    @Column(name = "D_FECCREAC")
    private LocalDateTime createdDate;

    @Column(name = "D_FECNACMTO")
    private LocalDate birthdayDate;

    @Column(name = "I_IDEINSTRUC")
    private Integer level;

    @Column(name = "V_TELCELULAR")
    private String mobile;

    @Column(name = "V_DIRECCION")
    private String address;

    @Column(name = "I_IDEUBIGEO")
    private Integer geocode;

    @Column(name = "I_IDENACIONALD")
    private Integer country;

    @Column(name = "I_TIPPERSONA")
    private Integer type;

    @Column(name = "C_ESTADO")
    private String status;

    @Column(name = "I_USUCREACION")
    private Integer createdUser;

}
