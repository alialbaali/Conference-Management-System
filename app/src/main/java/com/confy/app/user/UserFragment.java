package com.confy.app.user;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.confy.app.R;
import com.confy.app.databinding.FragmentUserBinding;
import com.confy.app.utils.SharedPreferencesUtils;

public class UserFragment extends Fragment {
    FragmentUserBinding binding;
    UserViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUserBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(viewModel);

        Glide.with(this)
                .load(viewModel.getUser().getValue().imageUrl)
                .error(R.drawable.ic_round_person_24)
                .placeholder(R.drawable.ic_round_person_24)
                .into(binding.img);

        setupListeners();
        return binding.getRoot();
    }

    private void setupListeners() {
        binding.signOut.setOnClickListener(view ->
                signOut()
        );

        binding.tvChangeProfile.setOnClickListener(view ->
                NavHostFragment.findNavController(this)
                        .navigate(UserFragmentDirections.actionUserFragmentToChangeProfileBottomSheetDialog())
        );

        binding.tvChangePassword.setOnClickListener(view ->
                NavHostFragment.findNavController(this)
                        .navigate(UserFragmentDirections.actionUserFragmentToChangePasswordBottomSheetDialog())
        );
    }


    private void signOut() {
        viewModel.signOut();

        requireContext()
                .getSharedPreferences(SharedPreferencesUtils.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(SharedPreferencesUtils.IS_USER_SIGNED_IN, false)
                .apply();

        NavController controller = NavHostFragment.findNavController(this);

        controller.navigate(UserFragmentDirections.actionUserFragmentToSignUpFragment());

    }
}
