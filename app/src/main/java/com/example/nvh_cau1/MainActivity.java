package com.example.nvh_cau1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtTaiKhoan,edtMatKhau;
    private Button btnDangNhap,btnThoat;
    private CheckBox cboLuuThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTaiKhoan = (EditText) findViewById(R.id.edtTaiKhoan);
        edtMatKhau = (EditText) findViewById(R.id.edtMatKhau);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        cboLuuThongTin = (CheckBox) findViewById(R.id.cboLuuThongTin);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        final AlertDialog.Builder myDialog =  new AlertDialog.Builder(this);
        myDialog.setTitle("Thông báo");
        myDialog.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        myDialog.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTaiKhoan.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(),"Không được để trống tài khoản"+edtTaiKhoan.getText(),Toast.LENGTH_LONG);
                    toast.show();
                    myDialog.setMessage("Không được để trống tài khoản");
                    AlertDialog alertDialog = myDialog.create();
                    alertDialog.show();
                }
                else if(edtMatKhau.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(),"Không được để trống mật khẩu",Toast.LENGTH_LONG);
                    toast.show();
                    myDialog.setMessage("Không được để trống mật khẩu");
                    AlertDialog alertDialog = myDialog.create();
                    alertDialog.show();
                }
                else {
                    if(cboLuuThongTin.isChecked()){
                        Toast toast = Toast.makeText(getApplicationContext(),"Chào mừng bạn đã đăng nhập vào hệ thống,thông tin của bạn đã được lưu",Toast.LENGTH_LONG);
                        toast.show();
                        myDialog.setMessage("Chào mừng bạn đã đăng nhập vào hệ thống \n thông tin của bạn đã được lưu");
                        AlertDialog alertDialog = myDialog.create();
                        alertDialog.show();
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(),"Chào mừng bạn đã đăng nhập vào hệ thống,thông tin của bạn không được lưu",Toast.LENGTH_LONG);
                        toast.show();
                        myDialog.setMessage("Chào mừng bạn đã đăng nhập vào hệ thống \n thông tin của bạn không được lưu");
                        AlertDialog alertDialog = myDialog.create();
                        alertDialog.show();
                    }
                }

            }
        });
        final AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn thoát không?");

        builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog alertDialog = builder.create();
                alertDialog.dismiss();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}