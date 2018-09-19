package com.example.mathmurder.tablehitch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends android.support.v4.app.Fragment  {

    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    private EditText mEmailLogin, mPasswordLogin;

    private Button mButtonLogin;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View loginFragmentView = inflater.inflate(R.layout.login_fragment, container, false);

        mEmailLogin = (EditText) loginFragmentView.findViewById(R.id.emailLogin);
        mPasswordLogin = (EditText) loginFragmentView.findViewById(R.id.passwordLogin);


        mButtonLogin = (Button) loginFragmentView.findViewById(R.id.buttonLogin);


        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailLogin.getText().toString();
                String password = mPasswordLogin.getText().toString();
                if(validateInput()) {
                    ((LoginAndRegisterActivity)getActivity()).login(email, password);
                }

            }
        });


        return loginFragmentView;
    }


    public boolean validateInput() {
        boolean valid = true;

        String email = mEmailLogin.getText().toString();
        String password = mPasswordLogin.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmailLogin.setError("enter a valid email address");
            valid = false;
        } else {
            mEmailLogin.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            mPasswordLogin.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            mPasswordLogin.setError(null);
        }

        return valid;
    }




}
