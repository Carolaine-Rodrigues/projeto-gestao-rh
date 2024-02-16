package br.com.api.rh.api.domain.service;

import br.com.api.rh.api.domain.dto.PostUserDTO;
import br.com.api.rh.api.domain.dto.PutPasswordUserDTO;
import br.com.api.rh.api.domain.entity.User;
import br.com.api.rh.api.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    // cadastro de usuario
    public User saveUser(PostUserDTO data){

        var userData = new User(data);
        userRepository.save(userData);
        return userData;
    }

    // atualizção de usuários
    @Transactional
    public Optional<User> updateUser(Long id, PutPasswordUserDTO updatePassword) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User updateUser = optionalUser.get();
            if (updateUser.getPassword() != null) {
                updateUser.setPassword(updatePassword.newPassword());
            }
            userRepository.save(updateUser);
            return Optional.of(updateUser);

        } else {
            throw new EntityNotFoundException();
        }

    }
    //lista todos
    public List<User> listAllUsers(){
        List<User> list = userRepository.findAll();
        return list;
    }

    // lista por id
    public User listUserId(Long id){
        var user = userRepository.findById(id).get();
        return user;
    }

    // deleta por id
    public void deleteId(Long id){
        Optional<User> deleteUser = userRepository.findById(id);
        if(deleteUser.isPresent()){
            User user = deleteUser.get();
            userRepository.delete(user);
        }else {
            throw new EntityNotFoundException();
        }
    }
}
