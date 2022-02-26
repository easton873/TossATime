package Response;

import Model.Budget;
import Model.Expenditure;

public class AddExpenditureResponse extends Response{
    private Expenditure expenditure;

    public AddExpenditureResponse(String message) {
        super(message);
    }

    public AddExpenditureResponse(Expenditure expenditure) {
        super();
        this.expenditure = expenditure;
    }

    public Expenditure getExpenditure() {
        return expenditure;
    }
}
