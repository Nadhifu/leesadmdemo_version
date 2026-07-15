package com.example.application.services;

//import com.example.examplefeature.ui.*;
//import com.example.examplefeature.MembershipFeesBean;
//import com.example.examplefeature.MembershipFeesBeanRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.application.repositories.MembershipFeesBeanRepository;
import com.example.application.entities.MembershipFeesBean;

@Service
public class MembershipFeesBeanService {
	
  //  @Autowired
    private  MembershipFeesBeanRepository repository;

    @Autowired
    public void MembersFeeBeansService(MembershipFeesBeanRepository repository) {
        this.repository = repository;
    }

    public Optional<MembershipFeesBean> get(Long id) {
       return repository.findById(id);
    }

    public MembershipFeesBean save(MembershipFeesBean entity) {
    	return repository.save(entity);
    	
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<MembershipFeesBean> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

   public Page<MembershipFeesBean> list(Pageable pageable, Specification<MembershipFeesBean> filter) {
      return repository.findAll(filter, pageable);
   }
    public int count() {
        return (int) repository.count();
    }
    
}
