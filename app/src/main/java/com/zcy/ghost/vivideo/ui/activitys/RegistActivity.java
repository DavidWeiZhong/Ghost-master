package com.zcy.ghost.vivideo.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zcy.ghost.vivideo.R;
import com.zcy.ghost.vivideo.utils.SharedUtil;

/**
 * Created by ${qiuweizhong} on 2017/4/8.
 */
public class RegistActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    Button btn_regist;

    private String username;
    private String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
    }

    public void initView() {
        et_username = (EditText) findViewById(R.id.et_register_username);
        et_password = (EditText) findViewById(R.id.et_register_password);
        btn_regist = (Button) findViewById(R.id.btn_register);
    }

    public void btnclick(View view) {

        username = et_username.getText().toString();
        password = et_password.getText().toString();
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_register:
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(this, "用户名不能为空哦!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "密码不能为空哦!", Toast.LENGTH_LONG).show();
                    return;
                }
                //进行注册了
                SharedUtil.putString("username", username);
                SharedUtil.putString("password", password);
                Toast.makeText(this, "注册成功，请牢记密码!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, LoginActivity.class));
        }
    }

}
