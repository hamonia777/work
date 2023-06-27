package com.sparta.homework.dto;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Getter
public class WorkRequestDto {
    private Long id;

    String name;
    String contents;
    String password;
    String createAt;
}
