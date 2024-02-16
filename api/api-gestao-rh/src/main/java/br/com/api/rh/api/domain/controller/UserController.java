package br.com.api.rh.api.domain.controller;

import br.com.api.rh.api.domain.dto.PostUserDTO;
import br.com.api.rh.api.domain.dto.PutPasswordUserDTO;
import br.com.api.rh.api.domain.entity.User;
import br.com.api.rh.api.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    private final PasswordEncoder encoder;

    public UserController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @PostMapping("/save")
    public ResponseEntity saveUsers(@RequestBody PostUserDTO data){
        data.setPassword((encoder.encode(data.getPassword())));
        var userData = userService.saveUser(data);
        return ResponseEntity.ok().body(userData);
    }

    @PutMapping(value= "/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody PutPasswordUserDTO updateData){
        var updatePasswordUser = userService.updateUser(id,updateData);
        return ResponseEntity.ok().body(updatePasswordUser);
    }

    @GetMapping(value= "/")
    public ResponseEntity<List<User>> listAll(){
        List<User> list = userService.listAllUsers();
        return ResponseEntity.ok(list);
    }
    @GetMapping(value= "/{id}/")
    public ResponseEntity<User> listId(@PathVariable Long id){
        var listUser = userService.listUserId(id);
        return ResponseEntity.ok().body(listUser);
    }

    @DeleteMapping(value= "/delete/{id}/")
    public ResponseEntity deleteId(@PathVariable Long id){
        userService.deleteId(id);
        return ResponseEntity.noContent().build();
    }

}
