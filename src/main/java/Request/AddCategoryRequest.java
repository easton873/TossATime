package Request;

import Model.Budget;
import Model.Category;

public class AddCategoryRequest {
    private Budget budget;
    private Category category;

    public AddCategoryRequest(Category category, Budget budget) {
        this.budget = budget;
        this.category = category;
    }

    public AddCategoryRequest() {
    }

    public Budget getBudget() {
        return budget;
    }

    public Category getCategory() {
        return category;
    }
}
