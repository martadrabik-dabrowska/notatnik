package com.chat.services;


import com.chat.model.User;
import com.chat.repositories.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<User> findAllSearch(String param) {
        List<User> userList=adminRepository.findAllSearch(param);
        return userList;
    }

    @Override
    public void deleteUserById(int id) {
        adminRepository.deleteUserFromUserRole(id);
        adminRepository.deleteUserFromUser(id);
    }
}
