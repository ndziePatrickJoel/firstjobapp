package com.embarkx.firstjobapp.job;

import java.util.List;
import java.util.NoSuchElementException;

public interface JobService {
	
	List<Job> findAll();
	
	void createJob(Job job);
	
	Job findById(Long id) throws NoSuchElementException;
	
	boolean deleteById(Long id);
	
	boolean updateById(Long id, Job updatedJob);

}
