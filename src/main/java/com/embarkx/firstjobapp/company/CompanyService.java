 package com.embarkx.firstjobapp.company;

import java.util.List;

public interface CompanyService {

	List<Company> getAllCompanies();
	
	Company createCompany(Company company);
	
	boolean deleteCompanyById(Long id);
	
	Company updateCompanyById(Long id, Company update);
	
	Company getCompanyById(Long id);
}
