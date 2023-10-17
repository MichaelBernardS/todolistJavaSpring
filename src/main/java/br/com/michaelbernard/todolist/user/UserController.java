package br.com.michaelbernard.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired /* Spring gerencia o ciclo de instância da classe (UserRepository) */
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) { /* ResponseEntity - Possibilita retornos distintos na aplicação dentro da mesma requisição / RequestBody indica que os dados da requisição http estarão no corpo da msg e serão convertidos para o objeto especificado no parâmetro do método */
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe"); /* Status Code 400 - Erro */
        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray()); /* Criar hash pra senha - Criptografar */

        userModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated); /* Status Code 201 - Sucesso sem retorno */
    }
}