package Response;

import Model.Budget;
import Model.Expenditure;

import java.util.List;

public class GetExpenditureForDayResponse extends Response{
    private List<Expenditure> expenditures;

    public GetExpenditureForDayResponse(String message) {
        super(message);
    }

    public GetExpenditureForDayResponse(List<Expenditure> expenditures) {
        super();
        this.expenditures = expenditures;
    }

    public List<Expenditure> getExpenditures() {
        return expenditures;
    }
}
