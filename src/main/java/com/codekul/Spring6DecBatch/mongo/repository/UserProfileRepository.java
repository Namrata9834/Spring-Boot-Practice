package com.codekul.Spring6DecBatch.mongo.repository;

import com.codekul.Spring6DecBatch.mongo.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile,String> {
}
