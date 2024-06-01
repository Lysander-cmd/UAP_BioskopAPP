/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap_bioskopapp;

import java.util.Map;

/**
 *
 * @author USER
 */
public class AksiUser extends Aksi {
    @Override
    public void tampilanAksi() {
        System.out.println("Aksi User:");
        System.out.println("1. Lihat Saldo");
        System.out.println("2. Lihat List Film");
        System.out.println("3. Pesan Film");
        System.out.println("4. Lihat Pesanan");
        System.out.println("5. Logout");
        System.out.println("6. Tutup Aplikasi");
    }

    public void lihatSaldo() {
        System.out.println("Saldo anda: " + Akun.getCurrentUser().getSaldo());
    }

    @Override
    public void lihatListFilm() {
        System.out.println("Daftar Film:");
        for (Film film : Film.getFilms().values()) {
            System.out.println(film.getName() + " - " + film.getDescription() + " - Harga: " + film.getPrice() + " - Stok: " + film.getStock());
        }
    }

    public void pesanFilm() {
        System.out.print("Nama Film yang ingin dipesan: ");
        String namaFilm = Main.scanner.nextLine();
        Film film = Film.getFilms().get(namaFilm);
        if (film == null) {
            System.out.println("Film yang dicari tidak ditemukan.");
            return;
        }
        System.out.print("Jumlah tiket yang ingin dipesan: ");
        int jumlahTiket = Main.scanner.nextInt();
        if (jumlahTiket > film.getStock()) {
            System.out.println("Stok tiket tidak mencukupi.");
            return;
        }
        double totalHarga = jumlahTiket * film.getPrice();
        System.out.println("Harga satuan tiket " + film.getPrice());
        System.out.println("Total harga " + totalHarga);
        if (totalHarga > Akun.getCurrentUser().getSaldo()) {
            System.out.println("Saldo tidak mencukupi, saldo yang dimiliki " + Akun.getCurrentUser().getSaldo() + ".");
            return;
        }
        film.setStock(film.getStock() - jumlahTiket);
        Akun.getCurrentUser().setSaldo(Akun.getCurrentUser().getSaldo() - totalHarga);
        Akun.getCurrentUser().addPesanan(film, jumlahTiket);
        System.out.println("Tiket berhasil dipesan.");
    }

    public void lihatPesanan() {
        Map<String, Pesanan> pesananUser = Akun.getCurrentUser().getPesanan();
        if (pesananUser.isEmpty()) {
            System.out.println("Kamu belum pernah melakukan pemesanan.");
        } else {
            for (Pesanan pesanan : pesananUser.values()) {
                Film film = pesanan.getFilm();
                System.out.println("Film: " + film.getName() + " - Jumlah: " + pesanan.getKuantitas() + " - Total Harga: " + (film.getPrice() * pesanan.getKuantitas()));
            }
        }
    }
    @Override
    public void keluar() {
        Akun.logout();
        System.out.println("Anda telah logout.");
    }
    @Override
    public void tutupAplikasi() {
        System.out.println("Aplikasi ditutup.");
        System.exit(0);
    }
}


