package com.G1AppDevProj.Project.Service;


import com.G1AppDevProj.Project.Entity.Topic;
import com.G1AppDevProj.Project.Repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private final TopicRepo topicRepository;

    @Autowired
    public TopicService(TopicRepo topicRepository) {
        this.topicRepository = topicRepository;
    }

    // Create
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    // Find by ID
    public Optional<Topic> findTopicById(int id) {
        return topicRepository.findById(id);
    }

    // Find All
    public List<Topic> findAllTopics() {
        return topicRepository.findAll();
    }

    // Update
    public Topic updateTopic(int id, Topic updatedTopic) {
        Optional<Topic> existingTopic = topicRepository.findById(id);
        if (existingTopic.isPresent()) {
            Topic topic = existingTopic.get();
            topic.setTopicName(updatedTopic.getTopicName());
            topic.setDescription(updatedTopic.getDescription());
            return topicRepository.save(topic);
        }
        return null;
    }

    // Delete
    public boolean deleteTopic(int id) {
        if (topicRepository.existsById(id)) {
            topicRepository.deleteById(id);
            return true;
        }
        return false;
    }
}