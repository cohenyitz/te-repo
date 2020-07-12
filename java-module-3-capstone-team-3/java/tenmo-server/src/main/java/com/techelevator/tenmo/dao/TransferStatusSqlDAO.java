package com.techelevator.tenmo.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class TransferStatusSqlDAO implements TransferStatusDAO {

	private JdbcTemplate jdbcTemplate;

    public TransferStatusSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	@Override
	public int getByID(int transferID) {
		return jdbcTemplate.queryForObject("select transfer_status_id from transfer_statuses where transfer_id = ?", int.class, transferID);
	}

}
