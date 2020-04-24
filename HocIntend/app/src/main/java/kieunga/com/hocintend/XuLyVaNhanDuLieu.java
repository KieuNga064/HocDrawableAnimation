package kieunga.com.hocintend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import kieunga.com.hocintend.databinding.ActivityXuLyNhanDuLieuBinding;

public class XuLyVaNhanDuLieu extends AppCompatActivity {

    ActivityXuLyNhanDuLieuBinding binding;
    int N=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityXuLyNhanDuLieuBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        N=getIntent().getIntExtra("N",1);
        binding.txtValue.setText(N+"");
    }

    public void traDanhSachUocSo(View view) {
        ArrayList<Integer>dsUS=new ArrayList<>();
        for(int i=1;i<=N;i++)
            if(N%1==0)
                dsUS.add(i);

    }
}
