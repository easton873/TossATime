package Request;

import Model.User;

public class GetBudgetsRequest {
    User user;

    public GetBudgetsRequest() {
    }

    public GetBudgetsRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
