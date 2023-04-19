package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ImageEntity;
@Repository
public interface ImageRepository extends CrudRepository<ImageEntity,Long>{

}
