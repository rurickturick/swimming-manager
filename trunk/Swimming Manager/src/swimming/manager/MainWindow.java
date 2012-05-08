/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package swimming.manager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juanlu
 */
public class MainWindow extends JFrame {

    /**
     * Creates new form MainWindow
     */
    
    private SwimmingManager swimming;
    
    private final JTable tabla;
    private DefaultTableModel tableModel;
    private JButton botonMolon;
    
    public MainWindow() {
        initComponents();
        this.setTitle("Swimming Manager");
        Image img=Toolkit.getDefaultToolkit().getImage("images/Swimming_Manager_Logo_modelo_2.png");
        this.setIconImage(img);
        
        initListener();
        botonMolon = new JButton("Botón Molón");
        this.setLayout(new BorderLayout());
        
        //this.add(botonMolon, "North");
        
        tableModel = new DefaultTableModel();
        tabla = new JTable(tableModel);
        JScrollPane container = new JScrollPane(tabla);
        this.getContentPane().add(container);        
        
        
        
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Abrir");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Guardar");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Guardar como...");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Mostrar todo");
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Salir");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Buscar por...");

        jMenuItem7.setText("Nombre");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Nacionalidad");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Sexo");
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Estilo");
        jMenu2.add(jMenuItem10);

        jMenuItem11.setText("Distancia");
        jMenu2.add(jMenuItem11);

        jMenuItem12.setText("Núm. Federativo");
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("Edad");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuItem14.setText("Marca");
        jMenu2.add(jMenuItem14);

        jMenuItem15.setText("Récord");
        jMenu2.add(jMenuItem15);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Editar");

        jMenuItem16.setText("Dar de alta");
        jMenu3.add(jMenuItem16);

        jMenuItem17.setText("Dar de baja");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenu6.setText("Nadador");

        jMenuItem18.setText("Añadir marca");
        jMenu6.add(jMenuItem18);

        jMenuItem19.setText("Eliminar marca");
        jMenu6.add(jMenuItem19);

        jMenuItem20.setText("Información");
        jMenu6.add(jMenuItem20);

        jMenu3.add(jMenu6);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Comparar");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ayuda");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        jMenuItem21.setText("Acerca de...");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem21);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        JOptionPane.showMessageDialog(null, ""
                + "Creado por '6+2' para Ingeniería del Software.\nUniversidad Complutense de Madrid."
                , "Swimming Manager 0.1", 1, null);
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
         JOptionPane.showMessageDialog(null, ""
                + "Creado por '6+2' para Ingeniería del Software.\nUniversidad Complutense de Madrid."
                , "Swimming Manager 0.1", 1, null);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        System.exit(0);	
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
    private void initListener(){
        jMenuItem2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                  JFileChooser selecFich=new JFileChooser();
                  int i=selecFich.showOpenDialog(MainWindow .this);
                  try {
                      if(i==1) throw new IOException("No se ha seleccionado ningún archivo");
                      else{
                           String fich=selecFich.getSelectedFile().getName();
                                    Scanner f= new Scanner(new File(fich));
                                    fich = fich.substring(0, fich.length()-4); 
                                    JMenu archivo=new JMenu(fich);
                                    
                            }
                    } catch (IOException e1) {
                            JOptionPane.showMessageDialog(null,"No se ha seleccionado archivo");
                    }	  
                    
                    
            }
        });
        jMenuItem4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                  FileNameExtensionFilter filter = new FileNameExtensionFilter("Documentos de texto (*.txt)", ".txt");
				JFileChooser selecFich=new JFileChooser();
				selecFich.addChoosableFileFilter(filter);
				int i=selecFich.showSaveDialog(MainWindow.this);
				try{
					if(i==1) throw new IOException("No se ha guardado ningún archivo");
					else{
						String fich=selecFich.getSelectedFile().getName();
						fich+=".txt";
						
					}					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,"No se ha seleccionado archivo");
				}
                    
            }
        });
        
        jMenuItem16.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(swimming==null) JOptionPane.showMessageDialog(null,"Debe crear un documento nuevo o abrir uno existente.","Dar de alta",0,null);
                else{ 
                    final JFrame mainVentana = new JFrame();
                    mainVentana.setVisible(true);
                    mainVentana.setSize(new Dimension(300, 400));
                    mainVentana.setAlwaysOnTop(true);

                    JPanel mainPanel = new JPanel();
                    mainPanel.setLayout(new BorderLayout());                

                    JPanel auxPanelCampos = new JPanel();
                    GridLayout contenedorCampos = new GridLayout(6, 2, 10, 35);
                    auxPanelCampos.setLayout(contenedorCampos);

                    mainPanel.add(auxPanelCampos, "Center");
                    JPanel auxPanelBotones = new JPanel();
                    auxPanelBotones.setEnabled(true);

                    JButton botonAceptar = new JButton();
                    botonAceptar.setText("Aceptar");
                    JButton botonCancelar = new JButton();
                    botonCancelar.setText("Cancelar");
                    auxPanelBotones.add(botonAceptar);
                    auxPanelBotones.add(botonCancelar);                
                    mainPanel.add(auxPanelBotones, "South");                              

                    JLabel campoNombre = new JLabel();
                    campoNombre.setText("Nombre: ");
                    JLabel campoNacionalidad = new JLabel("Nacionalidad: ");
                    JLabel campoSexo = new JLabel("Sexo: ");
                    JLabel diaNac = new JLabel("Día de Nacimiento: ");
                    JLabel mesNac = new JLabel("Mes de Nacimiento: ");
                    JLabel annoNac = new JLabel("Año de Nacimiento: ");

                    final JTextField nombreTexto = new JTextField();
                    final JTextField nacionTexto = new JTextField();
                    final JTextField diaTexto = new JTextField();
                    final JTextField mesTexto = new JTextField();
                    final JTextField annoTexto = new JTextField();
                    final JTextField sexoTexto = new JTextField();

                    auxPanelCampos.add(campoNombre);
                    auxPanelCampos.add(nombreTexto);
                    auxPanelCampos.add(campoNacionalidad);
                    auxPanelCampos.add(nacionTexto);
                    auxPanelCampos.add(campoSexo);
                    auxPanelCampos.add(sexoTexto);
                    auxPanelCampos.add(diaNac);
                    auxPanelCampos.add(diaTexto);
                    auxPanelCampos.add(mesNac);
                    auxPanelCampos.add(mesTexto);
                    auxPanelCampos.add(annoNac);                
                    auxPanelCampos.add(annoTexto);


                    mainVentana.add(mainPanel);          

                    botonCancelar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            mainVentana.dispose();
                        }                
                    });


                    botonAceptar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            try{
                                String fecha = diaTexto.getText()+"-"+mesTexto.getText()+"-"+annoTexto.getText();
                                //swimming.darDeAltaNadador(nombreTexto.getText(), fecha, nacionTexto.getText());
                            }
                            catch(Exception ex){

                            }
                        }

                    });
                }
            }
        });
        
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {              
                JOptionPane.showMessageDialog(null,"Se ha creado un documento en blanco.","",1,null);
                
                String[] columnNames = {"Nombre", "Edad","Sexo","Nacionalidad","Estilo","N. Federativo","Récord"};
                String [][] matriz = new String[0][7];
                tableModel.setDataVector(matriz, columnNames);     
                swimming = new SwimmingManager();
            }
        });                
    }

}
