import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
// authentication manager 
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
// http builder configurations for authorize requests and form login 
    }
}

// Authentication Manager --> Here the Users are Hardcoded, not logical for production ANYWHERE!!!
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
	        .and()
	        .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
	        .and()
	        .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
// Restricting /admin to ADMIN roles and securing --> This will have to scale
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
	    http
	      // ...
	      .and()
	      .formLogin()
	      .loginPage("/login.html") // The custom login page
	      .loginProcessingUrl("/perform_login") // Location URl to submit the userName and password 
	      .defaultSuccessUrl("/homepage.html", true) // Pass login landing page
	      .failureUrl("/login.html?error=true") // Fail login landing page --> How many tries before lockout?
	      .failureHandler(authenticationFailureHandler())
	      .and()
	      .logout() // Custom logout page
	      .logoutUrl("/perform_logout")
	      .deleteCookies("JSESSIONID")
	      .logoutSuccessHandler(logoutSuccessHandler());
	}
	
	
//One reason to override most of the defaults in Spring 
// Security is to hide the fact that the application is secured 
// Spring Security and minimize the information 
// a potential attacker knows about the application.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.formLogin()
	      .loginPage("/login.html")
	      .loginProcessingUrl("/perform_login")
	      .defaultSuccessUrl("/homepage.html",true)
	      .failureUrl("/login.html?error=true")
	}

	
}
