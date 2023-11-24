//package com.model;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotEmpty;
//
//public class CustomerDetail extends User implements UserDetails{
//	
//	private static final long serialVersionUID =1L;
//
//	public CustomerDetail(int id, @NotEmpty String firstName, String lastName,
//			@NotEmpty @Email(message = "{errors.invalid_email}") String email, String password, List<Role> roles) {
//		super(id, firstName, lastName, email, password, roles);
//		// TODO Auto-generated constructor stub
//	}
//	
////	public CustomerDetail(@NotEmpty String firstName, String lastName,
////			@NotEmpty @Email(message = "{errors.invalid_email}") String email, @NotEmpty String password,
////			List<Role> roles) {
////		super(firstName, lastName, email, password, roles);
////		// TODO Auto-generated constructor stub
////	}
//
//	public CustomerDetail(User user) {
//		super(user);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> authorityList = new ArrayList<>();
//		super.getRoles().forEach(role -> {
//			authorityList.add(new SimpleGrantedAuthority(role.getName()));
//		}
//		 );
//		return authorityList;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return super.getEmail();
//	}
//	
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return super.getPassword();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
//	
//}
