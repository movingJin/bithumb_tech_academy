package net.movingjin.api.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.movingjin.api.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private final long actorId;
    private final String username;
    private final String email;
    private final String name;
    @JsonIgnore
    private final String password;  //실제값이 아닌, 암호화된 Token으로 전달받음.
    private final Collection<? extends GrantedAuthority> authorities;   //password와 authorities은 UserDetails가 관리

    public static UserDetailsImpl build(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getName(),
                user.getPassword(), authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
