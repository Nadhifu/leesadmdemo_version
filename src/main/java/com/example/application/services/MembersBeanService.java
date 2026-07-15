package com.example.application.services;

//import com.example.application.views.MembersBean;
//import com.example.application.views.MembersBeanRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.application.repositories.MembersBeanRepository;
import com.example.application.entities.MembersBean;

@Service
public class MembersBeanService {
	
  //  @Autowired
    private  MembersBeanRepository repository;

    @Autowired
    public void MembersBeansService(MembersBeanRepository repository) {
        this.repository = repository;
    }

    public Optional<MembersBean> get(Long id) {
        return repository.findById(id);
    }

    public MembersBean save(MembersBean entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<MembersBean> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<MembersBean> list(Pageable pageable, Specification<MembersBean> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }
    
}
