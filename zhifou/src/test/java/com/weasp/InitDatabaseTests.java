package com.weasp;

import com.weasp.dao.UserDAO;
import com.weasp.model.Question;
import com.weasp.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ZhifouApplication.class)
@Sql("/inti-schema.sql")
public class InitDatabaseTests {
	@Autowired
	UserDAO userDAO;

	@Test
	public void contextLoads() {
		Random random = new Random();
		for (int i = 0; i < 11 ; i++){
			User user = new User();
			user.setHeadUrl(String.format("http://images.nowcoder.com/head/dt.png",random.nextInt(1000)));
			user.setName(String.format("USER%d",i));
			user.setPassword("");
			user.setSalt("");
			userDAO.addUser(user);

			user.setPassword("newpassword");
			userDAO.updatePassword(user);

			Question question = new Question();
		}
	}

}
