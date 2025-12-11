import java.util.Scanner;

public class SistemMagang {
    static Scanner scanner = new Scanner(System.in);
    static String[][] dataMagang = new String[100][6];
    static int jumlahData = 0;

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

    // buat create data
    static void tambahData() {
        System.out.print("Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Program Studi: ");
        String prodi = scanner.nextLine();
        System.out.print("Perusahaan Tujuan Magang: ");
        String pt = scanner.nextLine();

        String semester;
        while (true) {
            System.out.print("Semester pengambilan magang (6 atau 7): ");
            semester = scanner.nextLine();
            if (semester.equals("6") || semester.equals("7")) {
                break;
            }
            System.out.println("Semester harus 6 atau 7!");
        }

        String status;
        while (true) {
            System.out.print("Status magang (Diterima/Menunggu/Ditolak): ");
            status = scanner.nextLine();
            if (status.equalsIgnoreCase("Diterima") ||
                    status.equalsIgnoreCase("Menunggu") ||
                    status.equalsIgnoreCase("Ditolak")) {

                if (status.equalsIgnoreCase("Diterima"))
                    status = "Diterima";
                else if (status.equalsIgnoreCase("Menunggu"))
                    status = "Menunggu";
                else
                    status = "Ditolak";
                break;
            }
            System.out.println("Error: Status harus Diterima, Menunggu, atau Ditolak!");
        }

        dataMagang[jumlahData][0] = nama;
        dataMagang[jumlahData][1] = nim;
        dataMagang[jumlahData][2] = prodi;
        dataMagang[jumlahData][3] = pt;
        dataMagang[jumlahData][4] = semester;
        dataMagang[jumlahData][5] = status;

        jumlahData++;
        System.out.println("Data pendaftaran magang berhasil ditambahkan. Total pendaftar: " + jumlahData);

    }

    // buat tampilkan data
    static void tampilkanData() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data.");
            return;
        }

        System.out.printf("%-20s %-10s %-20s %-15s %-10s %-10s\n",
                "NAMA", "NIM", "PRODI", "PERUSAHAAN", "SMT", "STATUS");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i = 0; i < jumlahData; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0)
                    System.out.printf("%-20s ", dataMagang[i][j]);
                else if (j == 1)
                    System.out.printf("%-10s ", dataMagang[i][j]);
                else if (j == 2)
                    System.out.printf("%-20s ", dataMagang[i][j]);
                else if (j == 3)
                    System.out.printf("%-15s ", dataMagang[i][j]);
                else if (j == 4)
                    System.out.printf("%-10s ", dataMagang[i][j]);
                else
                    System.out.printf("%-10s", dataMagang[i][j]);
            }
            System.out.println();
        }
    }

    // cari data prodi
    static void cariProdi() {
        System.out.print("Masukkan Program Studi yang dicari: ");
        String cariProdi = scanner.nextLine();

        boolean ditemukan = false;
        System.out.println("Data Mahasiswa Magang ");
        System.out.printf("%-20s %-10s %-20s %-15s %-10s %-10s\n",
                "NAMA", "NIM", "PRODI", "PERUSAHAAN", "SMT", "STATUS");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i = 0; i < jumlahData; i++) {
            if (dataMagang[i][2].equalsIgnoreCase(cariProdi)) {
               System.out.printf("%-20s %-10s %-20s %-15s %-10s %-10s\n",
                dataMagang[i][0], 
                dataMagang[i][1], 
                dataMagang[i][2], 
                dataMagang[i][3], 
                dataMagang[i][4],
                dataMagang[i][5]  
        );

        ditemukan = true;
    }
        }

        if (ditemukan == false) {
            System.out.println("Data tidak ditemukan untuk prodi tersebut.");
        }

    }

    // jumlah pendaftar dari statusnya
    static void Status() {
        int countDiterima = 0;
        int countMenunggu = 0;
        int countDitolak = 0;

        for (int i = 0; i < jumlahData; i++) {
            String status = dataMagang[i][5];
            if (status.equals("Diterima")) {
                countDiterima++;
            } else if (status.equals("Menunggu")) {
                countMenunggu++;
            } else if (status.equals("Ditolak")) {
                countDitolak++;
            }
        }

        System.out.println("Diterima : " + countDiterima);
        System.out.println("Menunggu : " + countMenunggu);
        System.out.println("Ditolak  : " + countDitolak);
        System.out.println("Total pendaftar: " + jumlahData);

    }
}