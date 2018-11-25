package mariam.berishvili.ge.bogapp.main.fragment.transactions;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.model.transactions.MyOperation;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionViewHolder> {
    List<MyOperation> myOperations = new ArrayList<>();

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_transactions_cell, viewGroup, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder transactionViewHolder, int i) {
        transactionViewHolder.setData(myOperations.get(i));
    }

    @Override
    public int getItemCount() {
        return myOperations.size();
    }

    public void setData(List<MyOperation> myOperations){
        this.myOperations.clear();
        this.myOperations.addAll(myOperations);
        notifyDataSetChanged();
    }
}
