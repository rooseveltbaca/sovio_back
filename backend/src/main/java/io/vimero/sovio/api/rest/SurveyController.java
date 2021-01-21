package io.vimero.sovio.api.rest;

import io.vimero.ms.crud.APIRest;
import io.vimero.sovio.api.data.SurveyData;
import io.vimero.sovio.entity.Survey;
import io.vimero.sovio.service.SurveyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/surveys")
public class SurveyController extends APIRest<Survey, Long, SurveyData, SurveyService>  {


    public SurveyController(SurveyService service) {
        super(service);
    }

}
