package kieunga.com.hocsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import kieunga.com.hocsqlite.databinding.ActivityThemDanhBaBinding;
import kieunga.com.model.DanhBa;

public class ThemDanhBaActivity extends AppCompatActivity {

    ActivityThemDanhBaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityThemDanhBaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_them_danh_ba);
        binding.btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DanhBa db=new DanhBa();
                db.setTen(binding.edtName.getText().toString());
                db.setPhone(binding.edtPhone.getText().toString());

            }
        });
    }
}
