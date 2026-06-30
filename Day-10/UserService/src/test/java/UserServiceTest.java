import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.userservice.model.User;
import com.example.userservice.model.UserRequest;
import com.example.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testCreateUser(){
        User user = userService.createUser(new UserRequest("test","test@gmail.com")
        );
        assertNotNull(user);
    }
}
