package com.eddie.fragmentslogin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PasswordFragment extends Fragment implements View.OnClickListener {

    private EditText inputPassword;
    private Button backBtn, okBtn;
    private Callback callback;

    public PasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_password, container, false);
        inputPassword = view.findViewById(R.id.password_in);
        backBtn = view.findViewById(R.id.back_btn);
        okBtn = view.findViewById(R.id.ok_btn);
        backBtn.setOnClickListener(this);
        okBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.back_btn && callback != null) {

            callback.onPasswordBackClick();

        } else if (v.getId() == R.id.ok_btn && callback != null) {

            callback.onPasswordOkCLick(inputPassword.getText().toString());
        }
    }

    public void setCallback(Callback callback) {

        this.callback = callback;
    }

    public interface Callback {

        void onPasswordBackClick();
        void onPasswordOkCLick(String password);
    }
}
