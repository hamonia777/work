package com.sparta.homework.repository;

import com.sparta.homework.dto.WorkRequestDto;
import com.sparta.homework.dto.WorkResponseDto;
import com.sparta.homework.entity.Work;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Component
public class WorkRepository {
    private final Map<Long, Work> workList = new HashMap<>();
    public Work save(Work work) {
        Long maxId = workList.size() > 0 ? Collections.max(workList.keySet()) + 1 : 1;
        work.setId(maxId);
        workList.put(maxId, work);
        work.datesetter();
        return work;
    }

    public List<WorkResponseDto> findAll() {

        // Map To List
        List<WorkResponseDto> responseList = workList.values().stream()
                .map(WorkResponseDto::new).toList();

        return responseList;
    }

    public String update(Long id, WorkRequestDto requestDto,String pw) {
        if(workList.containsKey(id)) {

            Work work = workList.get(id);
            if(pw.equals(work.getPassword())) {
                work.update(requestDto);
                String answer="값이 변경 되었습니다";
                return answer;
            }
            else{
                String answer="비밀 번호가 틀렸습니다";
                return answer;
            }
        }
        else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }

    }

    public String delete(Long id,String pw) {
        if(workList.containsKey(id)) {
            // 해당 메모 삭제하기
            Work work = workList.get(id);
            if(pw.equals(work.getPassword())) {
                workList.remove(id);
                String answer="삭제 되었습니다";
                return answer;
            }
            else{
                String answer="비밀 번호가 일치하지않습니다";
                return answer;
            }
        }
        else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }

    }

    public Work find(Long id) {
        Work work = workList.get(id);
        return work;
    }
}
