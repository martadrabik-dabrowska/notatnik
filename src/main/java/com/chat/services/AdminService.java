package com.chat.services;

import com.chat.model.User;
import java.util.List;

public interface AdminService {

    List<User> findAllSearch(String param);

    void deleteUserById(int id);
}
