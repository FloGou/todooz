package fr.todooz.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import fr.todooz.domain.Task;
import fr.todooz.util.TagCloud;

@Service
public class TagCloudServiceImpl implements TagCloudService {

		@Inject
		private TaskService taskService;
	
	   public TagCloud buildTagCloud(){
		  TagCloud myTagCloud = new TagCloud();
		  
		  List<Task> maliste = taskService.findAll();
		  
		  for (Task t : maliste){
			  String[] tags = StringUtils.split(t.getTags(), ",");
			  myTagCloud.add(tags);
			
		  }
		  
		  return myTagCloud;
	   }
	   
	  
}
