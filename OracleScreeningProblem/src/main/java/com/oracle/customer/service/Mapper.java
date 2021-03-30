package com.oracle.customer.service;

import java.util.List;

import com.oracle.customer.bean.CustomerDetailsBean;

public interface Mapper {
	public List<CustomerDetailsBean> setMultiLineToBean(String multiLineList);
}
