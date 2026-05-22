package com.amit8085.testdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepositary repo;
    public UserService(UserRepositary repo){
        this.repo=repo;
    }
    //CREATE
    public UserResponseDTO save(UserRequestDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        User saved =repo.save(user);
        return new UserResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getAge()
        );
    }
    //READ
    public List<UserResponseDTO> getAll(){
        return repo.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getAge()
                ))
                .toList();

    }
    //UPDATE
    public UserResponseDTO update(Long id,UserRequestDTO dto){
        User user=repo.findById(id).orElseThrow(()->new RuntimeException("User not Found.."));
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        User updated =repo.save(user);
        return new UserResponseDTO(
                updated.getId(),
                updated.getName(),
                updated.getAge()
        );
    }
    //DELETE
    public void delete(Long id){
        repo.deleteById(id);
    }

}
