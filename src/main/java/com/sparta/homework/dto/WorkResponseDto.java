package com.sparta.homework.dto;

import com.sparta.homework.entity.Work;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Getter
public class WorkResponseDto {
    private Long id;

    String name;
    String contents;
    String createAt;
    public WorkResponseDto(Work savework) {
        this.id= savework.getId();
        this.name=savework.getName();
        this.contents=savework.getContents();
        this.createAt= savework.getCreateAt();
    }
}
