package adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import kieunga.com.hockaraoke.MainActivity;
import kieunga.com.hockaraoke.R;
import model.BaiHat;

public class BaiHatAdapter extends ArrayAdapter<BaiHat> {

    Activity context;
    int resource;
    public BaiHatAdapter(@NonNull Activity context, int resource) {

        super(context, resource);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=this.context.getLayoutInflater().inflate(this.resource,null);
        TextView txtMa=view.findViewById(R.id.txtMa);
        TextView txtTen=view.findViewById(R.id.txtTen);
        TextView txtCaSi=view.findViewById(R.id.txtCaSi);
        final ImageView imgLove=view.findViewById(R.id.imgLove);
        final ImageView imgDislike=view.findViewById(R.id.imgDislike);
        final BaiHat baiHat=getItem(position);
        txtMa.setText(baiHat.getMa());
        txtCaSi.setText(baiHat.getCasi());
        txtTen.setText(baiHat.getTen());
        if(baiHat.getThich()==1) {
            imgLove.setVisibility(View.INVISIBLE);
            imgDislike.setVisibility(View.VISIBLE);
        }
            else
        {
            imgDislike.setVisibility(View.INVISIBLE);
            imgLove.setVisibility(View.VISIBLE);
        }
            imgLove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgLove.setVisibility(View.INVISIBLE);
                    imgDislike.setVisibility(View.VISIBLE);
                    xuLyLove(baiHat);
                }
            });
            imgDislike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgDislike.setVisibility(View.INVISIBLE);
                    imgLove.setVisibility(View.VISIBLE);

                    xuLyDislike(baiHat);
                }
            });
        return view;
    }

    private void xuLyDislike(BaiHat baiHat) {
        ContentValues contentValues=new ContentValues();
        contentValues.put("YEUTHICH",0);
        int ketQua= MainActivity.database.update(
                MainActivity.TableName, contentValues
                ,"MABH=?", new String[] {baiHat.getMa()});
        if(ketQua>0)
            Toast.makeText(context,"Đã gỡ bỏ bài hát ["+baiHat.getTen()+"] khỏi danh sách yêu thích thành công.",Toast.LENGTH_LONG).show();
            if(MainActivity.selectedTab==1)
            {
                remove(baiHat);
            }
    }


    private void xuLyLove(BaiHat baiHat) {
        ContentValues contentValues=new ContentValues();
        contentValues.put("YEUTHICH",1);
        int ketQua= MainActivity.database.update(
                MainActivity.TableName, contentValues
                ,"MABH=?", new String[] {baiHat.getMa()});
        if(ketQua>0)
            Toast.makeText(context,"Đã thêm bài hát ["+baiHat.getTen()+"] vào danh sách yêu thích thành công.",Toast.LENGTH_LONG).show();


    }
}
