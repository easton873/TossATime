package Handler;

import DAO.Mongo.DatabaseManager;
import Request.DeleteCategoryRequest;
import Response.DeleteCategoryResponse;

public class DeleteCategoryHandler extends Handler<DeleteCategoryRequest, DeleteCategoryResponse> {
    @Override
    protected DeleteCategoryResponse handle(DeleteCategoryRequest request) {
        DatabaseManager.getInstance().createCategoryDao().delete(request.getCategory());
        return new DeleteCategoryResponse(request.getCategory());
    }

    @Override
    protected DeleteCategoryResponse fail(Exception e) {
        return new DeleteCategoryResponse(e.getMessage());
    }

    @Override
    protected DeleteCategoryRequest emptyRequest() {
        return new DeleteCategoryRequest();
    }
}
