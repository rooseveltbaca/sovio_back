package io.vimero.sovio.repository;

import io.vimero.sovio.entity.Parameter;
import io.vimero.sovio.entity.ParameterId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParameterRepository extends JpaRepository<Parameter, ParameterId> {

    List<Parameter> findByTable(Integer table);

}
