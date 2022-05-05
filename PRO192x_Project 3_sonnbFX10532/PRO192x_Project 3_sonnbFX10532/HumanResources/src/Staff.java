


public abstract class Staff implements ICalculator {
    int mnv;
    String ten_nv;
    int tuoi_nv;
    int hs_luong;
    String ngay_vao_lam;
    String bo_phan;
    int ngay_nghi_phep;
    public  Staff(){}
    public abstract void displayInformation();
    public abstract String getChucDanh();
    public abstract String getBoPhan();
    public abstract void bangLuong();
    public Staff(int mnv, String ten_nv, int tuoi_nv, int hs_luong, String ngay_vao_lam,String bo_phan, int ngay_nghi_phep){
        this.mnv= mnv;
        this.ten_nv= ten_nv;
        this.tuoi_nv=tuoi_nv;
        this.hs_luong=hs_luong;
        this.ngay_vao_lam=ngay_vao_lam;
        this.bo_phan=bo_phan;
        this.ngay_nghi_phep=ngay_nghi_phep;
    }
    //    public Staff(String ten_nv){
//        this.ten_nv= ten_nv;
//    }
    public int getMnv(){
        return mnv;
    }
    public String getTennv(){
        return ten_nv;
    }

}


