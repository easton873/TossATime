package Handler;

import DAO.Mongo.DatabaseManager;
import Request.DeleteBudgetRequest;
import Response.DeleteBudgetResponse;

public class DeleteBudgetHandler extends Handler<DeleteBudgetRequest, DeleteBudgetResponse> {
    @Override
    protected DeleteBudgetResponse handle(DeleteBudgetRequest request) {
        DatabaseManager.getInstance().createBudgetDao().delete(request.getBudget());
        return new DeleteBudgetResponse();
    }

    @Override
    protected DeleteBudgetResponse fail(Exception e) {
        return new DeleteBudgetResponse(e.getMessage());
    }

    @Override
    protected DeleteBudgetRequest emptyRequest() {
        return new DeleteBudgetRequest();
    }
}
