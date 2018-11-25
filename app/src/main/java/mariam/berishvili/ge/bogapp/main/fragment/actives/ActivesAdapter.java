package mariam.berishvili.ge.bogapp.main.fragment.actives;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.model.actives.AssetBase;
import mariam.berishvili.ge.bogapp.model.actives.AssetsAndLiabilities;

public class ActivesAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CELL_TITLE = 0;
    private static final int CELL_ASSET = 1;
    private List<List<AssetBase>> assetsLists = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i){
            case CELL_ASSET:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_actives_cell_item_active, viewGroup, false);
                return  new ItemActiveViewHolder(view);
            case CELL_TITLE:
            default:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_actives_cell_category_name, viewGroup, false);
                return  new TitleViewHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        AssetBase data = getData(i);
        if( getItemViewType(i) == CELL_TITLE) {
            ((TitleViewHolder)viewHolder).setData(data.getTitle());
        }else {
            ((ItemActiveViewHolder)viewHolder).setData(data);
        }
    }

    @Override
    public int getItemCount() {
        int size = assetsLists.size();
        for(List list : assetsLists) {
            size += list.size();
        }
        return size;
    }

    @Override
    public int getItemViewType(int position) {
        for (List<AssetBase> list : assetsLists){
            if(position == 0) {
                return CELL_TITLE;
            }else{
                position --;
            }
            if( position < list.size()) return CELL_ASSET;
            else position -= list.size();
        }
        return CELL_ASSET;
    }

    private AssetBase getData(int pos){
        int position = pos;
        for (List<AssetBase> list : assetsLists){
            if(position == 0) {
                return list.get(0);
            }else {
                position --;
            }
            if(position < list.size()){
                return list.get(position);
            }
            else position -= list.size();
        }
        return null;
    }

    public void setData(AssetsAndLiabilities assetsAndLiabilities){
        assetsLists.clear();
        for(List<AssetBase > list : assetsAndLiabilities.getAssetLists() ){
            ArrayList<AssetBase> l = new ArrayList();
            l.addAll(list);
            assetsLists.add(l);
        }
        notifyDataSetChanged();
    }
}
