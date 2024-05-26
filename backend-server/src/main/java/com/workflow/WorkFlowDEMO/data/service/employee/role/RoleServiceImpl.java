package com.workflow.WorkFlowDEMO.data.service.employee.role;

import com.workflow.WorkFlowDEMO.data.entity.employee.Role;
import com.workflow.WorkFlowDEMO.data.repository.employee.RoleJpaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService{


    @Autowired
    private  RoleJpaRepository roleJpaRepository;

    @Autowired
    private EntityManager entityManager;



    @Override
    public Role findByName(String roleName) {
        return roleJpaRepository.findByName(roleName);
    }

    @Override
    public Role findById(long id) {
        return roleJpaRepository.findById(id);
    }

    @Override
    public Role saveNewRole(String roleName) {
        Role newRole = new Role(roleName);
        return roleJpaRepository.save(newRole);
    }

    @Override
    public Role deleteById(long id) {
        return roleJpaRepository.deleteById(id);
    }


    @Override
    public boolean existById(long id) {
        return roleJpaRepository.existsById(id);
    }


}
