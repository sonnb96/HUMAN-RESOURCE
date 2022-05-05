import java.io.IOException;
import java.util.*;

public class HummanResources {
    public static void main(String[] args) {
        ArrayList<Staff> list = new ArrayList<Staff>();
        list.add(new Employee(1, "huong", 24, 2, "20-5-2021", "Bussiness", 12, 20));
        list.add(new Employee(2, "nam", 25, 2, "20-5-2021", "Project", 12, 10));
        list.add(new Employee(3, "linh", 23, 3, "20-5-2021", "Bussiness", 12, 5));
        list.add(new Employee(4, "son", 29, 4, "20-5-2021", "Technical", 12, 15));
        list.add(new Employee(5, "huong", 35, 4, "20-5-2021", "Bussiness", 12, 24));
        list.add(new Manager(6, "thao", 24, 2, "19-7-2020", "Bussiness", 12, "Business Leader"));
        list.add(new Manager(7, "trang", 24, 2, "18-8-2020", "Technical", 10, "Technical Leader"));
        list.add(new Manager(8, "dien", 24, 2, "20-9-2020", "Project", 9, "Project Leader"));
//        ____________________________________________________________________________________

//        ____________________________________________________________________________________
        themNhanVien(list);// Thêm nhân viên vào danh sách công ty

        hienThiNhanVienCTy( list);// Hiển thị bảng nhân viên toàn công ty bao gôm cả nhân viên thường và quản lý

        hienThiDanhSachTungBoPhan( list); // Hiển thị danh sách các bộ phận của công ty

        hienThiThongTinNhanVienTungBP( list); // Hiển thị gom nhóm các nhân viên theo từng bộ phận

        timKiemTheoMa(list);// Tìm kiếm nhân viên theo mã nhân viên

        timKiemTheoTen(list);// Tìm kiếm nhân viên theo tên nhân viên

        hienThiBangLuong( list);// Hiển thị bảng lương nhân viên toàn công ty

        hienThiBangLuongTheoThuTuTangDan(list);// Hiện thị bảng lương theo chiều tăng dần của lương

        hienThiBangLuongTheoThuTuGiamDan(list);// Hiển thị bản lường theo chiều giảm dần của lương

    }
//--------------------------------------------------------------------------------------------------
    public static void themNhanVien(ArrayList<Staff> list) {
        String answer;// Biến lưu câu trả lời yes/no
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Bạn có muốn nhập thêm nhân sự (yes/no): ");
        answer = input.next();
        if (answer.equals("yes")) {
            System.out.print("Thêm nhan viên (yes/no) : ");
            String answer_nv = input.next();//Biến lưu trả lời yes/no
            if (answer_nv.equals("yes")) {
                do {
                    System.out.print("Mã nhân viên : ");
                    int mnv = input.nextInt();
                    System.out.print("Tên nhân viên: ");
                    String ten_nv = input.next();
                    System.out.print("Tuổi nhân viên : ");
                    int tuoi_nv = input.nextInt();
                    System.out.print("Hệ số lương : ");
                    int hs_luong = input.nextInt();
                    System.out.print("Ngày vào làm : ");
                    String ngay_vao_lam = input.next();
                    System.out.print("Bộ phận: ");
                    String bo_phan = input.next();
                    System.out.print("Ngày nghỉ phép : ");
                    int ngay_nghi_phep = input.nextInt();
                    System.out.print("Giờ làm thêm : ");
                    int giolamthem = input.nextInt();

                    list.add(new Employee(mnv, ten_nv, tuoi_nv, hs_luong, ngay_vao_lam, bo_phan, ngay_nghi_phep, giolamthem));
                    System.out.println("Bạn có muốn tiếp tục (yes/no) :");
                    answer = input.next();

                } while (answer.equals("yes"));
            }
                System.out.print("Thêm quản lý (yes/no) : ");
                String answer_mn = input.next();//Biến lưu trả lời yes/no
                if (answer_mn.equals("yes")) {
                    do {
                        System.out.print("Mã quản lý : ");
                        int mnv = input.nextInt();
                        System.out.print("Tên quản lý: ");
                        String ten_nv = input.next();
                        System.out.print("Tuổi quản lý : ");
                        int tuoi_nv = input.nextInt();
                        System.out.print("Hệ số lương : ");
                        int hs_luong = input.nextInt();
                        System.out.print("Ngày vào làm : ");
                        String ngay_vao_lam = input.next();
                        System.out.print("Bộ phận: ");
                        String bo_phan = input.next();
                        System.out.print("Ngày nghỉ phép : ");
                        int ngay_nghi_phep = input.nextInt();
                        System.out.print("Chức danh : ");
                        input.nextLine();
                        String chucdanh = input.nextLine();

                        list.add(new Manager(mnv, ten_nv, tuoi_nv, hs_luong, ngay_vao_lam, bo_phan, ngay_nghi_phep, chucdanh));
                        System.out.print("Bạn có muốn tiếp tục (yes/no) :");
                        answer = input.next();
                    } while (answer.equals("yes"));
                }

        }
        System.out.println();
    }


//-------------------------------------------------------------------------------------------------------------------


    public  static void hienThiNhanVienCTy(ArrayList<Staff> list){
        String t = "|%-16s| %-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|";
        Scanner input= new Scanner(System.in);
        String answer;// Biến lưu trả lời yes/no

        System.out.print("Bạn có muốn hiển thị danh sách toàn bộ nhân viên công ty (yes/no) : ");
        answer = input.next();
        do {
            if (answer.equals("yes")) {
                System.out.println();
                System.out.println("Thông tin toàn bộ nhân viên");
                for (int i = 0; i < list.size(); i++) {
                    if (i == 0 && list.get(i).getChucDanh() == "Nhan Vien") {
                        System.out.format(t, "Ma nhan vien", "Ten nhan vien", "Tuoi nhan vien", "He so luong", "Ngay vao lam", "Bo phan", "Ngay nghi phep", "Gio lam them", "Chuc danh");
                        System.out.println();
                    }
                    list.get(i).displayInformation();
                }
                System.out.println();
                System.out.print("Bạn có muốn hiển thị lại danh sách toàn bộ nhân viên công ty (yes/no) : ");
                answer = input.next();
            }

        } while (answer.equals("yes"));
        System.out.println();


    }
    //-----------------------------------------------------------------------------------------------------------------------
    public static void hienThiThongTinNhanVienTungBP(ArrayList<Staff> list){

        String t = "|%-16s| %-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|";
        Scanner input= new Scanner(System.in);
        String answer;// Biến lưu trả lời yes/no

        System.out.print("Bạn có muốn hiển thị danh sách nhân viên theo từng bộ phận (yes/no) : ");
        answer = input.next();
        while (answer.equals("yes")) {
            System.out.println("Thông tin toàn bộ nhân viên theo bộ phận");
            //-----------------Khối bussiness-------------------------
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getBoPhan() == "Bussiness") {
                    if (i == 0) {
                        System.out.format(t, "Ma nhan vien", "Ten nhan vien", "Tuoi nhan vien", "He so luong", "Ngay vao lam", "Bo phan", "Ngay nghi phep", "Gio lam them", "Chuc danh");
                        System.out.println();
                    }
                    list.get(i).displayInformation();
                }
            }
            //-----------------Khối Technical--------------------
            System.out.println();
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i).getBoPhan() == "Technical") {
                    if (i == 0) {
                        System.out.format(t, "Ma nhan vien", "Ten nhan vien", "Tuoi nhan vien", "He so luong", "Ngay vao lam", "Bo phan", "Ngay nghi phep", "Gio lam them", "Chuc danh");
                    }
                    list.get(i).displayInformation();
                }
            }
            //-----------------Khối Project----------------------
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getBoPhan() == "Project") {
                    if (i == 0) {
                        System.out.format(t, "Ma nhan vien", "Ten nhan vien", "Tuoi nhan vien", "He so luong", "Ngay vao lam", "Bo phan", "Ngay nghi phep", "Gio lam them", "Chuc danh");
                    }
                    list.get(i).displayInformation();
                }
            }
            System.out.println();
            System.out.print("Bạn có muốn hiển thị lại danh sách nhân viên từng bộ phận (yes/no) : ");
            answer = input.next();
        }
        System.out.println();
    }

    //------------------------------------------------------------------------------------------------------------
    public static void hienThiDanhSachTungBoPhan( ArrayList<Staff> list){
        int nvbs = 0; //So luong nhan vien bussiness
        int nvtn = 0; //So luong nhan vien technical
        int nvpr = 0; //So luong nhan vien project
        int dem=0;// Biến đếm có bao nhieu bộ phận
        String l = "|%-19s| %-19s|%-19s|";
        Scanner input= new Scanner(System.in);
        String answer;

        System.out.print("Bạn có muốn hiển thị danh sách từng bộ phận (yes/no) : ");
        answer =input.next();

        while(answer.equals("yes")){
            for (Staff ls : list) {
                if (ls.getBoPhan() == "Bussiness") {
                    nvbs++;
                } else if (ls.getBoPhan() == "Technical") {
                    nvtn++;

                } else if (ls.getBoPhan() == "Project") {
                    nvpr++;

                }

            }
            ArrayList<Department> listdepartment = new ArrayList<Department>();
            listdepartment.add(new Department("BSN", "Bussiness", nvbs));
            listdepartment.add(new Department("TNC", "Technical", nvtn));
            listdepartment.add(new Department("PRJ", "Project", nvpr));


            for (Department dp : listdepartment) {

//                if (dem == 0) {
//                    System.out.format(l, "Ma bo phan", "Ten bo phan", "So luong nhan vien");
//                    System.out.println();
//                }

              System.out.println(dp.toString());
                dem++;
            }
            System.out.println();
            System.out.print("Bạn có muốn hiển thị lại danh sách từng bộ phận yes/no : ");
            answer = input.next();
        }
        System.out.println();
    }

    //-------------------------------------------------------------------------------------------------------------------
    public static void hienThiBangLuong(ArrayList<Staff> list) {
        int dem;
        String d = "|%-19s| %-19s|%-19s|%-19s|%-19s|%-19s|%-19s|";
        Scanner input = new Scanner(System.in);
        String answer;


        System.out.print("Bạn có muốn hiển thị bảng lương toàn bộ nhân viên công ty (yes/no) : ");
        answer = input.next();
        while (answer.equals("yes")) {

            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    System.out.format(d, "Ma nhan vien", "Ten nhan vien", "Tuoi nhan vien", "He so luong", "Gio lam them", "Chuc danh", "Luong");
                    System.out.println();
                }
                list.get(i).bangLuong();
            }
            System.out.println();
            System.out.print("Bạn có muốn hiển thị lại bảng lương toàn bộ nhân viên công ty (yes/no) : ");
            answer = input.next();
        }
        System.out.println();
    }
//    ---------------------------------------------------------------------------------------------------
    public static void hienThiBangLuongTheoThuTuTangDan(ArrayList<Staff> list) {

        String d = "|%-19s| %-19s|%-19s|%-19s|%-19s|%-19s|%-19s|";
        Scanner input= new Scanner(System.in);
        String answer;
        System.out.print("Bạn có muốn hiển thị bảng lương theo thứ tự tăng dần(yes/no) : ");
        answer= input.next();
        while (answer.equals("yes")) {
            list.sort(new Comparator<Staff>() {
                @Override
                public int compare(Staff o1, Staff o2) {

                    return o1.calculateSalary() - o2.calculateSalary();
                }
            });
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    System.out.format(d, "Ma nhan vien", "Ten nhan vien", "Tuoi nhan vien", "He so luong", "Gio lam them", "Chuc danh", "Luong");
                    System.out.println();
                }
                list.get(i).bangLuong();

            }
            System.out.println();
            System.out.print("Bạn có muốn hiển thị lại bảng lương theo thứ tự tăng dần (yes/no) : ");
            answer = input.next();

        }
        System.out.println();
    }
//---------------------------------------------------------------------------------------------------------------
public static void hienThiBangLuongTheoThuTuGiamDan(ArrayList<Staff> list) {

    String d = "|%-19s| %-19s|%-19s|%-19s|%-19s|%-19s|%-19s|";
    Scanner input= new Scanner(System.in);
    String answer;
    System.out.print("Bạn có muốn hiển thị bảng lương theo thứ tự giảm dần(yes/no) : ");
    answer= input.next();
    while (answer.equals("yes")) {
        list.sort(new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {

                return o1.calculateSalary() - o2.calculateSalary();
            }
        }.reversed());
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                System.out.format(d, "Ma nhan vien", "Ten nhan vien", "Tuoi nhan vien", "He so luong", "Gio lam them", "Chuc danh", "Luong");
                System.out.println();
            }
            list.get(i).bangLuong();

        }
        System.out.println();
        System.out.print("Bạn có muốn hiển thị lại bảng lương theo thứ tự giảm dần (yes/no) : ");
        answer = input.next();

    }
    System.out.println();
}
//  ------------------------------------------------------------------------------------------------------------

    public static void timKiemTheoMa(ArrayList<Staff> list){
        int dem;//Biến đếm có bao nhiêu mã số trùng với kết quả tìm kiếm
        int  search1=0;
        String t = "|%-16s| %-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|";
        Scanner input= new Scanner(System.in);
        String answer;


        do {
            System.out.print("Bạn có muốn tìm kiếm theo mã số (yes/no) : ");
            dem=0;
            answer = input.next();
            if (answer.equals("yes")) {
                System.out.print("Mã số bạn muốn tìm kiếm: ");
                String loi_nhap = "";
                do {
                    loi_nhap = "";
                    try {
                        search1 = input.nextInt();

                    } catch (InputMismatchException loi) {
                        System.out.print("Bạn cần phải nhập vào một số : ");
                        loi_nhap = loi.toString();
                        input.nextLine();
                    }
                } while (loi_nhap.equals("java.util.InputMismatchException"));
                for (Staff ds : list) {
                    if (list.indexOf(ds) == 0) {
                        System.out.format(t, "Ma nhan vien", "Ten nhan vien", "Tuoi nhan vien", "He so luong", "Ngay vao lam", "Bo phan", "Ngay nghi phep", "Gio lam them", "Chuc danh");
                        System.out.println();
                    }
                    if (ds.getMnv() == search1) {
                        ds.displayInformation();
                        dem++;
                    }
                }
                if (dem == 0) {
                    System.out.println("Không có mã số này");
                }
            }

        } while(answer.equals("yes"));
        System.out.println();
    }

    //-----------------------------------------------------------------------------------------------------------------
    public static void timKiemTheoTen(ArrayList<Staff> list){
        int dem;// Biến đếm có bao nhiêu tên nhân viên trùng với tim kiếm
        String t = "|%-16s| %-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|%-16s|";
        Scanner input= new Scanner(System.in);
        String answer;
        do {
            dem=0;
            System.out.print("Bạn có muốn tìm kiếm theo tên nhân viên không? (yes/no) : ");
            answer=input.next();
            if(answer.equals("yes")) {
                System.out.print("Tên nhân viên bạn muốn tìm kiếm: ");
                String  search = input.next();
                for (Staff ds : list) {
                    if (list.indexOf(ds) == 0) {
                        System.out.format(t, "Ma nhan vien", "Ten nhan vien", "Tuoi nhan vien", "He so luong", "Ngay vao lam", "Bo phan", "Ngay nghi phep", "Gio lam them", "Chuc danh");
                        System.out.println();
                    }

                    if (ds.getTennv().equals(search)) {
                        ds.displayInformation();
                        dem++;
                    }

                }
                if(dem==0){System.out.println("Không có người này");}
            }
        }while (answer.equals("yes"));
        System.out.println();
    }

}

