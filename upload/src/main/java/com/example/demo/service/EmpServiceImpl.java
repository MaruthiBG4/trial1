package com.example.demo.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.DtoAddress;
import com.example.demo.dto.DtoUpdate;
import com.example.demo.dto.Dtoemp;
import com.example.demo.dto.EmpImgResponse;
import com.example.demo.dto.Response;
import com.example.demo.dto.ResponseJson;
import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.Entity1;
import com.example.demo.entity.ImageEntity;
import com.example.demo.repository.AddressRepo;
import com.example.demo.repository.EmpImgRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.RepoData;
import com.example.demo.util.ImageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Service 

public class EmpServiceImpl implements EmpService
{
	@Autowired
	private AddressRepo arep;
	
	@Autowired
	private RepoData repo;
	
	@Autowired 
	private ImageRepository imgrep; 
	
	@Autowired 
	private EmpImgRepository imgRepository; 

	
	ObjectMapper mapper; 
	@PostConstruct
	  public void init() {
	     mapper = new ObjectMapper();
	  }
	@Override
	public Map<String, String> createuser(Dtoemp epj,String data) 
	{
		Map<String,String> map = new HashMap<String,String>();
		 
		 List<Map<String, Object>> jsonData = epj.getResponseJson();
		 
//		ResponseJson jsonData = epj.getResponseJson(); 
		try {
			Entity1 emp = new Entity1();
		  
			 String data1 = mapper.writeValueAsString(jsonData); 
			   emp.setAge(epj.getAge()); 
			   emp.setFirstName(epj.getFirstName()); 
			   emp.setUserName(epj.getUserName());
			   emp.setLastName(epj.getLastName());
			   emp.setPhno(epj.getPhno());
			   emp.setEmail(epj.getEmail());
			   emp.setCreatedDate(new Date());
			   emp.setCreatedBY(data);
			   emp.setDetails(data1);
			   
			   
				/* emp.setDetails(data); */
			   
				/* DtoAddress address = (DtoAddress) epj.getAddress(); */
			   repo.save(emp);
			   Integer id = repo.getId(epj.getUserName());
			   
			 //  AddressEntity en = new AddressEntity();	
				/*
				 * en.setCountry(address.getCountry()); en.setCity(address.getCity());
				 * en.setState(address.getState()); en.setPostalCode( address.getPostalCode());
				 */
			 //    en.setEmpId(id);
		     
             //   arep.save(en);
                
                  map.put("Message","Success");
				}
		 catch (Exception e) {
					      System.out.print(e.getMessage());
			 		    map.put("Message","Failure");
				    }
				           
	                  return map;
	}
		
	
	@Override
	public Response getuserbyid(Integer id) 
	{
		Response res = new Response(); 
	 
		 Map<String,Object>dataEmp =repo.getEmpDetailsbyid(id);
		  // to fetch only employee details
		 //Map<String,Object>dataAdd =repo.getEmpAddressbyid(id);
		 
		 String datajson = repo.getdata(id);
		//  sql query to fetch the json data
		 
		 
		 try {
			 TypeReference <List<Map<String,Object>>> ref = new TypeReference<>() {};
				 List<Map<String, Object>> response = mapper.readValue(datajson,ref);
			 
			 
			// ResponseJson str = mapper.readValue(datajson, ResponseJson.class);
			 res.setFirstName(String.valueOf(dataEmp.get("first_Name")));
			 res.setLastName(String.valueOf(dataEmp.get("last_Name")));
			 res.setUserName(String.valueOf(dataEmp.get("user_Name")));
			 res.setEmail(String.valueOf(dataEmp.get("email")));
			 res.setPhno(String.valueOf(dataEmp.get("phno")));
			 res.setId(Integer.parseInt(String.valueOf(dataEmp.get("id"))));
			 res.setAge(Integer.parseInt(String.valueOf(dataEmp.get("age"))));
			  res.setResponseJson(response);
			 res.setCreatedBY(String.valueOf(dataEmp.get("created_by")));
			 res.setCreatedDate(String.valueOf(dataEmp.get("created_date")));
			 res.setUpdatedDate(String.valueOf(dataEmp.get("updated_date")));
			 res.setUpdatedBY(String.valueOf(dataEmp.get("updated_by")));
			 
			 
			 //res.setAddress(dataAdd);
		 }
		 catch ( Exception e) {
				e.printStackTrace();
			}
		 
 
		 return res;
		 
		
	}

	/*
	 * @Override public Map<String, Object> getuserbyname(String firstName) { //
	 * TODO Auto-generated method stub return null; }
	 * 
	 * @Override public Map<String, String> updateuser(DtoUpdate update, Integer id)
	 * { // TODO Auto-generated method stub return null; }
	 */
	@Override
	public Map<String, String> storedata(MultipartFile file, String data) 
	{
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			Entity1 emp = new Entity1();
			Entity1 courseEntity = mapper.readValue(data, Entity1.class);
			
			         emp.setAge( courseEntity.getAge());
			         emp.setFirstName( courseEntity.getFirstName());
					 emp.setLastName( courseEntity.getLastName());
					 emp.setEmail( courseEntity.getEmail());
	                 emp.setUserName( courseEntity.getUserName());
					 emp.setPhno( courseEntity.getPhno());
		
					 repo.save(emp); 
					 
					 Integer id = repo.getemp_Id(emp.getUserName());
					 
					 ImageEntity imageEntity = new ImageEntity ();
					 imageEntity.setName(file.getOriginalFilename());
	                  imageEntity.setType(file.getContentType());
	                  imageEntity.setEmpimage(ImageUtil.compressedbyte(file.getBytes()));
	                  imageEntity.setEmpId(id);
	                  
	                  imgrep.save(imageEntity);
	                  map.put("Message","Success");
	                  
        }
          catch (Exception e) {
          System.out.print(e.getMessage());
         map.put("Message","Failure");
            }
		return map;
				}
	                  
	
	
	@Override
	public EmpImgResponse getimagebyid(Integer id) 
	{
		 EmpImgResponse imgResponse = new  EmpImgResponse();
		 
		 Map<String,Object>dataEmp =repo.getEmpDetailsbyid(id);    
		 
		 Map<String,Object>dataImg =repo.getEmpImgById(id);
		  
		 try {
			 
			  imgResponse.setFirstName(String.valueOf(dataEmp.get("first_Name")));   
			  imgResponse.setUserName(String.valueOf(dataEmp.get("user_Name")));
			  imgResponse.setLastName(String.valueOf(dataEmp.get("last_Name")));
			  imgResponse.setEmail(String.valueOf(dataEmp.get("email")));
			  imgResponse.setPhno(String.valueOf(dataEmp.get("phno")));
			  imgResponse.setId(Integer.parseInt(String.valueOf(dataEmp.get("id"))));
			  imgResponse.setAge(Integer.parseInt(String.valueOf(dataEmp.get("age"))));
			  
			  imgResponse.setImadegata(dataImg);
		 
		 }
		 
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 return imgResponse ;
	}
	@Override
	public Map<String, String> createdata(Dtoemp dtoemp) {
		
		Map<String,String> map = new HashMap<String,String>();
		try {
			Entity1 emp = new Entity1();
			emp.setAge(dtoemp.getAge());
			emp.setFirstName(dtoemp.getFirstName());
			emp.setUserName(dtoemp.getUserName());
			emp.setLastName(dtoemp.getLastName());
			emp.setPhno(dtoemp.getPhno());
			emp.setEmail(dtoemp.getEmail());
			emp.setCreatedDate(new Date());
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, String> createuser(DtoUpdate dtoupdate, Integer id, String data) 
	{
		Map<String,String> map = new HashMap<String,String>();
		try {
			Entity1 emp = new Entity1();
			emp.setId(dtoupdate.getId());
			emp.setFirstName(dtoupdate.getFirstName());
			emp.setUserName(dtoupdate.getUserName());
			emp.setLastName(dtoupdate.getLastName());
			emp.setPhno(dtoupdate.getPhno());
			emp.setEmail(dtoupdate.getEmail());
			emp.setUpdatedBY(data);
			emp.setUpdatedDate(new Date());
			repo.save(emp);
			}
		
		catch(Exception e) {
			e.printStackTrace();
	}
		return map;
		}
	@Override
	public Map<String, String> updateselectedfields(Map<String, Object> fields, Integer id, String data) 
	{
		Map<String,String> map = new HashMap<String,String>();
		try {
			Entity1 existingdata = repo.findById(id).get();
			existingdata.setUpdatedBY(data);
			existingdata.setUpdatedDate(new Date());
			
			fields.forEach((key,value)->
			{
				 Field field = ReflectionUtils.findField(Entity1.class,key);
           	  field.setAccessible(true);
           	  ReflectionUtils.setField(field, existingdata, value);
             });
			repo.save(existingdata); 
			
			map.put("message", "updated"); 
			
		                    }
                            catch (Exception e){
                     map.put("message", "failure"); 

                     }

			                   return map; 
		                      }
}
	/*@Override
	public Map<String, String> getdata(Integer id) 
	{
		Map<String,String> map = new HashMap<String,String>();
		try {
		Dtoemp emp = new Dtoemp();
		emp.setId(emp.getId());
		emp.setFirstName(emp.getFirstName());
		emp.setUserName(emp.getUserName());
		emp.setLastName(emp.getLastName());
		emp.setPhno(emp.getPhno());
		emp.setEmail(emp.getEmail());
		emp.setCreatedBY(emp.getCreatedBY());
		emp.setCreatedDate(emp.getCreatedDate());
		emp.setUpdatedBY(emp.getUpdatedBY());
		emp.setUpdatedDate(emp.getUpdatedDate());
		
		}
	catch(Exception e) {
		e.printStackTrace();
	}
		return map;*/
	
	/* }} */			
			
		
		
	
	
	
	
	

	
	
	
	
	
	
	
	
		
	

