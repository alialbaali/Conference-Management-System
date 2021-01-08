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

import com.confy.databinding.FragmentSignUpBinding;
import com.google.android.material.snackbar.Snackbar;

public class SignUpFragment extends Fragment {
    FragmentSignUpBinding binding;

    SigningViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(SigningViewModel.class);

        setupObservers();
        setupTextListeners();

        binding.btnSignUp.setOnClickListener(view -> Snackbar.make(binding.getRoot(), "Sign up Button clicked", Snackbar.LENGTH_INDEFINITE)
                .show());

        binding.tvSignIn.setOnClickListener(view -> Snackbar.make(binding.getRoot(), "Sign In Text clicked", Snackbar.LENGTH_INDEFINITE)
                .show());

        return binding.getRoot();
    }

    private void setupObservers() {
        viewModel.getName().observe(getViewLifecycleOwner(), name ->
                binding.etName.setText(name)
        );

        viewModel.getEmail().observe(getViewLifecycleOwner(), email ->
                binding.etEmail.setText(email)
        );

        viewModel.getPassword().observe(getViewLifecycleOwner(), password ->
                binding.etPassword.setText(password)
        );
    }

    private void setupTextListeners() {

        binding.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setName(s.toString());
                binding.etName.setSelection(s.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


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