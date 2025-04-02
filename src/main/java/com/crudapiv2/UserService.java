package com.crudapiv2;

import com.crudapiv2.dto.UserRequestDTO;
import com.crudapiv2.dto.UserResponseDTO;
import org.springframework.stereotype.Service;
import com.crudapiv2.UserRepository;

@Service
public class UserService {
    // creating an object that will act as a gateway to the db.
    // basically saying, "this userService depends on userRepository to function".
    private final UserRepository userRepository;

    // constructor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // convert entity -> to dto mapper.
    // receive a user, and return a dto
    private UserResponseDTO mapToResponseDTO(User user) {
        return new UserResponseDTO(
                user.getUsername(),
                user.getEmail(),
                user.getFirstname(),
                user.getLastname());
    }

    // convert dto -> entity
    // receive dto object, and return a user.
    private User mapToNewEntity(UserRequestDTO dto) {
        return new User(
                dto.getUsername(),
                dto.getFirstname(),
                dto.getLastname(),
                dto.getEmail(),
                dto.getPassword()
                );
    }

    // create user
    private UserResponseDTO createUser(UserRequestDTO dto) {
        User user = mapToNewEntity(dto); // mapping dto to new entity
        User savedUser = userRepository.save(user); // saving the new entity in database
        return mapToResponseDTO(savedUser); // mapping new entity back to dto
    }

    // find user by id

    // return all users

    // update username

    // update user email

    // update first name

    // update last name

    // soft delete down the line.

}
