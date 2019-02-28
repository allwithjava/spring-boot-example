package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	// By default its a GET request
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
		
	}
	
	//@PathVariable should be specified when there is a parameter in the request. Here id values comes from user's request
	// and passed in variable id
	@RequestMapping("/topics/{id}")	
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	// @RequestBody says MVC  that the request payload contains a JSON representation of this Topic instance and takes
	// the topic from the request body and convert it to an object and makes it ready for the operation.
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {		
		topicService.addTopic(topic);
		
	}
	
	// @RequestBody says MVC  that the request payload contains a JSON representation of this Topic instance and takes
	// the topic from the request body and convert it to an object and makes it ready for the operation.
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {		
			topicService.updateTopic(id, topic);
			
	}
	
	// @RequestBody says MVC  that the request payload contains a JSON representation of this Topic instance and takes
	// the topic from the request body and convert it to an object and makes it ready for the operation.
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {		
				topicService.deleteTopic(id);
				
	}

}
