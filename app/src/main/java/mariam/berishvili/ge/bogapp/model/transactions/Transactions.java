package mariam.berishvili.ge.bogapp.model.transactions;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Transactions {
    @SerializedName("OutcomeSum")
    private double outcomeSum;
    @SerializedName("IncomeSum")
    private double incomeSum;
    @SerializedName("MyOperations")
    private List<MyOperation> myOperations;

    public double getOutcomeSum() {
        return outcomeSum;
    }

    public double getIncomeSum() {
        return incomeSum;
    }

    public List<MyOperation> getMyOperations() {
        return myOperations;
    }
}
