package Handler;

import DAO.Mongo.DatabaseManager;
import Request.AddExpenditureRequest;
import Response.AddExpenditureResponse;

public class AddExpenditureHandler extends Handler<AddExpenditureRequest, AddExpenditureResponse> {
    @Override
    protected AddExpenditureResponse handle(AddExpenditureRequest request) {
        DatabaseManager.getInstance().createExpenditureDao().createExpenditure(request.getExpenditure());
        return new AddExpenditureResponse(request.getExpenditure());

    }

    @Override
    protected AddExpenditureResponse fail(Exception e) {
        return new AddExpenditureResponse(e.getMessage());
    }

    @Override
    protected AddExpenditureRequest emptyRequest() {
        return new AddExpenditureRequest();
    }
}
