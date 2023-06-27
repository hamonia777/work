package com.sparta.homework.entity;

import com.sparta.homework.dto.WorkRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;
    String contents;
    String password;
    Date now = new Date();

    String createAt;

    public Work(WorkRequestDto workRequestDto) {
        this.name=workRequestDto.getName();
        this.contents=workRequestDto.getContents();
        this.password=workRequestDto.getPassword();
        this.createAt=workRequestDto.getCreateAt();
    }
    public void datesetter(){
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
        this.createAt= formatter.format(now);
    }
    public void update(WorkRequestDto requestDto) {
        this.name=requestDto.getName();
        this.contents=requestDto.getContents();
    }
}
