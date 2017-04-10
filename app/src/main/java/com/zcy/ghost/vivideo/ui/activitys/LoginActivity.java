package com.zcy.ghost.vivideo.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zcy.ghost.vivideo.R;
import com.zcy.ghost.vivideo.utils.SharedUtil;

/**
 * Created by ${qiuweizhong} on 2017/4/8.
 */
public class LoginActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    Button btn_login;
    Button btn_regist;
    TextView tv_forgit;
    private String mUsername;
    private String mPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        mUsername = SharedUtil.getString("username");
        mPassword = SharedUtil.getString("password");
        if (SharedUtil.getString("username") != null && SharedUtil.getString("password") != null) {
            et_username.setText(mUsername);
            et_password.setText(mPassword);
            Log.d("print", "" + mUsername + "---" + mPassword);
        }

//        Explode explode = new Explode();
//        explode.setDuration(5000);
//        getWindow().setEnterTransition(explode);

    }

    public void initView() {
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_username);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_regist = (Button) findViewById(R.id.btn_regist);

    }

//    @OnClick({R.id.btn_login, R.id.btn_regist})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_login:
                if (TextUtils.isEmpty(et_password.getText()) || TextUtils.isEmpty(et_username.getText())) {
                    Toast.makeText(this, "请输入用户名密码", Toast.LENGTH_LONG).show();
                    return;
                }

                if (SharedUtil.getString("username") != null && SharedUtil.getString("password") != null) {
                    Log.d("print", "" + et_username.getText() + "---" + et_password.getText());
                    if (mUsername.equals(et_username.getText().toString()) && mPassword.equals(et_password.getText().toString())) {
                        //登陆成功
                        Toast.makeText(this, "登陆成功", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(this, WelcomeActivity.class));
                        SharedUtil.putString("username", et_username.getText().toString());
                        SharedUtil.putString("password", et_password.getText().toString());
                        return;
                    } else {
                        Toast.makeText(this, "请输入正确的用户名密码", Toast.LENGTH_LONG).show();
                    }
                }
                Toast.makeText(this, "没有该用户，请先注册！", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_regist:
                startActivity(new Intent(this, RegistActivity.class));
                break;
        }
    }
}
