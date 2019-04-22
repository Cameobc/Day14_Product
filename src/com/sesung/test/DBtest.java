package com.sesung.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sesung.util.DBConnector;

public class DBtest {

	@Test
	public void test() throws Exception {
		new DBConnector().connector();
	}

}
