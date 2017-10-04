package com.onlineshopping.sample.OnlineShopping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
List<Task> l=new ArrayList<>(Arrays.asList(new Task(100,"welcome",true)));

List getTasks(){
	return l;
}
String addTask(int val,String msg){
	new Task(val,msg,false);
	return "success";
}
public Task save(Task task) {
	l.add(task);
	return task;
}

	}
