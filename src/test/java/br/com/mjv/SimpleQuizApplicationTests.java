package br.com.mjv;

import br.com.mjv.model.User;
import br.com.mjv.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleQuizApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void chamaSequenciaCrud(){
		User usuarioGravadoNoBanco = gravarDadosUsuario();
		System.out.println("Valor do usuário gravado no banco: " + usuarioGravadoNoBanco);

		User usuarioAtualizado = atualizarDadosUsuario(usuarioGravadoNoBanco);
		System.out.println("Valor do usuário atualizado: " + usuarioAtualizado);

		apagaUsuario(usuarioAtualizado);
		System.out.println("Apagou o usuário!");
	}


	private User gravarDadosUsuario() {
		User user = new User();
		user.setAge(38);
		user.setName("Samuel");
		user.setFullName("Samuel Ferreira Duarte");
		System.out.println("A - Meu usuario antes de gravar: " + user);

		User usuarioGravadoNoBanco = userRepository.save(user);

		System.out.println("B - Meu usuario depois de gravar." + usuarioGravadoNoBanco);
		return usuarioGravadoNoBanco;
	}


	private User atualizarDadosUsuario(User usuarioGravadoNoBanco) {
		usuarioGravadoNoBanco.setName("Nao é samuca");
		return userRepository.save(usuarioGravadoNoBanco);
	}

	private void apagaUsuario(User usuarioParaDeletar) {
		userRepository.delete(usuarioParaDeletar);
	}

	void dataBaseQuizTests() {

	}





}
