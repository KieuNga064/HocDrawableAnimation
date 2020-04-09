package kieunga.com.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import kieunga.com.contact.Contact;
import kieunga.com.recyclerview.R;

public class ContactAdapter extends ArrayAdapter<Contact> {



    Activity context;
    int resource;

    public ContactAdapter(@NonNull Context context, int resource) {

        super(context, resource);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View custom=context.getLayoutInflater().inflate(resource, null);
        ImageView imgAvatar=custom.findViewById(R.id.imgAvatar);
        TextView txtName=custom.findViewById(R.id.txtName);
        TextView txtPhone=custom.findViewById(R.id.txtPhone);

        Contact contact=getItem(position);
        imgAvatar.setImageResource(contact.getAvatar());
        txtName.setText(contact.getName());
        txtPhone.setText(contact.getPhone());
        return custom;
    }
}
