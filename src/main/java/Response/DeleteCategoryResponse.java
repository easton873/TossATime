package Response;

import Model.Category;

public class DeleteCategoryResponse extends Response {
    Category category;

    public DeleteCategoryResponse(String message) {
        super(message);
    }

    public DeleteCategoryResponse(Category category) {
        super();
        this.category = category;
    }
}
