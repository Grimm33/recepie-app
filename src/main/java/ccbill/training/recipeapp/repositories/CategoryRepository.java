package ccbill.training.recipeapp.repositories;

import ccbill.training.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
