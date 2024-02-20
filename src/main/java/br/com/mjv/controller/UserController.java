package br.com.mjv.controller;

import br.com.mjv.dto.UserDTO;

import br.com.mjv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UserController {


    @Autowired
    private UserService usuarioService;

    @PostMapping("salvar")
    public UserDTO save(@RequestBody UserDTO userDTO){
        return usuarioService.saveUser(userDTO);
    }

    @GetMapping("buscar-por-id/{id}")
    public UserDTO save(@PathVariable Long id){
        return usuarioService.buscarPorId(id).get();
    }

}
