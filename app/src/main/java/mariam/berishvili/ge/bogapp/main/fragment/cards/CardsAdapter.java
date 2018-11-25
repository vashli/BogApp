package mariam.berishvili.ge.bogapp.main.fragment.cards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.model.cards.Card;

public class CardsAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private List<Card> cards = new ArrayList<>();
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_cards_cell, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        cardViewHolder.setData(cards.get(i));
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public void setData(List<Card> cards){
        this.cards.clear();
        this.cards.addAll(cards);
        notifyDataSetChanged();
    }
}
