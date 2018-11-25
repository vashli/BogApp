package mariam.berishvili.ge.bogapp.main.fragment.transactions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.api.Api;
import mariam.berishvili.ge.bogapp.model.transactions.Transactions;
import mariam.berishvili.ge.bogapp.network.RetrofitProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransactionsFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView incomeTextView;
    private TextView outcomeTextView;
    private TransactionsAdapter adapter;

    public static TransactionsFragment newInstance(){
        TransactionsFragment fragment = new TransactionsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transactions, container, false);
        initViewComponents(view);
        getData();
        return view;
    }
    
    private void initViewComponents(View view){
        recyclerView = view.findViewById(R.id.fragment_transactions_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TransactionsAdapter();
        recyclerView.setAdapter(adapter);
        incomeTextView = view.findViewById(R.id.fragment_transactions_income_value);
        outcomeTextView = view.findViewById(R.id.fragment_transactions_outcome_value);
    }

    private void fillViewComponentsWithData(Transactions transactions){
        incomeTextView.setText(Double.toString(transactions.getIncomeSum()));
        outcomeTextView.setText(Double.toString(transactions.getOutcomeSum()));
        adapter.setData(transactions.getMyOperations());
    }

    public void getData(){
        Api api = RetrofitProvider.getRetrofitInstance().create(Api.class);
        api.getTransactions().enqueue(new Callback<Transactions>() {
            @Override
            public void onResponse(Call<Transactions> call, Response<Transactions> response) {
                fillViewComponentsWithData(response.body());
            }

            @Override
            public void onFailure(Call<Transactions> call, Throwable t) {
                Log.e("transaction", t.getMessage() );
            }
        });
    }
}
