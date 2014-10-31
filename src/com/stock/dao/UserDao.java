package com.stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.stock.dao.base.AbstractDao;
import com.stock.entity.User;

@Repository
public class UserDao extends AbstractDao<User, Long> {

	protected Class<User> getClassType() {
		return User.class;
	}

	public User findByUserName(User o) {
		return super.queryForObject("SELECT_USER_INFO", o.getUserName());
	}

	public User findById(User o) {
		return super.queryForObject("SELECT_USER", o.getId());
	}

	public void save(User o) {

	}

	public void update(User o) {

	}

	public void delete(User o) {

	}

	@Override
	public User baseMapper(ResultSet rs, int row) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("U_ID"));
		user.setName(rs.getString("U_NAME"));
		user.setUserName(rs.getString("U_USERNAME"));
		user.setPassWord(rs.getString("U_PASSWORD"));
		user.setEnabled(rs.getString("U_ENABLED"));
		return user;
	}

}
