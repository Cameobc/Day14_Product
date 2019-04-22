package com.sesung.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sesung.product.ProductDAO;
import com.sesung.product.ProductDTO;

public class ProductDAOTest {

	@Test
	public void test() throws Exception {
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = new ProductDTO();
		dto = dao.selectOne(3);
		assertNotNull(dto);
//		dto.setCategory("ELECTRONIC");
//		dto.setpName("GRAM");
//		dto.setPrice(150);
//		dto.setStock(10);
//		int result = dao.insert(dto);
//		assertEquals(1, result);
	}

}
