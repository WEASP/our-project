package com.weasp.dao;

import com.weasp.model.Question;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * Created by 72703 on 2017/6/8.
 */
@Mapper
public interface QuestionDAO {

    String TABLE_NAME = " question ";
    String INSERT_FIELDS = " title,content,created_date,user_id,comment_count ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;

    @Insert({"insert into ",TABLE_NAME," (",INSERT_FIELDS,
            ") values (#{title},#{content},#{createdDate},#{userId},#{commentCount})"})
    int addQuestion(Question question);

    List<Question> selectLatesQuestions(@Param("userId") int userId, @Param("offset") int offset,
                                        @Param("limit") int limit);
}
