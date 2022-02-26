package Response;

import Model.Budget;

public class AddBudgetResponse extends Response{
    private Budget budget;

    public AddBudgetResponse(String message) {
        super(message);
    }

    public AddBudgetResponse(Budget budget) {
        super();
        this.budget = budget;
    }

    public Budget getBudget() {
        return budget;
    }
}
