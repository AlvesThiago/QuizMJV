package br.com.mjv.service;

import br.com.mjv.builder.UserMapper;
import br.com.mjv.dto.UserDTO;
import br.com.mjv.model.User;
import br.com.mjv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository usuarioRepository;

    private UserMapper userMapper;


    public UserDTO saveUser(UserDTO userDTO) {
        User userModel = userMapper.toEntity(userDTO);
        userModel = usuarioRepository.save(userModel);

        return userMapper.toDTO(userModel);
    }

    public List<User> salvarVariosUsuarios(List<User> userList) {
        return usuarioRepository.saveAll(userList);
    }

    public Optional<UserDTO> buscarPorId(Long id) {
        return Optional.ofNullable(userMapper.toDTO(usuarioRepository.findById(id).get()));
    }

    public User atualizarUsuario(User user) {
        Optional<User> userController = usuarioRepository.findById(user.getId());
        return usuarioRepository.save(userController.get());
    }

    public void apagarUsuario(User user) {
        usuarioRepository.delete(user);
    }

}
