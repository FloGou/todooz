package fr.todooz.service;

import java.util.List;

import org.joda.time.Interval;

import fr.todooz.domain.Task;

public interface TaskService {

	public void save(Task task);

	public void delete(Long id);

	public List<Task> findAll();

	public List<Task> findByQuery(String query);
	
	public List<Task> findByTag(String query);
	
	public List<Task> findByDay(Interval inter);

	public int count();

	public Task findById(Long id);

}