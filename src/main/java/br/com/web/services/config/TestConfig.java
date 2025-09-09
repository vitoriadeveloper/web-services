package br.com.web.services.config;

import br.com.web.services.entities.*;
import br.com.web.services.entities.enums.OrderStatus;
import br.com.web.services.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class TestConfig {

    @Bean
    CommandLineRunner initDatabase (UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository, OrderItemRepository orderItemRepository){
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

            Product p1 = new Product();
            p1.setName("TV");
            p1.setDescription("Tv Samsung ultima geração");
            p1.setImgUrl("localhost:8080");
            p1.setPrice(2000.00);
            p1.getCategories().add(c1);

            Product p2 = new Product();
            Product p3 = new Product();
            p2.setName("Clean Code");
            p2.setDescription("Livro sobre boas práticas de programação");
            p2.setImgUrl("http://localhost:8080/img/cleancode.png");
            p2.setPrice(120.00);

            p3.setName("Arroz 5kg");
            p3.setDescription("Pacote de arroz branco");
            p3.setImgUrl("http://localhost:8080/img/arroz.png");
            p3.setPrice(25.00);

            p1.getCategories().add(c1);
            p2.getCategories().add(c2);
            p3.getCategories().add(c3);
            productRepository.saveAll(Arrays.asList(p1, p2, p3));

            OrderItem oi1 = new OrderItem();
            oi1.setId(new OrderItemPk());
            oi1.getId().setOrder(o1);
            oi1.getId().setProduct(p1);
            oi1.setQuantity(1);
            oi1.setPrice(p1.getPrice());

            OrderItem oi2 = new OrderItem();
            oi2.setId(new OrderItemPk());
            oi2.getId().setOrder(o1);
            oi2.getId().setProduct(p3);
            oi2.setQuantity(2);
            oi2.setPrice(p3.getPrice());

            OrderItem oi3 = new OrderItem();
            oi3.setId(new OrderItemPk());
            oi3.getId().setOrder(o2);
            oi3.getId().setProduct(p2);
            oi3.setQuantity(1);
            oi3.setPrice(p2.getPrice());

            orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
        };
    }
}
