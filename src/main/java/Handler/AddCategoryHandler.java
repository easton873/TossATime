package Handler;

import DAO.Mongo.DatabaseManager;
import Request.AddCategoryRequest;
import Response.AddCategoryResponse;

public class AddCategoryHandler extends Handler<AddCategoryRequest, AddCategoryResponse> {
    @Override
    protected AddCategoryResponse handle(AddCategoryRequest request) {
        DatabaseManager.getInstance().createCategoryDao().create(request.getCategory(), request.getBudget());
        return new AddCategoryResponse(request.getCategory());
    }

    @Override
    protected AddCategoryResponse fail(Exception e) {
        return new AddCategoryResponse(e.getMessage());
    }

    @Override
    protected AddCategoryRequest emptyRequest() {
        return new AddCategoryRequest();
    }
}
