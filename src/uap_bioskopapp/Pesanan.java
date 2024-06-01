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
public class Pesanan {
    private final Film film;
    private final int kuantitas;

    public Pesanan(Film film, int kuantitas) {
        this.film = film;
        this.kuantitas = kuantitas;
    }

    public Film getFilm() {
        return film;
    }

    public int getKuantitas() {
        return kuantitas;
    }
}

