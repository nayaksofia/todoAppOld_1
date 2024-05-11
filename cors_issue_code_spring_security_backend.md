package com.in28minutes.rest.webservices.restfulwebservices.basic.auth;


public class AuthenticationBean {

	private String message;

	public AuthenticationBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]", message);
	}

}
	


------


package com.in28minutes.rest.webservices.restfulwebservices.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController {

	@GetMapping(path = "/basicauth")
	public AuthenticationBean helloWorldBean() {
		//throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
		return new AuthenticationBean("You are authenticated");
	}	
}

/*Remember:
 * We can replace RequestMapping() method with respective request like 
 * @GetMapping() , @PostMapping() etc. 
 * 
 */
----------------------------------------------------------------------

package com.in28minutes.rest.webservices.restfulwebservices.basic.auth;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfigurationBasicAuth {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll());

		http.csrf(csrf -> csrf.disable());

		http.httpBasic(withDefaults());

		return http.build();
	}

}

----------------------------

package com.in28minutes.rest.webservices.restfulwebservices.basic.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods(HttpMethod.GET.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name())
                .allowedHeaders(HttpHeaders.CONTENT_TYPE,
                        HttpHeaders.AUTHORIZATION);
    }









//Way-2 For CORS ISSUE To Resolve: Global Configuration ; Replacing @CrossOrigin(origins="http://localhost:4200")
//@Configuration
//public class WebConfig{
//
//	@Bean
//	public WebMvcConfigurer corsConfig() {
//		return new WebMvcConfigurer() {
//			
//			@Override
//		    public void addCorsMappings(CorsRegistry registry) {
//		        registry.addMapping("/**")
//		        .allowedOrigins("http://localhost.4200")
//		        .allowedMethods(HttpMethod.GET.name(),
//		        		HttpMethod.POST.name(),
//		        		HttpMethod.PUT.name(),
//		        		HttpMethod.DELETE.name())
//		        .allowedHeaders(HttpHeaders.CONTENT_TYPE,
//		        		HttpHeaders.AUTHORIZATION);
//			
//		}
//	};
//    
//   }
    
}

