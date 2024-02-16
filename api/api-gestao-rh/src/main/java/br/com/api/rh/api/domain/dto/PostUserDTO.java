package br.com.api.rh.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PostUserDTO{

   private Long id;
    private String name;
    private String email;
    private String password;



}
