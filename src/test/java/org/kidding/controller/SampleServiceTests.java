package org.kidding.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kidding.mapper.T1Mapper;
import org.kidding.mapper.T2Mapper;
import org.kidding.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleServiceTests {

	

	
	@Setter(onMethod_=  @Autowired)
	private SampleService service;

	
	@Test
	public void testMulti() {
		String str = "블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라";
		service.addMulti(str);
	}
	
	@Test
	public void testAdd()throws Exception {
		
		log.info("RESULT: " + service.doAdd("123", "456"));
//		log.info("RESULT: " + service.doAdd("123", null));

	}
	
	
	
}
