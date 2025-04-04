package com.crudapiv2;

import com.crudapiv2.dto.UserRequestDTO;
import com.crudapiv2.dto.UserResponseDTO;
import com.crudapiv2.dto.UserUpdateDTO;
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
                user.getLastname()); // moved from line 24 to 26 because of mapping issue.
    }

    // convert dto -> entity
    // receive dto object, and return a user.
    private User mapToNewEntity(UserRequestDTO dto) {
        return new User(
                dto.getUsername(),
                dto.getEmail(),
                dto.getFirstname(),
                dto.getLastname(),
                dto.getPassword()
                );
    }

    // create user
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = mapToNewEntity(dto); // mapping dto to new entity
        User savedUser = userRepository.save(user); // saving the new entity in database
        return mapToResponseDTO(savedUser); // mapping new entity back to dto
    }

    // connecting to userUpdateDTO
    public UserResponseDTO updateUser(Long id, UserUpdateDTO dto) {
        User user = findUserById(id);

        // check nulls for username, email, firstname, lastname
        if (dto.getUsername() != null) {
            user.setUsername(dto.getUsername());
        }

        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }

        if (dto.getFirstname() != null) {
            user.setFirstname(dto.getFirstname());
        }

        if (dto.getLastname() != null) {
            user.setLastname(dto.getLastname());
        }

        user = userRepository.save(user);

        return mapToResponseDTO(user);
    }

    // find user by id
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    // return all users
    public UserResponseDTO getUserById(Long id) {
        User user = findUserById(id);
        return mapToResponseDTO(user);
    }

    // update username

    // update user email

    // update first name

    // update last name

    // soft delete down the line.

}
