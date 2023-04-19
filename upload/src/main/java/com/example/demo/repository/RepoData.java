package com.example.demo.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Entity1;
@Repository
public interface RepoData extends CrudRepository<Entity1,Integer> 
{
	 @Query(value = "SELECT * FROM employ9 where id=?1", nativeQuery = true)
	   Map<String,Object>getEmpDetailsbyid(Integer id);
	   
	  @Query(value="SELECT * FROM address where empid = ?1", nativeQuery=true)
	     Map<String,Object>getEmpAddressbyid(Integer id);
	  
	  @Query(value="SELECT response_Json from employ9 where id=?1 ", nativeQuery=true)
      String getdata (Integer id );
	  
	  @Query(value= "SELECT * FROM employ9 where first_Name= ?1", nativeQuery=true)
	  Map<String,Object>getEmpName(String firstName);
	  
	  @Query(value="SELECT id from employ9 where user_Name= ?1", nativeQuery=true)
	  Integer getId(String userName);
	  
	  @Query(value="SELECT id from employ9 where user_Name= ?1", nativeQuery=true)
	  Integer getemp_Id(String userName);
	  
	  @Query(value="Select * from emp_image where emp_id=?1", nativeQuery=true)
	  Map<String,Object>getEmpImgById(Integer id);

		/*
		 * @Query(value = "select * from employ9 where id =?1",nativeQuery=true)
		 * Map<String,Object> getId(Integer id);
		 */
	  

}
