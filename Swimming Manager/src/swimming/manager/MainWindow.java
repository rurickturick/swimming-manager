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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
public class MainWindow extends JFrame implements WindowListener{

    /**
     * Creates new form MainWindow
     */
    
    private SwimmingManager swimming;
    
    private final JTable tabla;
    private DefaultTableModel tableModel;
    private Image img;
    
    public MainWindow() {
        initComponents();
        this.setTitle("Swimming Manager");
        img=Toolkit.getDefaultToolkit().getImage("images/Swimming_Manager_Logo_modelo_2.png");
        this.setIconImage(img);        
        initListener();
        this.setLayout(new BorderLayout());
        
        tableModel = new DefaultTableModel();
        tabla = new JTable(tableModel);
        JScrollPane container = new JScrollPane(tabla);
        this.getContentPane().add(container);        
        
        buscarMenu.setVisible(false);
        compararMenu.setVisible(false);
        editarMenu.setVisible(false);
        
        saveButton.setVisible(false);
        saveButton.setEnabled(false);
        saveAsButton.setVisible(false);
        showButton.setVisible(false);
        showButton.setEnabled(false);
        
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
        fileMenu = new javax.swing.JMenu();
        nuevoButton = new javax.swing.JMenuItem();
        openButton = new javax.swing.JMenuItem();
        saveButton = new javax.swing.JMenuItem();
        saveAsButton = new javax.swing.JMenuItem();
        showButton = new javax.swing.JMenuItem();
        exitButton = new javax.swing.JMenuItem();
        buscarMenu = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        editarMenu = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        compararMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        fileMenu.setText("Archivo");

        nuevoButton.setText("Nuevo");
        nuevoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoButtonActionPerformed(evt);
            }
        });
        fileMenu.add(nuevoButton);

        openButton.setText("Abrir");
        fileMenu.add(openButton);

        saveButton.setText("Guardar");
        fileMenu.add(saveButton);

        saveAsButton.setText("Guardar como...");
        fileMenu.add(saveAsButton);

        showButton.setText("Mostrar todo");
        fileMenu.add(showButton);

        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        fileMenu.add(exitButton);

        jMenuBar1.add(fileMenu);

        buscarMenu.setText("Buscar por...");

        jMenuItem7.setText("Nombre");
        buscarMenu.add(jMenuItem7);

        jMenuItem8.setText("Nacionalidad");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        buscarMenu.add(jMenuItem8);

        jMenuItem9.setText("Sexo");
        buscarMenu.add(jMenuItem9);

        jMenuItem10.setText("Estilo");
        buscarMenu.add(jMenuItem10);

        jMenuItem11.setText("Distancia");
        buscarMenu.add(jMenuItem11);

        jMenuItem12.setText("Núm. Federativo");
        buscarMenu.add(jMenuItem12);

        jMenuItem13.setText("Edad");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        buscarMenu.add(jMenuItem13);

        jMenuItem14.setText("Marca");
        buscarMenu.add(jMenuItem14);

        jMenuItem15.setText("Récord");
        buscarMenu.add(jMenuItem15);

        jMenuBar1.add(buscarMenu);

        editarMenu.setText("Editar");

        jMenuItem16.setText("Dar de alta");
        editarMenu.add(jMenuItem16);

        jMenuItem17.setText("Dar de baja");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        editarMenu.add(jMenuItem17);

        jMenu6.setText("Nadador");

        jMenuItem18.setText("Añadir marca");
        jMenu6.add(jMenuItem18);

        jMenuItem19.setText("Eliminar marca");
        jMenu6.add(jMenuItem19);

        jMenuItem20.setText("Información");
        jMenu6.add(jMenuItem20);

        editarMenu.add(jMenu6);

        jMenuBar1.add(editarMenu);

        compararMenu.setText("Comparar");
        jMenuBar1.add(compararMenu);

        helpMenu.setText("Ayuda");
        helpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuActionPerformed(evt);
            }
        });

        jMenuItem21.setText("Acerca de...");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem21);

        jMenuBar1.add(helpMenu);

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

    private void nuevoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Se ha creado un documento en blanco.","",1,null);
                //falta añadir el sexo
                String[] columnNames = {"Nombre", "Edad","Sexo","Nacionalidad","Estilo","N. Federativo","Récord"};
                String [][] matriz = new String[0][columnNames.length];
                tableModel.setDataVector(matriz, columnNames);     
                swimming = new SwimmingManager();
                
                buscarMenu.setVisible(true);
                compararMenu.setVisible(true);
                editarMenu.setVisible(true);
                saveButton.setVisible(true);
                saveAsButton.setVisible(true);
                showButton.setVisible(true);
    }//GEN-LAST:event_nuevoButtonActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
                
                try{                    
                    if(swimming==null) JOptionPane.showMessageDialog(null,"Debe crear un documento nuevo o abrir uno existente.","",0,null);
                    else{
                        final JFrame mainVentana = getVentana();
                        mainVentana.setTitle("Dar de baja nadador");
                        mainVentana.setSize(new Dimension(400, 100));
                        JPanel mainPanel = new JPanel(new BorderLayout());
                        JPanel auxPanel = new JPanel(new GridLayout(1, 2, 15, 15));
                        final JComboBox caja = getComboNadadores();         
                        JLabel label = new JLabel("Seleccione un nadador: ");
                        auxPanel.add(label);
                        label.setLabelFor(caja);
                        auxPanel.add(caja);
                        
                        JButton botonAceptar = new JButton();
                        botonAceptar.setText("Aceptar");
                        JButton botonCancelar = new JButton();
                        botonCancelar.setText("Cancelar");
                        
                        mainPanel.add(auxPanel, "Center");
                        mainPanel.add(getPanelBotones(botonAceptar, botonCancelar), "South");                        
                        
                        mainVentana.add(mainPanel);
                        
                        botonCancelar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            mainVentana.dispose();
                            }                
                        });
                        
                        
                        botonAceptar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            
                            
                            swimming.darDeBajaNadador((String)caja.getSelectedItem());
                            updateTabla();
                            mainVentana.dispose();
                            
                            }                
                        });
                        
                    }
                    
                }
                catch(Exception ex){
                    
                }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void helpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuActionPerformed
        JOptionPane.showMessageDialog(null, ""
                + "Creado por '6+2' para Ingeniería del Software.\nUniversidad Complutense de Madrid."
                , "Swimming Manager 0.1", 1, null);
    }//GEN-LAST:event_helpMenuActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        Icon icon = new ImageIcon("images/ucm.png");
        
        JOptionPane.showMessageDialog(null, "Creado por '6+2' para Ingeniería del Software.\nUniversidad Complutense de Madrid.\n"
                +"Facultad de Informática.", "Swimming Manager 0.1", 1, icon);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        if(swimming!=null) {
            int respuesta;
            respuesta = JOptionPane.showConfirmDialog(null,"Se perderán los cambios no guardados.","Salir",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
            if(respuesta==0) System.exit(0);
        }
        else System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu buscarMenu;
    private javax.swing.JMenu compararMenu;
    private javax.swing.JMenu editarMenu;
    private javax.swing.JMenuItem exitButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
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
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem nuevoButton;
    private javax.swing.JMenuItem openButton;
    private javax.swing.JMenuItem saveAsButton;
    private javax.swing.JMenuItem saveButton;
    private javax.swing.JMenuItem showButton;
    // End of variables declaration//GEN-END:variables
    private JPanel getLabelsPanel(String[] labels, JButton bAceptar, JButton bCancelar){
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());                
        JPanel auxPanelCampos = new JPanel(new SpringLayout());
        int numPairs = labels.length;
        //Create and populate the panel.
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            auxPanelCampos.add(l);
            JTextField textField = new JTextField(5);
            l.setLabelFor(textField);
            auxPanelCampos.add(textField);
        }
        
        
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(auxPanelCampos,
                                        numPairs, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad                
        mainPanel.add(auxPanelCampos, "Center");
        mainPanel.add(getPanelBotones(bAceptar, bCancelar), "South");
        
        return mainPanel;
    }
    
    private JPanel getPanelBotones(JButton aceptar, JButton cancelar){
        JPanel panelBotones = new JPanel();
        panelBotones.setEnabled(true);
        panelBotones.add(aceptar);
        panelBotones.add(cancelar);
        return panelBotones;
    }
    
    
    
    private void initListener(){
        this.addWindowListener(this);
        
        openButton.addActionListener(new ActionListener(){
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
        saveAsButton.addActionListener(new ActionListener(){
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
            if(swimming==null) 
                    JOptionPane.showMessageDialog(null,"Debe crear un documento nuevo o abrir uno existente.","Dar de alta",0,null);
                else {
                    final JFrame mainVentana = getVentana();   
                    mainVentana.setTitle("Dar de alta nadador");
                    String[] labels = {"Nombre: ", "País de Origen: ","Ciudad de Origen: ", "Día de Nacimiento: ", "Mes de Nacimiento: ",
                                        "Año de Nacimiento: "};
                    JButton botonAceptar = new JButton();
                    botonAceptar.setText("Aceptar");
                    JButton botonCancelar = new JButton();
                    botonCancelar.setText("Cancelar");               
                    mainVentana.add(getLabelsPanel(labels, botonAceptar, botonCancelar));
                    botonCancelar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            mainVentana.dispose();
                        }                
                    });                
                    botonAceptar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            try{
                                Component[] componentes = mainVentana.getContentPane().getComponents();
                                JPanel p = (JPanel)componentes[0];
                                componentes = p.getComponents();
                                p = (JPanel)componentes[0];
                                int a = p.getComponentCount();
                                componentes = p.getComponents();
                                JTextField[] camposTexto = new JTextField[componentes.length/2];
                                int cont = 0;
                                for(int i = 0; i<a; i++){
                                    if(i%2==1){
                                        camposTexto[cont] = (JTextField)componentes[i];
                                        cont++;
                                    }
                                }

                                String fecha = camposTexto[3].getText()+"-"+camposTexto[4].getText()+"-"+camposTexto[5].getText();
                                String nombre = camposTexto[0].getText();
                                String pais = camposTexto[1].getText();
                                String ciudad = camposTexto[2].getText();
                                
                                swimming.darDeAltaNadador(nombre, fecha, pais+" "+ciudad);
                                JOptionPane.showMessageDialog(null,"Nadador añadido.","",1,null);
                                updateTabla();
                                mainVentana.dispose();
                                
                            }
                            catch(Exception ex){
                                JOptionPane.showMessageDialog(null,"Debe rellenar todos los campos.","",0,null);
                                mainVentana.dispose();
                            }
                        }  
                    });
                }                
            }    
        });
        
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt){
                    
                }
        });
    }
    
    private JFrame getVentana(){
        JFrame mainVentana = new JFrame();
        mainVentana.setVisible(true);
        mainVentana.setSize(new Dimension(350, 275));
        mainVentana.setAlwaysOnTop(true);
        mainVentana.setResizable(false);
        mainVentana.setIconImage(img);
        return mainVentana;
    }
    
    //faltan accesora a los demás campos, tales como Nacionalidad, su mejor Récord, su mejor estilo 
    //no usamos el número federativo así que croe que podemos quitarlo y voy a añadir la pestaña sexo al formulario
    //pero aun queda por implementar la constructora del nadador al cual pasarle el sexo.
    
    private void updateTabla(){
        ArrayList<Nadador> list = swimming.getNadadores();
        String[] columnNames = {"Nombre", "Edad","Sexo","Nacionalidad","Estilo","N. Federativo","Récord"};
        String[][] matriz = new String[list.size()][columnNames.length];
        
        for(int i=0; i<list.size(); i++){
            matriz[i][0] = list.get(i).getNombre();
        }
        
        tableModel.setDataVector(matriz, columnNames);
        
    }
    

    private JComboBox getComboNadadores(){
        JComboBox combo = null;
        try{
            ArrayList<Nadador> list = swimming.getNadadores();
            String[] nadadores = new String[list.size()];
            for(int i = 0; i<nadadores.length; i++){
                nadadores[i] = list.get(i).getNombre();
            }
            combo = new JComboBox(nadadores);  
        }
        catch(Exception ex){
            throw new Exception();
        }
        finally{
            return combo;
        }
        
             
    }

    @Override
    public void windowOpened(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowClosing(WindowEvent e) {
        if(swimming!=null) {
            int respuesta;
            respuesta = JOptionPane.showConfirmDialog(null,"Se perderán los cambios no guardados.","Salir",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
            if(respuesta==0) System.exit(0);
        }
        else System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
}
