package br.com.michaelbernard.todolist.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter; /* Servlet é a base para qualquer framework web no Java */
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component /* Classe que queremos que o Spring gerencie; Classe mais genérica de gerenciamento do Spring */
public class FilterTaskAuth implements Filter { /* Filtro para autenticação de usuários no BD para saber se já existe com aquele ID gerado */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

                chain.doFilter(request, response); /* Toda requisição passa pelo filtro e valida se o usuário está no BD */
    }
}