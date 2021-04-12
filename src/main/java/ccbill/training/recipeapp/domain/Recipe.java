package ccbill.training.recipeapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    //here we need a Large object because Hibernate will automatically set the field size in the DB to only 256 characters, where we need a lot more
    @Lob
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    //BLOB field in DB (Binary Large OBject)
    @Lob
    private Byte[] image;

    /**
     * <h1>EnumTypes:</h1>
     * <h2>ORDINAL : default</h2>
     *   <p>-- persists as 1 , 2 , 3 etc</p>
     *   <p>-- can cause a problem if we add a new value in the middle of the Enum</p>
     *   <p>-- example if we have EASY, MEDIUM, HARD and add MIDDLING before MEDIUM,
     *      Recipes previously marked as MEDIUM will now be marked MIDDLING because the value points to 2, which is now MIDDLING</p>

     * <h2>STRING :</h2>
     *   <p>-- persists the literal string value of the Enum</p>
     */
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}
