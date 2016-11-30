package org.elevenfifty.shoppinglist;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().anyRequest().permitAll();

		// .and()
		// .csrf().disable()
		// .headers().frameOptions().disable();
	}

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).rolePrefix("").passwordEncoder(new PlaintextPasswordEncoder())
				.usersByUsernameQuery(
						"select email as username, password, active as enabled from shopping_list.users where username = ?")
				.authoritiesByUsernameQuery(
						"select u.email as username, ur.role as authority from shopping_list.users u inner join shopping_list.user_roles ur on (u.id = ur.user_id) where u.email = ?");
	}

}
