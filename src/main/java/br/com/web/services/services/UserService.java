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

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(long id) {
        return repository.findById(id);
    }

    public User create(User user) {
        return this.repository.save(user);
    }

    public boolean delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public User update(long id, User newUser){
        return repository.findById(id)
                .map(exists -> {
                    exists.setName(newUser.getName());
                    exists.setPassword(newUser.getPassword());
                    exists.setEmail(newUser.getEmail());
                    exists.setPhone(newUser.getPhone());
                    return repository.save(exists);
                }).orElseThrow(()-> new RuntimeException("Usuário não encontrado: " + id));
    }
}
