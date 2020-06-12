package com.saturday.newmodelview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class Login extends Fragment {
    EditText objUserName, objPassword;
    Button btnLogin, btnRegister;
    String username, password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onAttach(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("userfile", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        objUserName = view.findViewById(R.id.etUsernmae);
        objPassword = view.findViewById(R.id.etPassword);
        btnLogin = view.findViewById(R.id.idLog);
        btnRegister = view.findViewById(R.id.idReg);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = objUserName.getText().toString();
                password = objPassword.getText().toString();
                String uname, upassword;
                uname = sharedPreferences.getString("username", null);
                upassword = sharedPreferences.getString("password", null);
                if (username.equals(uname) && password.equals(upassword)) {
                    Toast.makeText(getContext(), "Login Sucessfull", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Login is failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register fragment = new Register();
                FragmentManager fragmentManager;
                fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        return view;

    }


}