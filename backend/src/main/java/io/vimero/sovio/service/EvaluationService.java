package io.vimero.sovio.service;

import io.vimero.ms.crud.CRUDService;
import io.vimero.sovio.api.data.EvaluationData;
import io.vimero.sovio.api.resource.*;
import io.vimero.sovio.entity.Evaluation;
import io.vimero.sovio.repository.EvaluationRepository;
import io.vimero.sovio.type.TestType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class EvaluationService extends CRUDService<Evaluation, Long, EvaluationData, EvaluationRepository> {

    public EvaluationService(EvaluationRepository repository) {
        super(repository);
    }

    @Override
    public Evaluation getEntity(EvaluationData data) {
        return null;
    }

    public EvaluationStructResource getStruct(Long id) {
        EvaluationStructResource resource = new EvaluationStructResource();
        List<Object[]> list = repository.getStruct(id);
        log.info("Size: {}", list.size());
        for (Object[] row : list) {
            addGroup(resource, getValue(row[0]), Integer.parseInt(getValue(row[5])), getValue(row[6]), row);
        }

        return resource;
    }

    public EvaluationListResource getList(Long id) {
        List<GroupListResource> list = new ArrayList<>();
        EvaluationStructResource resource = getStruct(id);
        for (GroupMapResource map : resource.values()) {
            list.add(getGroupList(map));
        }
        return new EvaluationListResource(list);
    }

    private void addGroup(EvaluationStructResource evaluation, String sequence, int typeValue, String question, Object[] row) {
        TestType type = TestType.findByValue(typeValue);
        GroupMapResource resource = evaluation.getOrDefault(sequence, getGroupResource(row));
        evaluation.put(sequence, resource);
        resource.getData().put(type, addQuestion(resource.getData(), type, question, row));
    }

    private Map<String, QuestionResource> addQuestion(EnumMap<TestType, Map<String, QuestionResource>> types, TestType type, String question, Object[] row) {
        Map<String, QuestionResource> questions = types.getOrDefault(type, new HashMap<>());
        questions.put(question, addAnswer(questions, question, row));
        return questions;
    }

    private QuestionResource addAnswer(Map<String, QuestionResource> questions, String question, Object[] row) {
        QuestionResource resource = questions.getOrDefault(question, new QuestionResource(getValue(row[6]), getValue(row[7]), getValue(row[8]), getValue(row[9]), (BigDecimal) row[10], getValue(row[11]), getValue(row[12]), getValue(row[13]), new ArrayList<>()));
        resource.getAnswers().add(new AnswerResource(getValue(row[14]), getValue(row[15]), getValue(row[16]), getValue(row[17]), getValue(row[18]), getValue(row[19]), getValue(row[20])));
        return resource;
    }

    public GroupMapResource getGroupResource(Object[] row) {
        GroupMapResource resource = new GroupMapResource();
        resource.setSequence(getValue(row[0]));
        resource.setName(getValue(row[1]));
        resource.setInstruction(getValue(row[2]));
        resource.setTime(getValue(row[3]));
        resource.setOrder(getValue(row[4]));
        resource.setType(getValue(row[5]));
        resource.setData(new EnumMap<>(TestType.class));
        return resource;
    }

    public GroupListResource getGroupList(GroupMapResource map) {
        GroupListResource list = new GroupListResource();
        list.setSequence(map.getSequence());
        list.setName(map.getName());
        list.setTime(map.getTime());
        list.setOrder(map.getOrder());
        list.setType(map.getType());
        list.setInstruction(map.getInstruction());
        EnumMap<TestType, Collection<QuestionResource>> enumMap = new EnumMap<>(TestType.class);
        for (TestType type : TestType.values()) {
            Map<String, QuestionResource> data = map.getData().get(type);
            if (data != null) {
                enumMap.put(type, data.values().stream()
                        .sorted(Comparator.comparing(QuestionResource::getOrder)).collect(toList()));
                list.setData(enumMap);
            }
        }

        return list;
    }

    public String getValue(Object object) {
        return object != null ? object.toString() : "";
    }

}
