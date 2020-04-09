package kieunga.com.hoclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moManHinhListViewLoai1(View view) {
        Intent intent=new Intent(MainActivity.this,
                ListViewCoBanLoai1
                .class);
        startActivity(intent);
    }

    public void moManHinhListViewLoai2(View view) {
        Intent intent=new Intent(MainActivity.this,
                ListViewCoBanLoai2Activity
                        .class);
        startActivity(intent);
    }
}
