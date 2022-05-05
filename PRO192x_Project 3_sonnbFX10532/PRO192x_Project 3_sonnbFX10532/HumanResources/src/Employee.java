import java.util.Formatter;
public class Employee extends Staff implements ICalculator{
    int giolamthem;
    String t="|%-16s| %-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|";
    String d="|%-19s| %-19s|%-19s|%-19s|%-19s|%-19s|%-19s|";
    private int luong;
    public Employee(int mnv, String ten_nv, int tuoi_nv, int hs_luong, String ngay_vao_lam,String bo_phan, int ngay_nghi_phep, int giolamthem){
        super(mnv, ten_nv, tuoi_nv, hs_luong, ngay_vao_lam,bo_phan, ngay_nghi_phep);
        this.giolamthem=giolamthem;
    }
    public Employee(String ten_nv){
        this.ten_nv=ten_nv;
    }
    @Override
    public void displayInformation() {
        System.out.format(t,super.getMnv(),ten_nv,tuoi_nv,hs_luong,ngay_vao_lam,bo_phan,ngay_nghi_phep,giolamthem,"");
        System.out.println();
    }
    @Override
    public void bangLuong(){
        luong= calculateSalary();
        System.out.format(d,mnv,ten_nv,tuoi_nv,hs_luong,giolamthem,"",luong);
        System.out.println();
    }
    @Override
    public String getChucDanh(){
        return "Nhan Vien";
    }
    @Override
    public String getBoPhan(){
        return bo_phan;
    }
    public int calculateSalary(){
        return hs_luong*3000000 + giolamthem*200000;
    }
}

