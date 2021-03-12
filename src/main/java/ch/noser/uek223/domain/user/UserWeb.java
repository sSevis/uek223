package ch.noser.uek223.domain.user;

import ch.noser.uek223.domain.user.dto.UserDTOAdmin;
import ch.noser.uek223.domain.user.dto.UserDTONew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserWeb {

    private final UserService userService;

    private UserMapper userMapper;

    @Autowired
    public UserWeb(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    /*@GetMapping({"/", ""})
    public ResponseEntity<List<UserDTOAdmin>> findAll(){
        return ResponseEntity.ok().body(userMapper.usersToUserDTOAdmin(userService.findAll()));
    }*/

    @PostMapping({"/", ""})
    public ResponseEntity<UserDTOAdmin> create(@RequestBody UserDTONew user) {
        return new ResponseEntity<>(userMapper.userToUserDTOAdmin(userService.create(userMapper.userDTONewToUser(user))), HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<UserDTOAdmin> findById(@PathVariable("id") String id){
        return new ResponseEntity<>(userMapper.userToUserDTOAdmin(userService.findById(UUID.fromString(id))), HttpStatus.OK);
    }

}
