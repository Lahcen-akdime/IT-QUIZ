package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.QuestionsDTO;
import com.example.demo.dto.QuizDTO;
import com.example.demo.entity.Formation;
import com.example.demo.entity.Options;
import com.example.demo.entity.Questions;
import com.example.demo.repository.FormationRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.OptionRepository ;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class QuizSaverService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private FormationRepository formationRepository ;

    @Autowired
    private OptionRepository optionRepository ;


    public Boolean SaveQuiz(QuizDTO quiz , Long formation_id) {
        Formation formation = formationRepository.findFormationById(formation_id) ;
        for(QuestionsDTO question : quiz.getQuestions()){
            Questions questionEntity = new Questions() ;
            questionEntity.setFormation(formation);
            questionEntity.setQuestion(question.getQuestion());

            questionRepository.save(questionEntity) ;

            for (int i = 0; i < question.getOptions().length ; i++) {
                Options optionEntity = new Options() ;
                optionEntity.setOption(question.getOptions()[i]);
                optionEntity.setQuestion(questionEntity);
                if (question.getCorrect_answer() == i) {
                    optionEntity.setIs_correct(true);
                }
                
                optionRepository.save(optionEntity) ;
            }
        }
        return true;
    }
}


