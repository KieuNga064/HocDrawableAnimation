package kieunga.com.model;

import androidx.annotation.NonNull;

public class DanhBa {
    private String ten;
    private String phone;

    @NonNull
    @Override
    public String toString() {
        return ten+ "\n"+phone;
    }

    public DanhBa() {
    }

    public DanhBa(String ten, String phone) {
        this.ten = ten;
        this.phone = phone;
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
}
