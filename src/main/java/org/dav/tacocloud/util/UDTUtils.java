package org.dav.tacocloud.util;

import org.dav.tacocloud.domain.Ingredient;
import org.dav.tacocloud.domain.IngredientUDT;
import org.dav.tacocloud.domain.Taco;
import org.dav.tacocloud.domain.TacoUDT;

public class UDTUtils {
    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }

    public static TacoUDT toTacoUDT(Taco taco) {
        return new TacoUDT(taco.getName(), taco.getIngredients());
    }
}
