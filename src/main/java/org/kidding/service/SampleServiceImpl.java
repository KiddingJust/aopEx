package org.kidding.service;

import org.kidding.mapper.T1Mapper;
import org.kidding.mapper.T2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;

@Service
public class SampleServiceImpl implements SampleService{

	@Setter(onMethod_= @Autowired)
	private T1Mapper t1Mapper;
	@Setter(onMethod_= @Autowired)
	private T2Mapper t2Mapper;
	
	@Override
	public Integer doAdd(String str1, String str2) throws Exception {

		
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}

	//transactional 걸기 전에는, varchar(500)인 tbl_t1에는 들어가고 t2에는 들어가지 않는다. 하지만 transactional을 걸면 둘 다 안들어간다. 
	@Transactional
	@Override
	public void addMulti(String str) {
		// TODO Auto-generated method stub
		
		t1Mapper.insert(str);
		t2Mapper.insert(str);
	}

}
