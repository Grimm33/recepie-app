package ccbill.training.recipeapp.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setup(){
        category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 4L;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    void getDescription() {
        String descriptionValue = "I am a description";

        category.setDescription(descriptionValue);

        assertEquals(descriptionValue, category.getDescription());
    }

    @Test
    void getRecipes() {
    }
}