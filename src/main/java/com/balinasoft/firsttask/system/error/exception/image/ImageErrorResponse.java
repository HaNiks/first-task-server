package com.balinasoft.firsttask.system.error.exception.image;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ImageErrorResponse {

    private String message;
    private LocalDateTime time;
}
