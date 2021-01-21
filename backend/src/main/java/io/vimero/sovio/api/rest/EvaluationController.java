package io.vimero.sovio.api.rest;

import io.vimero.ms.crud.APIRest;
import io.vimero.sovio.api.data.EvaluationData;
import io.vimero.sovio.entity.Evaluation;
import io.vimero.sovio.service.EvaluationService;
import io.vimero.web.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/evaluations")
public class EvaluationController extends APIRest<Evaluation, Long, EvaluationData, EvaluationService> {

    public EvaluationController(EvaluationService service) {
        super(service);
    }

    @GetMapping("/struct/{id}")
    public ResponseEntity<Object> findStructById(@PathVariable Long id) {
        log.info("Find entity by id: {}", id);
        return ResponseEntity.ok(new DataResponse(new DataResponse(service.getList(id))));
    }

    @GetMapping("/map/{id}")
    public ResponseEntity<Object> findByIdMap(@PathVariable Long id) {
        log.info("[MAP] Find entity by id: {}", id);
        return ResponseEntity.ok(new DataResponse(service.getStruct(id)));
    }

}
