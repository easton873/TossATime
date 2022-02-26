package Request;

import Model.Category;

public class DeleteCategoryRequest {
    private Category category;

    public DeleteCategoryRequest() {
    }

    public DeleteCategoryRequest(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
