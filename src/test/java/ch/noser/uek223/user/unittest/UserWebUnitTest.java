package ch.noser.uek223.user.unittest;

import ch.noser.uek223.domain.user.UserMapper;
import ch.noser.uek223.domain.user.UserService;
import ch.noser.uek223.domain.user.UserWeb;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class UserWebUnitTest {

    @Mock
    private UserService userService;
    @Mock
    private UserMapper userMapper;

    private UserWeb userWeb = new UserWeb(userService, userMapper);

    /*@Test
    public boolean create_(){
        return true;
    }*/

}
