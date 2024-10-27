package com.G1AppDevProj.Project.Controller;

import com.G1AppDevProj.Project.Entity.Topic;
import com.G1AppDevProj.Project.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    // Create Topic
    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        Topic createdTopic = topicService.createTopic(topic);
        return new ResponseEntity<>(createdTopic, HttpStatus.CREATED);
    }

    // Get Topic by ID
    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable int id) {
        Optional<Topic> topic = topicService.findTopicById(id);
        return topic.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get All Topics
    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = topicService.findAllTopics();
        return ResponseEntity.ok(topics);
    }

    // Update Topic
    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable int id, @RequestBody Topic updatedTopic) {
        Topic topic = topicService.updateTopic(id, updatedTopic);
        if (topic != null) {
            return ResponseEntity.ok(topic);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete Topic
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable int id) {
        if (topicService.deleteTopic(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
