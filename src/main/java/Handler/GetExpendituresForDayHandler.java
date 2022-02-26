package Handler;

import DAO.Mongo.DatabaseManager;
import Request.GetExpendituresForDayRequest;
import Response.GetExpenditureForDayResponse;

public class GetExpendituresForDayHandler extends Handler<GetExpendituresForDayRequest, GetExpenditureForDayResponse> {
    @Override
    protected GetExpenditureForDayResponse handle(GetExpendituresForDayRequest request) {
        return new GetExpenditureForDayResponse(DatabaseManager
            .getInstance()
            .createExpenditureDao()
            .getExpendituresForDay(
                request.getBudget(),
                request.getYear(),
                request.getMonth(),
                request.getDay()
            ));
    }

    @Override
    protected GetExpenditureForDayResponse fail(Exception e) {
        return new GetExpenditureForDayResponse(e.getMessage());
    }

    @Override
    protected GetExpendituresForDayRequest emptyRequest() {
        return new GetExpendituresForDayRequest();
    }
}
