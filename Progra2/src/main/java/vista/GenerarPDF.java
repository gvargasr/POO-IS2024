package vista;

import controlador.VistaPrincipalController;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Escuela;
import modelo.Plan;

/**
 *
 * Interfaz grafica para Generar PDF
 * @author gvargasr
 */
public class GenerarPDF extends javax.swing.JFrame {

  /**
   * Creates new form GenerarPDF
   */
  public GenerarPDF() {
    initComponents();
    setLocationRelativeTo(null);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel3 = new javax.swing.JPanel();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    jButton8 = new javax.swing.JButton();
    jLabel15 = new javax.swing.JLabel();
    jComboBox1 = new javax.swing.JComboBox<>();
    jComboBox2 = new javax.swing.JComboBox<>();
    jButton9 = new javax.swing.JButton();
    jButton10 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel3.setPreferredSize(new java.awt.Dimension(450, 450));

    jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel13.setText("Generar Plan en PDF");

    jLabel14.setText("Código del plan de estudios: ");

    jButton8.setText("Generar");
    jButton8.setBorder(
        javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jButton8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton8jButton2ActionPerformed(evt);
      }
    });

    jLabel15.setText("Escuela propietaria del plan:");

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[] {"Item 1", "Item 2", "Item 3", "Item 4"}));
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox1jComboBox1ActionPerformed(evt);
      }
    });

    jComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jComboBox2
        .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"0", "1", "2", "3", "4"}));
    jComboBox2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox2jComboBox2ActionPerformed(evt);
      }
    });

    jButton9.setText("Cerrar");
    jButton9.setBorder(
        javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jButton9.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton9jButton3ActionPerformed(evt);
      }
    });

    jButton10.setText("Limpiar");
    jButton10.setBorder(
        javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jButton10.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton10jButton4ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING,
                javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 173,
                javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(10, 10, 10)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(27, 27, 27))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
            jPanel3Layout.createSequentialGroup().addGap(59, 59, 59)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup().addGap(158, 158, 158).addComponent(
                    jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createSequentialGroup().addGap(47, 47, 47).addComponent(
                    jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 308,
                    javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(68, Short.MAX_VALUE)));
    jPanel3Layout.setVerticalGroup(jPanel3Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup().addGap(18, 18, 18)
            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createSequentialGroup().addGap(4, 4, 4).addComponent(
                    jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                    javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 50,
                        Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(19, Short.MAX_VALUE)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING,
            javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addContainerGap()
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 286,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton8jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8jButton2ActionPerformed
    if (jComboBox1.getSelectedItem() == null || jComboBox2.getSelectedItem() == null) {
      JOptionPane.showMessageDialog(this, "Por favor, seleccione una opción en ambos espacios.",
          "Error de Validación", JOptionPane.ERROR_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(this, "Plan de estudios generado exitosamente!",
          "Generar PDF", JOptionPane.INFORMATION_MESSAGE);
      controlador.GenerarPDFController.eventoBotonGenerarPDF();
    }
  }// GEN-LAST:event_jButton8jButton2ActionPerformed

  private void jComboBox1jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1jComboBox1ActionPerformed
    // TODO add your handling code here:
    String escuelaActual = (String) jComboBox1.getSelectedItem();
    ArrayList<Escuela> listaEscuelas = VistaPrincipalController.modelo.getEscuelas();
    for (Escuela escuela : listaEscuelas) {
      if (escuela.getNombre().equals(escuelaActual)) {
        // updateEscuelas();
        updatePlanes(escuela.getPlanDeEstudio());
        break;
      }
    }
  }// GEN-LAST:event_jComboBox1jComboBox1ActionPerformed

  private void jComboBox2jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox2jComboBox2ActionPerformed
    // TODO add your handling code here:
  }// GEN-LAST:event_jComboBox2jComboBox2ActionPerformed

  private void jButton9jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9jButton3ActionPerformed
    // TODO add your handling code here:
    VistaPrincipalController.mostrar();
    this.dispose();
  }// GEN-LAST:event_jButton9jButton3ActionPerformed

  private void jButton10jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton10jButton4ActionPerformed
    // TODO add your handling code here:
    // Limpiar los textfields
    if (jComboBox1.getSelectedItem() == null || jComboBox2.getSelectedItem() == null) {
      // JOptionPane.showMessageDialog(this, "Por favor, seleccione una opción en ambos
      // ComboBoxes.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
    } else {
      controlador.GenerarPDFController.eventoBotonLimpiar();
    }
  }// GEN-LAST:event_jButton10jButton4ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
          .getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(GenerarPDF.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(GenerarPDF.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(GenerarPDF.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(GenerarPDF.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new GenerarPDF().setVisible(true);
      }
    });
  }


  public void limpiarEspacios() {
    jComboBox1.setSelectedIndex(0);
    jComboBox2.setSelectedIndex(0);
  }

  public void updateEscuelas() {
    ArrayList<Escuela> listaEscuelas = VistaPrincipalController.modelo.getEscuelas();
    jComboBox1.removeAllItems();
    jComboBox2.removeAllItems();
    for (Escuela escuela : listaEscuelas) {
      jComboBox1.addItem(escuela.getNombre());
    }
  }

  public void updatePlanes(ArrayList<Plan> listaPlanes) {
    jComboBox2.removeAllItems();
    for (Plan planActual : listaPlanes) {
      jComboBox2.addItem(String.valueOf(planActual.getCodigo()));
    }
  }

  public JComboBox<String> getjComboBox1() {
    return jComboBox1;
  }

  public void setjComboBox1(JComboBox<String> jComboBox1) {
    this.jComboBox1 = jComboBox1;
  }

  public JComboBox<String> getjComboBox2() {
    return jComboBox2;
  }

  public void setjComboBox2(JComboBox<String> jComboBox2) {
    this.jComboBox2 = jComboBox2;
  }


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton10;
  private javax.swing.JButton jButton8;
  private javax.swing.JButton jButton9;
  private javax.swing.JComboBox<String> jComboBox1;
  private javax.swing.JComboBox<String> jComboBox2;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JPanel jPanel3;
  // End of variables declaration//GEN-END:variables



}