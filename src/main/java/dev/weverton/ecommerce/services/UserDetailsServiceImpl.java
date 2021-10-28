package dev.weverton.ecommerce.services;

import dev.weverton.ecommerce.domain.Cliente;
import dev.weverton.ecommerce.repositories.ClienteRepository;
import dev.weverton.ecommerce.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));

        return new User(cliente.getId(), cliente.getEmail(), cliente.getSenha(), cliente.getRoles());
    }
}
