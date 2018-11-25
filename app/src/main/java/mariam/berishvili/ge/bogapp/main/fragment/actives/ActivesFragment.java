package mariam.berishvili.ge.bogapp.main.fragment.actives;

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

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.api.Api;
import mariam.berishvili.ge.bogapp.model.actives.AssetsAndLiabilities;
import mariam.berishvili.ge.bogapp.model.profile.ClientInfo;
import mariam.berishvili.ge.bogapp.network.RetrofitProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivesFragment extends Fragment {
    private RecyclerView recyclerView;
    private ActivesAdapter adapter;
    public static ActivesFragment newInstance(){
        ActivesFragment fragment = new ActivesFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actives, container, false);
        recyclerView = view.findViewById(R.id.fragment_actives_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ActivesAdapter();
        recyclerView.setAdapter(adapter);
        getData();
        return view;
    }

    private void getData(){
        Api api = RetrofitProvider.getRetrofitInstance().create(Api.class);
        api.getAssetsAndLiabilities().enqueue(new Callback<AssetsAndLiabilities>() {
            @Override
            public void onResponse(Call<AssetsAndLiabilities> call, Response<AssetsAndLiabilities> response) {
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<AssetsAndLiabilities> call, Throwable t) {

            }
        });

    }
}
