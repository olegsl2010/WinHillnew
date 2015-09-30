package pro.winhill.winhillnew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import pro.winhill.winhillnew.logInFragment.LoginFrame;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(null);
            setContentView(R.layout.activity_main);



            Button logo = (Button) findViewById(R.id.logo);
            Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
            logo.startAnimation(hyperspaceJumpAnimation);

            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
                            .replace(R.id.container, new LoginFrame(), "LoginMenu")
                            .commit();
                }
            });
        }
    }