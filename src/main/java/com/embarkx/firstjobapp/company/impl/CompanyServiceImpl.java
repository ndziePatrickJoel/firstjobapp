package com.embarkx.firstjobapp.company.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.embarkx.firstjobapp.company.Company;
import com.embarkx.firstjobapp.company.CompanyRepository;
import com.embarkx.firstjobapp.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyRepository companyRepository;
	
	public CompanyServiceImpl(CompanyRepository companyRepository)
	{
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		
		return this.companyRepository.findAll();
	}

	@Override
	public Company createCompany(Company company) {
		
		return this.companyRepository.save(company);
		
	}

	@Override
	public boolean deleteCompanyById(Long id) {
		
		try {
			this.companyRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}

	@Override
	public Company updateCompanyById(Long id, Company update) throws NoSuchElementException {
		
		Company company = this.companyRepository.findById(id).orElseThrow();
	
		company.setDescription(update.getDescription());
		company.setName(update.getName());
		company.setJobs(update.getJobs());
			
		this.companyRepository.save(company);
			
		return company;
		
	}

	@Override
	public Company getCompanyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
