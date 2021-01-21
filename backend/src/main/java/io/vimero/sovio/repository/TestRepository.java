package io.vimero.sovio.repository;

import io.vimero.sovio.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

    @Query(value = "SELECT * FROM TSEMTBC_PREGUNTAS " +
            "WHERE i_ideprueba = :idTest", nativeQuery = true)
    List<Object[]> getStruct(@Param("idTest") Long id);

}
