package br.com.api.rh.api.domain.entity;

import br.com.api.rh.api.domain.dto.GetUserDTO;
import br.com.api.rh.api.domain.dto.PostUserDTO;
import br.com.api.rh.api.domain.dto.PutPasswordUserDTO;
import ch.qos.logback.core.encoder.Encoder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name= "tb_user")
@Entity(name= "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;


    public User(GetUserDTO data){
        this.name = data.name();
        this.email = data.email();
    }

    public User(PostUserDTO data){
        this.name = data.getEmail();
        this.email = data.getEmail();
        this.password = data.getPassword();
    }
}
