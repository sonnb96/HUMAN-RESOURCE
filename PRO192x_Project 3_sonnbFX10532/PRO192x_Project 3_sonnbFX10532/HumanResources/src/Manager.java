import java.util.Formatter;
public class Manager extends Staff implements ICalculator {
    static final int BL=8000000;
    static final int PL=5000000;
    static final int TL=6000000;
    private int luong_tn;
    private int luong;
    String chucdanh;
    String t="|%-16s| %-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|";
    String d="|%-19s| %-19s|%-19s|%-19s|%-19s|%-19s|%-19s|";
    public Manager(int mnv, String ten_nv, int tuoi_nv, int hs_luong, String ngay_vao_lam,String bo_phan, int ngay_nghi_phep,String chucdanh){
        super(mnv, ten_nv, tuoi_nv, hs_luong, ngay_vao_lam, bo_phan, ngay_nghi_phep);
        this.chucdanh=chucdanh;
    }
    @Override
    public void displayInformation(){

        System.out.format(t,mnv,ten_nv,tuoi_nv,hs_luong,ngay_vao_lam,bo_phan,ngay_nghi_phep,"",chucdanh);
        System.out.println();
    }
    public void bangLuong(){
        luong= calculateSalary();
        System.out.format(d,mnv,ten_nv,tuoi_nv,hs_luong,"",chucdanh,luong);
        System.out.println();
    }
    @Override
    public String getChucDanh(){
        return chucdanh;
    }

    @Override
    public String getBoPhan(){
        return bo_phan;
    }

    public int calculateSalary() {
        if (chucdanh.equals("Business Leader")) {
            luong_tn=BL;
        } else if (chucdanh.equals("Project Leader")) {
            luong_tn=PL;
        } else if (chucdanh.equals("Technical Leader")) {
            luong_tn=TL;
        }
        return hs_luong*5000000 + luong_tn;
    }
}

