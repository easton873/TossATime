package Response;

import Model.Budget;

public class UpdateBudgetResponse extends Response{
    private Budget updatedBudget;

    public UpdateBudgetResponse(String message) {
        super(message);
    }

    public UpdateBudgetResponse(Budget budget) {
        super();
        this.updatedBudget = budget;
    }

    public Budget getUpdatedBudget() {
        return updatedBudget;
    }
}
