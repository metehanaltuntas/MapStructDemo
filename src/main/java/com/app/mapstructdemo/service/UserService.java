package com.app.mapstructdemo.service;

import com.app.mapstructdemo.dto.UserDTO;
import com.app.mapstructdemo.entity.User;
import com.app.mapstructdemo.mapper.UserMapper;
import com.app.mapstructdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    UserRepository userRepository;

    UserMapper userMapper;


    public User saveUser(UserDTO userDTO) {
        return userRepository.save(userMapper.toEntity(userDTO));
    }

    public UserDTO getUserById(Long id) {

        return userRepository.findById(id)
                .map(userMapper::toDTO )
                .orElse(new UserDTO());
    }

    public List<UserDTO> getUserList() {
        return  userMapper.toDTOList(userRepository.findAll());
    }

}