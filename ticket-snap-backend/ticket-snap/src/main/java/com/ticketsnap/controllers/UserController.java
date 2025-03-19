package com.ticketsnap.controllers;


import com.ticketsnap.dtos.RegisterUserRequestDto;
import com.ticketsnap.dtos.RegisterUserResponseDto;
import com.ticketsnap.models.User;
import com.ticketsnap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody User getUser(@PathVariable("userId") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody RegisterUserResponseDto registerUser(@RequestBody RegisterUserRequestDto request) {
        User user = userService.registerUser(request.getName(), request.getEmail(), request.getPassword(), "ROLE_USER");
        return new RegisterUserResponseDto(user.getId());
    }
}
