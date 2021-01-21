package io.vimero.sovio.api.rest;

import io.vimero.ms.crud.APIRest;
import io.vimero.sovio.api.data.QuestionData;
import io.vimero.sovio.entity.Question;
import io.vimero.sovio.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/questions")
public class QuestionController extends APIRest<Question, Long, QuestionData, QuestionService> {


    public QuestionController(QuestionService service) {
        super(service);
    }

    @PutMapping("/{id}/answer/{answer}")
    public void markAnswer(@PathVariable Long id,  @PathVariable Long answer){
        log.info("[PUT] /questions/{}/answer/{}",id, answer);
        service.checkAnswer(id, answer);
    }

}
