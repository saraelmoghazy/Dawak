package com.elmoghazy.dawak;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.elmoghazy.dawak.viewmodels.RegisterViewModel;
import com.google.android.material.snackbar.Snackbar;

/**
 * Created by Asmaa Hassan.
 */
public class RegisterFragment extends Fragment {
    private RegisterViewModel registerViewModel;
    private EditText phoneNumberEditText;
//    private EditText codeEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private static final String TAG = "RegisterFragment";
    private Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerViewModel = ViewModelProviders.of(requireActivity()).get(RegisterViewModel.class);
        phoneNumberEditText = view.findViewById(R.id.phone_number);
        usernameEditText = view.findViewById(R.id.username);
        passwordEditText = view.findViewById(R.id.password);
        submitButton = view.findViewById(R.id.register_button);
        final NavController navController = Navigation.findNavController(view);
        final View root = view;
        registerViewModel.authenticationState.observe(getViewLifecycleOwner(),authenticationState -> {
            switch (authenticationState) {
                case AUTHENTICATED:
                    Log.d(TAG,"AUTHENTICATED");
                    navController.navigate(R.id.home_fragment);
                    break;
                case INVALID_AUTHENTICATION:
                    Log.d(TAG,"INVALID_AUTHENTICATION");
                    Snackbar.make(root, "invalid credintials", Snackbar.LENGTH_SHORT).show();
                    break;
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        Log.d(TAG,"onBack presses");
                        registerViewModel.refuseAuthentication();
                        navController.popBackStack();
                        Log.d(TAG,"after onBack presses");
                    }
                });
        submitButton.setOnClickListener(v ->
                registerViewModel.authenticate(phoneNumberEditText.getText().toString(),usernameEditText.getText().toString(),passwordEditText.getText().toString()));
    }

    public void register(View view){
        Log.d(TAG,"register method");
        registerViewModel.authenticate(phoneNumberEditText.getText().toString(),usernameEditText.getText().toString(),passwordEditText.getText().toString());
    }
}
