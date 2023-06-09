package com.example.demo.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmpImg;
@Repository
public interface EmpImgRepository extends CrudRepository<EmpImg,Integer> {

	 @Query(value="Select * from empimg where id=?1", nativeQuery=true)
	 Map<String,Object> getdata(Integer id);
	 
}
