package br.com.michaelbernard.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, UUID> { /* Qual a classe que o repositório está representando / Tipo de Id que a entidade tem */
    UserModel findByUsername(String username); /* Criando um método para implementar a interface; SpringData deixa definir um método apenas achando pelo atributo, onde ele faz um select por baixo dos panos achando a coluna username; */
}