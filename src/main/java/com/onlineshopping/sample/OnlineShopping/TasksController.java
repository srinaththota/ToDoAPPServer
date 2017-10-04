package com.onlineshopping.sample.OnlineShopping;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;


@RestController
public class TasksController {
	
	final static Logger logger = Logger.getLogger(TasksController.class);
	
	@Autowired
TaskService taskService;
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/home",method= RequestMethod.GET, headers="Accept=application/json")
public @ResponseBody	List allTasks(){
		
		return new TaskService().getTasks();
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Task>> getTask() {
		List<Task> tasks = taskService.getTasks();
		if (tasks.isEmpty()) {
			logger.debug("Tasks does not exists");
			return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + tasks.size() + " Tasks");
		logger.debug(tasks);
		logger.debug(Arrays.toString(tasks.toArray()));
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST , value="/task")
	  public Task create(@RequestBody String task) throws JsonParseException, JsonMappingException, IOException{
		
		//----------

	
            ObjectMapper objectMapper = new ObjectMapper();
            Task tsk = (Task) objectMapper.readValue(task, Task.class);
            return taskService.save(tsk);
            
        
		
		
		
		
	    
	  }
}

