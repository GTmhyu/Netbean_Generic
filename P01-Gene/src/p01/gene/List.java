/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package p01.gene;

import p01.gene.KoleksiMusik;
import p01.gene.Musik;
import java.awt.PopupMenu;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Afkar
 */
public class List extends javax.swing.JFrame {

    KoleksiMusik koleksi = new KoleksiMusik();

    /**
     * Creates new form List
     */

    private void resizeColumns() {
        float[] columnWidthPercentage = {90.0f, 10.0f};
        int tW = tblPlaylist.getWidth();
        TableColumn column;
        TableColumnModel jTableColumnModel = tblPlaylist.getColumnModel();
        int cantCols = jTableColumnModel.getColumnCount();
        for (int i = 0; i < cantCols; i++) {
            column = jTableColumnModel.getColumn(i);
            int pWidth = Math.round(columnWidthPercentage[i] * tW);
            column.setPreferredWidth(pWidth);
            tblPlaylist.setRowHeight(27);
        }

    }
    private void resizeListener(){
 addComponentListener(new ComponentAdapter() {
 @Override
 public void componentResized(ComponentEvent e) {
 resizeColumns();
 }
 });
 }

    private String fileSizeOf(File file) {
        DecimalFormat format = new DecimalFormat("#.##");
        long MB = 1024 * 1024;
        long KB = 1024;
        final double length = file.length();
        if (length > MB) {
            return format.format(length / MB) + " MB";
        }
        if (length > KB) {
            return format.format(length / KB) + " KB";
        }
        return format.format(length) + " B";
    }

    private String extensionOf(File file) {
        String fileExtension = "";
        String fileName = file.getName();
        if (fileName.contains(".") && fileName.lastIndexOf(".") != 0) {
            fileExtension
                    = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return fileExtension;
    }

    private void addFiles(File[] files) {
        for (File file : files) {
            String path = file.getAbsolutePath();
            String fn = file.getName();
            String fileName = fn.substring(0, fn.length() - 4);
            String fileSize = fileSizeOf(file);
            String extension = "";
            int i = path.lastIndexOf('.');
            if (i > 0) {
                extension = extensionOf(file);
            }
            Musik m = new Musik(path, fileName, fileSize, extension);
            koleksi.add(m);
        }
    }

    private void addFolder(File dir) {
        File[] listOfFiles = dir.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String path = listOfFile.getAbsolutePath();
                String fn = listOfFile.getName();
                String fileName = fn.substring(0, fn.length() - 4);
                String fileSize = fileSizeOf(listOfFile);
                String extension;
                int i = path.lastIndexOf('.');
                if (i > 0) {
                    extension = extensionOf(listOfFile);
                    if ("mp3".equalsIgnoreCase(extension)) {
                        Musik m = new Musik(path, fileName, fileSize, extension);
                        koleksi.add(m);
                    }
                }
            } else if (listOfFile.isDirectory()) {
                addFolder(listOfFile);
            }
        }
    }



public List() {
        initComponents();
        tblPlaylist.setModel(koleksi);
        resizeColumns();
        resizeListener();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopupTombol = new javax.swing.JPopupMenu();
        addfile = new javax.swing.JMenuItem();
        addfolder = new javax.swing.JMenuItem();
        clearplaylist = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnlist = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlaylist = new javax.swing.JTable();

        addfile.setText("Add File");
        addfile.setName("addfile"); // NOI18N
        addfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addfileActionPerformed(evt);
            }
        });
        PopupTombol.add(addfile);

        addfolder.setText("Add Folder");
        addfolder.setName("addfolder"); // NOI18N
        addfolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addfolderActionPerformed(evt);
            }
        });
        PopupTombol.add(addfolder);

        clearplaylist.setText("Clear Playlist");
        clearplaylist.setName("clearplaylist"); // NOI18N
        clearplaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearplaylistActionPerformed(evt);
            }
        });
        PopupTombol.add(clearplaylist);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setName("pnFooter"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(50, 50));

        btnlist.setText("List");
        btnlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnlist)
                .addContainerGap(322, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnlist)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        tblPlaylist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlaylistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPlaylist);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistActionPerformed
     PopupTombol.show(btnlist,
     btnlist.getWidth(),
     btnlist.getHeight()/2);
    }//GEN-LAST:event_btnlistActionPerformed

    private void addfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addfileActionPerformed
       JFileChooser fc = new JFileChooser();
       fc.setDialogType(JFileChooser.FILES_ONLY);
       fc.setMultiSelectionEnabled(true);
       fc.setDialogTitle("Add Files");
       fc.setAcceptAllFileFilterUsed(false);
       fc.setFileFilter(new FileNameExtensionFilter("MP3 File (*.mp3)","mp3"));
       fc.setApproveButtonText("Add file");
       int show = fc.showOpenDialog(this);
       if (show == JFileChooser.APPROVE_OPTION){
       File[] file = fc.getSelectedFiles();
       addFiles(file);
       }
    }//GEN-LAST:event_addfileActionPerformed

    private void addfolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addfolderActionPerformed
            JFileChooser fc = new JFileChooser();
       fc.setDialogType(JFileChooser.DIRECTORIES_ONLY);
       fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
       fc.setDialogTitle("Add Folder");
       fc.setApproveButtonText("Add folder");
       int show = fc.showOpenDialog(this);
       if (show == JFileChooser.APPROVE_OPTION){
       File[] file = fc.getSelectedFiles();
       addFiles(file);
       }
    }//GEN-LAST:event_addfolderActionPerformed

    private void clearplaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearplaylistActionPerformed
    koleksi.clear();
    }//GEN-LAST:event_clearplaylistActionPerformed

    private void tblPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlaylistMouseClicked
    int i = tblPlaylist.getSelectedRow();
    if (evt.getClickCount() == 2 && i != -1) {
    Musik m = koleksi.get(i);
    JOptionPane.showMessageDialog(this, "<html>" +"<head>"
            +"<style>"
            +"table { border-collapse: collapse; border: lpx solid blue; }"
            +"tr { border-bottom:lpt solid black; }"
    +"</style>"
    +"</head>"
            +"<body>"+"<h3>Detail Musik:</h3>"+"<table>"+"<tr><td>Lokasi</td><td>:</td><td> "+ m.getPath()+ "</td></tr>"
    + "<tr><td>Nama File</td><td>:</td><td>" + m.getFileName()+ "</td></tr>"
            + "<tr><td>Ukuran</td><td>:</td><td>" + m.getFileSize()+ "</td></tr>"
            + "<tr><td>Ekstensi</td><td>:</td><td>" + m.getExtention()+ "</td></tr>"
            + "</table>"
            + "</body>" 
            + "</html>");
    }
    
    }//GEN-LAST:event_tblPlaylistMouseClicked

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
            java.util.logging.Logger.getLogger(List.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu PopupTombol;
    private javax.swing.JMenuItem addfile;
    private javax.swing.JMenuItem addfolder;
    private javax.swing.JButton btnlist;
    private javax.swing.JMenuItem clearplaylist;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPlaylist;
    // End of variables declaration//GEN-END:variables
}
