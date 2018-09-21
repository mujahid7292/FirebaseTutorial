package com.sand_corporation.www.firebasetutorial.Welcome;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sand_corporation.www.firebasetutorial.R;
import com.sand_corporation.www.firebasetutorial.SignIn.SignInActivity;
import com.sand_corporation.www.firebasetutorial.SignUp.SignUpActivity;
import com.sand_corporation.www.firebasetutorial.Welcome.Presenter.WelcomeActivityPresenter;
import com.sand_corporation.www.firebasetutorial.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding welcomeBinding;
    private static final String TAG = "WelcomeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        welcomeBinding = DataBindingUtil.setContentView(this,R.layout.activity_welcome);
        setPresenterForThisView();
        Intent intent = new Intent(this,SignInActivity.class);
    }

    private void setPresenterForThisView() {
        welcomeBinding.setWelcomePresenter(new WelcomeActivityPresenter() {
            @Override
            public void onClickUserSignIn() {
                Log.i(TAG,"onClickUserSignIn() clicked");
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
            }

            @Override
            public void onClickUserSignUp() {
                Log.i(TAG,"onClickUserSignUp clicked");
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
