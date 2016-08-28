package cn.edu.seu.pczhou.dao;

import cn.edu.seu.pczhou.model.Question;

/**
 * Created by 鹏程 on 2016/8/28.
 */
public interface QuestionDao {
    void insert(Question question);
    Question findQuestionById(int id);
}
