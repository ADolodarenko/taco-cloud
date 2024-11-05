package org.dav.tacocloud.application;

import org.dav.tacocloud.domain.Ingredient;
import org.dav.tacocloud.domain.User;
import org.dav.tacocloud.repository.IngredientRepository;
import org.dav.tacocloud.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {
    @Bean
    public ApplicationRunner dataLoader(IngredientRepository ingredientRepository) {
        return args -> {
            if (ingredientRepository.count() == 0) {
                ingredientRepository.save(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
                ingredientRepository.save(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
                ingredientRepository.save(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
                ingredientRepository.save(new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
                ingredientRepository.save(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
                ingredientRepository.save(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
                ingredientRepository.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
                ingredientRepository.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
                ingredientRepository.save(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
                ingredientRepository.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
            }
        };
    }

    @Bean
    public ApplicationRunner userLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() > 0) {
                return;
            }

            String password = passwordEncoder.encode("admin");

            userRepository.save(new User("admin", password, "Администратор",
                    null, null, null, null, null));

        };
    }
}
