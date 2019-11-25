/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Auth1 {

    static HashMap<String, String> tabelAkun = new HashMap<String, String>();
    static HashMap<String, String> tabelSesiLogin = new HashMap<String, String>();
    String email, password;
    Scanner sc = new Scanner(System.in);
    int hlogin = 0, hlogout = 0;

    public void pilihKegiatan() {
        int pilihan;
        System.out.println("Menu\n1. Kegiatan 1\t 2. Kegiatan 2\t 3. Keluar");
        System.out.println("Masukkan Pilihan : ");
        pilihan = sc.nextInt();
        switch (pilihan) {
            case 1:
                Auth1 a1 = new Auth1();
                a1.registerAkun(email, password);
                a1.hapusAkun(email, password);
                a1.totalEmailUMM();
                a1.pilihKegiatan();
                break;
            case 2:
                Auth1 a2 = new Auth1();
                a2.loginAkun(email, password);
                a2.logoutAkun(email);
                a2.totalLogin();
                a2.totalAuth();
                a2.totalLogout();
                a2.totalAuth();
                a2.pilihKegiatan();
                break;
            case 3:
                System.out.println("Terima Kasih");
                break;
            default:
                System.out.println("Tidak Ada Pilihan");
                Auth1 a3 = new Auth1();
                a3.pilihKegiatan();
                break;
        }
    }

    public boolean dataAkun() {
        String[][] dataAkun = new String[][]{
            {"labit@umm.ac.id", "kharismamuzaki@gmail.com", "byasageng@gmail.com", "dosen.tersayang@umm.ac.id", "email.saya@umm.ac.id"},
            {"Labit321", "Testing123", "cobalagi321", "dosenkuGG", "email_Student"}};
        int barisMasuk = 0;
        if (dataAkun[0].length == dataAkun[1].length) {
            while (barisMasuk < dataAkun[0].length) {
                tabelAkun.put(dataAkun[0][barisMasuk], dataAkun[1][barisMasuk]);
                barisMasuk++;
            }
        } else {
            System.out.println("Data panjang kolom tidak sama");
        }
        return false;
    }

    public boolean registerAkun(String email, String password) {
        System.out.println("");
        System.out.println("SILAHKAN REGISTER EMAIL");
        System.out.println("Masukkan Email : ");
        email = sc.next();
        System.out.println("Masukkan Password : ");
        password = sc.next();
        if (tabelAkun.containsKey(email) == false ) {
            tabelAkun.put(email, password);
            System.out.println("Anda Berhasil Register");
        } else {
            System.out.println("Email yang anda masukkan telah digunakan/ tidak sesuai ketentuan");
            Auth1 a1 = new Auth1();
            a1.registerAkun(email, password);
        }
        return false;
    }

    public boolean hapusAkun(String email, String password) {
        System.out.println("");
        System.out.println("SILAHKAN HAPUS EMAIL");
        System.out.println("Masukkan Email : ");
        email = sc.next();
        System.out.println("Masukkan Password : ");
        password = sc.next();
        if (tabelAkun.containsKey(email) == false && tabelAkun.containsValue(password) == false) {
            System.out.println("Email yang anda masukkan salah");
            Auth1 a1 = new Auth1();
            a1.hapusAkun(email, password);
        } else {
            tabelAkun.remove(email);
            System.out.println("Email yang anda masukkan berhasil dihapus");
        }
        return false;
    }

    public int totalEmailUMM() {
        int hitung = 0;
        for (String key : tabelAkun.keySet()) {
            if (key.endsWith("@umm.ac.id")) {
                hitung++;
            }
        }
        System.out.println("Total email yang menggunakan ekstensi email umm : " + hitung);
        return 0;
    }

    public boolean loginAkun(String email, String password) {
        System.out.println("");
        System.out.println("LOGIN");
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
            Auth1 a2 = new Auth1();
            a2.loginAkun(email, password);
        }
        return false;
    }

    public boolean logoutAkun(String email) {
        System.out.println("");
        System.out.println("LOGOUT");
        System.out.println("Masukkan Email : ");
        email = sc.next();
        if (tabelSesiLogin.containsKey(email) == true) {
            tabelSesiLogin.remove(email);
            System.out.println("Anda Telah Logout");
            hlogout++;
        } else {
            System.out.println("Anda salah memasukkan email");
            Auth1 a2 = new Auth1();
            a2.logoutAkun(email);
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

    public int totalAuth() {
        System.out.println("Total data yang sedang login : " + tabelSesiLogin.size());
        return 0;
    }
}
