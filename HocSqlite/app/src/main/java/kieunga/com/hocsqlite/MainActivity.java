package kieunga.com.hocsqlite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import kieunga.com.hocsqlite.databinding.ActivityMainBinding;
import kieunga.com.model.DanhBa;

public class MainActivity extends AppCompatActivity {
    String DATABASE_NAME="CSDL_DanhBa.sqlite";
    String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database=null;
    ActivityMainBinding binding;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        processCopy();
        //loadAllDanhBa();
        //addControls();
    }

    private void addControls() {
        adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        binding.lvContact.setAdapter(adapter);

    }

    private void loadAllDanhBa() {
        //mở cơ sở dữ liệu
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        //lưu ý: hàm trên không bao giờ lỗi do không thấy csdl và ko bị null
        //nếu không thấy csdl thì nó sẽ tự tạo ra 1 CSDl không có bảng nào cả
        //chứ database không bao giờ null (nên không được if...else...null
        //khi có lỗi xảy ra


        String sql="select * from DanhBa";
        Cursor cursor=database.rawQuery(sql,null);

        while(cursor.moveToNext()) //di chuyển tới dòng tiếp
        {
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String phone=cursor.getString(2);
            Log.d("DanhBa_InFo", id+"\t"+name+"\t"
                    +phone);
            DanhBa db=new DanhBa();
            db.setId(id);
            db.setTen(name);
            db.setPhone(phone);
            adapter.add(db);
        }

    }

    private void processCopy() {
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists())
        {
            try
            {
                CopyDataBaseFromAsset();
                Toast.makeText(this,
                        "Copying success from Assets folder",
                        Toast.LENGTH_LONG).show();
            }
            catch (Exception e)
            {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX+ DATABASE_NAME;
    }


    private void CopyDataBaseFromAsset() {
        try {
            InputStream myInput;
            myInput = getAssets().open(DATABASE_NAME);
            String outFileName = getDatabasePath();
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();
            OutputStream myOutput = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnuDanhBa)
        {
            Intent intent=new Intent(MainActivity.this, ThemDanhBaActivity.class);
            startActivityForResult(intent,888);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==888 && requestCode==999) {
         //   DanhBa db = data.getBooleanArrayExtra("DANHBA_MOI");
            ContentValues values = new ContentValues();
        }
    }
}
