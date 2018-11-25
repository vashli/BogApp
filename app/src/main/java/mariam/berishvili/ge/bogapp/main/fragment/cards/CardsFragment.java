package mariam.berishvili.ge.bogapp.main.fragment.cards;

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

import java.util.List;

import javax.security.auth.callback.Callback;

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.api.Api;
import mariam.berishvili.ge.bogapp.model.cards.Card;
import mariam.berishvili.ge.bogapp.network.RetrofitProvider;
import retrofit2.Call;
import retrofit2.Response;

public class CardsFragment extends Fragment {
    private RecyclerView recyclerView;
    private CardsAdapter adapter;

    public static CardsFragment newInstance(){
        CardsFragment fragment = new CardsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cards, container, false);
        recyclerView = view.findViewById(R.id.fragment_cards_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new CardsAdapter();
        recyclerView.setAdapter(adapter);
        getData();
        return view;
    }

    private void getData(){
        Api api = RetrofitProvider.getRetrofitInstance().create(Api.class);
        api.getCards().enqueue(new retrofit2.Callback<List<Card>>() {
            @Override
            public void onResponse(Call<List<Card>> call, Response<List<Card>> response) {
                Log.d("xxx", "succ" + response.body().size());
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<Card>> call, Throwable t) {

            }
        });
    }
}
