package com.chelseaUniversity.ver1.repository.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chelseaUniversity.ver1.utill.DBUtil;

public interface SugangStatus {

	public int updateAllSugangPeriod(String preSugangStatus, String sugangStatus);
	public int updatePrePeriod(String preSugangStatus);
	public int updateSugangPeriod(String sugangStatus);
}
