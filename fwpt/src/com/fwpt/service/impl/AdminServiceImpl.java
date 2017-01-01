package com.fwpt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fwpt.mapper.AdminMapper;
import com.fwpt.po.Admin;
import com.fwpt.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired  
	private AdminMapper adminMapper;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED,
					noRollbackFor={RuntimeException.class},readOnly=true,timeout=5)
	public Admin login(String number, String password) {
		Admin admin=new Admin();
		admin.setNumber(number);
		admin.setPassword(password);
		return adminMapper.login(admin);
	}

}
