package ge.vakhtang.um.service.impl;

import ge.vakhtang.um.entity.UserEntity;
import ge.vakhtang.um.model.dto.UserDTO;
import ge.vakhtang.um.repository.UserEntityRepository;
import ge.vakhtang.um.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserEntityRepository userEntityRepository, PasswordEncoder passwordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void performUserRegistration(UserDTO userDTO) {
        if (!userDTO.getPassword().equals(userDTO.getMatchingPassword())) return;
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setFirstname(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntityRepository.saveAndFlush(userEntity);

        //TODO return jwt
    }

    @Override
    public void performUserLogin(UserDTO userDTO) {
        //TODO login
    }
}
