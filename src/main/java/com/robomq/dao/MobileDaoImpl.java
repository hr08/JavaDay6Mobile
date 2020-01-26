package com.robomq.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.robomq.pojo.Mobile;
import com.robomq.pojo.MobileMapper;

@Component
public class MobileDaoImpl implements MobileDao{
	
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_FIND_PERSON = "select * from mobile where mobile_id = ?";
	private final String SQL_DELETE_PERSON = "delete from mobile where mobile_id = ?";
	private final String SQL_UPDATE_PERSON = "update mobile set name = ?, price = ?,quantity=?,description=? where mobile_id = ?";
	private final String SQL_GET_ALL = "select * from mobile";
	private final String SQL_INSERT_PERSON = "insert into mobile(mobile_id, name, price, quantity,description) values(?,?,?,?,?)";
	
	@Autowired
	public MobileDaoImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public Mobile getMobileById(Integer id) {
		return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] { id }, new MobileMapper());
	}

	public List<Mobile> getAllMobiles() {
		return jdbcTemplate.query(SQL_GET_ALL, new MobileMapper());
	}

	public boolean deleteMobile(Mobile mobile) {
		return jdbcTemplate.update(SQL_DELETE_PERSON, mobile.getId()) > 0;
	}

	public boolean updateMobile(Mobile mobile) {
		return jdbcTemplate.update(SQL_UPDATE_PERSON, mobile.getName(), mobile.getPrice(),mobile.getQuantity(),mobile.getDesp(),
				mobile.getId()) > 0;
	}

	public boolean createMobile(Mobile mobile) {
		return jdbcTemplate.update(SQL_INSERT_PERSON, mobile.getId(), mobile.getName(), mobile.getPrice(),mobile.getQuantity(),
				mobile.getDesp()) > 0;
	}

	
	
}
