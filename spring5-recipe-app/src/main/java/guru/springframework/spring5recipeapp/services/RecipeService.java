package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.commands.RecipeCommand;
import guru.springframework.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Recipe findById(Long l);

    Set<Recipe> getRecipes();

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
