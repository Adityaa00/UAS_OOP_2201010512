
package gymm;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static gymm.koneksi.getKoneksi;
import javax.swing.table.DefaultTableModel;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author eadit
 *
 */
public class GYMMFORM extends javax.swing.JFrame {

    
    
    DefaultTableModel TM = new DefaultTableModel();

    public GYMMFORM() throws SQLException {
        initComponents();
        gym_tbl.setModel(TM);
        TM.addColumn("id_member");
        TM.addColumn("nama_member");
        TM.addColumn("jenis_member");
        TM.addColumn("jenis_kelamin");
        TM.addColumn("tgl_pendaftaran");
        TM.addColumn("tgl_habis");
        
        this.setTitle("Aplikasi Pendaftaran Member GYM");
        ImageIcon IC = new ImageIcon("img/INSTIKII.png");
        this.setIconImage(IC.getImage());
        
        List_all();
        kosongkanform();
        loadphoto("");
    }
    
    private void loadphoto(String idx){
        String nopic = "src/img/nopic.png";
        String img = "src/img/"+idx+".png";

        BufferedImage phototeman = loadphoto.loadImage(img);
        if (phototeman == null) {
            phototeman = loadphoto.loadImage(nopic);
        }
        ImageIcon iconphoto = new ImageIcon(phototeman);
        imgData.setIcon(iconphoto);
    }
    
    private void List_all () throws SQLException {
        
        TM.getDataVector().removeAllElements();       
        TM.fireTableDataChanged();
        
        Connection cnn = getKoneksi() ;
        if(!cnn.isClosed()){
            
            String sql = "SELECT * FROM member";
            PreparedStatement PS = cnn.prepareStatement(sql);
            ResultSet rs = PS.executeQuery();
            
            while(rs.next()){
                
                String idBrg = rs.getString("id_member");
                String namaBrg = rs.getString("nama_member");
                String jumlah = rs.getString("jenis_member");
                String kondisi = rs.getString("jenis_kelamin");
                String tglInput = rs.getString("tgl_pendaftaran");
                String tglHabis = rs.getString("tgl_habis");
                Object[] dta = new Object[6];
                dta [0] = idBrg;
                dta [1] = namaBrg;
                dta [2] = jumlah;
                dta [3] = kondisi;
                dta [4] = tglInput;
                dta [5] = tglHabis;
                TM.addRow(dta);
                
            }
           
        }
        
    }
    
    private  void storeData() throws SQLException{
        Connection cnn = getKoneksi();
        String nama = TxNama.getText();
        String jenis_member = TxMember.getText();
        String jenis_kelamin = TxKelamin.getText();
        String tgl_pendaftaran = TxPendaftaran.getText();
        String tgl_habis = TxHabis.getText();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement(
            "INSERT INTO member(nama_member,jenis_member,jenis_kelamin,tgl_pendaftaran,tgl_habis) VALUES (?,?,?,?,?);");
            PS.setString(1, nama);
            PS.setString(2, jenis_member);
            PS.setString(3 ,jenis_kelamin);
            PS.setString(4, tgl_pendaftaran);
            PS.setString(5, tgl_habis);
            PS.executeUpdate();
        }

    }
    
    private void updateData() throws SQLException {
        Connection cnn = getKoneksi();
        
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement(
            "UPDATE member SET nama_member=?,jenis_kelamin=?,jenis_kelamin=?,tgl_pendaftaran=?,tgl_habis=? WHERE id_member =?;");
            PS.setString(1, TxNama.getText());
            PS.setString(2, TxMember.getText());
            PS.setString(3, TxKelamin.getText());
            PS.setString(4 ,TxPendaftaran.getText());
            PS.setString(5 ,TxHabis.getText());
            PS.setString(6 ,TxID.getText());
            PS.executeUpdate();
            cnn.close();
        }
        
    }
    
    private void destroyData() throws SQLException {
        
        Connection cnn = getKoneksi();
        if(!cnn.isClosed()){
        
            PreparedStatement PS = cnn.prepareStatement(
            "DELETE FROM member WHERE id_member =?;");
            PS.setString(1, TxID.getText());
            PS.executeUpdate();
            cnn.close();
        }

    }
    
    private void kosongkanform(){
        
        TxID.setText("");
        TxNama.setText("");
        TxMember.setText("");
        TxKelamin.setText("");
        TxPendaftaran.setText("");
        TxHabis.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnTUTUP = new javax.swing.JButton();
        TxKelamin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gym_tbl = new javax.swing.JTable();
        TxPendaftaran = new javax.swing.JTextField();
        TxHabis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxID = new javax.swing.JTextField();
        TxNama = new javax.swing.JTextField();
        imgData = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnINPUT = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnUPDATE = new javax.swing.JButton();
        TxMember = new javax.swing.JTextField();
        btnHAPUS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("jenis_kelamin");

        btnTUTUP.setText("TUTUP");
        btnTUTUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTUTUPActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SISTEM INPUT MEMBER GYM");

        jLabel6.setText("tgl_pendaftaran");

        gym_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_member", "nama_member", "jenis_member", "jenis_kelamin", "tgl_pendaftaran", "tgl_habis"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        gym_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gym_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gym_tbl);

        TxHabis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxHabisActionPerformed(evt);
            }
        });

        jLabel2.setText("id_member");

        jLabel7.setText("tgl_habis");

        TxNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxNamaActionPerformed(evt);
            }
        });

        imgData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setText("nama_member");

        btnINPUT.setText("INPUT");
        btnINPUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINPUTActionPerformed(evt);
            }
        });

        jLabel4.setText("jenis_member");

        btnUPDATE.setText("UPDATE");
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });

        btnHAPUS.setText("HAPUS");
        btnHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHAPUSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TxNama, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                        .addComponent(TxID)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel6))
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxPendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(TxKelamin, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                            .addComponent(TxMember))
                                        .addComponent(TxHabis, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(30, 30, 30)
                            .addComponent(imgData, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnINPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnTUTUP, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(184, 184, 184)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imgData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(96, 96, 96)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxPendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxHabis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnINPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTUTUP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTUTUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTUTUPActionPerformed
        if(btnTUTUP.getText().equals("Tutup Form")){
            dispose();
        }else{
            btnTUTUP.setText("Tutup Form");
            btnTUTUP.setText("Input");
        }
    }//GEN-LAST:event_btnTUTUPActionPerformed

    private void gym_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gym_tblMouseClicked
        TxID.setText(gym_tbl.getValueAt( gym_tbl.getSelectedRow(),0).toString());
        TxNama.setText(gym_tbl.getValueAt( gym_tbl.getSelectedRow(),1).toString());
        TxMember.setText(gym_tbl.getValueAt( gym_tbl.getSelectedRow(),2).toString());
        TxKelamin.setText(gym_tbl.getValueAt( gym_tbl.getSelectedRow(),3).toString());
        TxPendaftaran.setText(gym_tbl.getValueAt( gym_tbl.getSelectedRow(),4).toString());
        TxHabis.setText(gym_tbl.getValueAt( gym_tbl.getSelectedRow(),5).toString());
        loadphoto(TxID.getText());
    }//GEN-LAST:event_gym_tblMouseClicked

    private void TxHabisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxHabisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxHabisActionPerformed

    private void TxNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxNamaActionPerformed

    private void btnINPUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINPUTActionPerformed
        if(btnINPUT.getText().equals("Input")){
            btnINPUT.setText("Simpan");
            btnTUTUP.setText("Batal");
            kosongkanform();
            gym_tbl.setEnabled(false);
        }else{
            btnINPUT.setText("Input");
            btnTUTUP.setText("Tutup Form");
            gym_tbl.setEnabled(true);
            try {
                storeData();
                List_all();
            } catch (SQLException ex) {
                Logger.getLogger(GYMMFORM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnINPUTActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed
        if(btnUPDATE.getText().equals("update")){
            btnUPDATE.setText("Simpan");
            btnTUTUP.setText("Batal");
        }else{
            btnUPDATE.setText("update");
            btnTUTUP.setText("Tutup Form");
            try {
                updateData();
                List_all();
                JOptionPane.showMessageDialog(this, "Data telah diupdate");
            } catch (SQLException ex) {
                Logger.getLogger(GYMMFORM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void btnHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAPUSActionPerformed
        int jwb = JOptionPane.showOptionDialog(
            this,
            "Apakah anda yakin akan menghapus data dengan nim : "+ TxID.getText() + "?" ,
            "Hapus data",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null,
            null,
            null);
        if(jwb == JOptionPane.YES_OPTION){
            try {
                destroyData();
                List_all();
                JOptionPane.showMessageDialog(this, "Data telah dihapus");
            } catch (SQLException ex) {
                Logger.getLogger(GYMMFORM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnHAPUSActionPerformed

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
            java.util.logging.Logger.getLogger(GYMMFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GYMMFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GYMMFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GYMMFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GYMMFORM().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GYMMFORM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxHabis;
    private javax.swing.JTextField TxID;
    private javax.swing.JTextField TxKelamin;
    private javax.swing.JTextField TxMember;
    private javax.swing.JTextField TxNama;
    private javax.swing.JTextField TxPendaftaran;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnINPUT;
    private javax.swing.JButton btnTUTUP;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JTable gym_tbl;
    private javax.swing.JLabel imgData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
