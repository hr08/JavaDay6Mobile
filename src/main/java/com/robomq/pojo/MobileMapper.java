package com.robomq.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MobileMapper implements RowMapper<Mobile>{

	public Mobile mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mobile mobile = new Mobile();
		mobile.setId(rs.getInt("mobile_id"));
		mobile.setName(rs.getString("name"));
		mobile.setPrice(rs.getInt("price"));
		mobile.setQuantity(rs.getInt("quantity"));
		mobile.setDesp(rs.getString("description"));
		return mobile;
	}
}
