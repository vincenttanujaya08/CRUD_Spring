package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "students")
public class Student {
    @Id
    @NotBlank
    @Column(nullable = false)
    private String nim;

    @NotBlank
    @Column(nullable = false)
    private String namaDepan;

    @Column(nullable = true)
    private String namaBelakang; // optional

    @NotNull
    @Column(nullable = false)
    private LocalDate tanggalLahir;


    public Student() { }

    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNamaDepan() {
        return namaDepan;
    }
    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }
    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }
    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

}
