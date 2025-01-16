package com.embarkx.firstjobapp.job.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.job.JobRepository;
import com.embarkx.firstjobapp.job.JobService;

@Service
public class JobServiceImpl implements JobService {
	
	
	private JobRepository jobRepository;
	
	
	public JobServiceImpl(JobRepository jobRepository)
	{
		this.jobRepository = jobRepository;
	}
	

	@Override
	public List<Job> findAll() {
		
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
	
		jobRepository.save(job);
		
		return;
		
	}
	
	public Job findById(Long id) throws NoSuchElementException
	{
		return jobRepository.findById(id).orElseThrow();
	}

	@Override
	public boolean deleteById(Long id) {
		
		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}	
		
	}
	
	@Override
	public boolean updateById(Long id, Job updatedJob) {
		
		Optional<Job> jobOptional = jobRepository.findById(id);
		
		if(jobOptional.isPresent())
		{
			Job job = jobOptional.get();
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getTitle());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setLocation(updatedJob.getLocation());
			
			jobRepository.saveAndFlush(job);
			
			return true;
		}
		else {
			
			return false;
		}
	}
	
	

}
