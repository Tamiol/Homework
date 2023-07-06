package org.example.model;

import com.example.asianfoodapp.catalog.domain.dto.CreateRecipeCommandDTO;
import com.example.asianfoodapp.catalog.domain.dto.RestIngredientDTO;
import com.example.asianfoodapp.catalog.domain.dto.RestRecipeDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CoinMapper implements Function<RestRecipeDTO, CreateRecipeCommandDTO> {
    @Override
    public CreateRecipeCommandDTO apply(RestRecipeDTO recipe) {
        return new CreateRecipeCommandDTO(
                recipe.name(),
                recipe.ingredients()
                        .stream()
                        .map(RestIngredientDTO::toCreateCommand)
                        .collect(Collectors.toSet()),
                recipe.readyInMinutes(),
                recipe.instructions(),
                recipe.vegetarian(),
                recipe.vegan(),
                recipe.glutenFree());
    }
}
