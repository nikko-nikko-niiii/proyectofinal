package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.apiDevelopment.grupo2.proyectoFinal.model.Admin;
import io.apiDevelopment.grupo2.proyectoFinal.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin getAdminByUsername(Admin admin) {
		Optional<Admin> adminFound = adminRepository.findByUsername(admin.getUsername());
		if(adminFound.isEmpty()) {
			// throw UserNotFound
			return null;
		}
		
		if(!admin.getPassword().equals(adminFound.get().getPassword())) {
			// throw PasswordNotMatch
			return null;
		}
		
		return adminFound.get();
	}

}
