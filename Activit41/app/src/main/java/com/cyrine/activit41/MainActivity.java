package com.cyrine.activit41;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public abstract class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private EditText mName, mPassword;
    private Button btnLogin;
    private CheckBox mCheckBox;
    @Override

    protected void onCreat(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = (EditText) findViewById(R.id.editTextTextPersonName);
        mPassword = (EditText) findViewById(R.id.editTextTextPassword);
        btnLogin = (Button) findViewById(R.id.button);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);

        //mPreferences = getSharedPreferences("com.cyrine.activit41", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
        checkSharedPreferences();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckBox.isChecked()) {
                    mEditor.putString(getString(R.string.Checkbox), "True");
                    mEditor.commit();
                    //SAVE NAME
                    String name = mName.getText().toString();
                    mEditor.putString(getString(R.string.name), name);
                    mEditor.commit();
                    //SAVE PASSWORD
                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password), password);
                    mEditor.commit();
                } else {
                    (mCheckBox.isChecked()){
                    mEditor.putString(getString(R.string.Checkbox), "False");
                    mEditor.commit();
                    //SAVE NAME
                    mEditor.putString(getString(R.string.name), "");
                    mEditor.commit();
                    //SAVE PASSWORD
                    mEditor.putString(getString(R.string.password), "");
                    mEditor.commit();

                }
            }
        });
        }
    }

    private void checkSharedPreferences() {
    }


