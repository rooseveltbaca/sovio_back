package io.vimero.sovio.repository;

import io.vimero.sovio.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {
}
