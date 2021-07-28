package com.example.lesson2m_1task2.Service;


import com.example.lesson2m_1task2.Repository.UserRepository;
import com.example.lesson2m_1task2.entity.User;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ApiResponse add(UserDto userDto){
        boolean exists = userRepository.existsByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        boolean exists1 = userRepository.existsByEmail(userDto.getEmail());
        if (exists1){
            return new ApiResponse("Email already exist",false);
        }
        if (exists){
            return new ApiResponse("User already exist",false);
        }

        User user=new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return new ApiResponse("Added",true);
    }
    public ApiResponse get(Integer id){
        boolean exists = userRepository.existsById(id);
        if (exists){
            User user = userRepository.getById(id);
            return new ApiResponse("Done",true,user);
        }
        return new ApiResponse("User not found",false);
    }

    public ApiResponse edit(UserDto userDto,Integer id){
        boolean exists1 = userRepository.existsByEmailAndIdNot(userDto.getEmail(), id);
        boolean exists = userRepository.existsById(id);
        if (!exists){
            return new ApiResponse("User not found",false);
        }
        if (exists1){
            return new ApiResponse("Email already exist",false);
        }
        User user = userRepository.getById(id);
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
        return new ApiResponse("Edit",true);
    }

    public ApiResponse delete(Integer id){
        boolean exists = userRepository.existsById(id);
        if (exists) {
            userRepository.deleteById(id);
            return new ApiResponse("Delete",true);
        }
        return new ApiResponse("User not found",false);
    }
}
