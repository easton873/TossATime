package Request;

import Model.Budget;

import java.util.UUID;

public class DeleteBudgetRequest {
    private Budget budget;

    public DeleteBudgetRequest() {
    }

    public DeleteBudgetRequest(Budget budget) {
        this.budget = budget;
    }

    public Budget getBudget() {
        return budget;
    }
}
