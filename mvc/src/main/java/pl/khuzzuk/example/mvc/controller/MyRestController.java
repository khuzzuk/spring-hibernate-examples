package pl.khuzzuk.example.mvc.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import pl.khuzzuk.example.mvc.model.User;

import javax.validation.Valid;

@RestController
public class MyRestController {
    @Getter
    private User currentUser;

    @GetMapping(path = "getAdmin")
    public User getAdmin() {
        User user = new User();
        user.setName("Admin");
        return user;
    }

    @GetMapping("/throw")
    public User throwException() {
        throw new UnsupportedOperationException();
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public User returnAnyways(UnsupportedOperationException e) {
        return getAdmin();
    }

    @PutMapping("saveUser")
    public void saveUser(@RequestBody @Valid User user) {
        currentUser = user;
    }

    @GetMapping("simpleSaveUser/{user}")
    public User createIfEmpty(@PathVariable("user") User user) {
        currentUser = user;
        return user;
    }

    void resetCurrentUser() {
        currentUser = null;
    }
}
