package com.communityuni.adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.communityuni.baitaprenluyenkaraoke.MainActivity;
import com.communityuni.baitaprenluyenkaraoke.R;
import com.communityuni.model.BaiHat;

/**
 * Created by cafe on 16/01/2017.
 */

public class BaiHatAdapter extends ArrayAdapter<BaiHat>
{
    Activity context;
    int resource;
    public BaiHatAdapter(@NonNull Activity context, @LayoutRes int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=this.context.getLayoutInflater().inflate(this.resource,null);
        TextView txtMa= (TextView) view.findViewById(R.id.txtMa);
        TextView txtTen= (TextView) view.findViewById(R.id.txtTen);
        TextView txtCasi= (TextView) view.findViewById(R.id.txtCasi);
        final ImageView imgLike= (ImageView) view.findViewById(R.id.imgLike);
        final ImageView imgDislike= (ImageView) view.findViewById(R.id.imgDislike);
        final BaiHat bh=getItem(position);
        txtMa.setText(bh.getMa());
        txtTen.setText(bh.getTen());
        txtCasi.setText(bh.getCasi());
        if(bh.getThich()==1) {
            imgLike.setVisibility(View.INVISIBLE);
            imgDislike.setVisibility(View.VISIBLE);
        }
        else
        {
            imgLike.setVisibility(View.VISIBLE);
            imgDislike.setVisibility(View.INVISIBLE);
        }
        imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgLike.setVisibility(View.INVISIBLE);
                imgDislike.setVisibility(View.VISIBLE);
                xuLyLike(bh);
            }
        });
        imgDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgDislike.setVisibility(View.INVISIBLE);
                imgLike.setVisibility(View.VISIBLE);
                xuLyDislike(bh);
            }
        });
        return view;
    }

    private void xuLyDislike(BaiHat bh) {
        ContentValues values=new ContentValues();
        values.put("YEUTHICH",0);
        int kq=MainActivity.database.update(
                MainActivity.TableName,
                values,
                "MABH=?",new String[]{bh.getMa()});
        if(kq>0) {
            Toast.makeText(context,
                    "Đã gỡ bỏ bài hát [" + bh.getTen() + "] khỏi danh sách yêu thích thành công",
                    Toast.LENGTH_LONG).show();
            if(MainActivity.selectedTab==1)
            {
                remove(bh);
            }
        }
    }
    private void xuLyLike(BaiHat bh) {
        ContentValues values=new ContentValues();
        values.put("YEUTHICH",1);
        int kq=MainActivity.database.update(
                MainActivity.TableName,
                values,
                "MABH=?",new String[]{bh.getMa()});
        if(kq>0)
            Toast.makeText(context,
                    "Đã thêm bài hát ["+bh.getTen()+"] vào danh sách yêu thích thành công",
                    Toast.LENGTH_LONG).show();
    }
}
