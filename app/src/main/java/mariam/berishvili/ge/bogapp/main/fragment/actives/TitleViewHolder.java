package mariam.berishvili.ge.bogapp.main.fragment.actives;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.model.actives.Asset;

public class TitleViewHolder extends RecyclerView.ViewHolder {
    private TextView title;

    public TitleViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.fragment_actives_cell_category_name_title);
    }

    public void setData(String title){
        this.title.setText(title);
    }
}
