package com.confy.app.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.confy.app.BaseBottomSheetDialogFragment;
import com.confy.app.databinding.FragmentChangePasswordBinding;

public class ChangePasswordBottomSheetDialog extends BaseBottomSheetDialogFragment {
    FragmentChangePasswordBinding binding;
    UserViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentChangePasswordBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(viewModel);



        return binding.getRoot();
    }
}
