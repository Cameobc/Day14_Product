package com.sesung.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.sesung.io.IoDAO;
import com.sesung.io.IoDTO;
import com.sesung.product.ProductDAO;
import com.sesung.product.ProductDTO;
import com.sesung.util.DBConnector;

public class IoDAOTest {

	@Test
	public void test(){
		//이클립스하고, 디벨로퍼는 auto-commit
		IoDAO dao = new IoDAO();
		IoDTO dto = new IoDTO();
		ArrayList<IoDTO> ar = new ArrayList<IoDTO>();
		dto.setPnum(4);
		dto.setIn_date("2019-04-3");
		Connection con = null;
		int result = 0;
		try {
			con = DBConnector.connector();
			con.setAutoCommit(false);
			dto.setIn_pct(20);
			result = dao.insertIo(dto, con);
			if(result<=1) {   //1
				throw new Exception();
			}

		  // 2
				ProductDAO pdao = new ProductDAO();
				ProductDTO pdto = new ProductDTO();
				pdto.setStock(dto.getIn_pct());
				pdto.setPnum(122);
				result = pdao.update(pdto, con);
			

			if(result<=1) {  // 1
				throw new Exception();
			}
			con.commit();  //1


		}catch(Exception e){
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			
			try {
				con.close();
				con.setAutoCommit(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertEquals(1, result);
		//		ar = dao.selectIoList();
		//		assertNotEquals(0, ar);

	}

}
