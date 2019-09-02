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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jakewharton.rxbinding2.widget.RxTextView;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Asmaa Hassan.
 */
public class RegisterFragment extends Fragment {
    private RegisterViewModel registerViewModel;
    private EditText usernameEditText;
    private EditText phoneNumberEditText;
    private EditText addressEditText;
    private EditText codeEditText;
    private static final String TAG = "RegisterFragment";
    private FloatingActionButton submitButton;
    Observable<Boolean> observable;


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
        addressEditText = view.findViewById(R.id.address);
        submitButton = view.findViewById(R.id.confirm_button);
        Observable<String> nameObservable = RxTextView.textChanges(usernameEditText).skip(1).map(new Function<CharSequence, String>() {
            @Override
            public String apply(CharSequence charSequence) throws Exception {
                return charSequence.toString();
            }
        });
        Observable<String> phoneNumberObservable = RxTextView.textChanges(phoneNumberEditText).skip(1).map(new Function<CharSequence, String>() {
            @Override
            public String apply(CharSequence charSequence) throws Exception {
                return charSequence.toString();
            }
        });
        Observable<String> addressObservable = RxTextView.textChanges(addressEditText).skip(1).map(new Function<CharSequence, String>() {
            @Override
            public String apply(CharSequence charSequence) throws Exception {
                return charSequence.toString();
            }
        });


        observable = Observable.combineLatest(nameObservable, phoneNumberObservable, addressObservable, new Function3<String, String, String, Boolean>() {
            @Override
            public Boolean apply(String s, String s2, String s3) throws Exception {
                return isValidForm(s, s2, s3);

            }
        });

        observable.subscribe(new DisposableObserver<Boolean>() {
            @Override
            public void onNext(Boolean aBoolean) {
                updateButton(aBoolean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


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
//        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
//                new OnBackPressedCallback(true) {
//                    @Override
//                    public void handleOnBackPressed() {
//                        Log.d(TAG,"onBack presses");
//                        registerViewModel.refuseAuthentication();
//                        navController.popBackStack();
//                        Log.d(TAG,"after onBack presses");
//                    }
//                });
        submitButton.setOnClickListener(v ->
                registerViewModel.authenticate(usernameEditText.getText().toString(),phoneNumberEditText.getText().toString(), addressEditText.getText().toString()));
    }

//    public void register(View view){
//        Log.d(TAG,"register method");
//        registerViewModel.authenticate(phoneNumberEditText.getText().toString(),usernameEditText.getText().toString(), addressEditText.getText().toString());
//    }

    public void updateButton(boolean valid) {
        if (valid)
            submitButton.setEnabled(true);
    }

    public boolean isValidForm(String name, String phoneNumber, String address) {
        boolean validName = !name.isEmpty();
        if (!validName) {
            usernameEditText.setError("Please enter valid name");
        }
        boolean validPhoneNumber = phoneNumber.length()>=11;
        if (!validPhoneNumber) {]

            phoneNumberEditText.setError("Incorrect phone number");
        }
        boolean validAddress = !address.isEmpty();
        if (!validAddress) {
            addressEditText.setError("Please enter valid valid address");
        }
        return validName && validPhoneNumber && validAddress;
    }


}
