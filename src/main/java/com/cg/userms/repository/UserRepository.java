package com.cg.userms.repository;

import org.springframework.data.repository.CrudRepository;


import com.cg.userms.entity.Userdata;


public interface UserRepository extends CrudRepository<Userdata,Integer>{

}
