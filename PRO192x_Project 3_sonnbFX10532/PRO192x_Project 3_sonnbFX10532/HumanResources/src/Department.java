public class Department {
    String mbp;
    String ten_bp;
    int sl_nhanvien;
    private String l="|%-19s| %-19s|%-19s|";
    public Department(String mbp, String ten_bp,int sl_nhanvien){
        this.mbp= mbp;
        this.ten_bp=ten_bp;
        this.sl_nhanvien=sl_nhanvien;
    }

//    public void toStringbp(){
//        System.out.format(l,mbp,ten_bp,sl_nhanvien);
//        System.out.println();
//    }
    @Override
    public String toString(){
        return "Mã bộ phân : "+mbp+", Tên bộ phận : "+ten_bp+", Số lượng nhân viên : "+sl_nhanvien;
    }
}
