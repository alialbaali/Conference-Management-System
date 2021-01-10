package com.confy.app;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.confy.app.databinding.ActivityMainBinding;
import com.confy.app.utils.SharedPreferencesUtils;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        boolean isUserSignedIn = getSharedPreferences(SharedPreferencesUtils.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
                .getBoolean(SharedPreferencesUtils.IS_USER_SIGNED_IN, false);

        if (isUserSignedIn) {
            NavController controller = Navigation.findNavController(this, R.id.nav_host_fragment);
            controller.popBackStack();
            controller.navigate(R.id.conferenceListFragment);
        }
    }
}