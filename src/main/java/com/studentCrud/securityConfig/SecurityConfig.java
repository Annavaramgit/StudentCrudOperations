//package com.studentCrud.securityConfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import static org.springframework.security.config.Customizer.withDefaults;
//
////for customized spring security instead of default security we here write the code 
//
//@Configuration
//@EnableMethodSecurity
//public class SecurityConfig 
//{
////this PasswordEncoder-->the AuthenicationProvider uses PasswordEncoder and UserDetailsService to authenticate
//	@Bean
//	public PasswordEncoder pwdEncoder() {
//		return new BCryptPasswordEncoder();
//		
//	}
//
//	
////this UserDetailsService-->the AuthenicationProvider uses PasswordEncoder and UserDetailsService to authenticate	
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails adminUser  = User.withUsername("admin")
//				.password(pwdEncoder().encode("admin"))
//				.roles("ADMIN")
//				.build();
//		
//		
//		UserDetails userUser  = User.withUsername("user")
//				.password(pwdEncoder().encode("user"))
//				.roles("USER")
//				.build();
//		
//		
//		return new InMemoryUserDetailsManager(userUser,adminUser);
//				
//		
//	}
//	
//	
//	
//	
//	
////1. first this practiced	
////this code is all the url's are authenticate means all the url's requests are asks username and password
//	/*
//	@Bean
//    SecurityFilterChain  securityFilterChain(HttpSecurity http)throws Exception
//	{
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//	 
//	return  http.build();
//    }
//	*/
//
////2. second this practiced	
////this code is only save and getSpecific/** url only authenticate means those url request asks username and pwd
////	/*
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception {
//
//        httpSecurity.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/save")
//                        .authenticated()
//                        .requestMatchers("/getSpecific/**")
//                        .authenticated()
//                        .anyRequest()
//                        .permitAll())
//                .formLogin(withDefaults())
//                .httpBasic(withDefaults());
//		
//		
//         return httpSecurity.build();
//	}
//	//*/
//	
//	
////3. THIRD this practiced	
////this code is regarding role based giving access
////here ADMNIN only can save && and user can only see getSpecific/** 
////the remaining url's any one can access
//	
////NOTE= we can also use annotation instead of hasRole using like below 
//		//for that comment this  .hasRole("ADMIN"), .hasRole("USER") add authenticated() like above commented code(sec practiced)   or comment this whole code and uncomment 2nd practiced code
//		//add @EnableMethodSecurity annotation at this class SecurityConfig cls
//		//and in the conteroller class ,add  @PreAuthorize("hasRole('USER')"),@PreAuthorize("hasRole('ADMIN')")
//		// at top of whcih methods you want make them access controll
//	/*
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception {
//
//        httpSecurity.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/save")
//                        .hasRole("ADMIN")
//                        .requestMatchers("/getSpecific/**")
//                        .hasRole("USER")
//                        .anyRequest()
//                        .permitAll())
//                .formLogin(withDefaults())
//                .httpBasic(withDefaults());
//		
//		
//         return httpSecurity.build();
//	}
//	
//	*/
//	
//	
//}
//		
//
//
