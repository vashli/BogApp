package mariam.berishvili.ge.bogapp.main.fragment.actives;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.model.actives.Asset;
import mariam.berishvili.ge.bogapp.model.actives.AssetBase;

public class ItemActiveViewHolder extends RecyclerView.ViewHolder {
    private TextView productName;
    private TextView amount;

    public ItemActiveViewHolder(@NonNull View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.fragment_actives_cell_item_active_product_name);
        amount = itemView.findViewById(R.id.fragment_actives_cell_item_active_amount_base);
    }

    public void setData(AssetBase assetBase){
        productName.setText(assetBase.getProductName());
        amount.setText(Double.toString(assetBase.getAmount()));
    }

}
