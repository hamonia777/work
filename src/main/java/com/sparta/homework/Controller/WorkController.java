package com.sparta.homework.Controller;

import com.sparta.homework.dto.WorkRequestDto;
import com.sparta.homework.dto.WorkResponseDto;
import com.sparta.homework.entity.Work;
import com.sparta.homework.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WorkController {
    private final WorkService workService;
    public WorkController(WorkService workService){
        this.workService=workService;
    }
    private final Map<Long, Work> memoList = new HashMap<>();

    @PostMapping("/api/works")
    public WorkResponseDto creatework(@RequestBody WorkRequestDto workRequestDto){
        return workService.creatework(workRequestDto);
    }
    @GetMapping("/api/works/{id}")
    public Work find(@PathVariable Long id){
        return workService.find(id);
    }
    @GetMapping("/api/works")
    public List<WorkResponseDto> getworks() {
        // Map To List
        return workService.getworks();
    }

    @PutMapping("/api/works/{id}/{pw}")
    public String updateWork(@PathVariable Long id, @RequestBody WorkRequestDto requestDto,@PathVariable String pw) {
        // 해당 메모가 DB에 존재하는지 확인
        return workService.updateWork(id,requestDto,pw);
    }

    @DeleteMapping("/api/works/{id}/{pw}")
    //{id}/{password}
    public String deleteMemo(@PathVariable Long id,@PathVariable String pw) {

        return workService.delete(id,pw);
    }
}
