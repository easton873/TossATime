package Handler;

import DAO.Mongo.DatabaseManager;
import Request.GetBudgetsRequest;
import Response.GetBudgetResponse;

public class GetBudgetsHandler extends Handler<GetBudgetsRequest, GetBudgetResponse> {
    @Override
    protected GetBudgetResponse handle(GetBudgetsRequest request) {
        return new GetBudgetResponse(DatabaseManager.getInstance().createBudgetDao().getBudgets(request.getUser()));
    }

    @Override
    protected GetBudgetResponse fail(Exception e) {
        return new GetBudgetResponse(e.getMessage());
    }

    @Override
    protected GetBudgetsRequest emptyRequest() {
        return new GetBudgetsRequest();
    }
}
