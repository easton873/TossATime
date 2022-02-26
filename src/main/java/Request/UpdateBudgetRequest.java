package Request;

import Model.Budget;
import Model.User;

public class UpdateBudgetRequest {
    private Budget budget;
    private User user;

    public UpdateBudgetRequest() {
    }

    public UpdateBudgetRequest(Budget budget, User user) {
        this.budget = budget;
        this.user = user;
    }

    public Budget getBudget() {
        return budget;
    }

    public User getUser() {
        return user;
    }
}
