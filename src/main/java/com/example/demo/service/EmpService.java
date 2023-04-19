package com.example.demo.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.DtoUpdate;
import com.example.demo.dto.Dtoemp;
import com.example.demo.dto.EmpImgResponse;
import com.example.demo.dto.Response;

public interface EmpService {

	Map<String, String> createuser(Dtoemp epj,String data);

	Response getuserbyid(Integer id);

	/*
	 * Map<String, Object> getuserbyname(String firstName);
	 * 
	 * Map<String, String> updateuser(DtoUpdate update, Integer id)
	 */;

	Map<String, String> storedata(MultipartFile file, String data);

	EmpImgResponse getimagebyid(Integer id);

	Map<String, String> createdata(Dtoemp dtoemp);

	Map<String, String> createuser(DtoUpdate dtoupdate, Integer id, String data);

	

	Map<String, String> updateselectedfields(Map<String, Object> fields, Integer id, String data);

	

	/* Map<String, String> getdata(Integer id); */

}
