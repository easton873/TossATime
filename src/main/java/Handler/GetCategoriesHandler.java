package Handler;

import DAO.Mongo.DatabaseManager;
import Request.GetCategoriesRequest;
import Response.GetCategoriesResponse;


public class GetCategoriesHandler extends Handler<GetCategoriesRequest, GetCategoriesResponse> {
    @Override
    protected GetCategoriesResponse handle(GetCategoriesRequest request) {
        return new GetCategoriesResponse(DatabaseManager.getInstance().createCategoryDao().getCategories(request.getBudget()));
    }

    @Override
    protected GetCategoriesResponse fail(Exception e) {
        return new GetCategoriesResponse(e.getMessage());
    }

    @Override
    protected GetCategoriesRequest emptyRequest() {
        return new GetCategoriesRequest();
    }
}
