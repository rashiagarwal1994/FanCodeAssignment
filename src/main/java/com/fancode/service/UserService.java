package com.fancode.service;

import com.fancode.api.Endpoints;
import com.fancode.model.Task;
import com.fancode.model.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class UserService {

    public List<User> getUsers() {
        Response response = RestAssured.get(Endpoints.BASE_URL + Endpoints.USERS);
        return response.jsonPath().getList("", User.class);
    }

    public List<Task> getTasksForUser(int userId) {
        Response response = RestAssured.get(Endpoints.BASE_URL + Endpoints.TASKS + "?userId=" + userId);
        return response.jsonPath().getList("", Task.class);
    }

    public double calculateCompletionPercentage(List<Task> tasks) {
        long completedCount = tasks.stream().filter(Task::isCompleted).count();
        return (double) completedCount / tasks.size() * 100;
    }
}
