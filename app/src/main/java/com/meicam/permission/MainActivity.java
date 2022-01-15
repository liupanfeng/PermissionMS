package com.meicam.permission;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.meicam.mslibrary.OnPermissionCallBack;
import com.meicam.mslibrary.PermissionMS;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPhoneCall(View view) {
        String[] permission = {Manifest.permission.CALL_PHONE};
        PermissionMS.INSTANCE.request(this, permission, new OnPermissionCallBack() {
            @Override
            public void callBack(boolean allGranted, @NotNull ArrayList<String> deniedList) {
                if (allGranted) {
                    phoneCall();
                } else {
                    Toast.makeText(MainActivity.this, "you denied $deniedList", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void phoneCall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:18810765302"));
        startActivity(intent);
    }
}