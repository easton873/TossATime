package Handler;

import DAO.Database;
import Model.TimeStamp;
import Model.Vote;
import Request.VoteEventRequest;
import Response.VoteEventResponse;

public class VoteEventHandler extends Handler<VoteEventRequest, VoteEventResponse> {

    @Override
    protected VoteEventResponse handle(VoteEventRequest request) {
        for (TimeStamp ts : request.getTimes()){
            Database.getInstance().getVoteDao().create(new Vote(
                null, request.getEventID(), request.getName(), ts.getYear(), ts.getMonth(), ts.getDay(), ts.getHour()
            ));
        }
        return new VoteEventResponse();
    }

    @Override
    protected VoteEventResponse fail(Exception e) {
        return new VoteEventResponse(e.getMessage());
    }

    @Override
    protected VoteEventRequest emptyRequest() {
        return new VoteEventRequest();
    }
}
