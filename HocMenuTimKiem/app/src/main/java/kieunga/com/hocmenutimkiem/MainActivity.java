package kieunga.com.hocmenutimkiem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lvTinhThanh;
    ArrayAdapter<String>adapterTInhthanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        lvTinhThanh=(ListView) findViewById(R.id.lvTinhThanh);
        adapterTInhthanh=new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1
        );
        adapterTInhthanh.addAll(getResources().getStringArray(R.array.arrTinhThanh));
        lvTinhThanh.setAdapter(adapterTInhthanh);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        MenuItem mnuSearch=menu.findItem(R.id.mnuSearch);
      // SearchView searchView= (SearchView) MenuItemCompat.getActionView(mnuSearch);
        SearchView searchView= (SearchView) mnuSearch.getActionView();
        MenuItemCompat.setOnActionExpandListener(mnuSearch, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(MainActivity.this,"Đang expand",Toast.LENGTH_SHORT ).show();
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(MainActivity.this,"Đang collapse",Toast.LENGTH_SHORT ).show();
                return false;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterTInhthanh.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
