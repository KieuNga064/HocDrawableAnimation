package kieunga.com.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import kieunga.com.hoclistviewnangcao.R;
import kieunga.com.model.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {
    Activity context;
    int resource;

    /**
     * constructor để khởi tạo Adaper
     * @param context màn hình nào sd adapter này
     * @param resource giao diện nào đc gắn
     */

    public ContactAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View custom= context.getLayoutInflater().inflate(resource,
                null) ;
        //lưu y: ImageView (imgAvatar), TextView (txtName, txtPhone)
        //cả 3 nằm trong custom nên muốn truy suất thì phải trong custom
        ImageView imageAvatar=custom.findViewById(R.id.imgAvatar);
        TextView txtName=custom.findViewById(R.id.txtName);
        TextView txtPhone=custom.findViewById(R.id.txtPhone);

        //đối số position ở trên là dòng dữ liệu đang đc nhân bản
        Contact contact=getItem(position);
        imageAvatar.setImageResource(contact.getAvatar());
        txtName.setText(contact.getName());
        txtPhone.setText(contact.getPhone());

        return custom;

    }
}
