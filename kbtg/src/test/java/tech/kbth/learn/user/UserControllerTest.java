package tech.kbth.learn.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import tech.kbth.learn.Application;

@SpringBootTest(classes = Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void success_get_user_id_1() {
        // Act
        UserResponse response
                = restTemplate.getForObject("/user/1", UserResponse.class);
        // Assert
        Assertions.assertEquals(1, response.getId());
        Assertions.assertEquals("TEST", response.getName());
        Assertions.assertEquals(23, response.getAge());
        // Quiz
        UserResponse expected = new UserResponse(1, "TEST", 23);
        Assertions.assertEquals(expected, response);
    }
    @Test
    void userNotFoundWithUserId15() {
        ErrorResponse errorResponse = restTemplate.getForObject("/user/15", ErrorResponse.class);
        Assertions.assertEquals(1234, errorResponse.getCode());
        Assertions.assertEquals("User not found id 15", errorResponse.getMessage());
    }
}
