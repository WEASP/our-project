package com.weasp.dao;

import com.weasp.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 72703 on 2017/6/8.
 */
@Mapper
public interface QuestionDAO {

    String TABLE_NAME = " question ";
    String INSERT_FIELDS = " title,content,user_id,created_date,comment_count ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;

    @Insert({"insert into ",TABLE_NAME," (",INSERT_FIELDS,
            ") values (#{title},#{content},#{userId},#{createdDate},#{commentCount})"})
    int addQuestion(Question question);

    @Select({"select ", SELECT_FIELDS ," from ",TABLE_NAME," where id =#{userId}"})
    Question selectQuestion(int userId);

    @Select({"select ", SELECT_FIELDS ," from ",TABLE_NAME," ORDER BY id DESC LIMIT #{offset},#{limit}"})
    List<Question> selectLatestQuestions(@Param("offset")int offset , @Param("limit")int limit);

}
