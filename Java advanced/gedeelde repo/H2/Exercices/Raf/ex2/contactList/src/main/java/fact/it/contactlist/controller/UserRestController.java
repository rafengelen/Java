package fact.it.contactlist.controller;

import fact.it.contactlist.model.User;
import fact.it.contactlist.model.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserService userService;

    @PostConstruct
    public void fillUserServiceWithUsers() {
        this.userService = new UserService();
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getUserList();
    }

    @PostMapping("users/add")
    @ResponseStatus(HttpStatus.CREATED)
    public List<User> addMultipleUsers(@RequestBody List<User> newUser){

            return userService.addUsers(newUser);
        }
    }


