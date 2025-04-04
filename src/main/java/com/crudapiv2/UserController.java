package com.crudapiv2;

import com.crudapiv2.dto.UserRequestDTO;
import com.crudapiv2.dto.UserResponseDTO;
import com.crudapiv2.dto.UserUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    // declaration
    private final UserService userService;

    // constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  // Response output 201.
    public UserResponseDTO createUser(@RequestBody UserRequestDTO dto) {
        return userService.createUser(dto);
    }

    @PatchMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO dto) {
        return userService.updateUser(id, dto);
    }


}
