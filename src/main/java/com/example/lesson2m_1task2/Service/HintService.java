package com.example.lesson2m_1task2.Service;


import com.example.lesson2m_1task2.Repository.HintRepository;
import com.example.lesson2m_1task2.entity.Hint;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.HintDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HintService {

    @Autowired
    HintRepository hintRepository;

    public ApiResponse add(HintDto hintDto){
        Hint hint=new Hint();
        hint.setHint_content(hintDto.getHint_content());
        hintRepository.save(hint);
        return new ApiResponse("Added",true);
    }

    public ApiResponse get(Integer id){
        boolean exists = hintRepository.existsById(id);
        if (!exists)
            return new ApiResponse("Hint not found",false);

        Hint hint = hintRepository.getById(id);
        return new ApiResponse("Done!",true,hint);
    }
    public ApiResponse edit(HintDto hintDto,Integer id){
        boolean exists = hintRepository.existsById(id);
        if (!exists)
            return new ApiResponse("Hint not found",false);
        Hint hint = hintRepository.getById(id);
        hint.setHint_content(hintDto.getHint_content());
        hintRepository.save(hint);

        return new ApiResponse("Edit!",true);
    }

    public ApiResponse delete(Integer id){
        boolean exists = hintRepository.existsById(id);
        if (!exists)
            return new ApiResponse("Hint not found",false);
        hintRepository.deleteById(id);
        return new ApiResponse("Delete!",true);
    }

}
