import java.util.Scanner;

public class SistemMagang {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean lanjut = true;
        do {
            tampilkanMenu();
            System.out.print("Pilih menu (1-5): ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    tambahData();
                    break;
                case "2":
                    tampilkanData();
                    break;
                case "3":
                    cariProdi();
                    break;
                case "4":
                    Status();
                    break;
                case "5":
                    System.out.println(" Keluar");
                    lanjut = false;
                    break;
                default:
                    System.out.println("Input salah!");
            }
            System.out.println();
        } while (lanjut);
    }

    static void tampilkanMenu() {
        System.out.println("=== Sistem Pendaftaran Magang Mahasiswa ===");
        System.out.println("1. Tambah Data Magang");
        System.out.println("2. Tampilkan Semua Pendaftar Magang");
        System.out.println("3. Cari Pendaftar berdasarkan Program Studi");
        System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
        System.out.println("5. Keluar");
    }

    //buat create data
    static void tambahData() {
    }

    // buat tampilkan data
    static void tampilkanData() {
    }

    //cari data prodi
    static void cariProdi() {
    }

    //jumlah pendaftar dari statusnya
    static void Status() {
    }
}