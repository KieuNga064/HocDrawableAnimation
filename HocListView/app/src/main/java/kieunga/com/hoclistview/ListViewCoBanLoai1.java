package kieunga.com.hoclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kieunga.com.hoclistview.databinding.ActivityListViewCoBanLoai1Binding;

public class ListViewCoBanLoai1 extends AppCompatActivity {

    ActivityListViewCoBanLoai1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityListViewCoBanLoai1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {

    }
}
