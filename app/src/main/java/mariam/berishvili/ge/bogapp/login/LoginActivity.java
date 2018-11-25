package mariam.berishvili.ge.bogapp.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.main.MainActivity;
import mariam.berishvili.ge.bogapp.model.login.ClientLoginInfo;


public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView{
    private EditText username;
    private EditText password;
    private Button loginButton;
    private LoginContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenterImpl(this, new LoginIntractorImpl());
        initView();
    }

    private void initView(){
        username = findViewById(R.id.login_activity_username_exit_text);
        password = findViewById(R.id.login_activity_password_exit_text);
        loginButton = findViewById(R.id.login_activity_login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.fetchLoginDataFromServer(username.getText().toString(), password.getText().toString());
            }
        });
    }

    @Override
    public void onLoginSuccess(ClientLoginInfo loginInfo) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        showToast(R.string.login_activity_unable_login_toast_text);
    }

    @Override
    public void onInvalidUsernamePassword() {
        showToast(R.string.login_activity_invalid_username_password_toast_text);
    }


    private void showToast(int stringResourceId){
        Toast toast = Toast.makeText(this, stringResourceId, Toast.LENGTH_SHORT);
        TextView v = toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        toast.show();
    }
}
