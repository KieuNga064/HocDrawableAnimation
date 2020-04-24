package kieunga.com.androidnangcaophan1btrenluyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import adapter.NhanVienAdapter;
import model.NhanVien;

public class MainActivity extends AppCompatActivity {
    ListView lvNhanVien;
    NhanVienAdapter nhanVienAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void addControls() {
        lvNhanVien=findViewById(R.id.lvNhanVien);
        nhanVienAdapter=new NhanVienAdapter(MainActivity.this,R.layout.item);
        lvNhanVien.setAdapter(nhanVienAdapter);

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nmuNew:
                break;
            case R.id.mnuHelp:
                break;
            case R.id.nmuAbout:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void hienThiManHinhNhapNhanVien(MenuItem item) {
        final Dialog dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.detail_layout);
        final EditText edtMa=dialog.findViewById(R.id.edtMa);
        final EditText edtTen=dialog.findViewById(R.id.txtTen);
        final RadioButton radNu=dialog.findViewById(R.id.radNu);
        RadioButton radNam=dialog.findViewById(R.id.radNam);
        Button btnLuu=dialog.findViewById(R.id.btnLuu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nv=new NhanVien();
                nv.setMa(edtMa.getText().toString());
                nv.setMa(edtTen.getText().toString());
                nv.setLaNu(radNu.isChecked());

                nhanVienAdapter.add(nv);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
