package com.fancode.model;

import lombok.Data;

@Data
public class Task {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
