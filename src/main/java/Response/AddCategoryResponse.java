package Response;

import Model.Category;

public class AddCategoryResponse extends Response{
    private Category category;

    public AddCategoryResponse(String message) {
        super(message);
    }

    public AddCategoryResponse(Category category) {
        super();
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
