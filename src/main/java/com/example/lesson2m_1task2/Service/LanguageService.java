package com.example.lesson2m_1task2.Service;


import com.example.lesson2m_1task2.Repository.LanguageRepository;
import com.example.lesson2m_1task2.Repository.UserRepository;
import com.example.lesson2m_1task2.entity.Language;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    UserRepository userRepository;

    public ApiResponse add(LanguageDto languageDto){

        Language language=new Language();
        language.setName(languageDto.getName());
        languageRepository.save(language);
        return new ApiResponse("Added",true);
    }
    public ApiResponse get(Integer id){
        boolean exists = languageRepository.existsById(id);
        if (exists){
            Language language = languageRepository.getById(id);
            return new ApiResponse("Done",true,language);
        }
        return new ApiResponse("Language not found",false);
    }

    public ApiResponse edit(LanguageDto languageDto,Integer id){
        boolean exists = languageRepository.existsById(id);
        if (!exists){
            return new ApiResponse("Language not found",false);
        }

        Language language = languageRepository.getById(id);
        language.setName(languageDto.getName());
        return new ApiResponse("Edit",true);
    }

    public ApiResponse delete(Integer id){
        boolean exists = languageRepository.existsById(id);
        if (exists) {
            languageRepository.deleteById(id);
            return new ApiResponse("Delete",true);
        }
        return new ApiResponse("Language not found",false);
    }
}
