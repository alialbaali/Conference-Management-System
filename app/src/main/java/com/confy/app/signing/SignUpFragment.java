package com.confy.app.signing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.confy.app.R;
import com.confy.app.databinding.FragmentSignUpBinding;
import com.google.android.material.snackbar.Snackbar;

public class SignUpFragment extends Fragment {
    FragmentSignUpBinding binding;

    SigningViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(SigningViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        setupObservers();

        binding.btnSignUp.setOnClickListener(view -> {
                    String name = binding.etName.getText().toString();
                    String email = binding.etEmail.getText().toString();
                    String password = binding.etPassword.getText().toString();

                    if (name.isEmpty())
                        binding.tilName.setError(getString(R.string.empty_name));
                    if (email.isEmpty())
                        binding.tilEmail.setError(getString(R.string.empty_email));
                    if (password.isEmpty())
                        binding.tilPassword.setError(getString(R.string.empty_password));
                    if (!(name.isEmpty() && email.isEmpty() && password.isEmpty())) {
//                        binding.btnSignUp.setEnabled(false);
                        viewModel.signUp();
                    }
                }
        );

        binding.tvSignIn.setOnClickListener(view ->
                NavHostFragment.findNavController(this)
                        .navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
        );

        return binding.getRoot();
    }

    private void setupObservers() {
        viewModel.getName().observe(getViewLifecycleOwner(), name -> {
            if (!name.isEmpty()) {
                binding.tilName.setError(null);
            }
        });

        viewModel.getEmail().observe(getViewLifecycleOwner(), email -> {
                    if (!email.isEmpty()) {
                        binding.tilEmail.setError(null);
                    }
                }
        );

        viewModel.getPassword().observe(getViewLifecycleOwner(), password -> {
                    if (!password.isEmpty()) {
                        binding.tilPassword.setError(null);
                    }
                }
        );
        viewModel.shouldNavigate().observe(getViewLifecycleOwner(), value -> {
                    if (value) {
                        Snackbar.make(binding.getRoot(), "Congrats you signed up!", Snackbar.LENGTH_INDEFINITE)
                                .show();
                    }
                }
//                        NavHostFragment.findNavController(this).navigate()
        );
        viewModel.getError().observe(getViewLifecycleOwner(), error ->
                Snackbar.make(binding.getRoot(), error, Snackbar.LENGTH_SHORT)
                        .show()
        );
    }

}