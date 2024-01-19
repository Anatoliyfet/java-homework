package ru.edu.module12.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.edu.module12.entity.User;
import ru.edu.module12.service.UserService;

import java.util.List;

// http://localhost:8080/swagger-ui/index.html#/
//@RestController
//@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Controller
//@Tag(name = "User", description = "User API")

public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService service;

    @GetMapping()
    @Operation(summary = "Get all users")
    public ResponseEntity<List<User>> getAllCars() {
        List<User> users = service.findAll();
        logger.info("getting user list: {}", users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //GETs
    @GetMapping("/user")
    public String listUsers(Model model) {
        model.addAttribute("users", service.findAll());
        return "user/general.html";
    }

    @GetMapping("/admin/create")
    public String viewAdmin(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "admin/create/edit.html";
    }

    @GetMapping("/admin/update/{id}")
    public String viewAdminUpdate(@PathVariable("id") long id, Model model) {
        User user = service.findById(id);
        model.addAttribute(user);
        return "/admin/update/update.html";
    }
//    /**
//     * @param userId
//     * @return
//     */
//    @GetMapping("/{id}")
//    @Operation(summary = "User car details")
//    public User getUserById(@PathVariable("id") long userId) {
//
//        return service.findById(userId);
//    }
//POSTs

    /**
     * @param user
     * @return
     */
    @PostMapping
    @Operation(summary = "Create user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        service.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/cars/" + user.getId());
        return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
    }

    @PostMapping("/admin")
    @Operation(summary = "Create user")
    public String createUserFromHtml(@Valid @ModelAttribute("user") User user, BindingResult result) {
        service.save(user);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Location", "/api/create" + user.getId());
        return "redirect:/user";
    }
// PUTs

    /**
     * @param user
     * @return
     */
    @PutMapping
    @Operation(summary = "Update a user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        service.update(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin")
    public String updateUserFromHtml(@Valid @ModelAttribute("user") User user, BindingResult result) {
        service.update(user);
        return "redirect:/user";
    }
    //DELETEs

    /**
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    @Operation(summary = "Delete a user by id")
    public ResponseEntity<User> deleteUserById(@PathVariable long userId) {
        service.deleteById(userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/admin")
    @Operation(summary = "Delete a user by id")
    public String deleteUserByIdFromHtml(@Valid @ModelAttribute("user") User user, BindingResult result) {
        service.deleteById(user.getId());
        return "redirect:/user";
    }

    // for themelyf
    @PostMapping("admin/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "admin/update";
        }

        service.save(user);
        return "redirect:/user";
    }

//    @GetMapping("admin/update/{id}")
//    public String redirectUser(@PathVariable("id") long id, Model model) {
//        return "redirect:/user";
//    }

    @GetMapping("admin/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = service.findById(id);
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        service.deleteById(user.getId());
        return "redirect:/user";
    }
}
