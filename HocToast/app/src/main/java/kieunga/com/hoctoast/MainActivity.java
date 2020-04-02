package kieunga.com.hoctoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import kieunga.com.hoctoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.btnShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyToastShort();
            }
        });
        binding.btnLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyToastLength();
            }
        });
    }

    private void xuLyToastLength() {
        Toast.makeText(MainActivity.this,
                "Xin chào bạn, sau <= 3.5s tôi tắt.",
                Toast.LENGTH_LONG).show();
    }

    private void xuLyToastShort() {
        Toast.makeText(MainActivity.this,
                "Xin chào bạn, sau đây tôi tắt.",
                Toast.LENGTH_SHORT).show(); //hiển thị lên


    }
}
