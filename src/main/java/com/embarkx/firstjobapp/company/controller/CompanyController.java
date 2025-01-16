package com.embarkx.firstjobapp.company.controller;

import java.util.List;

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
import com.embarkx.firstjobapp.company.Company;
import com.embarkx.firstjobapp.company.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	
	private CompanyService companyService;
	
	
	public CompanyController(CompanyService companyService)
	{
		this.companyService = companyService;
	}

	
	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies()
	{
		return ResponseEntity.ok(this.companyService.getAllCompanies());
	}
	
	@PostMapping
	public ResponseEntity<Company> createCompany(@RequestBody Company company)
	{		
		return ResponseEntity.ok(this.companyService.createCompany(company));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCompanyById(@PathVariable Long id)
	{
		Company company = this.companyService.getCompanyById(id);
		
		if(company != null)
		{
			return ResponseEntity.ok(company);
		}
		
		return new ResponseEntity<String>("Item not found", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id)
	{
		boolean result = this.companyService.deleteCompanyById(id);
		
		if(result)
		{
			return ResponseEntity.ok("Item successfully deleted");
		}
		
		return new ResponseEntity<String>("Item not deleted", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company)
	{
		Company result = this.companyService.updateCompanyById(id, company);
		return ResponseEntity.ok(result);
	}
	
}
