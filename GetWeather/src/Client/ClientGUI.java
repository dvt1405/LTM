/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author tun
 */
public class ClientGUI extends javax.swing.JFrame {

    /**
     * Creates new form ClientGUI
     */
    private ArrayList<Pair<String, String>> listCapitalCity;
    private client c;

    public ClientGUI() {
        this.listCapitalCity = new ArrayList<>();
        initComponents();
        setLocationRelativeTo(this);
        this.showValues.setEnabled(false);
        c = new client();
        c.connect("localhost", 80);
        this.showValues.setEnabled(true);
        this.showJson.setEnabled(false);
        this.showXml.setEnabled(false);
        c.getCapitalCity();
        this.cityListComboBox.removeAllItems();
        for (int i = 0; i < c.getListCapital().size(); i++) {
            String items = c.getListCapital().get(i).getKey();
            if (!items.equalsIgnoreCase("")) {
                this.cityListComboBox.addItem(items);
            }
        }
        this.showValues.setSize(50, 50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        cityListComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        showJson = new javax.swing.JButton();
        showXml = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        showValues = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Get Weather");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cityListComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cityListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityListComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Choose a city");

        showJson.setText("Show Json");
        showJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showJsonActionPerformed(evt);
            }
        });

        showXml.setText("Show XML");
        showXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showXmlActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thành phố", "Thời tiết ", "Nhiệt độ (°C)", "Độ ẩm(%)", "Áp suất(hPa)", "Mây", "Tầm nhìn(m)"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTabbedPane1.addTab("Thông tin thời tiết", jScrollPane2);

        showValues.setColumns(20);
        showValues.setRows(5);
        jScrollPane1.setViewportView(showValues);

        jTabbedPane1.addTab("XML/Json String", jScrollPane1);

        jLabel2.setText("Ngày: ");

        jLabel4.setText("yyyy-mm-ddThh-mm-ss");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(showJson)
                .addGap(53, 53, 53)
                .addComponent(showXml)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cityListComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(cityListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showJson)
                    .addComponent(showXml))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cityListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityListComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityListComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.showValues.setText("");
        String citySelected = this.cityListComboBox.getSelectedItem().toString();
        System.out.println(citySelected);
        this.c.requestGetWeather(citySelected);
        this.c.receiveWeatherJson();
        this.c.receiveWeatherXml();
        if (this.c.getJsonReceived() == null) {
            JOptionPane.showMessageDialog(null, "Unknow weather of this city! Choose other citty! Sorry");
        } else {
            this.c.readXml(this.c.getXmlReceived());
            this.showJson.setEnabled(true);
            this.showXml.setEnabled(true);
            DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
            model.addRow(this.c.getWeather().toObject());
            this.jLabel4.setText(this.c.getWeather().getLastUpdate());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void showJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showJsonActionPerformed
        // TODO add your handling code here:
        this.showValues.setRows(10);
        this.jTabbedPane1.setSelectedIndex(1);
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = g.toJson(c.getJsonReceived());
        this.showValues.setText(prettyJson);
        System.out.println(c.parseJsontoXmlStrting(c.getJsonReceived()));

    }//GEN-LAST:event_showJsonActionPerformed

    private void showXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showXmlActionPerformed
        // TODO add your handling code here:
        this.jTabbedPane1.setSelectedIndex(1);
        String s = c.formatXml(c.getXmlReceived());
        this.showValues.removeAll();
        this.showValues.setText(s);
        System.out.println(c.getWeather().toString());
    }//GEN-LAST:event_showXmlActionPerformed

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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cityListComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton showJson;
    private javax.swing.JTextArea showValues;
    private javax.swing.JButton showXml;
    // End of variables declaration//GEN-END:variables
}
