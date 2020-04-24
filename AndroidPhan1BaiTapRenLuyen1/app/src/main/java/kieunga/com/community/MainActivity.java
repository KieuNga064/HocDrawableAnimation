package kieunga.com.community;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;

import java.util.ArrayList;

import adapter.NhanVienAdapter;
import model.NhanVien;

public class MainActivity extends AppCompatActivity {
    NhanVienAdapter adapterNhanVien;
    ListView lvNhanVien;
    NhanVien selectedNV=null;
    ArrayList<NhanVien>dsNguon=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvNhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedNV=adapterNhanVien.getItem(position);
            }
        });
        lvNhanVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selectedNV=adapterNhanVien.getItem(position);
                return false;
            }
        });
    }

    private void addControls() {
        lvNhanVien=findViewById(R.id.lvNhanVIen);
        adapterNhanVien=new NhanVienAdapter(MainActivity.this, R.layout.item);
        lvNhanVien.setAdapter(adapterNhanVien);

        registerForContextMenu(lvNhanVien);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnuEdit)
            hienThiManHinhEdit();
        else if(item.getItemId()==R.id.mnuRemove)
            xuLyXoa();

        return super.onContextItemSelected(item);
    }

    private void xuLyXoa() {
        adapterNhanVien.remove(selectedNV);
    }

    private void hienThiManHinhEdit() {
        final Dialog dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.detail_layout);
        final EditText edtMa=dialog.findViewById(R.id.edtMa);
        final EditText edtTen=dialog.findViewById(R.id.edtTen);
        RadioButton radMan=dialog.findViewById(R.id.radMan);
        final RadioButton radWoman=dialog.findViewById(R.id.radWoman);
        Button btnThem=dialog.findViewById(R.id.btnThem);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedNV.setMa(edtMa.getText().toString());
                selectedNV.setTen(edtTen.getText().toString());
                selectedNV.setLaNu(radWoman.isChecked());
                adapterNhanVien.notifyDataSetChanged();

                dsNguon.clear();
                for(int i=0;i<adapterNhanVien.getCount(); i++)
                {
                    dsNguon.add(adapterNhanVien.getItem(i));
                }
                dialog.dismiss();

            }
        });
        edtMa.setText(selectedNV.getMa());
        edtTen.setText(selectedNV.getTen());
        if(selectedNV.isLaNu())
            radWoman.setChecked(true);
        else
            radMan.setChecked(true);

        dialog.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        MenuItem mnuSearch=menu.findItem(R.id.mnuSearch);
        SearchView searchView= (SearchView) mnuSearch.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.isEmpty())
                {
                    adapterNhanVien.clear();
                    adapterNhanVien.addAll(dsNguon);
                }
                ArrayList<NhanVien> dsTim=new ArrayList<NhanVien>();
                for(NhanVien nv:dsNguon)
                {
                    if(nv.getMa().contains(newText)||nv.getMa().contains(newText))
                        dsTim.add(nv);
                }
                adapterNhanVien.clear();
                adapterNhanVien.addAll(dsTim);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnuNew:
                hienThiManHinhNhap();
                break;
            case R.id.mnuHelp:
                break;
            case R.id.mnuAbout:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void hienThiManHinhNhap() {
        final Dialog dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.detail_layout);
        final EditText edtMa=dialog.findViewById(R.id.edtMa);
        final EditText edtTen=dialog.findViewById(R.id.edtTen);
        RadioButton radMan=dialog.findViewById(R.id.radMan);
        final RadioButton radWoman=dialog.findViewById(R.id.radWoman);
        Button btnThem=dialog.findViewById(R.id.btnThem);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nv=new NhanVien();
                nv.setMa(edtMa.getText().toString());
                nv.setTen(edtTen.getText().toString());
                nv.setLaNu(radWoman.isChecked());
                adapterNhanVien.add(nv);
                dialog.dismiss();
                dsNguon.clear();
                for(int i=0;i<adapterNhanVien.getCount(); i++)
                {
                    dsNguon.add(adapterNhanVien.getItem(i));
                }
            }
        });
        dialog.show();
    }
}
