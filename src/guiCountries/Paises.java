
package guiCountries;

import static guiCountries.AdminPais.listapaistarifa;
import static guiCountries.AdminPais.listatipocambio;
import static guiCountries.Registro.listaUsuarios;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;


public class Paises extends javax.swing.JFrame {

    ArrayList <String> listaPaises = new ArrayList <>();
    public static ArrayList <variableReporteTransf> reptranf = new ArrayList();
       
    public Paises() {
        initComponents();
        listapais ();
        listaservicio ();
        //vermoneda ();
        this.setLocationRelativeTo(null);
        this.setTitle("Transferencias De Dinero"); 
    }
     
    public void listapais (){
        String p = (String )listaP.getSelectedItem();
        
        for (int i = 0 ; i < listapaistarifa.size(); i++ ){
        listaP.addItem(listapaistarifa.get(i).getPais());
        }
    }
     
    public void listaservicio () {
    
    ArrayList servicio = new ArrayList ();
    
    servicio.add("Inmediato");
    servicio.add("Dia siguiente");
    int i; 
    for (i=0; i < servicio.size(); i++){
        listaS.addItem(servicio.get(i) + "");
        }
}
    
    public void tarifaxpais () {
            
        int precio = Integer.parseInt(txtmonto.getText());
        int tarifa = 0;
        String pais = (String)listaP.getSelectedItem();
        String monedaenvio = (String) Combomonedaenvio.getSelectedItem();
        
        if (monedaenvio.equals("CRC")){
        
        for (int i = 0 ; i < listapaistarifa.size() ; i++ ){
            if (pais.equals(listapaistarifa.get(i).getPais())){
                    
            if (precio < 100000){
                tarifa = listapaistarifa.get(i).getTecho1();
            }

            else if (precio < 1000000){
                tarifa = listapaistarifa.get(i).getTecho2();
            }
            else if (precio < 4999999){
                tarifa = listapaistarifa.get(i).getTecho3();
            }

            else if (precio > 5000000){

                JOptionPane.showMessageDialog(rootPane,"Monto de envio supera el maximo permitido. Favor ingrese un monto menor");
                txtmonto.setText("");
            }
            txttarifa1.setText(tarifa +"");
            }
        }
    }
        if (monedaenvio.equals("USD")){
            
                
        for (int i = 0 ; i < listapaistarifa.size() ; i++ ){
            if (pais.equals(listapaistarifa.get(i).getPais())){
                    
            if (precio < 165){
                tarifa = listapaistarifa.get(i).getTecho1()/ listatipocambio.get(i).getTipocambio();
            }

            else if (precio < 1650){
                tarifa = listapaistarifa.get(i).getTecho2()/ listatipocambio.get(i).getTipocambio();
            }
            else if (precio < 8000){
                tarifa = listapaistarifa.get(i).getTecho3()/ listatipocambio.get(i).getTipocambio();
            }

            else if (precio > 8000){

                JOptionPane.showMessageDialog(rootPane,"Monto de envio supera el maximo permitido. Favor ingrese un monto menor");
                txtmonto.setText("");
            }
            txttarifa1.setText(tarifa +"");
            }
        }
    }    
    }
    
    private void tarifaservicio (){
                  
        int v = Integer.parseInt(txtmonto.getText());
        int tar;
        
        String tipo = (String) listaS.getSelectedItem();
        String monedaenvio = (String) Combomonedaenvio.getSelectedItem().toString();
        
        if (monedaenvio.equals("CRC")){
        
        
        if (tipo.equals("Inmediato")){
        
        if ( v < 100000){
        tar = 20;
        }
        else if (v < 1000000) {
        tar = 75;
        }
        else if (v < 5000000){
        tar = 200;
        }
        else if (v < 10000000){
        tar = 500;}
        else {
        tar = 500000;}
        
        txttarifa.setText(tar + "");
        }
        
        else if (tipo.equals("Dia siguiente")){
            if ( v < 100000){
        tar = 5;
        }
        else if (v < 1000000) {
        tar = 50;
        }
        else if (v < 5000000){
        tar = 100;
        }
        else if (v < 10000000){
        tar = 250;}
        else {
        tar = 0;}
            
        txttarifa.setText(tar + "");
        }
        }
        
        if (monedaenvio.equals("USD")){
        
        
        if (tipo.equals("Inmediato")){
        
        if ( v < 100000){
        tar = 5;
        }
        else if (v < 1000000) {
        tar = 10;
        }
        else if (v < 5000000){
        tar = 30;
        }
        else if (v < 10000000){
        tar = 60;}
        else {
        tar = 500000;}
        
        txttarifa.setText(tar + "");
        }
        
        else if (tipo.equals("Dia siguiente")){
            if ( v < 100000){
        tar = 1;
        }
        else if (v < 1000000) {
        tar = 6;
        }
        else if (v < 5000000){
        tar = 22;
        }
        else if (v < 10000000){
        tar = 52;}
        else {
        tar = 0;}
            
        txttarifa.setText(tar + "");
        }
        }
    }
        
    private void total (){
    
    int t = Integer.parseInt(txtmonto.getText());
    int t2 = Integer.parseInt(txttarifa.getText());
    int t3 = Integer.parseInt(txttarifa1.getText());
    
    int tot = t + t2 +t3;
    
    txttotal.setText(tot +"");
    }
    
    private void resetAmount (){
    txttarifa1.setText("");    
    txtmonto.setText("");
    txttarifa.setText("");
    txttotal.setText("");
    }
    
    public void reportetrans(){
        
        String padest = listaP.getSelectedItem().toString();
        String tipenv = listaS.getSelectedItem().toString();
        String monedaenv = Combomonedaenvio.getSelectedItem().toString();
        int monenv = Integer.parseInt(txtmonto.getText());
        int tardest = Integer.parseInt(txttarifa.getText());
        int tarserv = Integer.parseInt(txttarifa1.getText());
        int totcan = Integer.parseInt(txttotal.getText());
        String fecha;
        
        Fecha nuevafecha1 = new Fecha();
        fecha = nuevafecha1.FechaActual();
        
        variableReporteTransf rep = new variableReporteTransf();
        
        //espacio de usuario agregado para saber a quien pertenece el registro
        rep.setUsuario(Login.usuario);
        rep.setPaisdestino(padest);
        rep.setTipoenvio(tipenv);
        rep.setMonedaenvio(monedaenv);
        rep.setMontoenv(monenv);
        rep.setTarifdest(tardest);
        rep.setTarifserv(tarserv);
        rep.setTottransf(totcan);
        rep.setFecha(fecha);
                
        
        reptranf.add(rep);
    
    
    } 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listaP = new javax.swing.JComboBox<>();
        lblpais = new javax.swing.JLabel();
        listaS = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtmonto = new javax.swing.JTextField();
        lblmonto = new javax.swing.JLabel();
        btnrefrescar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txttarifa = new javax.swing.JTextField();
        lblmonto2 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        lblmonto1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblmonto3 = new javax.swing.JLabel();
        txttarifa1 = new javax.swing.JTextField();
        Combomonedaenvio = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Plataforma de envio de dinero");

        listaP.setToolTipText("");
        listaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPActionPerformed(evt);
            }
        });

        lblpais.setBackground(new java.awt.Color(153, 153, 153));
        lblpais.setFont(new java.awt.Font("Consolas", 1, 26)); // NOI18N
        lblpais.setForeground(new java.awt.Color(255, 255, 255));
        lblpais.setText("Paises destino: ");

        listaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaSActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de envio:");

        lblmonto.setFont(new java.awt.Font("Consolas", 1, 26)); // NOI18N
        lblmonto.setForeground(new java.awt.Color(255, 255, 255));
        lblmonto.setText("Monto a enviar: ");

        btnrefrescar.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        btnrefrescar.setForeground(new java.awt.Color(255, 153, 102));
        btnrefrescar.setText("Refrescar");
        btnrefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefrescarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 0));
        jButton1.setText("verificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txttarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttarifaActionPerformed(evt);
            }
        });

        lblmonto2.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lblmonto2.setForeground(new java.awt.Color(255, 255, 255));
        lblmonto2.setText("Tarifa por pais destino:");

        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        lblmonto1.setFont(new java.awt.Font("Consolas", 1, 26)); // NOI18N
        lblmonto1.setForeground(new java.awt.Color(255, 255, 255));
        lblmonto1.setText("Total a cancelar: ");

        jButton2.setForeground(new java.awt.Color(0, 51, 102));
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setForeground(new java.awt.Color(153, 0, 0));
        jButton3.setText("Calcelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lblmonto3.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lblmonto3.setForeground(new java.awt.Color(255, 255, 255));
        lblmonto3.setText("Tarifa por servicio:");

        txttarifa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttarifa1ActionPerformed(evt);
            }
        });

        Combomonedaenvio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CRC", "USD" }));
        Combomonedaenvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombomonedaenvioActionPerformed(evt);
            }
        });

        jButton4.setText("Continuar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblmonto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblmonto3, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                            .addComponent(lblpais, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblmonto2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listaS, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttarifa1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Combomonedaenvio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(listaP, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnrefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(lblmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpais, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaS, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Combomonedaenvio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmonto2)
                    .addComponent(txttarifa1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmonto3)
                    .addComponent(txttarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmonto1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnrefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
        for (int i = 0; i < listaUsuarios.size(); i++) {
            //este if compara el nombre de usuario logueado con los de la lista para encontrar su posicion en ella
            if (listaUsuarios.get(i).getUsuario().equalsIgnoreCase(Login.usuario)) {
                int totcan = Integer.parseInt(txttotal.getText());
                //verifica que el monto que se va a rebajar de la cuenta no exceda la cantidad de saldo disponible
                if (totcan < listaUsuarios.get(i).getSaldo()) {
                    reportetrans();

                    //reportetransferencia procesar = new reportetransferencia ();
                    txtmonto.setText("");
                    txttarifa.setText("");
                    txttarifa1.setText("");
                    txttotal.setText("");

                    JOptionPane.showMessageDialog(rootPane, "Transferencia enviada satisfactoriamente");

                    String transcorreo = listaUsuarios.get(i).getCorreo().toString();

                    try {

                        CorreoTransferencia mailtransf = new CorreoTransferencia(transcorreo);
                        mailtransf.enviarcorreotransf();
                        JOptionPane.showMessageDialog(rootPane, "Correo de confirmacion enviado a: " + transcorreo);

                    } catch (UnsupportedEncodingException | MessagingException e) {
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El monto de la transacción excede los fondos del usuario");
                }

            }
        }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Verifique que todos los datos han sido agregados correctamente");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CombomonedaenvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombomonedaenvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CombomonedaenvioActionPerformed

    private void txttarifa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttarifa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttarifa1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtmonto.setText("");
        txttarifa.setText("");
        txttarifa1.setText("");
        txttotal.setText("");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Menu view= new Menu();
        view.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txttarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttarifaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttarifaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
        tarifaxpais ();
        tarifaservicio ();
        total ();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Verique los datos ingresados he intente de nuevo");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed
        resetAmount ();
    }//GEN-LAST:event_btnrefrescarActionPerformed

    private void listaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaSActionPerformed

    }//GEN-LAST:event_listaSActionPerformed

    private void listaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPActionPerformed

    }//GEN-LAST:event_listaPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combomonedaenvio;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblmonto;
    private javax.swing.JLabel lblmonto1;
    private javax.swing.JLabel lblmonto2;
    private javax.swing.JLabel lblmonto3;
    private javax.swing.JLabel lblpais;
    private javax.swing.JComboBox<String> listaP;
    private javax.swing.JComboBox<String> listaS;
    private javax.swing.JTextField txtmonto;
    private javax.swing.JTextField txttarifa;
    private javax.swing.JTextField txttarifa1;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
