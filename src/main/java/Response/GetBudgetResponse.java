package Response;

import Model.Budget;

import java.util.List;

public class GetBudgetResponse extends Response{
    private List<Budget> budgets;

    public GetBudgetResponse(String message) {
        super(message);
    }

    public GetBudgetResponse(List<Budget> budgets) {
        super();
        this.budgets = budgets;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }
}
