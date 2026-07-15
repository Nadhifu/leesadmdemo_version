package com.example.application.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.stereotype.Repository;
import com.example.application.entities.MembersBean;




//@Repository
public interface MembersBeanRepository 
		        extends
	            JpaRepository<MembersBean, Long>,
	            JpaSpecificationExecutor<MembersBean> {
	
	
	}
   