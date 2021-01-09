package com.confy.app.signing;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.confy.app.databinding.FragmentSignInBinding;
import com.google.android.material.snackbar.Snackbar;

public class SignInFragment extends Fragment {

    FragmentSignInBinding binding;
    SigningViewModel viewModel;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSignInBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(SigningViewModel.class);

        setupObservers();
        setupTextListeners();

        binding.btnSignIn.setOnClickListener(view -> Snackbar.make(binding.getRoot(), "Sign In Button clicked", Snackbar.LENGTH_INDEFINITE)
                .show());
        return binding.getRoot();
    }

    private void setupObservers() {

        viewModel.getEmail().observe(getViewLifecycleOwner(), email ->
                binding.etEmail.setText(email)
        );

        viewModel.getPassword().observe(getViewLifecycleOwner(), password ->
                binding.etPassword.setText(password)
        );
    }

    private void setupTextListeners() {

        binding.etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setEmail(s.toString());
                binding.etEmail.setSelection(s.length());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setPassword(s.toString());
                binding.etPassword.setSelection(s.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}