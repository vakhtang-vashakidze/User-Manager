package ge.vakhtang.um.service.impl;

import ge.vakhtang.um.entity.UserEntity;
import ge.vakhtang.um.repository.UserEntityRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    public UserDetailsServiceImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userEntityRepository.getUserEntityByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        return User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities("USER")
                .disabled(false).build();
    }


}
