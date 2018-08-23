package com.intertech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.intertech.domain.Contact;

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Contact getContact(Long id) {
		String sql = "select * from contact where id = :id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return (Contact) jdbcTemplate.queryForObject(sql, paramSource,
				new ContactRowMapper());
	}

	@Override
	public List<Contact> getContacts() {
		String sql = "select * from contact";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		return jdbcTemplate.query(sql, paramSource, new ContactRowMapper());
	}

	@Override
	public long saveContact(Contact contact) {
		String sql = "insert into contact (first_name,last_name,date_of_birth,married,children) values (:first,:last,:dob,:married,:children)";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("first", contact.getFirstName());
		paramSource.addValue("last", contact.getLastName());
		paramSource.addValue("dob", contact.getDateOfBirth());
		paramSource.addValue("married", contact.isMarried());
		paramSource.addValue("children", contact.getChildren());
		jdbcTemplate.update(sql, paramSource);

		sql = "call identity()";
		paramSource = new MapSqlParameterSource();
		return jdbcTemplate.queryForLong(sql, paramSource);
	}

	@Override
	public void updateContact(Contact contact) {
		String sql = "update contact set first_name = :first, last_name = :last, date_of_birth = :dob, married = :married, children = :children where id =:id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("first", contact.getFirstName());
		paramSource.addValue("last", contact.getLastName());
		paramSource.addValue("dob", contact.getDateOfBirth());
		paramSource.addValue("married", contact.isMarried());
		paramSource.addValue("children", contact.getChildren());
		paramSource.addValue("id", contact.getId());
		jdbcTemplate.update(sql, paramSource);
	}

	@Override
	public void deleteContact(Long id) {
		String sql = "delete from contact where id = :id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		jdbcTemplate.update(sql, paramSource);
	}

	public class ContactRowMapper implements RowMapper<Contact> {
		public Contact mapRow(ResultSet rs, int index) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getLong("id"));
			contact.setFirstName(rs.getString("first_name"));
			contact.setLastName(rs.getString("last_name"));
			contact.setDateOfBirth(rs.getDate("date_of_birth"));
			contact.setChildren(rs.getInt("children"));
			contact.setMarried(rs.getBoolean("married"));
			return contact;
		}
	}
}
