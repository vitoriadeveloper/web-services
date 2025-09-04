package br.com.web.services.services;

import br.com.web.services.entities.User;
import br.com.web.services.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
    
    public Optional<User> findById(Long id){
        return repository.findById(id);
    }
}
