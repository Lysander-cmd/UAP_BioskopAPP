/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap_bioskopapp;

/**
 *
 * @author USER
 */
public class AksiAdmin extends Aksi {
    @Override
    public void tampilanAksi() {
        System.out.println("Aksi Admin:");
        System.out.println("1. Lihat List Film");
        System.out.println("2. Tambah Film");
        System.out.println("3. Logout");
        System.out.println("4. Tutup Aplikasi");
    }

    @Override
    public void lihatListFilm() {
        System.out.println("Daftar Film:");
        for (Film film : Film.getFilms().values()) {
            System.out.println(film.getName() + " - " + film.getDescription() + " - Harga: " + film.getPrice() + " - Stok: " + film.getStock());
        }
    }

    public void tambahFilm() {
        System.out.print("Nama Film: ");
        String namaFilm = Main.scanner.next();
        System.out.print("Deskripsi Film: ");
        String deskripsiFilm = Main.scanner.next();
        System.out.print("Harga Tiket: ");
        int  hargaTiket = Main.scanner.nextInt();
        System.out.print("Stok Tiket: ");
        int stokTiket = Main.scanner.nextInt();
        Film.addFilm(namaFilm, deskripsiFilm, hargaTiket, stokTiket);
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

