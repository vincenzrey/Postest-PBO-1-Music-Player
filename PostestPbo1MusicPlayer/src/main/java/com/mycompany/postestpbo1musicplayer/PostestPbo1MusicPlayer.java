/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.postestpbo1musicplayer;

import Lagu.Lagu;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class PostestPbo1MusicPlayer {
    private static ArrayList<Lagu> playlist = new ArrayList<>();
    private Lagu LaguDiPutar;
    Scanner objekscanner = new Scanner(System.in);
    
    public PostestPbo1MusicPlayer() {
        playlist = new ArrayList<>();
        LaguDiPutar = null;
        objekscanner = new Scanner(System.in);
    }   
    
    public void tambahRecordLagu() {
        playlist.add(new Lagu(1,"Blinding Lights", "The Weeknd", 3.2));
        playlist.add(new Lagu(2,"Shape of You", "Ed Sheeran", 4.2));
        playlist.add(new Lagu(3,"Bohemian Rhapsody", "Queen", 5.9));
        playlist.add(new Lagu(4,"Rolling in the Deep", "Adele", 3.8));
        playlist.add(new Lagu(5,"Hotel California", "Eagles", 6.3));
        playlist.add(new Lagu(6,"Someone Like You", "Adele", 4.5));
        playlist.add(new Lagu(7,"Let It Be", "The Beatles", 4.0));
        playlist.add(new Lagu(8,"Billie Jean", "Michael Jackson", 4.5));
        playlist.add(new Lagu(9,"Thinking Out Loud", "Ed Sheeran", 4.4));
        playlist.add(new Lagu(10,"Stay", "Justin Bieber & The Kid LAROI", 2.5));
    }
    
    public void tambahlagu(){
        System.out.println("Masukan Judul Lagu :");
        String judul = objekscanner.nextLine();
        System.out.println("Masukan Artis Lagu : ");
        String artis = objekscanner.nextLine();
        System.out.println("Masukan Durasi Lagu :");
        double durasi = objekscanner.nextDouble();
        objekscanner.nextLine();
        int nomorlagubaru = playlist.size() + 1;
        Lagu Lagubaru = new Lagu(nomorlagubaru, judul, artis, durasi);
        playlist.add (Lagubaru);
        System.out.println("Lagu Baru Berhasil di Tambahkan");
    }
        
    public void lihatPlaylist(){
        if (playlist.isEmpty()){
            System.out.println("Playlist masih kosong");
        } else {
            System.out.println("\n--- Playlist ---");
            for (Lagu lagu : playlist) {
                System.out.println(+ lagu.nomorlagu() + "Judul: " + lagu.getjudul() + ", Artis: " + lagu.getartis() + ", Durasi: " + lagu.getdurasi() + " menit");
            }
        }
    }
    
    public void ubahlagu(){
        if (playlist.isEmpty()) {
            System.out.println("Playlist Masih Kosong");
            return;
        }

        lihatPlaylist(); 
        System.out.println("Masukkan Nomor Lagu yang Ingin diperbarui:");
        int nomorLagu = objekscanner.nextInt();
        objekscanner.nextLine(); 

        if (nomorLagu < 1 || nomorLagu > playlist.size()) {
            System.out.println("Nomor lagu tidak valid");
            return;
        }

        Lagu lagu = playlist.get(nomorLagu - 1); 
        System.out.println("Mengedit lagu: " + lagu.getjudul());

        System.out.println("Masukkan Judul Baru (tekan Enter untuk tidak mengubah):");
        String judulBaru = objekscanner.nextLine();
        if (!judulBaru.isEmpty()) {
            lagu.setjudul(judulBaru);
        }

        System.out.println("Masukkan Artis Baru (tekan Enter untuk tidak mengubah):");
        String artisBaru = objekscanner.nextLine();
        if (!artisBaru.isEmpty()) {
            lagu.setartis(artisBaru);
        }

        System.out.println("Masukkan Durasi Baru (dalam menit, tekan Enter untuk tidak mengubah):");
        String durasiBaru = objekscanner.nextLine();
        if (!durasiBaru.isEmpty()) {
            lagu.setdurasi(Double.parseDouble(durasiBaru));
        }

        System.out.println("Lagu Berhasil diperbaharui");
    }
    
    public void hapuslagu() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist Masih Kosong");
        } else {
            System.out.print("Masukan Judul Lagu Yang Ingin di Hapus : ");
            String title = objekscanner.nextLine();
            boolean found = false;

            for (Lagu lagu : playlist) {
                if (lagu.getjudul().equalsIgnoreCase(title)) {
                    playlist.remove(lagu);
                    System.out.println("Lagu Berhasid dihapus");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Lagu Tidak di Temukan");
            }
        }
    }
    
    public void putarlagu() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist Masih Kosong");
            return;
        }
        lihatPlaylist();
        System.out.print("Masukkan Judul Lagu yang Ingin diputar: ");
        String judul = objekscanner.nextLine();
        boolean found = false;

        for (Lagu lagu : playlist) {
            if (lagu.getjudul().equalsIgnoreCase(judul)) {
                LaguDiPutar = lagu;
                System.out.println("Sedang memutar: " + lagu.getjudul() + " oleh " + lagu.getartis());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Lagu Tidak ditemukan");
        }
    }

    public static void main(String[] args) {
        PostestPbo1MusicPlayer musicPlayer = new PostestPbo1MusicPlayer();
        boolean running = true;
        musicPlayer.tambahRecordLagu();

        while (running) {
            System.out.println("\n--- Menu Music Player ---");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Tampilkan Playlist");
            System.out.println("3. Mengubah Lagu Dalam Playlist");
            System.out.println("4. Menghapus Lagu");
            System.out.println("5. Putar Lagu");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = musicPlayer.objekscanner.nextInt();
            musicPlayer.objekscanner.nextLine(); 

            if (pilihan == 1) {
                musicPlayer.tambahlagu();
            } else if (pilihan == 2) {
                musicPlayer.lihatPlaylist();
            } else if (pilihan == 3) {
                musicPlayer.ubahlagu();
            } else if (pilihan == 4) {
                musicPlayer.hapuslagu();
            } else if (pilihan == 5) {
                musicPlayer.putarlagu();
            } else if (pilihan == 6) {
                running = false;
                System.out.println("Keluar dari Music Player...");
            } else {
                System.out.println("Opsi tidak valid, silakan coba lagi.");
            }
        }
    }
}

