package com.example.demo.topic;

import com.example.demo.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
   List<Topic> topics=  new ArrayList<>(Arrays.asList(
            new Topic("Spring","Spring FrameWork","Spring FrameWork Description"),
                new Topic("Java","Core Java","Core Java Description"),
                new Topic("JavaScript","JavaScript","JavaScript Description")

                                                   ));
   public List<Topic> getAllTopics(){
       return topics;
   }
   public Topic getTopic(String id){
       return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
   }

    public void addTopic(Topic topic) {
       topics.add(topic);
    }
    public void updateTopic(String id,Topic topic){
       for(int i=0;i<topics.size();i++){
           Topic t=topics.get(i);
           if(topic.getId().equals(id)){
               topics.set(i,topic);
               return;
           }
       }
    }

    public void deleteTopic(String id) {
       topics.removeIf(t->t.getId().equals(id));
       return;
    }
}
