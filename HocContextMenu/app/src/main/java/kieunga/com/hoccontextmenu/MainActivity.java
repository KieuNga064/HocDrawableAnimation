package kieunga.com.hoccontextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        btn1=(Button) findViewById((R.id.btn1));
        registerForContextMenu(btn1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_context,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnuMauDo:
                btn1.setTextColor(Color.RED);
                break;
            case R.id.mnuMauVang:
                btn1.setTextColor(Color.YELLOW);
                break;
            case  R.id.mnuMauXanh:
                btn1.setTextColor(Color.BLUE);
                break;



        }
        return super.onContextItemSelected(item);
    }
}
