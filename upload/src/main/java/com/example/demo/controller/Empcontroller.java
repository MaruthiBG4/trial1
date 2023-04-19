package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.dto.DtoUpdate;
import com.example.demo.dto.Dtoemp;
import com.example.demo.dto.EmpImgResponse;
import com.example.demo.dto.Response;
import com.example.demo.service.EmpService;

@RestController
@RequestMapping("/empuser")
public class Empcontroller 
{
	@Autowired
	EmpService empService;
	
	@PostMapping("/createuser")
	  public Map<String,String>postdetails(@RequestBody Dtoemp epj,@RequestHeader("login") String data){
			Map<String,String> map = empService.createuser(epj,data);
		return map;
		}
	
	//FETCH DATA BY ID
	@GetMapping("/getdata/{id}")
	  public Response fetchuser(@PathVariable Integer id){	   
	  Response m1 = empService.getuserbyid(id);
	  return m1;

}
/*
 * //FETCH DATA BY NAME FROM TABLE
 * 
 * @GetMapping("/getname/{first_Name}") public Map<String, Object>
 * fetchusername(@PathVariable String firstName){ Map<String, Object> m3 =
 * empService.getuserbyname(firstName); return m3; }
 * 
 * @PutMapping("/update/{id}") public
 * Map<String,String>updatedetails(@RequestBody DtoUpdate
 * update, @PathVariable("id") Integer id){ Map<String,String> m2 =
 * empService.updateuser(update, id); return m2; }
 */
	 
	 @PostMapping("/storedata")
     public Map<String, String> store( @RequestPart("image") MultipartFile file, @RequestPart("metadata") String data) {
    	 return empService.storedata(file, data);
     }
     
	 @GetMapping("/getval/{id}")
     public  EmpImgResponse fetchval(@PathVariable Integer id){
    	  EmpImgResponse r1 = empService.getimagebyid(id);
		return r1;
    	 }
	 
	 
	 @PutMapping("/update/{id}")
	 public Map<String, String> updaterecord(@RequestBody DtoUpdate dtoupdate,@PathVariable("id")Integer id,@RequestHeader("login") String data)
	 {
		 Map<String, String> s1 = empService.createuser(dtoupdate,id, data);
		 return s1;
		 
		 
	 }
	 
	 @PatchMapping("/{id}")
	 public Map<String, String> updatefields(@PathVariable("id")Integer id,@RequestBody Map<String, Object> fields, @RequestHeader("login")String data){
		 Map<String, String> s2 = empService.updateselectedfields(fields,id,data);
		return s2;
	 }
	 
		/*
		 * @GetMapping("/getval/{id}") public Map<String, String>
		 * fetchval1(@PathVariable Integer id){ Map<String, String> s3 =
		 * empService.getdata(id); return s3; }
		 */
	 
	 
	 
	 
	 @PostMapping("/createdata")
	 public Map<String, String> create(@ RequestBody Dtoemp dtoemp)
	 {
		 return empService.createdata(dtoemp);
		 
	 }
	
	
}
