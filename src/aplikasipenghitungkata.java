/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author ASUS
 */
public class aplikasipenghitungkata extends javax.swing.JFrame {
private JTextArea textArea;
private javax.swing.JLabel searchResultLabel;
    /**
     * Creates new form aplikasipenghitungkata
     */
    public aplikasipenghitungkata() {
        initComponents();
        String kataDicari = searchField.getText().trim();
        if (!kataDicari.isEmpty()) {
            int jumlahKemunculan = cariKata(kataDicari);
            searchResultLabel.setText("Jumlah Kemunculan: " + jumlahKemunculan);
        }
    jTextArea1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                hitungTeks();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                hitungTeks();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                hitungTeks();
            }
        });    
    }
private void hitungTeks() {
        String teks = jTextArea1.getText();
        String[] kataArray = teks.trim().split("\\s+");
        int jumlahKata = teks.isEmpty() ? 0 : kataArray.length;
        int jumlahKarakter = teks.replace(" ", "").length();
        String[] kalimatArray = teks.split("[.!?]+");
        int jumlahKalimat = teks.isEmpty() ? 0 : kalimatArray.length;
        String[] paragrafArray = teks.split("\\n\\n+");
        int jumlahParagraf = teks.isEmpty() ? 0 : paragrafArray.length;

        labelKata.setText("Jumlah Kata: " + jumlahKata);
        labelKarakter.setText("Jumlah Karakter: " + jumlahKarakter);
        labelKalimat.setText("Jumlah Kalimat: " + jumlahKalimat);
        labelParagraf.setText("Jumlah Paragraf: " + jumlahParagraf);
    }

    private int cariKata(String kata) {
        String teks = jTextArea1.getText().toLowerCase();
        kata = kata.toLowerCase();
        String[] kataArray = teks.split("\\s+");
        int count = 0;
        for (String word : kataArray) {
            if (word.equals(kata)) { count++; }
        }
        return count;
    }
    
    private void saveToFile() {
    // Membuka JFileChooser untuk memilih file lokasi penyimpanan
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Pilih Lokasi untuk Menyimpan File");
    int result = fileChooser.showSaveDialog(this);
    
    if (result == JFileChooser.APPROVE_OPTION) {
        // Mendapatkan lokasi dan nama file yang dipilih
        File file = fileChooser.getSelectedFile();
        
        // Menyiapkan teks yang akan disimpan
        String teks = jTextArea1.getText();
        String jumlahKata = labelKata.getText();
        String jumlahKarakter = labelKarakter.getText();
        String jumlahKalimat = labelKalimat.getText();
        String jumlahParagraf = labelParagraf.getText();
        
        // Membuat isi file yang akan disimpan
        StringBuilder fileContent = new StringBuilder();
        fileContent.append("Teks:\n");
        fileContent.append(teks).append("\n\n");
        fileContent.append("Hasil Perhitungan:\n");
        fileContent.append(jumlahKata).append("\n");
        fileContent.append(jumlahKarakter).append("\n");
        fileContent.append(jumlahKalimat).append("\n");
        fileContent.append(jumlahParagraf).append("\n");
        
        // Menyimpan isi ke file yang dipilih
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(fileContent.toString());
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        labelKata = new javax.swing.JLabel();
        labelKarakter = new javax.swing.JLabel();
        labelKalimat = new javax.swing.JLabel();
        labelParagraf = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        lbCariKata = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        hasillabel = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Penghitung Kata");

        jPanel1.setBackground(new java.awt.Color(204, 102, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        labelKata.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelKata.setText("Jumlah Kata :");

        labelKarakter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelKarakter.setText("Jumlah Karakter :");

        labelKalimat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelKalimat.setText("Jumlah Kalimat :");

        labelParagraf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelParagraf.setText("Jumlah Paragraf :");

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lbCariKata.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCariKata.setText("Cari Kata :");

        hasillabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hasillabel.setText("Hasil :");

        btnHitung.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        btnSimpan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnKeluar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelKata, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbCariKata, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(hasillabel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelKarakter, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)
                                .addComponent(labelKalimat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelParagraf, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelKata)
                            .addComponent(labelParagraf))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelKarakter)
                            .addComponent(labelKalimat))
                        .addGap(33, 33, 33)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCariKata, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(hasillabel)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
        hitungTeks();
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        saveToFile();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
             String kataDicari = searchField.getText().trim();
            if (!kataDicari.isEmpty()) {
                int jumlahKemunculan = cariKata(kataDicari);
                hasillabel.setText("Jumlah Kemunculan: " + jumlahKemunculan);
            }

    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(aplikasipenghitungkata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aplikasipenghitungkata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aplikasipenghitungkata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aplikasipenghitungkata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new aplikasipenghitungkata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel hasillabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelKalimat;
    private javax.swing.JLabel labelKarakter;
    private javax.swing.JLabel labelKata;
    private javax.swing.JLabel labelParagraf;
    private javax.swing.JLabel lbCariKata;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}