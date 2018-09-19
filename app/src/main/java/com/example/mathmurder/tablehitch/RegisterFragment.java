package com.example.mathmurder.tablehitch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class RegisterFragment extends android.support.v4.app.Fragment {
    private EditText  mEmailRegistration, mPasswordRegistration
            , mNameRegistration, mAgeRegistration, mProfileRegistration, reenterPassword;


    private RadioGroup sexChoice;
    private String sex;
    private Button mButtonRegistration;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View registerFragmentView = inflater.inflate(R.layout.register_fragment, container, false);



        mEmailRegistration = (EditText) registerFragmentView.findViewById(R.id.emailRegistration);
        mPasswordRegistration = (EditText) registerFragmentView.findViewById(R.id.passwordRegistration);
        mNameRegistration = (EditText) registerFragmentView.findViewById(R.id.nameRegistration);
        mAgeRegistration = (EditText) registerFragmentView.findViewById(R.id.ageRegistration);
        mProfileRegistration = (EditText) registerFragmentView.findViewById(R.id.profileRegistration);
        reenterPassword = (EditText) registerFragmentView.findViewById(R.id.reenterPassword);


        sexChoice = (RadioGroup) registerFragmentView.findViewById(R.id.sexRegistration);
        sexChoice.check(R.id.male);
        sexChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.male) {
                    sex = "Male";

                    Toast.makeText(getContext(), "choice: male",

                            Toast.LENGTH_SHORT).show();

                } else if(checkedId == R.id.female) {
                    sex = "Female";
                    Toast.makeText(getContext(), "choice: female",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });

        mButtonRegistration = (Button) registerFragmentView.findViewById(R.id.buttonRegistration);


        mButtonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String password = mPasswordRegistration.getText().toString();
                final String email = mEmailRegistration.getText().toString();
                final String age = mAgeRegistration.getText().toString();
                final String name = mNameRegistration.getText().toString();
                final String profile = mProfileRegistration.getText().toString();
                final String reenterPw = reenterPassword.getText().toString();

                //final String email, final String name, final String age, final String password, final String sex, final String profile
                if(validate(name, password, email, age, reenterPw)) {
                    ((LoginAndRegisterActivity)getActivity()).register(email, name, age, password, sex, profile);
                }

            }
        });

        return registerFragmentView;
    }


    public boolean validate(String name, String password, String email, String age, String reEnterPassword) {
        boolean valid = true;


        if (name.isEmpty() || name.length() < 3) {
            mNameRegistration.setError("at least 3 characters");
            valid = false;
        } else {
            mNameRegistration.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmailRegistration.setError("enter a valid email address");
            valid = false;
        } else {
            mEmailRegistration.setError(null);
        }

        if (age.isEmpty() || age.length()!=2) {
            mAgeRegistration.setError("Enter Valid Age");
            valid = false;
        } else {
            mAgeRegistration.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            mPasswordRegistration.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            mPasswordRegistration.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            reenterPassword.setError("Password Do not match");
            valid = false;
        } else {
            reenterPassword.setError(null);
        }

        return valid;
    }
}
