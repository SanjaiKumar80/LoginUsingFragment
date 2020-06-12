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


public class Register extends Fragment {
    EditText objUserName, objEmail, objPassword;
    Button btnLogin, btnRegister;
    String username, email, password;
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

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        objUserName = view.findViewById(R.id.regUser);
        objPassword = view.findViewById(R.id.regPass);
        objEmail = view.findViewById(R.id.regEmail);
        btnLogin = view.findViewById(R.id.regLogin);
        btnRegister = view.findViewById(R.id.regReg);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Login fragment = new Login();
                FragmentManager fragmentManager;
                fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = objUserName.getText().toString();
                password = objPassword.getText().toString();
                email = objEmail.getText().toString();
                editor.putString("username",username);
                editor.putString("password",password);
                editor.putString("email",email);
                editor.apply();
                Toast.makeText(getContext(), "Registerd Succesfully", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
