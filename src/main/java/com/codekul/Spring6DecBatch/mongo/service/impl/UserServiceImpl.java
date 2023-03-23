package com.codekul.Spring6DecBatch.mongo.service.impl;

import com.codekul.Spring6DecBatch.mongo.model.User;
import com.codekul.Spring6DecBatch.mongo.model.UserProfile;
import com.codekul.Spring6DecBatch.mongo.repository.UserProfileRepository;
import com.codekul.Spring6DecBatch.mongo.repository.UserRepository;
import com.codekul.Spring6DecBatch.mongo.service.UserService;
import com.codekul.Spring6DecBatch.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Override
    public ResponseEntity<?> createUser(User user) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("User Created Successfully");
        apiResponse.setStatus(HttpStatus.CREATED.value());
        userRepository.save(user);
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<?> getUserByNameAndDesignation(String name, String designation) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("User Found");
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setResult(userRepository.findByNameAndDesignation(name,designation));
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<?> getUsersByCity(String city) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Get users by city");
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setResult(userRepository.findUsersByCity(city));
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<?> searchUser(String searchString) {
        ApiResponse apiResponse = new ApiResponse();

        List<User> users = userRepository.searchUserByText(searchString);
        if (users.isEmpty()){
            apiResponse.setMessage("List is empty");
            apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
        }
        apiResponse.setMessage("search user");
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setResult(users);
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public void saveUserProfile(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }

    @Override
    public List<UserProfile> getAllUsersProfile() {
        return userProfileRepository.findAll();
    }
}
