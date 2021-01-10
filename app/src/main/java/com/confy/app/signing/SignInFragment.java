package com.confy.app.signing;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.confy.app.R;
import com.confy.app.databinding.FragmentSignInBinding;
import com.confy.app.utils.SharedPreferencesUtils;
import com.google.android.material.snackbar.Snackbar;

public final class SignInFragment extends Fragment {

    private FragmentSignInBinding binding;
    private SigningViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSignInBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(SigningViewModel.class);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(viewModel);

        setupObservers();
        setupListeners();
        binding.btnSignIn.setOnClickListener(view -> Snackbar.make(binding.getRoot(), "Sign In Button clicked", Snackbar.LENGTH_INDEFINITE)
                .show());

        binding.tvSignUp.setOnClickListener(view ->
                NavHostFragment.findNavController(this)
                        .navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        );

        return binding.getRoot();
    }

    private void setupListeners() {

        binding.btnSignIn.setOnClickListener(view -> {

                    String email = binding.etEmail.getText().toString();
                    String password = binding.etPassword.getText().toString();

                    if (email.isEmpty())
                        binding.tilEmail.setError(getString(R.string.empty_email));
                    if (password.isEmpty())
                        binding.tilPassword.setError(getString(R.string.empty_password));

                    if (!email.isEmpty() && !password.isEmpty()) {
                        binding.btnSignIn.setEnabled(false);
                        viewModel.signIn();
                    }

                }
        );


        binding.tvSignUp.setOnClickListener(view ->
                NavHostFragment.findNavController(this)
                        .navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        );
    }

    private void setupObservers() {
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
        viewModel.shouldNavigate().observe(getViewLifecycleOwner(), sholdNavigate -> {
                    if (sholdNavigate) {

                        requireContext().getSharedPreferences(SharedPreferencesUtils.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
                                .edit()
                                .putBoolean(SharedPreferencesUtils.IS_USER_SIGNED_IN, true)
                                .apply();

                        NavHostFragment.findNavController(this)
                                .navigate(SignInFragmentDirections.actionSignInFragmentToConferenceListFragment());
                    }
                }
        );
        viewModel.getError().observe(getViewLifecycleOwner(), error -> {
                    if (!error.isEmpty()) {
                        binding.btnSignIn.setEnabled(true);
                        Snackbar.make(binding.getRoot(), error, Snackbar.LENGTH_SHORT)
                                .show();
                    }
                }
        );
    }
}
