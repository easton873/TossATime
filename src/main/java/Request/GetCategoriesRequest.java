package Request;

import Model.Budget;

public class GetCategoriesRequest {
    Budget budget;

    public GetCategoriesRequest() {
    }

    public GetCategoriesRequest(Budget budget) {
        this.budget = budget;
    }

    public Budget getBudget() {
        return budget;
    }
}
