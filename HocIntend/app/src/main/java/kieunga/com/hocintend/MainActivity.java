package kieunga.com.hocintend;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import kieunga.com.hocintend.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
 ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }

    public void moManHInhCheKhuatToanBo(View view) {
        Intent intent=new Intent(MainActivity.this, CheToanBoManHinhActivity.class);
        startActivity(intent);

    }

    public MainActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "onDestroy",Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "onPause",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "onResume",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "onRestart",Toast.LENGTH_SHORT).show();

    }

    public void moManHinhCheKhuatMotPhan(View view) {
        Intent intent=new Intent(MainActivity.this, CheKhuatMotPhan.class);
        startActivity(intent);
    }

    public void guiDuLieu(View view) {
        Intent intend=new Intent(MainActivity.this, XuLyNhanDuLieu.class);
        intend.putExtra("VALUE", binding.editText.getText().toString());
        intend.putExtra("GIA_TRI",113);
        startActivity(intend);



    }

    public void xuLyDuLieu(View view) {
        Intent intent=new Intent(MainActivity.this, XuLyVaNhanDuLieu.class);
        intent.putExtra("N",Integer.parseInt(binding.editText2.toString()));
        startActivityForResult(intent,114);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==114&&resultCode==113)
        {
            ArrayList<Integer>dsUS=data.getIntegerArrayListExtra("DSUS");
            showListView(dsUS);
        }
    }

    private void showListView(ArrayList<Integer> dsUS) {
        ArrayAdapter<Integer>adapter=new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dsUS
        );
        binding.lvDs.setAdapter(adapter);
    }
}
