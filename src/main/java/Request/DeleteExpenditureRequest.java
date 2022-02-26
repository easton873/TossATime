package Request;

import Model.Expenditure;

public class DeleteExpenditureRequest {
    Expenditure expenditure;

    public DeleteExpenditureRequest() {
    }

    public DeleteExpenditureRequest(Expenditure expenditure) {
        this.expenditure = expenditure;
    }

    public Expenditure getExpenditure() {
        return expenditure;
    }
}
