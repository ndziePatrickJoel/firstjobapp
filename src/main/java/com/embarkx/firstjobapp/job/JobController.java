package com.embarkx.firstjobapp.job;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	
	@Autowired
	private JobService jobService;
	

	@GetMapping
	public ResponseEntity<List<Job>> findAll()
	{
		return ResponseEntity.ok(jobService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job)
	{
		jobService.createJob(job);
		
		return ResponseEntity.ok("job created");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id)
	{
		Job job;
		
		try {
			job = jobService.findById(id);
			return new ResponseEntity<>(job, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id)
	{
		jobService.deleteById(id);
		
		return new ResponseEntity<String>("Item deleted", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job)
	{
		boolean response = jobService.updateById(id, job);
		
		if(!response)
		{
			return new ResponseEntity<String>("Unable to update item", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("Item updated", HttpStatus.OK);
			
	}
	
	
}
