package kieunga.com.hoctabselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    EditText edtUser, edtPassword;
    Button btnDangNhap, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("t1"))
                {
                    Toast.makeText(MainActivity.this,"Bạn chọn tab đăng nhập", Toast.LENGTH_LONG).show();
                }
                else if(tabId.equals("t2"))
                {
                    Toast.makeText(MainActivity.this, "Bạn chọn tab hướng dẫn",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyDangNhap();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void xuLyDangNhap() {
        Toast.makeText(MainActivity.this,"User Name: "+edtUser.getText().toString()+", Password: "+edtPassword.getText().toString(),Toast.LENGTH_LONG).show();

    }

    private void addControls() {
        tabHost=findViewById(R.id.tabhost);
        tabHost.setup();
        //tạo đối tượng 1 tab có id là t1
        TabHost.TabSpec tab1=tabHost.newTabSpec("t1");
        //thiết lập nội dung layout
        tab1.setContent(R.id.tab1);
        //thiết lập tiêu đề cho tab
        //tab1.setIndicator("Đăng nhập");
        tab1.setIndicator("",getResources().getDrawable(R.drawable.login));
        tabHost.addTab(tab1);

        //tạo đối tượng 1 tab có id là t1
        TabHost.TabSpec tab2=tabHost.newTabSpec("t2");
        //thiết lập nội dung layout
        tab2.setContent(R.id.tab2);
        //thiết lập tiêu đề cho tab
        tab2.setIndicator("Hướng dẫn");
        tabHost.addTab(tab2);

        edtUser=findViewById(R.id.edtUser);
        edtPassword=findViewById(R.id.edtPassword);
        btnDangNhap=findViewById(R.id.btnDangNhap);
        btnThoat=findViewById(R.id.btnThoat);


    }
}
