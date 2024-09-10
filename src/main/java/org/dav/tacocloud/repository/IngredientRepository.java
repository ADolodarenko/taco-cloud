package org.dav.tacocloud.repository;

import org.dav.tacocloud.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
