
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Asus
 */
public class Auth {

    static HashMap<String, String> tabelAkun = new HashMap<>();
    static HashMap<String, String> tabelSesiLogin = new HashMap<>();
    static String email, password;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] dataAkun = new String[][]{
            {"labit@umm.ac.id", "kharismamuzaki@gmail.com", "byasageng@gmail.com", "dosen.tersayang@umm.ac.id", "email.saya@umm.ac.id"},
            {"Labit321", "Testing123", "cobalagi321", "dosenkuGG", "email_Student"}};
        int barisMasuk = 0;
        if (dataAkun[0].length == dataAkun[1].length) {
            while (barisMasuk < dataAkun[0].length) {
                tabelAkun.put(dataAkun[0][barisMasuk], dataAkun[1][barisMasuk]);
                barisMasuk++;
            }
        }
        int pilihan;
        System.out.println("1.Kegiatan \t2.Kegiatan 2");
        System.out.println("Masukkan Pilihan : ");
        pilihan = sc.nextInt();
        sc.nextLine();
        switch(pilihan){
            case 1:
                kegiatan1 k1 = new kegiatan1();
//                k1.registerAkun(email, password, tabelAkun);
//                k1.hapusAkun(email, password, tabelAkun);
                k1.totalEmailUMM(tabelAkun);
                break;
            case 2:
                kegiatan2 k2 = new kegiatan2();
                k2.loginAkun(email, password, tabelAkun, tabelSesiLogin);
                k2.logoutAkun(email, tabelSesiLogin);
                k2.totalLogin();
                k2.totalLogout();
                k2.totalAuth(tabelSesiLogin);
                break;
            default:
                System.out.println("Tidak ada pilihan");
                break;
        }
    }
}

class kegiatan1 {

    Scanner sc = new Scanner(System.in);

    public boolean registerAkun(String email, String password, HashMap tabelAkun) {
        System.out.println("Silahkan Register Akun Anda");
        System.out.println("Masukkan Email : ");
        email = sc.next();
        System.out.println("Masukkan Password : ");
        password = sc.next();
        if (tabelAkun.containsKey(email) == false) {
            tabelAkun.put(email, password);
            System.out.println("Anda Berhasil Register");
        } else {
            System.out.println("Email yang anda masukkan telah digunakan");
            kegiatan1 k1 = new kegiatan1();
            k1.registerAkun(email, password, tabelAkun);
        }
        return false;
    }

    public boolean hapusAkun(String email, String password, HashMap tabelAkun) {
        System.out.println("Silahkan Hapus Akun Anda");
        System.out.println("Masukkan Email : ");
        email = sc.next();
        System.out.println("Masukkan Password : ");
        password = sc.next();
        if (tabelAkun.containsKey(email) == false) {
            System.out.println("Email yang anda masukkan salah");
            kegiatan1 k1 = new kegiatan1();
            k1.hapusAkun(email, password, tabelAkun);
        } else {
            tabelAkun.remove(email);
            System.out.println("Email yang anda masukkan berhasil dihapus");
        }
        return false;
    }

    public int totalEmailUMM(HashMap tabelAkun) {
        int hitung = 0;
        HashMap<String, String> ekstensi = new HashMap<>();
        ekstensi.put("@umm.ac.id", "");
        for (Object key : tabelAkun.keySet()) {
            if (key.equals(ekstensi)) {
                hitung++;
            }
        }
        System.out.println("Total email yang menggunakan ekstensi email umm : " + hitung);
        return 0;
    }
}

class kegiatan2 {

    Scanner sc = new Scanner(System.in);
    int hlogin = 0;
    int hlogout = 0;

    public boolean loginAkun(String email, String password, HashMap tabelAkun, HashMap tabelSesiLogin) {
        System.out.println("Silahkan Login Akun Anda");
        System.out.println("Masukkan Email : ");
        email = sc.next();
        System.out.println("Masukkan Password : ");
        password = sc.next();
        if (tabelAkun.containsKey(email) == true && tabelAkun.containsValue(password) == true) {
            tabelSesiLogin.put(email, password);
            System.out.println("Anda Berhasil Login");
            hlogin++;
        } else {
            System.out.println("Anda salah memasukkan email/password");
            kegiatan2 k2 = new kegiatan2();
            k2.loginAkun(email, password, tabelAkun, tabelSesiLogin);
        }
        return false;
    }

    public boolean logoutAkun(String email, HashMap tabelSesiLogin) {
        System.out.println("Silahkan Logout Akun Anda");
        System.out.println("Masukkan Email : ");
        email = sc.next();
        if (tabelSesiLogin.containsKey(email) == true) {
            tabelSesiLogin.remove(email);
            System.out.println("Anda Telah Logout");
            hlogout++;
        } else {
            System.out.println("Anda salah memasukkan email");
            kegiatan2 k2 = new kegiatan2();
            k2.logoutAkun(email, tabelSesiLogin);
        }
        return false;
    }

    public int totalLogin() {
        System.out.println("Total Login : " + hlogin);
        return 0;
    }

    public int totalLogout() {
        System.out.println("Total Logout : " + hlogout);
        return 0;
    }

    public int totalAuth(HashMap tabelSesiLogin) {
        System.out.println("Total data yang sedang login : " + tabelSesiLogin.size());
        return 0;
    }
}
