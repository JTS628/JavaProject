package guiCountries;

import static guiCountries.Registro.listaUsuarios;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import guiCountries.Paises;
import static guiCountries.Paises.reptranf;
import guiCountries.Registro;
import javax.swing.JOptionPane;

public class Mi_Cuenta extends javax.swing.JFrame {

    ArrayList<Paises> listaTrans = new ArrayList<>();
    DefaultTableModel trans;

    public Mi_Cuenta() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Mi Cuenta");
        trans = (DefaultTableModel) tbTransacciones.getModel();
        cargarRepTranf();
        setUsuario();
        setlbSaldo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        btnDepositar = new javax.swing.JButton();
        lbMicuenta = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTransacciones = new javax.swing.JTable();
        lbTransacciones = new javax.swing.JLabel();
        lbS = new javax.swing.JLabel();
        lbsaldo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbSaldoDolares = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese el monto ");

        btnAtras.setText("Atrrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnRetirar.setText("Retirar ");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        btnDepositar.setText("Depositar ");
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });

        lbMicuenta.setFont(new java.awt.Font("Yu Gothic Light", 1, 36)); // NOI18N
        lbMicuenta.setForeground(new java.awt.Color(255, 255, 255));
        lbMicuenta.setText("Mi cuenta");

        lbUsuario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbUsuario.setText("Usuario");

        tbTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "País", "Envio", "Monto", "Tarifa Destino", "Tarifa Servicio", "Total", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(tbTransacciones);

        lbTransacciones.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lbTransacciones.setForeground(new java.awt.Color(255, 255, 255));
        lbTransacciones.setText("Transacciones ");

        lbS.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        lbS.setForeground(new java.awt.Color(255, 255, 255));
        lbS.setText("Saldo Actual:");

        lbsaldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbsaldo.setForeground(new java.awt.Color(255, 255, 255));
        lbsaldo.setText("monto del saldo ");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("$");

        lbSaldoDolares.setForeground(new java.awt.Color(255, 255, 255));
        lbSaldoDolares.setText("Monto en dolares");

        jButton1.setText("Generar Reporte ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lbUsuario)
                .addGap(270, 270, 270)
                .addComponent(lbMicuenta)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTransacciones)
                .addGap(257, 257, 257))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnRetirar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDepositar))
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbS)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel2)
                                        .addGap(38, 38, 38)
                                        .addComponent(lbSaldoDolares))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(lbsaldo)))
                                .addGap(14, 14, 14)))
                        .addGap(106, 106, 106))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btnAtras)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(259, 259, 259))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbMicuenta)
                        .addGap(21, 21, 21)
                        .addComponent(lbTransacciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbS)
                                    .addComponent(lbsaldo))
                                .addGap(88, 88, 88)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRetirar)
                                    .addComponent(btnDepositar))
                                .addGap(63, 63, 63)
                                .addComponent(btnAtras)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbSaldoDolares)
                                    .addComponent(jLabel2))))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        Menu view = new Menu();
        view.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed

        for (int i = 0; i < listaUsuarios.size(); i++) {
            //este if compara el nombre de usuario logueado con los de la lista para encontrar su posicion en ella
            if (listaUsuarios.get(i).getUsuario().equalsIgnoreCase(Login.usuario)) {
                int saldo = listaUsuarios.get(i).getSaldo() - Integer.parseInt(txtMonto.getText());
                if (saldo >= 0) {
                    listaUsuarios.get(i).setSaldo(saldo);
                    setlbSaldo();
                    setlbSaldoDolares();
                } else {
                    JOptionPane.showMessageDialog(null, "El monto de la transacción excede los fondos del usuario");
                }

            }
        }

    }//GEN-LAST:event_btnRetirarActionPerformed

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        for (int i = 0; i < listaUsuarios.size(); i++) {
            //este if compara el nombre de usuario logueado con los de la lista para encontrar su posicion en ella
            if (listaUsuarios.get(i).getUsuario().equalsIgnoreCase(Login.usuario)) {
                int saldo = listaUsuarios.get(i).getSaldo() + Integer.parseInt(txtMonto.getText());
                listaUsuarios.get(i).setSaldo(saldo);
                setlbSaldo();
                setlbSaldoDolares();
            }
        }
    }//GEN-LAST:event_btnDepositarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ReportePersonal view = new ReportePersonal();
        view.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void setlbSaldo() {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            //este if compara el nombre de usuario logueado con los de la lista para encontrar su posicion en ella
            if (listaUsuarios.get(i).getUsuario().equalsIgnoreCase(Login.usuario)) {
                lbsaldo.setText(listaUsuarios.get(i).getSaldo() + "");
            }
        }
    }

    public void setlbSaldoDolares() {

        double totalDolares;

        for (int i = 0; i < listaUsuarios.size(); i++) {
            //este if compara el nombre de usuario logueado con los de la lista para encontrar su posicion en ella
            if (listaUsuarios.get(i).getUsuario().equalsIgnoreCase(Login.usuario)) {
                lbSaldoDolares.setText(listaUsuarios.get(i).getSaldo() / 620 + "");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMicuenta;
    private javax.swing.JLabel lbS;
    private javax.swing.JLabel lbSaldoDolares;
    private javax.swing.JLabel lbTransacciones;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lbsaldo;
    private javax.swing.JTable tbTransacciones;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables

    public void cargarRepTranf() {
        trans.setRowCount(0);

        for (int i = 0; i < reptranf.size(); i++) {
            if (reptranf.get(i).getUsuario().equalsIgnoreCase(Login.usuario)) {
                trans.addRow(new Object[]{
                    reptranf.get(i).getPaisdestino(),
                    reptranf.get(i).getTipoenvio(),
                    reptranf.get(i).getMontoenv(),
                    reptranf.get(i).getTarifdest(),
                    reptranf.get(i).getTarifserv(),
                    reptranf.get(i).getTottransf(),
                    reptranf.get(i).getFecha(),});
            }
        }

    }

    public void setUsuario() {
        lbUsuario.setText(Login.usuario);
    }

}
