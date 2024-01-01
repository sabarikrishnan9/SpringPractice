package com.zirius.zerp.quizmgt.quizmgtpro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zirius.zerp.quizmgt.quizmgtpro.Model.QuestionModel;

@Repository
public interface QuestionDAO extends JpaRepository<QuestionModel , Integer>{

    List<QuestionModel> findBySets(Integer sets);

    
}
