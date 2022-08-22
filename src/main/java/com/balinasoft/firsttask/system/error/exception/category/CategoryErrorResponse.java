package com.balinasoft.firsttask.system.error.exception.category;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class CategoryErrorResponse {

    private String message;
    private LocalDateTime time;
}
