package mariam.berishvili.ge.bogapp.main.fragment.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.api.Api;
import mariam.berishvili.ge.bogapp.model.profile.ClientAddress;
import mariam.berishvili.ge.bogapp.model.profile.ClientInfo;
import mariam.berishvili.ge.bogapp.network.RetrofitProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {
    private TextView firstNameValue;
    private TextView lastNameValue;
    private TextView genderValue;
    private TextView birthDateValue;
    private TextView clientCategoryValue;
    private TextView phoneValue;
    private TextView addressValue;
    private TextView mailValue;

    public static ProfileFragment newInstance(){
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initViewComponents(view);
        getClientInfo();
        return view;
    }

    private void initViewComponents(View view){
        firstNameValue = view.findViewById(R.id.fragment_profile_value_first_name);
        lastNameValue = view.findViewById(R.id.fragment_profile_value_last_name);
        genderValue = view.findViewById(R.id.fragment_profile_value_gender);
        birthDateValue = view.findViewById(R.id.fragment_profile_value_birthday);
        clientCategoryValue = view.findViewById(R.id.fragment_profile_value_category);
        phoneValue = view.findViewById(R.id.fragment_profile_value_phone);
        addressValue = view.findViewById(R.id.fragment_profile_value_address);
        mailValue = view.findViewById(R.id.fragment_profile_value_mail);
    }

    private void getClientInfo(){
        Api api = RetrofitProvider.getRetrofitInstance().create(Api.class);
        api.getClientInfo().enqueue(new Callback<ClientInfo>() {
            @Override
            public void onResponse(Call<ClientInfo> call, Response<ClientInfo> response) {
                if(response.isSuccessful()){
                    fillViewComponentsWithData(response.body());
                }
            }


            @Override
            public void onFailure(Call<ClientInfo> call, Throwable t) {

            }
        });
    }

    private void fillViewComponentsWithData(ClientInfo clientInfo){
        firstNameValue.setText(clientInfo.getClient().getFirstName());
        lastNameValue.setText(clientInfo.getClient().getLastName());
        genderValue.setText(clientInfo.getClient().getSex());

        Date birthDate = new Date(clientInfo.getClient().getBirthDate());
        SimpleDateFormat dt1 = new SimpleDateFormat("dd.mm.yyyy");
        birthDateValue.setText(dt1.format(birthDate));

        clientCategoryValue.setText(clientInfo.getClient().getClientCategory());
        phoneValue.setText(clientInfo.getClientPhones().get(0).getMobile());
        if(clientInfo.getClientAddresses().size() > 0){
            ClientAddress address = clientInfo.getClientAddresses().get(0);
            addressValue.setText(address.getStreet() + " " +
                                address.getBuilding() + " " +
                                address.getAppartment());
        }
        if(clientInfo.getClientPhones().size() > 0){
            phoneValue.setText(clientInfo.getClientPhones().get(0).getMobile());
        }
        if(clientInfo.getClientMails().size() > 0){
            mailValue.setText(clientInfo.getClientMails().get(0).getMail());
        }

    }

}
