package com.example.dinda.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.dinda.Popup.LayoutPopupError;
import com.example.dinda.R;
import com.example.dinda.Tabs.DashboardActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {


    @BindView(R.id.tiedt_name)
    TextInputEditText tiedtName;
    @BindView(R.id.til_name)
    TextInputLayout tilName;
    @BindView(R.id.et_pass)
    TextInputEditText etPass;
    @BindView(R.id.til_pass)
    TextInputLayout tilPass;
//    @BindView(R.id.cb_show_hide_pass)
//    CheckBox cbShowHidePass;
//    @BindView(R.id.tvc_forgot_pass)
//    TextView tvcForgotPass;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        if (etPass.getText().toString().isEmpty() && etPass.getText().toString().isEmpty()) {
            LayoutPopupError lpeLogin = new LayoutPopupError(getActivity());
            lpeLogin.setCancelable(true);
            lpeLogin.showDialog();
            lpeLogin.tvTitle.setText("Kesalahan");
            lpeLogin.tvKeterangan.setText(Html.fromHtml("Username dan password <br/>tidak boleh kosong."));
            lpeLogin.btnPositive.setVisibility(View.GONE);
            lpeLogin.btnNegativie.setVisibility(View.VISIBLE);
            lpeLogin.btnNegativie.setText("TUTUP");
            lpeLogin.btnNegativie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lpeLogin.dismissDialog();
                }
            });
        } else {

            Intent intent = new Intent(getActivity(), DashboardActivity.class);
            startActivity(intent);
        }
    }
}
