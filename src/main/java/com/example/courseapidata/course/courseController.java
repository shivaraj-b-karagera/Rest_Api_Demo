package com.example.courseapidata.course;

import com.example.courseapidata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class courseController {
    @Autowired
    private courseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<course> getAllcourses(@PathVariable String id) {

        return courseService.getAllcourses(id);
    }

    @RequestMapping("/topics/{topicid}/courses/{id}")
    public Optional<course> getcourse(@PathVariable String id) {

        return courseService.getcourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicid}/courses")
    public void addcourse(@RequestBody course course,@PathVariable String topicid) {
        course.setTopic(new Topic(topicid,"",""));
        courseService.addcourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicid}/courses/{id}")
    public void updatecourse(@RequestBody course course, @PathVariable String topicid,@PathVariable String id) {
        course.setTopic(new Topic(topicid,"",""));
        courseService.updatecourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicid}/courses/{id}")
    public void deletecourse(@PathVariable String id) {
        courseService.deletecourse(id);
    }
}
