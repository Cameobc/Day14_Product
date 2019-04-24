package com.sesung.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sesung.util.DBConnector;

public class IoDAO {
	
	public int insertIo(IoDTO dto, Connection con) throws Exception {
		String sql = "INSERT INTO IO VALUES(IO_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getPnum());
		st.setInt(2, dto.getIn_pct());
		st.setString(3, dto.getIn_date());
		st.setInt(4, dto.getOut_pct());
		st.setString(5, dto.getOut_date());
		int result = st.executeUpdate();
		DBConnector.disconnection(con, st);
		return result;
	}
	
	public ArrayList<IoDTO> selectIoList() throws Exception {
		Connection con = DBConnector.connector();
		String sql = "SELECT * FROM IO";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<IoDTO> ar = new ArrayList<IoDTO>();
		while(rs.next()) {
			IoDTO dto = new IoDTO();
			dto.setNum(rs.getInt("NUM"));
			dto.setPnum(rs.getInt("PNUM"));
			dto.setIn_pct(rs.getInt("IN_PCT"));
			dto.setIn_date(rs.getString("IN_DATE"));
			dto.setOut_pct(rs.getInt("OUT_PCT"));
			dto.setOut_date(rs.getString("OUT_DATE"));
			ar.add(dto);
		}
		DBConnector.disconnection(con, st, rs);
		return ar;
	}
	
	public IoDTO selectIoOne(int result)throws Exception {
		Connection con = DBConnector.connector();
		String sql = "SELECT * FROM IO WHERE NUM=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, result);
		ResultSet rs = st.executeQuery();
		IoDTO dto = null;
		if(rs.next()) {
			dto= new IoDTO();
			dto.setNum(rs.getInt(1));
			dto.setNum(rs.getInt(2));
			dto.setIn_pct(rs.getInt(3));
			dto.setIn_date(rs.getString(4));
			dto.setOut_pct(rs.getInt(5));
			dto.setOut_date(rs.getString(6));
		}
		DBConnector.disconnection(con, st, rs);
		return dto;
	}

}
