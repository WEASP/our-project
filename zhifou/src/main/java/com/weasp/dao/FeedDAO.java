package com.weasp.dao;

import com.weasp.model.Feed;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by JackHui on 2017/6/19.
 */
public interface FeedDAO {
    String TABLE_NAME = "feed";
    String INSERT_FIELDS = " user_id,data,created_date,type ";
    String SELECT_FIELDS = " id, "+ INSERT_FIELDS;

    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") values (#{userId},#{data},#{createdDate},#{type})"})
    int addFeed(Feed feed);

    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where ticket=#{ticket}"})
   Feed getFeedById(int id);

    List<Feed> selectUserFeeds(@Param( "maxId" ) int maxId,
                               @Param( "userIds" )List<Integer> userIds,
                               @Param( "count" ) int count);



}
