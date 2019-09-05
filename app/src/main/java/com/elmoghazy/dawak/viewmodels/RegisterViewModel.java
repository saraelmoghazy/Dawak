package com.elmoghazy.dawak.viewmodels;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.elmoghazy.dawak.models.DrugsResponse;
import com.elmoghazy.dawak.models.RegisterResponse;
import com.elmoghazy.dawak.repostories.remote.ClientServices;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RegisterViewModel extends ViewModel {
    private static final String TAG = "RegisterViewModel";
    private ClientServices clientServices = new ClientServices();
    public enum AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED,          // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }
    final public MutableLiveData<AuthenticationState> authenticationState =  new MutableLiveData<>();
//    public String username;
    final public MutableLiveData<String> usernameLiveData = new MutableLiveData<>();
    String phomeNumber;

    public void setUsername(String username){
        this.usernameLiveData.setValue(username);
    }
    public RegisterViewModel(){
        authenticationState.setValue(AuthenticationState.UNAUTHENTICATED);
        phomeNumber = null;
    }

    public void authenticate(String username, String phoneNumber, String address) {
        this.phomeNumber = phoneNumber;
        authenticationState.setValue(AuthenticationState.AUTHENTICATED);
        this.clientServices.registerClient(username.trim(), phoneNumber.trim(), address.trim())
                .subscribe(new Observer<RegisterResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG,"on subscribe");
                        Log.d(TAG,d.toString());
//                            isLoading.setValue(true);
                    }
                    @Override
                    public void onNext(RegisterResponse registerResponse) {
                     Log.d(TAG,"donee");
                     Log.d(TAG,registerResponse.getUsername());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,"On error retrofit");
                        e.printStackTrace();
//                            getErrorMessage().setValue(e.getMessage());
//                            isLoading.setValue(false);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
//                    response -> {
//                if (response.getUsername()=="") {
//                    Log.d(TAG,"username is empty");
//
//                    authenticationState.setValue(AuthenticationState.AUTHENTICATED);
//                }
//                else {
//                    Log.d(TAG,"username is not empty"+ response.getUsername());
//                    authenticationState.setValue(AuthenticationState.INVALID_AUTHENTICATION);
//                }
//            });
//        }
//        else{
//            authenticationState.setValue(AuthenticationState.INVALID_AUTHENTICATION);
//        }

    }


    public void refuseAuthentication() {
        authenticationState.setValue(AuthenticationState.UNAUTHENTICATED);
    }

//    private boolean validate(String phoneNumber, String username, String password) {
//        if(phoneNumber.length()<11|| username.length()<4 || password.length() < 7)
//            return false;
//        return true;
//    }
}
