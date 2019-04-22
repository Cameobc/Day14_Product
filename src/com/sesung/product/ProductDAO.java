package com.sesung.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sesung.util.DBConnector;

public class ProductDAO {
	
	public ArrayList<ProductDTO> selectList() throws Exception {
		Connection con = DBConnector.connector();
		String sql = "SELECT * FROM PRODUCT";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setPnum(rs.getInt("PNUM"));
			dto.setCategory(rs.getString("CATEGORY"));
			dto.setpName(rs.getString("PNAME"));
			dto.setPrice(rs.getInt("PRICE"));
			dto.setStock(rs.getInt("STOCK"));
			ar.add(dto);
		}
		DBConnector.disconnection(con, st, rs);
		return ar;
	}
	
	public ProductDTO selectOne(int result) throws Exception {
		Connection con = DBConnector.connector();
		String sql = "SELECT * FROM PRODUCT WHERE PNUM =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, result);
		ResultSet rs = st.executeQuery();
		ProductDTO dto = null;
		if(rs.next()) {
			dto = new ProductDTO();
			dto.setPnum(rs.getInt("PNUM"));
			dto.setCategory(rs.getString("CATEGORY"));
			dto.setpName(rs.getString("PNAME"));
			dto.setPrice(rs.getInt("PRICE"));
			dto.setStock(rs.getInt("STOCK"));
		}
		DBConnector.disconnection(con, st, rs);
		return dto;
		
	}
	
	public void update(String column, ProductDTO dto) throws Exception{
		Connection con = DBConnector.connector();
		String sql = "UPDATE PRODUCT SET = ? WHERE PNUM=1";
		PreparedStatement st = con.prepareStatement(sql);
	}
	
	public int insert(ProductDTO dto) throws Exception {
		Connection con = DBConnector.connector();
		String sql = "INSERT INTO PRODUCT VALUES (PRODUCT_SEQ.nextval, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getCategory());
		st.setString(2, dto.getpName());
		st.setInt(3, dto.getPrice());
		st.setInt(4, dto.getStock());
		int result = st.executeUpdate();
		DBConnector.disconnection(con, st);
		return result;
	}
	

}
