package com.zirius.zerp.quizmgt.quizmgtpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zirius.zerp.quizmgt.quizmgtpro.DAO.QuestionDAO;
import com.zirius.zerp.quizmgt.quizmgtpro.Model.QuestionModel;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<QuestionModel>> getAllQuestions() {

        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<QuestionModel>> getQuestionByCategory(Integer sets) {
        try {
            return new ResponseEntity<>(questionDAO.findBySets(sets), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(questionDAO.findBySets(sets), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(QuestionModel question) {
        questionDAO.save(question);
        return new ResponseEntity<>("Sucess",HttpStatus.CREATED);
        //Why do we use created ? 

        // We can return exception or error using HTTP status code
    }

}
