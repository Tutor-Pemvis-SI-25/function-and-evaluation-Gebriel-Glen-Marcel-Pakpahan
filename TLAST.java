//Gebriel Glen Marcel Pakpahan - 12S25019//
//Maria Octavia Simorangkir - 12S25033//

import java.util.*;
import java.lang.Math;

public class TLAST {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] deskripsitugas = new String[10], kodematkul = new String[10], dosen = new String[10], deadline = new String[10], nimnama = new String[10], status = new String[10], matkul = new String[10], teks = new String[10];
        double[] tingkatkesulitan = new double[10], prioritas = new double[10];
        int[] harihinggadeadline = new int[10];
        String task;
        int i, n;

        n = 0;
        inisialisasi(deskripsitugas, kodematkul, matkul, dosen, deadline, nimnama, tingkatkesulitan, harihinggadeadline, status, prioritas, teks);
        for (i = 0; i <= 9; i++) {
            task = input.nextLine();
            if (task.equals("Add task")) {
                n = addtask(deskripsitugas, kodematkul, matkul, dosen, deadline, nimnama, tingkatkesulitan, harihinggadeadline, status, prioritas, teks, i, n);
            } else {
                if (task.equals("Update task status")) {
                    updatetaskstatus(kodematkul, status, n);
                    i = i - 1;
                } else {
                    if (task.equals("Show assigment")) {
                        i = i - 1;
                    } else {
                        if (task.equals("---")) {
                            i = 10;
                        }
                    }
                }
            }
        }
        descending(deskripsitugas, kodematkul, matkul, dosen, deadline, nimnama, tingkatkesulitan, harihinggadeadline, status, prioritas, teks, i, n);
        output(deskripsitugas, kodematkul, matkul, dosen, deadline, nimnama, status, prioritas, teks, n);
    }
    
    public static int addtask(String[] deskripsitugas, String[] kodematkul, String[] matkul, String[] dosen, String[] deadline, String[] nimnama, double[] tingkatkesulitan, int[] harihinggadeadline, String[] status, double[] prioritas, String[] teks, int i, int n) {
        deskripsitugas[i] = input.nextLine();
        kodematkul[i] = input.nextLine();
        matkul[i] = input.nextLine();
        dosen[i] = input.nextLine();
        deadline[i] = input.nextLine();
        nimnama[i] = input.nextLine();
        tingkatkesulitan[i] = Double.parseDouble(input.nextLine());
        harihinggadeadline[i] = Integer.parseInt(input.nextLine());
        status[i] = input.nextLine();
        prioritas[i] = tingkatkesulitan[i] * 1.0 / harihinggadeadline[i];
        if (prioritas[i] > 3) {
            teks[i] = "Penting! Anda harus mengerjakan tugas ini segera";
        } else {
            if (prioritas[i] <= 3 && prioritas[i] >= 1.5) {
                teks[i] = "Tugas ini memiliki prioritas menengah";
            } else {
                if (prioritas[i] < 1.5) {
                    teks[i] = "Tugas ini relatif ringan, namun jangan tunda terlalu lama";
                } else {
                    teks[i] = "---";
                }
            }
        }
        n = n + 1;
        
        return n;
    }
    
    public static void descending(String[] deskripsitugas, String[] kodematkul, String[] matkul, String[] dosen, String[] deadline, String[] nimnama, double[] tingkatkesulitan, int[] harihinggadeadline, String[] status, double[] prioritas, String[] teks, int i, int n) {
        int h;
        String svdeskripsitugas, svkodematkul, svdosen, svdeadline, svnimnama, svstatus, svmatkul, svteks;
        double svtingkatkesulitan, svprioritas;
        int svharihinggadeadline;

        for (i = 0; i <= n - 1; i++) {
            for (h = i + 1; h <= n - 1; h++) {
                if (prioritas[i] < prioritas[h]) {
                    svdeskripsitugas = deskripsitugas[h];
                    deskripsitugas[h] = deskripsitugas[i];
                    deskripsitugas[i] = svdeskripsitugas;
                    svkodematkul = kodematkul[h];
                    kodematkul[h] = kodematkul[i];
                    kodematkul[i] = svkodematkul;
                    svmatkul = matkul[h];
                    matkul[h] = matkul[i];
                    matkul[i] = svmatkul;
                    svdosen = dosen[h];
                    dosen[h] = dosen[i];
                    dosen[i] = svdosen;
                    svdeadline = deadline[h];
                    deadline[h] = deadline[i];
                    deadline[i] = svdeadline;
                    svnimnama = nimnama[h];
                    nimnama[h] = nimnama[i];
                    nimnama[i] = svnimnama;
                    svtingkatkesulitan = tingkatkesulitan[h];
                    tingkatkesulitan[h] = tingkatkesulitan[i];
                    tingkatkesulitan[i] = svtingkatkesulitan;
                    svharihinggadeadline = harihinggadeadline[h];
                    harihinggadeadline[h] = harihinggadeadline[i];
                    harihinggadeadline[i] = svharihinggadeadline;
                    svstatus = status[h];
                    status[h] = status[i];
                    status[i] = svstatus;
                    svprioritas = prioritas[h];
                    prioritas[h] = prioritas[i];
                    prioritas[i] = svprioritas;
                    svteks = teks[h];
                    teks[h] = teks[i];
                    teks[i] = svteks;
                }
            }
        }
    }
    
    public static void inisialisasi(String[] deskripsitugas, String[] kodematkul, String[] matkul, String[] dosen, String[] deadline, String[] nimnama, double[] tingkatkesulitan, int[] harihinggadeadline, String[] status, double[] prioritas, String[] teks) {
        int a;

        for (a = 0; a <= 9; a++) {
            deskripsitugas[a] = "";
            kodematkul[a] = "";
            matkul[a] = "";
            dosen[a] = "";
            deadline[a] = "";
            nimnama[a] = "";
            tingkatkesulitan[a] = 0;
            harihinggadeadline[a] = 0;
            status[a] = "";
            prioritas[a] = 0;
            teks[a] = "";
        }
    }
    
    public static void output(String[] deskripsitugas, String[] kodematkul, String[] matkul, String[] dosen, String[] deadline, String[] nimnama, String[] status, double[] prioritas, String[] teks, int n) {
        int i;

        for (i = 0; i <= n - 1; i++) {
            if (status[i].equals("Selesai")) {
                System.out.println("Prioritas: " + toFixed(prioritas[i],2));
                System.out.println(deskripsitugas[i] + "|" + kodematkul[i] + "|" + matkul[i] + "|" + dosen[i] + "|" + nimnama[i] + "|" + status[i]);
            } else {
                if (status[i].equals("Belum Selesai")) {
                    System.out.println("Prioritas: " + toFixed(prioritas[i],2));
                    System.out.println(deskripsitugas[i] + "|" + kodematkul[i] + "|" + matkul[i] + "|" + dosen[i] + "|" + deadline[i] + "|" + nimnama[i] + "|" + status[i] + "|" + teks[i]);
                }
            }
        }
    }
    
    public static void updatetaskstatus(String[] kodematkul, String[] status, int n) {
        String kodenya, setatus;
        int h;

        kodenya = input.nextLine();
        for (h = 0; h <= n - 1; h++) {
            if (kodenya.equals(kodematkul[h])) {
                setatus = input.nextLine();
                status[h] = setatus;
            }
        }
    }
    
    private static String toFixed(double value, int digits) {
        return String.format("%." + digits + "f", value);
    }
}
