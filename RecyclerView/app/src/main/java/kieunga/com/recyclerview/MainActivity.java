package kieunga.com.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import kieunga.com.adapter.ContactAdapter;
import kieunga.com.contact.Contact;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcContact;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    ContactAdapter contactAdapter;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcContact = (RecyclerView) findViewById(R.id.rcContact);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        rcContact.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        rcContact.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ContactAdapter();
        recyclerView.setAdapter(mAdapter);
        addControls();
    }

    private void addControls() {
        rcContact=findViewById(R.id.rcContact);
        //contactAdapter=new ContactAdapter();

    }
}
