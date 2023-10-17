package br.com.michaelbernard.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data /* Importa da biblioteca Lombok os Getters e Setters / Caso queira por em 1 atributo, basta colocar @Getter e/ou @Setter acima dele */
@Entity(name="tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id; /* Identificador único */

    @Column(unique = true) /* Cria um constraint tornando estes atributos únicos no BD */
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt; /* Definir quando o atributo foi criado no BD */
}
