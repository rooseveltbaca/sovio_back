package io.vimero.sovio.repository;

import io.vimero.sovio.entity.GeoCode;
import io.vimero.sovio.entity.ParameterId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoCodeRepository extends JpaRepository<GeoCode, ParameterId> {


}
