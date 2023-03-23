package com.codekul.Spring6DecBatch.mongo.controller;

import com.codekul.Spring6DecBatch.mongo.model.User;
import com.codekul.Spring6DecBatch.mongo.model.UserProfile;
import com.codekul.Spring6DecBatch.mongo.service.UserService;
import com.codekul.Spring6DecBatch.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public ResponseEntity<?> getUserByNameAndDesignation(@RequestParam String name,
                                                         @RequestParam String designation){
        return userService.getUserByNameAndDesignation(name,designation);
    }

    @GetMapping("/getUsersByCity/{city}")
    public ResponseEntity<?> getUsersByCity(@PathVariable String city){
        return userService.getUsersByCity(city);
    }

    @GetMapping("/searchUser")
    public ResponseEntity<?> searchUser(@RequestParam String searchString){
        return userService.searchUser(searchString);
    }

    @PostMapping("/saveUserProfile")
    public ResponseEntity<?> saveUserProfile(@RequestBody UserProfile userProfile){
        ApiResponse apiResponse = new ApiResponse();
        try {
            userService.saveUserProfile(userProfile);
            apiResponse.setMessage("User Profile saved successfully");
            apiResponse.setStatus(HttpStatus.CREATED.value());
            return ResponseEntity.ok(apiResponse);
        }catch (Exception e){
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setMessage("Something went wrong");
            return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllUsersProfile")
    public ResponseEntity<?> getAllUsersProfile(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Get All Data");
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setResult(userService.getAllUsersProfile());
        return ResponseEntity.ok(apiResponse);

    }
}
