package io.vimero.sovio.repository;

import io.vimero.sovio.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    @Query(value = "SELECT t.v_secuencia, t.v_nombre, t.v_instruccion, t.n_durmin , t.n_orden, t.n_prutipid, " +
            "q.n_preguntaid, q.v_titulo, q.v_descripcion as qdescription, q.v_secuencia as qsequence, q.n_orden as qorder, q.n_pretipid, q.n_rescorval, q.v_rutimg, " +
            "a.n_respuestaid, a.v_titulo as atitle, a.v_descripcion, a.v_secuencia as asequence, a.n_orden as aorder, a.n_valor, a.v_rutimg as qimage " +
            "FROM TSOVTBC_EVALUACION e " +
            "INNER JOIN TSOVTBC_PRUEBA t ON e.N_EVALUACIONID = t.N_EVALUACIONID " +
            "INNER JOIN TSOVTBC_PREGUNTA q ON q.N_PRUEBAID = t.N_PRUEBAID " +
            "INNER JOIN TSOVTBC_RESPUESTA a ON  q.n_preguntaid = a.n_preguntaid " +
            "WHERE e.N_EVALUACIONID = :idTest ORDER BY t.n_orden, qorder, aorder", nativeQuery = true)
    List<Object[]> getStruct(@Param("idTest") Long id);

}
