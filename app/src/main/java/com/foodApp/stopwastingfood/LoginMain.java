package com.foodApp.stopwastingfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.CallbackManager;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginMain extends AppCompatActivity implements View.OnClickListener {
    Button btnSignIn, cancelBtn,loginFb;
    EditText email,pass;
    private Button FacebookButton;
    private CircleImageView circleImageView;
    private TextView txtFbName,txtFbEmail;
    private CallbackManager callBackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        email = (EditText) findViewById(R.id.enterEmail);
        pass = (EditText) findViewById(R.id.enterLoginPassword);

        cancelBtn = (Button) findViewById(R.id.btnCancel);
        btnSignIn = (Button) findViewById(R.id.btnLogin);
        loginFb = (Button) findViewById(R.id.fb_login_button);
        /*callBackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callBackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });*/

        btnSignIn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        loginFb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCancel:
                startActivity(new Intent(this, Dashboard.class));
                break;
        }
        switch (v.getId()){
            case R.id.btnLogin:
                startActivity(new Intent(this, ShowData.class));
                break;
        }
        switch (v.getId()){
            case R.id.fb_login_button:
                startActivity(new Intent(this, LogInWithFacebook.class));
                break;
        }
    }
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callBackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
    AccessTokenTracker tokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

        }
    };
    private void loadUserProfile(AccessToken newAccessToken){

        GraphRequest request= GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String firstName=object.getString("first_name");
                    String lastName=object.getString("last_name");
                    String email=object.getString("email");
                    String id=object.getString("id");
                    String imageUrl="https://graphfacebook.com/"+id+"/picture?type=normal";

                    email.setText(email);
                }
                catch (JSONException e){
                    e.printStackTrace();
                }

            }
        });
        Bundle parameters= new Bundle();
        parameters.putString("fields","first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();
    }*/
}
