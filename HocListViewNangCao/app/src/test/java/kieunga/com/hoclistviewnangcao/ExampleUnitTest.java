package kieunga.com.hoclistviewnangcao;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.junit.Test;

import kieunga.com.adapter.ContactAdapter;
import kieunga.com.model.Contact;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    public static class MainActivity extends AppCompatActivity {

        ListView lvContact;
        ContactAdapter contactAdapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            addControls();
            addFakeData();
        }

        private void addFakeData() {
            contactAdapter.add(new Contact());
        }

        //làm recycle view

        private void addControls() {
            lvContact=findViewById(R.id.lvContact);
            contactAdapter=new ContactAdapter(MainActivity.this, R.layout.contact_item);


        }
    }
}