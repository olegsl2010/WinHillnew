package pro.winhill.winhillnew.logInFragment;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pro.winhill.winhillnew.GeneralActivity;
import pro.winhill.winhillnew.R;


public class LoginFrame extends Fragment implements View.OnClickListener {

    String secretKey = "XMzDdG4D03CKm2IxIWQw7g==";


    View rootView;
    Button forgot_pass_butt;
    //    Button sign_up_butt;
    Button lunch_demo_butt;
    private AsyncTask<String, String, String> asyncTask;
    Button log_in_butt;
    protected EditText email, pass;
    android.support.v4.app.FragmentTransaction fragManager;
    private String response;
    private static Context context;
    private String resp;
    private String errorMsg;
    String TAG = "LoginFrame";




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.login_frame, container, false);

        forgot_pass_butt = (Button) rootView.findViewById(R.id.forgot_pass_butt);
//        sign_up_butt = (Button) rootView.findViewById(R.id.sign_up_butt);
        lunch_demo_butt = (Button) rootView.findViewById(R.id.lunch_demo_butt);
        log_in_butt = (Button) rootView.findViewById(R.id.log_in_butt);
        email =(EditText) rootView.findViewById(R.id.email);
        pass = (EditText) rootView.findViewById(R.id.password);

        forgot_pass_butt.setOnClickListener(this);
//        sign_up_butt.setOnClickListener(this);
        lunch_demo_butt.setOnClickListener(this);
        log_in_butt.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        Context context = v.getContext();

        fragManager = getFragmentManager().beginTransaction();


        switch (v.getId()) {
            case R.id.forgot_pass_butt:

//                fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
//                fragManager.replace(R.id.container, new ForgotPassword());
//                fragManager.addToBackStack(null);

                break;
//            case R.id.sign_up_butt:

//                fragManager.replace(R.id.container, new SignUp());
//                break;
            case R.id.lunch_demo_butt:

                Intent intent = new Intent(context, GeneralActivity.class);
                context.startActivity(intent);



//                fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
//                fragManager.replace(R.id.container, new WalletStartButton()); // не тооо

                break;
            case R.id.log_in_butt:

                final String getEmail = email.getText().toString();
                final String getPass = pass.getText().toString();
                ValidatorLogIn logIn = new ValidatorLogIn();




                if (logIn.isValidEmail(getEmail) && logIn.isValidPassword(getPass)== true) {
                    email.setError(response);
                }
                else
                {
                    if(logIn.isValidEmail(getEmail)!=true){
                        email.setError("Invalid Email");}
                    if(logIn.isValidPassword(getPass)!=true){
                        pass.setError("Pass must cont +6");}
                }
                break;
        }
        fragManager.commit();
    }

}
