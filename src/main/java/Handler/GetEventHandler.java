package Handler;

import DAO.Database;
import Model.Event;
import Model.Time;
import Model.Vote;
import Request.GetEventRequest;
import Response.GetEventResponse;

import java.util.List;

public class GetEventHandler extends Handler<GetEventRequest, GetEventResponse> {
    @Override
    protected GetEventResponse handle(GetEventRequest request) {
        Event event = Database.getInstance().getEventDao().read(request.getEventID());
        List<Time> listTimes = Database.getInstance().getTimeDao().readTimes(request.getEventID());
        List<Vote> listVotes = Database.getInstance().getVoteDao().readVotes(request.getEventID());
        Time[] times = new Time[listTimes.size()];
        Vote[] votes = new Vote[listVotes.size()];
        for (int i = 0; i < times.length; ++i){
            times[i] = listTimes.get(i);
        }
        for (int i = 0; i < votes.length; ++i){
            votes[i] = listVotes.get(i);
        }
        return new GetEventResponse(event.getUuid(), event.getName(), event.getCreator(), event.getDescription(),
            times, votes);
    }

    @Override
    protected GetEventResponse fail(Exception e) {
        return new GetEventResponse(e.getMessage());
    }

    @Override
    protected GetEventRequest emptyRequest() {
        return new GetEventRequest();
    }
}
