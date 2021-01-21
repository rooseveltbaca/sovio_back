package io.vimero.sovio.service;

import io.vimero.ms.crud.CRUDService;
import io.vimero.sovio.api.data.TestData;
import io.vimero.sovio.api.resource.QuestionResource;
import io.vimero.sovio.api.resource.TestStructResource;
import io.vimero.sovio.entity.Test;
import io.vimero.sovio.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class TestService extends CRUDService<Test, Long, TestData, TestRepository> {

    public TestService(TestRepository repository) {
        super(repository);
    }

    @Override
    public Test getEntity(TestData data) {
        return null;
    }

    public TestStructResource getStruct(Long id) {
        TestStructResource resource = new TestStructResource();
        resource.setGroups(new HashMap<>());
        List<Object[]> list = repository.getStruct(id);
        log.info("Size: {}", list.size());
        for (Object[] row : list) {
            if (row[4] != null) {
                addQuestion(resource, row[11].toString(), row[3].toString(), row[4].toString());
            }
        }

        return resource;
    }

    private void addQuestion(TestStructResource resource, String group, String questionId, String question) {
        List<QuestionResource> questions = resource.getGroups().computeIfAbsent(group, k -> new ArrayList<>());
        questions.add(new QuestionResource(questionId, question, "", "", new BigDecimal("1"), "", "", "", new ArrayList<>()));
    }

}
