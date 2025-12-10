import java.util.Scanner;

public class MagangArray {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("\n=== Sistem Pendaftaran Magang Mahasiswa ===");
        System.out.println("1. Tambah Data Magang");
        System.out.println("2. Tampilkan Semua Pendaftar Magang");
        System.out.println("3. Cari Pendaftar berdasarkan Program Studi");
        System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
        String menu = in.nextLine();

        System.out.println("Pilihan tidak valid!");

        in.close();
    }
}
