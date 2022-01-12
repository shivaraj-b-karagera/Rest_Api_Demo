package com.example.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class topicService {
    @Autowired
   private static topicRepository topicRepository;

    private static final List<Topic> topics= new ArrayList<>(Arrays.asList()) ;
    /* new Topic("spring","spring FrameWork","spring FrameWork Description"),
            new Topic("java","core java","core java Description"),
            new Topic("javascript","JavaScript","JavaScript Description")
    )*/

    public topicService(topicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public static void addTopic(Topic topic) {
        //topics.add(topic);
     topicRepository.save(topic);
    }

    public static void updateTopic(String id, Topic topic) {
        /*for(int i=0;i<topics.size();i++){
            Topic t=topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }*/
        topicRepository.save(topic);
    }

    public List<Topic> getAllTopics(){
        //return topics;
        List<Topic> topics=new ArrayList<>();
        for (Topic topic : topicRepository.findAll())
            topics.add(topic);
        return topics;
}

    public Optional<Topic> getTopic(String id){
        //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
      return topicRepository.findById(id);
}

    public void deleteTopic(String id) {
//        topics.removeIf(t->t.getId().equals(id));
           topicRepository.deleteById(id);
    }
}
