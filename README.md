# Postest-PBO-1-Music-Player
Deskripsi Program 
Music Player dapat digunakan user untuk menambahkan lagu, melihat playlist, mengubah lagu dan memutar lagu

Struktur Program
Program ini terdiri dari beberapa bagian utama yaitu:
Class Lagu Lagu: Mendefinisikan objek lagu yang terdiri dari nomor lagu, judul lagu, artis, dan durasi lagu.
Class PostestPbo1MusicPlayer : Menangani logika utama aplikasi, termasuk manajemen playlist dan interaksi pengguna.

Package Lagu
Class Lagu
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lagu;

/**
 *
 * @author DELL
 */
public class Lagu {
    private int nomorlagu;
    private String judul;
    private String artis;
    private double durasi;
    
    public Lagu(int nomorlagu, String judul, String artis, double durasi){
        this.nomorlagu = nomorlagu;
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }
    
    public void displayinfo(){
        System.out.println(+nomorlagu+ "judul :" +judul+ ",artis :" +artis+ ",durasi :" +durasi+ "menit");
    }
    
    public int nomorlagu(){
    return nomorlagu;
    }
    
    public String getjudul(){
        return judul;
    }
    
    public String getartis(){
        return artis;
    }
    
    public double getdurasi(){
        return durasi;
    } 
    
    public void setnomorlagu(int nomorlagu){
    this.nomorlagu = nomorlagu;
    }
    
    public void setjudul(String judul){
        this.judul = judul;
    }
    
    public void setartis(String artis){
        this.artis = artis;
    }
    
    public void setdurasi(double durasi){
        this.durasi = durasi;
    }  
}

Package com.mycompany.postestpbo1musicplayer
Class PostestPbo1MusicPlayer
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

Output
Program yang saya buat adalah Music Player Sederhana dimana user dapat menambahkan lagu, melihat playlist, mengubah lagu dan memutar lagu
![image](https://github.com/user-attachments/assets/454be41c-eeec-43cd-8e52-13bde75943e9)

Menambahkan Lagu 
User dapat menambahkan lagu dengan memilih menu 1. Tambah Lagu. User dapat  menambahkan judul lagu, artis dan durasi
![image](https://github.com/user-attachments/assets/daf3ecd2-1c6d-4557-a571-c654fee6341d)
![image](https://github.com/user-attachments/assets/23938e07-346e-4bdb-9b74-9fac892ce411)

Melihat Playlist 
User dapat melihat playlist dengan memilih menu 2. Melihat Playlist
![image](https://github.com/user-attachments/assets/32c9de3b-8acf-4ed8-a2df-0438cdc58630)

Mengubah Lagu 
User dapat mengubah lagu dengan memilih menu 3. Mengubah Lagu. User dapat memperbaharui lagu dengan memasukan nomor lagu didalam playlist dan memasukan judul lagu, artis dan durasi lagu yang baru. Apanila tidak ingin menubah user dapat melewati dengan menekan tombol enter
![image](https://github.com/user-attachments/assets/b2ec4b36-1ffd-4cc3-9b28-ecf8e3ddfe5b)
![image](https://github.com/user-attachments/assets/97a8c6e2-3295-42e6-81f4-e622db2b0241)

Menghapus lagu 
User dapat menghapus lagu dengan memilih menu 4. Menghapus Lagu kemudian memasukan judul lagu yang ingin di hapus
![image](https://github.com/user-attachments/assets/140a6b09-b364-4984-a200-4db25acfb7aa)
![image](https://github.com/user-attachments/assets/b5d6b24e-788e-4bcc-b7ce-16d83c59d4b2)

Memutar lagu 
User dapat memutar lagu dengan memilih menu 5. Putar Lagu kemudian memasukan judul lagu yang di putar
![image](https://github.com/user-attachments/assets/1afd4335-69fc-4de6-9869-6c4ea24d33c4)

Keluar 
Untuk keluar dari program user dapat memilih menu 6. Keluar
![image](https://github.com/user-attachments/assets/190931cb-6dc6-43c9-9fce-5868857ff17b)
