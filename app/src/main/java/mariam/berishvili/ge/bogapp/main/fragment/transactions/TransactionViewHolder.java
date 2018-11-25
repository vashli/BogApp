package mariam.berishvili.ge.bogapp.main.fragment.transactions;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.model.Constants;
import mariam.berishvili.ge.bogapp.model.transactions.MyOperation;


public class TransactionViewHolder extends RecyclerView.ViewHolder {
    private TextView day;
    private TextView merchant;
    private TextView entryGroupName;
    private TextView amount;

    public TransactionViewHolder(@NonNull View itemView) {
        super(itemView);
        day = itemView.findViewById(R.id.fragment_transaction_cell_day);
        merchant = itemView.findViewById(R.id.fragment_transaction_cell_merchant_name);
        entryGroupName = itemView.findViewById(R.id.fragment_transaction_cell_entry_group_name);
        amount = itemView.findViewById(R.id.fragment_transaction_cell_entry_amount);
    }

    public void setData(MyOperation myOperation){
        day.setText(getDateText(myOperation.getPostDate()));
        merchant.setText(getMerchantName(myOperation.getMerchantName()));
        entryGroupName.setText(myOperation.getEntryGroupName());
        amount.setText(Double.toString(myOperation.getAmount()));
    }
    private String getDateText(Long date){
        SimpleDateFormat dt = new SimpleDateFormat("dd.mm.yyyy");
        String day;
        if (DateUtils.isToday(date)){
            day = Constants.DAY_TODAY;
        }else if(DateUtils.isToday(date + 1000 * 60 * 60 * 24 )){
            day = Constants.DAY_YESTERDAY;
        }else {
            day = dt.format(date);
        }
        return day;
    }

    private String getMerchantName(String merchantName){
        if(merchantName == null) return Constants.DEFAULT_MERCHANT_NAME;
        return merchantName;
    }
}
