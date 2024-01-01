package com.zirius.zerp.quizmgt.quizmgtpro.controller;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zirius.zerp.quizmgt.quizmgtpro.Model.QuestionModel;
import com.zirius.zerp.quizmgt.quizmgtpro.service.QuestionService;
import java.util.List;

    @RestController 
    @RequestMapping("question")
    public class QuestionController {

    @Autowired
    QuestionService questionService ;
        

    // Response entity is used sending data and the status code
    //This should be done in service because we need to handle exception 
    @GetMapping("allQuestions")
    public ResponseEntity<List<QuestionModel>> getAllQuestion(){
        return  questionService.getAllQuestions();
    }

    @GetMapping("sets/{sets}")
    public ResponseEntity<List<QuestionModel>> getQuestionByCategory(@PathVariable Integer sets){
        return questionService.getQuestionByCategory(sets);
    }
    
    // From the client side we can recieve in the json format
    //Spring will Change the json to object 
    //In the request body it has lot of request in it and have data in the request body.
    
    //Used to send data to the server and to get data we use getmapping
    @PostMapping("add") 
    public  ResponseEntity<String> addQuestion(@RequestBody QuestionModel question){
        return  questionService.addQuestion(question);
    }
}

