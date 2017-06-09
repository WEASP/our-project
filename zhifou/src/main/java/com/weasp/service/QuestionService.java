package com.weasp.service;

import com.weasp.dao.QuestionDAO;
import com.weasp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 72703 on 2017/6/8.
 */
@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDao;

    public List<Question> getLatestQuestions(int userId, int offset, int limit) {
        return questionDao.selectLatesQuestions(userId, offset, limit);
    }
}
