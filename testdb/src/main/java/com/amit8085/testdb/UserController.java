package com.amit8085.testdb;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;
    public UserController(UserService service){
        this.service=service;
    }
    //CREATE REQUEST
    @PostMapping()
    public ApiResponse<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto){
        return new ApiResponse<>(
                "Success",
                "User Created",
                service.save(dto)
        );
    }
    //READ REQUEST
    @GetMapping
    public ApiResponse<List<UserResponseDTO>> getAllUser(){
        return new ApiResponse<>(
                "Success",
                "User fetched",
                service.getAll()
        );
    }
    //UPDATE REQUEST
    @PutMapping("/{id}")
    public ApiResponse<UserResponseDTO> updateUser(@PathVariable Long id,@Valid @RequestBody UserRequestDTO dto){
        return new ApiResponse<>(
                "Success",
                "UserUpdated",
                service.update(id,dto)
        );
    }
    //DELETE REQUEST
    @DeleteMapping("/{id}")
    public ApiResponse<UserResponseDTO> deleteUser(@PathVariable Long id){
       service.delete(id);
        return new ApiResponse<>(
                "succes",
                "User Deleted",
                null
        );
    }
    //GET BY ID
    @GetMapping("/{id}")
    public ApiResponse<UserResponseDTO> getById(@Valid @PathVariable Long id){
        return new ApiResponse<>(
                "Success",
                "Fetched by id",
                service.getById(id)
        );
    }
    @GetMapping("/search")
    public ApiResponse<UserResponseDTO> getByNameAndAge(@RequestParam String name,@RequestParam int age){
        return new ApiResponse<>(
                "Success",
                "Fetched by name and age",
                service.getByNameAndAge(name,age)
        );
    }
}
