package Handler;

import DAO.Mongo.DatabaseManager;
import Request.UpdateBudgetRequest;
import Response.UpdateBudgetResponse;

public class UpdateBudgetHandler extends Handler<UpdateBudgetRequest, UpdateBudgetResponse> {
    @Override
    protected UpdateBudgetResponse handle(UpdateBudgetRequest request) {
        DatabaseManager.getInstance().createBudgetDao().update(request.getBudget(), request.getUser());
        return new UpdateBudgetResponse(request.getBudget());
    }

    @Override
    protected UpdateBudgetResponse fail(Exception e) {
        return new UpdateBudgetResponse(e.getMessage());
    }

    @Override
    protected UpdateBudgetRequest emptyRequest() {
        return new UpdateBudgetRequest();
    }
}
