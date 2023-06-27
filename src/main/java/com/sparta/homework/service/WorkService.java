package com.sparta.homework.service;

import com.sparta.homework.dto.WorkRequestDto;
import com.sparta.homework.dto.WorkResponseDto;
import com.sparta.homework.entity.Work;
import com.sparta.homework.repository.WorkRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class WorkService {
    private final WorkRepository workRepository;

    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }
    public WorkResponseDto creatework(WorkRequestDto workRequestDto) {
        Work work= new Work(workRequestDto);
        Work savework= workRepository.save(work);
        WorkResponseDto workResponseDto=new WorkResponseDto(savework);
        return workResponseDto;
    }

    public List<WorkResponseDto> getworks() {
        return workRepository.findAll();
    }

    public String updateWork(Long id, WorkRequestDto requestDto,String pw) {
        return workRepository.update(id,requestDto,pw);
    }

    public String delete(Long id,String pw) {
        return workRepository.delete(id,pw);
    }

    public Work find(Long id) {
        return workRepository.find(id);
    }
}
