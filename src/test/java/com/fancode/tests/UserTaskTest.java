package com.fancode.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.fancode.model.Task;
import com.fancode.model.User;
import com.fancode.service.CityService;
import com.fancode.service.UserService;
import com.fancode.utils.ReportManager;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static com.fancode.service.CityService.isFanCodeCity;

public class UserTaskTest {

    private UserService userService;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUpReport() {
        extent = ReportManager.getInstance();
    }

    @BeforeTest
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void verifyFanCodeUsersTodoCompletion() {
        test = ReportManager.createTest("Verify FanCode Users Todo Completion");
        boolean flag = false;
        List<User> users = userService.getUsers();
        for (User user : users) {
            if (CityService.isFanCodeCity(user)){
                List<Task> tasks = userService.getTasksForUser(user.getId());
                double completionPercentage = userService.calculateCompletionPercentage(tasks);
                if (completionPercentage > 50) {
                    test.pass("User " + user.getName() + " has " + completionPercentage + "% tasks completed.");
                } else {
                    test.fail("User " + user.getName() + " has only " + completionPercentage + "% tasks completed.");
                    flag = true;
                }
            }
        }
        if (flag) {
            Assert.fail();
        }

    }

    @AfterClass
    public void tearDownReport() {
        if (extent != null) {
            ReportManager.flush();
        }
    }

}
