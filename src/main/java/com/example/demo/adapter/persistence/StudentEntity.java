package com.example.demo.adapter.persistence;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @Column(name = "nim", nullable = false, unique = true, length = 20)
    private String nim;

    @Column(name = "nama_depan", nullable = false, length = 100)
    private String namaDepan;

    @Column(name = "nama_belakang", nullable = true, length = 100)
    private String namaBelakang;

    @Column(name = "tanggal_lahir", nullable = false)
    private LocalDate tanggalLahir;

    protected StudentEntity() {
    }

    public StudentEntity(String nim, String namaDepan, String namaBelakang, LocalDate tanggalLahir) {
        this.nim = nim;
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


    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(nim, that.nim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nim);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "nim='" + nim + '\'' +
                ", namaDepan='" + namaDepan + '\'' +
                ", namaBelakang='" + namaBelakang + '\'' +
                ", tanggalLahir=" + tanggalLahir +
                '}';
    }
}