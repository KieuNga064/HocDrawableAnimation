package kieunga.com.hoclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import kieunga.com.hoclistview.databinding.ActivityListViewCoBanLoai1Binding;

public class ListViewCoBanLoai1 extends AppCompatActivity {

    ActivityListViewCoBanLoai1Binding binding;
    ArrayAdapter<String>adapterTinhThanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityListViewCoBanLoai1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEvents();
    }

    private void loadData() {
        //Bước 1: tải dữ liệu lên 1 mảng
        String[]arr=getResources().getStringArray(R.array.arrTinhThanh);
        //Bước 2: khởi tạo adaptet phù hợp với dữ liệu
        adapterTinhThanh=new ArrayAdapter<>(
                ListViewCoBanLoai1.this //màn hình hiện tại
                , android.R.layout.simple_list_item_1,
                arr);
        //Bước 3:
        binding.lvTinhThanh.setAdapter(adapterTinhThanh);
    }

    private void addEvents() {
        binding.lvTinhThanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data=adapterTinhThanh.getItem(position);
                binding.txtTinhThanh.setText(position+"->"+data);
            }
        });
    }
}
