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
//		int result = dao.update(30, 2);
//		assertEquals(1, result);
//		dto.setCategory("ELECTRONIC");
//		dto.setpName("GRAM");
//		dto.setPrice(150);
//		dto.setStock(10);
//		int result = dao.insert(dto);
//		assertEquals(1, result);
	}

}
