package com.oracle.customer.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.oracle.customer.bean.CustomerDetailsBean;
import com.oracle.customer.service.Mapper;

public class MapperImpl  implements Mapper{
	
	
	//Method takes MultiLine string as Input AND loads every Row to Bean object and return list Of Bean
		public List<CustomerDetailsBean> setMultiLineToBean(String multiLineList) {
			String lines[] = multiLineList.split("[\\r\\n]+");
			List<CustomerDetailsBean> listOfRows=new ArrayList<CustomerDetailsBean>();
			
			for (String line : lines) {
				String words[] = line.split(",");
				CustomerDetailsBean bean=new CustomerDetailsBean();
				if(words.length ==6)
				{
					bean.setCustomerId(new BigInteger(words[0]));
					bean.setContractId(Integer.valueOf(words[1]));
					bean.setGeozone(words[2]);
					bean.setTeamcode(words[3]);
					bean.setProjectcode(words[4]);
					String buildDureation=words[5].trim();
					buildDureation=buildDureation.substring(0,buildDureation.length()-1);
					bean.setBuildduration(Integer.valueOf(buildDureation));
					listOfRows.add(bean);
				}
				else
				{
					System.out.println("Give row is not valid to capture data to beans");
				}
					
				
			}
			return listOfRows;
		}

}
