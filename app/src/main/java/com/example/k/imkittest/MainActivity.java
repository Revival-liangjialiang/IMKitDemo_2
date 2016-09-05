package com.example.k.imkittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class MainActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.startButton);
        String token = "ZnY9eEnjExDDaxaoU8oeeGI+Iy8DRQZA08dLPfqzlzTMNtWxyONd09cWGix0/tKhw+JYwpccAQxlUHqWNvTEO2b0ztB0MeTA";
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                Toast.makeText(MainActivity.this, "Token是错误的！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String s) {
                Toast.makeText(MainActivity.this, "连接成功！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Toast.makeText(MainActivity.this, "连接失败！", Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(RongIM.getInstance()!=null) {
                    RongIM.getInstance().startPrivateChat(MainActivity.this, "ok!", "hello");
                }
            }
        });
    }
}
