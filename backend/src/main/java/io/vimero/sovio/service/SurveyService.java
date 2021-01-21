package io.vimero.sovio.service;

import io.vimero.ms.crud.CRUDService;
import io.vimero.sovio.api.data.SurveyData;
import io.vimero.sovio.entity.Survey;
import io.vimero.sovio.repository.SurveyRepository;
import org.springframework.stereotype.Service;

@Service
public class SurveyService extends CRUDService<Survey, Long, SurveyData, SurveyRepository> {

    public SurveyService(SurveyRepository repository) {
        super(repository);
    }


    @Override
    public Survey getEntity(SurveyData data) {
        return null;
    }

}
