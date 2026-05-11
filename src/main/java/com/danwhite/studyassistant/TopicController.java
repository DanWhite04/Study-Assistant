package com.danwhite.studyassistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;
    @GetMapping

    public List<Topic> getAllTopics(){
        return topicRepository.findAll();
    }

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic) {
        return topicRepository.save(topic);
    }
    @DeleteMapping("/{id}")
    public void  DeleteTopic( @PathVariable int id) {
        topicRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Topic updateTopic(@PathVariable int id, @RequestBody Topic topic){
        topic.setId(id);
        return topicRepository.save(topic);
    }
}
