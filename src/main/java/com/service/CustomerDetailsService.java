//package com.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.model.CustomerDetail;
//import com.model.User;
//import com.repository.UserRepository;
//
//@Service
//public class CustomerDetailsService implements UserDetailsService {
//	
//	@Autowired
//	UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Optional<User> user = userRepository.findUserByEmail(email);
//		user.orElseThrow(()-> new UsernameNotFoundException("user is not found."));
//		return user.map(CustomerDetail::new).get();
//	}
//
//}
