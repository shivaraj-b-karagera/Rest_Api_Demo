package com.example.courseapidata.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface courseRepository extends CrudRepository<course,String> {
    public List<course>findByTopicId(String topicid);


}
