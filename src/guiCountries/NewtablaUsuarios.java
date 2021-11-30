
package guiCountries;

import static guiCountries.Registro.listaUsuarios;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


public class NewtablaUsuarios extends javax.swing.JFrame {

   // ArrayList <Usuarios> newlistaUsuarios = new ArrayList();
    DefaultTableModel t;
    
    
     public NewtablaUsuarios() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("Reportes de usuarios");
        listaUsuarios = new ArrayList<Usuarios>();
        t = (DefaultTableModel) tblDatos.getModel();

//            t.addColumn("Nombre");
//            t.addColumn("Apellido");
//            t.addColumn("Correo");
//            t.addColumn("Usuario");
//            t.addColumn("Contraseña");
//        this.setTitle("Tabla de Usuarios");
//        cargarTabla ();
}
    
 
public void cargarTabla (){
        t.setRowCount(0);
                
        for (int i=0 ; i < listaUsuarios.size(); i++ ){
            t.addRow(new Object[]{
                listaUsuarios.get(i).getNombre(),
                listaUsuarios.get(i).getApellido(),
                listaUsuarios.get(i).getCorreo(),
                listaUsuarios.get(i).getUsuario(),
//                listaUsuarios.get(i).getContrasena(),
                listaUsuarios.get(i).getRol(),
                
                
               // listaUsuarios.get(i).getDia(),
                //listaUsuarios.get(i).getMes(),
                //listaUsuarios.get(i).getAno(),
        });
        }    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btnmenu = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnCargar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btnmenu.setText("Volver a Registro");
        Btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnmenuActionPerformed(evt);
            }
        });

        jButton2.setText("Ir al Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Correo", "Usuario", "Roll"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDatos);

        btnCargar.setText("Cargar Información");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar reporte ");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Información del usuario registrado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btnmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(btnCargar)
                        .addGap(80, 80, 80)
                        .addComponent(btnEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar)
                    .addComponent(btnEnviar)
                    .addComponent(Btnmenu)
                    .addComponent(jButton2))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnmenuActionPerformed
        
       Registro regreso = new Registro();
       regreso.setVisible(true);
       dispose();
        
                
    }//GEN-LAST:event_BtnmenuActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Menu v = new Menu();
       v.setVisible(true);
       dispose();
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        
        cargarTabla();
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        Reportes report = new Reportes("REPORTE DE REGISTROS", new Date().toString(), "C:\\Users\\Equipo3\\Documents\\Castro Carazo\\Segundo Cuatri\\Proga\\NetBeansProjects\\JavaProject\\src\\Imagenes\\Fondo Menu.jpg","C:\\Users\\Equipo3\\Documents\\Castro Carazo\\Segundo Cuatri\\Proga\\NetBeansProjects\\JavaProject\\src\\Imagenes\\motivacion1.jpg",listaUsuarios);
        report.CrearReporte();
    }//GEN-LAST:event_btnEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(NewtablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewtablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewtablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewtablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewtablaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnmenu;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables

    void setModel(DefaultTableModel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
