package io.vimero.sovio.entity;


import io.vimero.persistence.SequenceEntity;
import io.vimero.security.model.UserSession;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TSOVTBC_USUARIO")
@AttributeOverride(name = "id", column = @Column(name = "N_USUARIOID"))
@SequenceGenerator(name = "seq_superclass", sequenceName = "SEQ_N_IDPERSONA", allocationSize = 1)
public class User extends SequenceEntity<Long> implements UserSession {

    @Column(name = "V_USUARIO")
    private String username;

    @Column(name = "V_CLAVE")
    private String password;

    @Column(name = "N_PERFILID")
    private Long profile;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "N_PERSONAID", nullable = false)
    private Person person;


}
