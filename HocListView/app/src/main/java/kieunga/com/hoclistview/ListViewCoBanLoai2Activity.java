package kieunga.com.hoclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import kieunga.com.hoclistview.databinding.ActivityListViewCoBanLoai1Binding;
import kieunga.com.hoclistview.databinding.ActivityListViewCoBanLoai2Binding;
import kieunga.com.model.DanhBa;

public class ListViewCoBanLoai2Activity extends AppCompatActivity {

    //vì nguồn dữ liệu là danh bạ nên adapter là DanhBa
    ArrayAdapter<DanhBa>adapterDanhBa;
    ActivityListViewCoBanLoai2Binding binding;
    DanhBa selectedDanhBa=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityListViewCoBanLoai2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addControls();
        addEvents();
    }

    private void addEvents() {
        binding.btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThemMoi();
            }
        });
        binding.lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DanhBa db=adapterDanhBa.getItem(position);
                binding.edtTen.setText(db.getTen());
                binding.edtPhone.setText(db.getPhone());
                selectedDanhBa=db;
            }
        });
        binding.btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chinhSua();
            }
        });
        binding.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedDanhBa!=null)
                {
                    adapterDanhBa.remove(selectedDanhBa);
                    selectedDanhBa=null;
                }
            }
        });
    }

    private void chinhSua() {
        if(selectedDanhBa!=null)
        {
            selectedDanhBa.setTen(binding.edtTen.getText().toString());
            selectedDanhBa.setPhone(binding.edtPhone.getText().toString());
            adapterDanhBa.notifyDataSetChanged();
        }

    }

    private void xuLyThemMoi() {
        //khởi tạo 1 danh bạ
        DanhBa db=new DanhBa(binding.edtTen.getText().toString(),
                binding.edtPhone.getText().toString());
        adapterDanhBa.add(db);
        binding.edtPhone.setText("");
        binding.edtTen.setText("");
        binding.edtTen.requestFocus();

    }

    private void addControls() {
        //khởi tạo adapter
        adapterDanhBa=new ArrayAdapter<>(
                ListViewCoBanLoai2Activity.this,
                android.R.layout.simple_list_item_1
        );
        //gán adapter cho listview
        binding.lvContact.setAdapter(adapterDanhBa);
    }
}
