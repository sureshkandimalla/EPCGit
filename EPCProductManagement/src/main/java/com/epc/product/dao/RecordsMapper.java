package com.epc.product.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.epc.product.model.Product1;

@Component
public class RecordsMapper implements RowMapper<Product1> {
	private Pattern pattern = Pattern.compile("(?<year>\\d{4})(?<month>\\d{2})(?<date>\\d{2})");

	@Override
	public Product1 mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product1 row = new Product1();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
		/*row.setFlightNumber(rs.getInt("flightnumber"));
		row.setDepartureDate(rs.getDate("departuredate"));
		row.setDepDateTime(rs.getString("depDateTime"));
		row.setDestination(rs.getString("destination"));
		row.setEquipmentType(rs.getString("equipmentType"));
		row.setFlightId(rs.getInt("flightId"));
		row.setOrigin(rs.getString("origin"));*/
		return row;
	}

	private String formatDate(String yyyyMMdd) {
		StringBuffer sb = new StringBuffer();
		Matcher matcher = pattern.matcher(yyyyMMdd);
		matcher.find();
		sb.append(matcher.group("year"));
		sb.append("-");
		sb.append(matcher.group("month"));
		sb.append("-");
		sb.append(matcher.group("date"));
		return sb.toString();
	}

}
