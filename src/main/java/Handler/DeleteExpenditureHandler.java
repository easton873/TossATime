package Handler;

import DAO.Mongo.DatabaseManager;
import Request.DeleteExpenditureRequest;
import Response.DeleteExpenditureResponse;

public class DeleteExpenditureHandler extends Handler<DeleteExpenditureRequest, DeleteExpenditureResponse> {
    @Override
    protected DeleteExpenditureResponse handle(DeleteExpenditureRequest request) {
        DatabaseManager.getInstance().createExpenditureDao().delete(request.getExpenditure());
        return new DeleteExpenditureResponse();
    }

    @Override
    protected DeleteExpenditureResponse fail(Exception e) {
        return new DeleteExpenditureResponse(e.getMessage());
    }

    @Override
    protected DeleteExpenditureRequest emptyRequest() {
        return new DeleteExpenditureRequest();
    }
}
