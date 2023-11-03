package br.com.fiap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.model.User;
import br.com.fiap.model.UserInfoDetails;
import br.com.fiap.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	private final UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	public UserInfoService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado com o nome de usuário: " + username);
		}
		return new UserInfoDetails(user);
	}

	public String createUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "Usuário adicionado com sucesso!";
	}
}
