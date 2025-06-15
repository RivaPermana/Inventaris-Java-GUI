/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report_tubes;

/**
 *
 * @author shadkinx
 */
public class Report_Class {
    private int idBarang;
    private String namaBarang;
    private String lokasiBarang;
    private String statusBarang;
    private int stok;

    public Report_Class(int idBarang, String namaBarang, String lokasiBarang, String statusBarang, int stok) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.lokasiBarang = lokasiBarang;
        this.statusBarang = statusBarang;
        this.stok = stok;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getLokasiBarang() {
        return lokasiBarang;
    }

    public String getStatusBarang() {
        return statusBarang;
    }

    public int getStok() {
        return stok;
    }
    
    
}
