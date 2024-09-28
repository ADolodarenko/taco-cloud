package org.dav.tacocloud.web;

import org.dav.tacocloud.domain.Ingredient;
import org.dav.tacocloud.domain.IngredientUDT;
import org.dav.tacocloud.repository.IngredientRepository;
import org.dav.tacocloud.util.UDTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientUDTByIdConverter implements Converter<String, IngredientUDT> {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientUDTByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientUDT convert(String id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);
        if (ingredient == null) {
            return null;
        }
        return UDTUtils.toIngredientUDT(ingredient);
    }
}
