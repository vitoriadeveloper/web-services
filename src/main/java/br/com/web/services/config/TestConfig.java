package br.com.web.services.config;

import br.com.web.services.entities.Category;
import br.com.web.services.entities.Order;
import br.com.web.services.entities.User;
import br.com.web.services.entities.enums.OrderStatus;
import br.com.web.services.repositories.CategoryRepository;
import br.com.web.services.repositories.OrderRepository;
import br.com.web.services.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class TestConfig {

    @Bean
    CommandLineRunner initDatabase (UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository){
        return args -> {
            User u1 = new User();
            u1.setName("Vic");
            u1.setEmail("vic@gmail.com");
            u1.setPhone("9999999");
            u1.setPassword("123456");

            User u2 = new User();
            u2.setName("Carol");
            u2.setEmail("carol@gmail.com");
            u2.setPhone("98989898");
            u2.setPassword("123456");

            userRepository.saveAll(Arrays.asList(u1, u2));
            Order o1 = new Order();
            o1.setMoment(new Date());
            o1.setOrderStatus(OrderStatus.PAID);
            o1.setClient(u1);

            Order o2 = new Order();
            o2.setMoment(new Date());
            o2.setOrderStatus(OrderStatus.DELIVERED);
            o2.setClient(u2);

            Order o3 = new Order();
            o3.setMoment(new Date());
            o3.setOrderStatus(OrderStatus.CANCELED);
            o3.setClient(u1);

            orderRepository.saveAll(Arrays.asList(o1, o2, o3));

            Category c1 = new Category();
            c1.setName("Eletronicos");

            Category c2 = new Category();
            c2.setName("Livros");

            Category c3 = new Category();
            c3.setName("Mercado");

            categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        };
    }
}
