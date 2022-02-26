package Handler;

import DAO.Mongo.DatabaseManager;
import Request.AddBudgetRequest;
import Response.AddBudgetResponse;

public class AddBudgetHandler extends Handler<AddBudgetRequest, AddBudgetResponse> {
    @Override
    public AddBudgetResponse handle(AddBudgetRequest request) {
        DatabaseManager.getInstance().createBudgetDao().insert(request.getBudget(), request.getUser());
        return new AddBudgetResponse(request.getBudget());
    }

    @Override
    protected AddBudgetResponse fail(Exception e) {
        return new AddBudgetResponse(e.getMessage());
    }

    @Override
    protected AddBudgetRequest emptyRequest() {
        return new AddBudgetRequest();
    }
}
