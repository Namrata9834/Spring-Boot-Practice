package com.codekul.Spring6DecBatch.mongo.repository;

import com.codekul.Spring6DecBatch.mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
    @Query(value = "{$and:[{name:?0},{designation:?1}]}",fields = "{'permanentAddress':0}")
    List<User> findByNameAndDesignation(String name, String designation);

    @Query("{$or:[{name:?0},{designation:?1}]}")
    List<User> findByNameOrDesignation(String name,String designation);

    @Query("{'permanentAddress.city':?0}")
    List<User> findUsersByCity(String city);

    @Query(value = "{$text:{$search:?0}}",fields = "{'permanentAddress':0,'correspondingAddress':0}")
    List<User> searchUserByText(String searchString);
}
