package com.techelevator.tenmo.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class TransferTypeSqlDAO implements TransferTypeDAO {

	private JdbcTemplate jdbcTemplate;

    public TransferTypeSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	@Override
	public int getByID(int transferID) {
		return jdbcTemplate.queryForObject("select transfer_type_id from transfer_types where transfer_id = ?", int.class, transferID);
	}
}
