package com.dragonjic.cubes.events24.ui.activity.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dragonjic.cubes.events24.ui.activity.BasicActivity;
import com.dragonjic.cubes.events24.databinding.ActivityMainRegistrationBinding;

public class MainRegistrationActivity extends BasicActivity {

    private ActivityMainRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

    }
}