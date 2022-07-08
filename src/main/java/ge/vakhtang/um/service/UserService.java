package ge.vakhtang.um.service;

import ge.vakhtang.um.model.dto.UserDTO;

public interface UserService {

    void performUserRegistration(UserDTO userDTO);

    void performUserLogin(UserDTO userDTO);
}
