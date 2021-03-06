package com.eddie.fragmentslogin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment implements View.OnClickListener {

    private TextView emailTxt, passwordTxt;
    private Button loginBtn;
    private Callback callback;

    public WelcomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        emailTxt = view.findViewById(R.id.email_txt);
        passwordTxt = view.findViewById(R.id.password_txt);
        loginBtn = view.findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);

        Bundle args = getArguments();

        if (args != null) {
            emailTxt.setText(args.getString("EMAIL", ""));
            passwordTxt.setText(args.getString("PASSWORD", ""));
        }

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.login_btn && callback != null) {
//            MainActivity activity = (MainActivity) callback;
            callback.onLoginClicked();
        }
    }

    public void setCallback(Callback callback) {

        this.callback = callback;
    }

    public interface Callback {

        void onLoginClicked();
    }
}
