package io.vimero.sovio.entity;

import io.vimero.persistence.NumberEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TSEMTBC_UBIGEO")
@AttributeOverride(name = "id", column = @Column(name = "I_IDEUBIGEO"))
public class GeoCode extends NumberEntity<Integer> {

    @Column(name = "V_IDEDEPART")
    private String departmentId;

    @Column(name = "V_DESDEPART")
    private String department;

    @Column(name = "V_IDEPROVIN")
    private String provinceId;

    @Column(name = "V_DESPROVINCI")
    private String province;

    @Column(name = "V_IDEDESTRITO")
    private String districtId;

    @Column(name = "V_DESDESTRITO")
    private String district;

}
