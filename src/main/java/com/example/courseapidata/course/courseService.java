package com.example.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class courseService {
    @Autowired
   private static courseRepository courseRepository;

    private static final List<course> COURSES = new ArrayList<>(Arrays.asList()) ;

    public courseService(courseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public static void addcourse(course course) {
     courseRepository.save(course);
    }

    public static void updatecourse(course course) {
        courseRepository.save(course);
    }

    public List<course> getAllcourses(String topicid){
        List<course> courses =new ArrayList<>();
        for (course course : courseRepository.findByTopicId(topicid))
            courses.add(course);
        return courses;
}

    public Optional<course> getcourse(String id){
      return courseRepository.findById(id);
}

    public void deletecourse(String id) {
           courseRepository.deleteById(id);
    }
}
