package Request;

import Model.Budget;

public class GetExpendituresForDayRequest {
    Budget budget;
    int year;
    int month;
    int day;

    public GetExpendituresForDayRequest() {
    }

    public GetExpendituresForDayRequest(Budget budget, int year, int month, int day) {
        this.budget = budget;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Budget getBudget() {
        return budget;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
