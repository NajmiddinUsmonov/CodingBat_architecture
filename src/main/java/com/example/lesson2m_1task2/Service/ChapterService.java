package com.example.lesson2m_1task2.Service;

import com.example.lesson2m_1task2.Repository.ChapterRepository;
import com.example.lesson2m_1task2.Repository.LanguageRepository;
import com.example.lesson2m_1task2.entity.Chapter;
import com.example.lesson2m_1task2.entity.Language;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.ChapterDto;
import com.example.lesson2m_1task2.payload.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ChapterService {

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    ChapterRepository chapterRepository;

    public ApiResponse add(ChapterDto chapterDto){
        boolean exists = languageRepository.existsById(chapterDto.getLanguageId());
        if (!exists){
            return new ApiResponse("Language not found",false);
        }
        Chapter chapter=new Chapter();
        chapter.setName(chapterDto.getName());
        chapter.setDescription(chapterDto.getDescription());
        chapter.setLanguage(languageRepository.getById(chapterDto.getLanguageId()));
        chapterRepository.save(chapter);
        return new ApiResponse("Added",true);
    }
    public ApiResponse get(Integer id){
        boolean exists = chapterRepository.existsById(id);
        if (exists){
            Chapter chapter = chapterRepository.getById(id);
            return new ApiResponse("Done",true,chapter);
        }
        return new ApiResponse("Language not found",false);
    }

    public ApiResponse edit(ChapterDto chapterDto,Integer id){
        boolean exists = chapterRepository.existsById(id);
        if (!exists){
            return new ApiResponse("Chapter not found",false);
        }
        Chapter chapter = chapterRepository.getById(id);
        chapter.setName(chapterDto.getName());
        chapter.setDescription(chapterDto.getDescription());
        chapter.setLanguage(languageRepository.getById(chapterDto.getLanguageId()));
        chapterRepository.save(chapter);
        return new ApiResponse("Edit",true);
    }

    public ApiResponse delete(Integer id){
        boolean exists = chapterRepository.existsById(id);
        if (exists) {
            chapterRepository.deleteById(id);
            return new ApiResponse("Delete",true);
        }
        return new ApiResponse("Language not found",false);
    }
}
