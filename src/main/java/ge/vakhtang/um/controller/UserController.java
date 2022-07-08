package ge.vakhtang.um.controller;


import ge.vakhtang.um.model.dto.UserDTO;
import ge.vakhtang.um.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/register")
    public void register(@RequestBody UserDTO userDTO) {
        userService.performUserRegistration(userDTO);
    }

    @PostMapping("/authenticate")
    public void authenticate(@RequestBody UserDTO userDTO) {
        userService.performUserRegistration(userDTO);
    }


}
