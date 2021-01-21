package io.vimero.sovio.service;

import io.vimero.ms.crud.CRUDService;
import io.vimero.sovio.api.data.QuestionData;
import io.vimero.sovio.entity.Question;
import io.vimero.sovio.entity.QuestionAnswer;
import io.vimero.sovio.entity.User;
import io.vimero.sovio.repository.QuestionAnswerRepository;
import io.vimero.sovio.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QuestionService extends CRUDService<Question, Long, QuestionData, QuestionRepository> {

    private final QuestionAnswerRepository questionAnswerRepository;

    public QuestionService(QuestionRepository repository, QuestionAnswerRepository questionAnswerRepository) {
        super(repository);
        this.questionAnswerRepository = questionAnswerRepository;
    }

    @Override
    public Question getEntity(QuestionData data) {
        return null;
    }

    public void checkAnswer(Long question, Long answer) {
        User session = (User) getSession();
        QuestionAnswer questionAnswer = new QuestionAnswer();
        questionAnswer.setQuestion(question);
        questionAnswer.setAnswer(answer);
        questionAnswer.setUser(session.getId());
        questionAnswerRepository.save(questionAnswer);
    }

}
