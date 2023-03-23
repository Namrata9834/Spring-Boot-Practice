package com.codekul.Spring6DecBatch.mongo.service;

import com.codekul.Spring6DecBatch.mongo.model.User;
import com.codekul.Spring6DecBatch.mongo.model.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<?> createUser(User user);

    ResponseEntity<?> getUserByNameAndDesignation(String name,String designation);

    ResponseEntity<?> getUsersByCity(String city);

    ResponseEntity<?> searchUser(String searchString);

    void saveUserProfile(UserProfile userProfile);

    List<UserProfile> getAllUsersProfile();
}
