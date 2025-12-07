package com.example.demo.domain.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Student {

    private final String nim;
    private String namaDepan;
    private String namaBelakang;
    private LocalDate tanggalLahir;

    public Student(String nim, String namaDepan, String namaBelakang, LocalDate tanggalLahir) {
        if (nim == null || nim.isBlank()) {
            throw new IllegalArgumentException("NIM tidak boleh kosong");
        }
        if (namaDepan == null || namaDepan.isBlank()) {
            throw new IllegalArgumentException("Nama depan tidak boleh kosong");
        }
        if (tanggalLahir == null) {
            throw new IllegalArgumentException("Tanggal lahir tidak boleh kosong");
        }

        this.nim = nim;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.tanggalLahir = tanggalLahir;
    }

    public String getNamaLengkap() {
        String depan = namaDepan == null ? "" : namaDepan.trim();
        String belakang = namaBelakang == null ? "" : namaBelakang.trim();

        if (depan.isBlank()) return belakang;
        if (belakang.isBlank()) return depan;

        return depan + " " + belakang;
    }

    public int getUsia() {
        if (tanggalLahir == null) return 0;
        return Period.between(tanggalLahir, LocalDate.now()).getYears();
    }

    public void updateDetails(String namaDepan, String namaBelakang, LocalDate tanggalLahir) {
        if (namaDepan == null || namaDepan.isBlank()) {
            throw new IllegalArgumentException("Nama depan tidak boleh kosong");
        }
        if (tanggalLahir == null) {
            throw new IllegalArgumentException("Tanggal lahir tidak boleh kosong");
        }

        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.tanggalLahir = tanggalLahir;
    }

    public String getNim() {
        return nim;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nim, student.nim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nim);
    }

    @Override
    public String toString() {
        return "Student{" +
                "nim='" + nim + '\'' +
                ", namaLengkap='" + getNamaLengkap() + '\'' +
                ", usia=" + getUsia() +
                '}';
    }
}