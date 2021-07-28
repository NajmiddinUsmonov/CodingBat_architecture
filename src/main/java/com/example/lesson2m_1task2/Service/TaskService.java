package com.example.lesson2m_1task2.Service;

import com.example.lesson2m_1task2.Repository.ChapterRepository;
import com.example.lesson2m_1task2.Repository.HintRepository;
import com.example.lesson2m_1task2.Repository.TaskRepository;
import com.example.lesson2m_1task2.entity.Hint;
import com.example.lesson2m_1task2.entity.Task;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.HintDto;
import com.example.lesson2m_1task2.payload.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ChapterRepository chapterRepository;

    @Autowired
    HintRepository hintRepository;

    public ApiResponse add(TaskDto taskDto){
        boolean chapter = chapterRepository.existsById(taskDto.getChapterId());
        if (!chapter)
            return new ApiResponse("Chapter not found",false);

        Task task=new Task();
        if (taskDto.getHintId()!=null){
            boolean hint = hintRepository.existsById(taskDto.getHintId());
            if (!hint){
                return new ApiResponse("Hint not found",false);
            }
            task.setHint(hintRepository.getById(taskDto.getHintId()));
        }

        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setChapter(chapterRepository.getById(taskDto.getChapterId()));
        taskRepository.save(task);
        return new ApiResponse("Added",true);
    }

    public ApiResponse get(Integer id){
        boolean exists = taskRepository.existsById(id);
        if (!exists)
            return new ApiResponse("Task not found",false);

        Task task = taskRepository.getById(id);
        return new ApiResponse("Done!",true,task);
    }

    public ApiResponse edit(TaskDto taskDto,Integer id){
        boolean exists = taskRepository.existsById(id);
        boolean chapter = chapterRepository.existsById(taskDto.getChapterId());
        if (!exists)
            return new ApiResponse("Task not found",false);

        if (!chapter)
            return new ApiResponse("Chapter not found",false);

        Task task = taskRepository.getById(id);

         if (taskDto.getHintId()!=null){

            boolean hint = hintRepository.existsById(taskDto.getHintId());
            if (!hint){
                return new ApiResponse("Hint not found",false);
            }
            task.setHint(hintRepository.getById(taskDto.getHintId()));
        }

        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setChapter(chapterRepository.getById(taskDto.getChapterId()));
        taskRepository.save(task);

        return new ApiResponse("Edit!",true);
    }

    public ApiResponse delete(Integer id){
        boolean exists = taskRepository.existsById(id);
        if (!exists)
            return new ApiResponse("Task not found",false);
        taskRepository.deleteById(id);
        return new ApiResponse("Delete!",true);
    }
}
