package kieunga.com.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class DanhBa implements Serializable {
    private int id;
    private  String ten;
    private  String phone;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NonNull
    @Override
    public String toString() {
        return ten+"-"+phone;
    }
}
