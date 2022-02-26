package Request;

import Model.Budget;
import Model.Expenditure;
import Model.User;

public class AddExpenditureRequest {

    // I am thinking we may not need the User here....??????????
    private Expenditure expenditure;
    private User user;

    public AddExpenditureRequest() {
    }

    public AddExpenditureRequest(Expenditure expenditure, User user) {
        this.expenditure = expenditure;
        this.user = user;
    }

    public Expenditure getExpenditure() {
        return expenditure;
    }

    public User getUser() {
        return user;
    }
}
