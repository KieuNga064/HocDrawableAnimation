package kieunga.com.hocintend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import kieunga.com.hocintend.databinding.ActivityXuLyNhanDuLieuBinding;

public class XuLyNhanDuLieu extends AppCompatActivity {
    ActivityXuLyNhanDuLieuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityXuLyNhanDuLieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        xuLyLayDULieu();
    }

    private void xuLyLayDULieu() {
        Intent intent=getIntent();
        String value=intent.getStringExtra("VALUE");
        int giaTri=intent.getIntExtra("GIA_TRI",0);
        binding.txtValue.setText(value+"\n"+giaTri);
    }
}
