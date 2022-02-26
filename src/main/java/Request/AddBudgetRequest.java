package Request;

import Model.Budget;
import Model.User;

public class AddBudgetRequest {
    private Budget budget;
    private User user;

    public AddBudgetRequest() {
    }

    public AddBudgetRequest(Budget budget, User user) {
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
