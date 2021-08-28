package net.movingjin.api.security.config;

import lombok.RequiredArgsConstructor;
import net.movingjin.api.security.domain.SecurityProvider;
import net.movingjin.api.security.filter.SecurityFilter;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//내부적인 보안설정
@RequiredArgsConstructor
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final SecurityProvider provider;

    @Override
    public void configure(HttpSecurity builder) throws Exception{
        SecurityFilter filter = new SecurityFilter(provider);
        builder.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
