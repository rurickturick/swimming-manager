package swimming.manager;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame implements WindowListener{
    
    private SwimmingManager swimming;
    
    private final JTable tabla;
    private DefaultTableModel tableModel;
    private Image img;
    private boolean sexo;
    
    public MainWindow() {
        initComponents();
        this.setTitle("Swimming Manager");
        img=Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("SW.png"));
        this.setIconImage(img);        
        initListener();
        this.setLayout(new BorderLayout());
        
        tableModel = new DefaultTableModel();
        tabla = new JTable(tableModel);
        tabla.setEnabled(false);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
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
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem18);

        jMenuItem19.setText("Eliminar marca");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
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
    }// </editor-fold>                        

    private void nuevoButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        showMessage("Se ha creado un documento en blanco.","Archivo Nuevo",1);                
        String[] columnNames = {"Nombre", "Edad","Sexo","Nacionalidad","Estilo","Récord"};
        String [][] matriz = new String[0][columnNames.length];
        tableModel.setDataVector(matriz, columnNames);     
        swimming = new SwimmingManager();

        tabla.getColumn("Sexo").setPreferredWidth(21);
        tabla.getColumn("Nombre").setPreferredWidth(120);
        tabla.getColumn("Edad").setPreferredWidth(10);
        tabla.getColumn("Nacionalidad").setPreferredWidth(33);
        
        buscarMenu.setVisible(true);
        compararMenu.setVisible(true);
        editarMenu.setVisible(true);
        saveButton.setVisible(true);
        saveAsButton.setVisible(true);
        showButton.setVisible(true);
    }                                           

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(swimming.getNadadores().isEmpty()) showMessage("No hay nadadores añadidos.","Error",0);

        else{
            final JFrame mainVentana = getVentana("Dar de baja nadador");
            mainVentana.setSize(new Dimension(400, 100));
            mainVentana.setLocationRelativeTo(this);
            JPanel mainPanel = new JPanel(new BorderLayout());

            JPanel auxPanel = new JPanel(new GridLayout(1, 1));
            JPanel auxPanelIz = new JPanel(new FlowLayout());
            JPanel mainPanelDr = new JPanel(new BorderLayout());
            JPanel auxPanelDr = new JPanel(new FlowLayout());
            final JComboBox caja = getComboNadadores();

            JLabel label = new JLabel("Seleccione un nadador: ");
            auxPanelIz.add(label);
            auxPanelDr.add(caja);
            mainPanelDr.add(auxPanelDr);
            auxPanel.add(auxPanelIz);
            auxPanel.add(mainPanelDr);
            mainPanel.add(auxPanel, "Center");

            JButton botonAceptar = new JButton();
            botonAceptar.setText("Aceptar");
            JButton botonCancelar = new JButton();
            botonCancelar.setText("Cancelar");                        

            mainPanel.add(getPanelBotones(botonAceptar, botonCancelar), "South");                             
            mainVentana.add(mainPanel, "Center");

            botonCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                mainVentana.dispose();
                }                
            });


            botonAceptar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                   // try{                            
                        swimming.darDeBajaNadador((String)caja.getSelectedItem());
                        updateTabla(swimming.getNadadores());
                        mainVentana.dispose();
                  //  } 
                  /*  catch (DataException exc){
                        showMessage(exc.getMessage(), "Error", 0);
                    }*/
                }
            });
            }
    }                                           

    private void helpMenuActionPerformed(java.awt.event.ActionEvent evt) {                                         
        showMessage("Creado por '6+2' para Ingeniería del Software.\nUniversidad Complutense de Madrid.",
                    "Swimming Manager 0.1", 1);
    }                                        

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        Icon icon = new ImageIcon(getClass().getClassLoader().getResource("ucm.png"));        
        JOptionPane.showMessageDialog(null, "Creado por '6+2' para Ingeniería del Software.\nUniversidad Complutense de Madrid.\n"
                +"Facultad de Informática.", "Swimming Manager 0.2.1", 1, icon);
    }                                           

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(!swimming.getNadadores().isEmpty()) {
            int respuesta;
            respuesta = JOptionPane.showConfirmDialog(null,"Se perderán los cambios no guardados.","Salir",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
            if(respuesta==0) System.exit(0);
        }
        else System.exit(0);
    }                                          

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        if(swimming.getNadadores().isEmpty()) showMessage("No hay nadadores añadidos.","Error",0);
        else{
            final JFrame ventana = this;
            final JFrame mainVentana = getVentana("Eliminar Marca");
            mainVentana.setSize(new Dimension(400, 100));
            mainVentana.setLocationRelativeTo(ventana);
            JPanel mainPanel = new JPanel(new BorderLayout());

            JPanel auxPanel = new JPanel(new GridLayout(1, 1));
            JPanel auxPanelIz = new JPanel(new FlowLayout());
            JPanel mainPanelDr = new JPanel(new BorderLayout());
            JPanel auxPanelDr = new JPanel(new FlowLayout());
            final JComboBox caja = getComboNadadores();

            JLabel label = new JLabel("Seleccione un nadador: ");
            auxPanelIz.add(label);
            auxPanelDr.add(caja);
            mainPanelDr.add(auxPanelDr);
            auxPanel.add(auxPanelIz);
            auxPanel.add(mainPanelDr);
            mainPanel.add(auxPanel, "Center");

            JButton botonSiguiente = new JButton();
            botonSiguiente.setText("Siguiente");
            JButton botonCancelar = new JButton();
            botonCancelar.setText("Cancelar");                        

            mainPanel.add(getPanelBotones(botonSiguiente, botonCancelar), "South");                             
            mainVentana.add(mainPanel, "Center");

            botonCancelar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    mainVentana.dispose();
                }
            });

            botonSiguiente.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    final String nombreNadador = (String)caja.getSelectedItem();
                    try{
                        if(swimming.buscarNadadorPorNombre(nombreNadador).getMarcas().isEmpty())
                            throw new DataException("Este Nadador no tiene marcas añadidas, añada primero alguna.");
                        mainVentana.setVisible(false);
                        final JFrame mainVentana = getVentana("Eliminar Marca");
                        mainVentana.setSize(new Dimension(400, 100));
                        mainVentana.setLocationRelativeTo(ventana);
                        JPanel mainPanel = new JPanel(new BorderLayout());

                        JPanel auxPanel = new JPanel(new GridLayout(1, 1));
                        JPanel auxPanelIz = new JPanel(new FlowLayout());
                        JPanel mainPanelDr = new JPanel(new BorderLayout());
                        JPanel auxPanelDr = new JPanel(new FlowLayout());
                        final JComboBox caja2 = getComboMarcas(swimming.buscarNadadorPorNombre(nombreNadador));

                        JLabel label = new JLabel("Seleccione una marca: ");
                        auxPanelIz.add(label);
                        auxPanelDr.add(caja2);
                        mainPanelDr.add(auxPanelDr);
                        auxPanel.add(auxPanelIz);
                        auxPanel.add(mainPanelDr);
                        mainPanel.add(auxPanel, "Center");

                        JButton botonAceptar = new JButton();
                        botonAceptar.setText("Aceptar");
                        JButton botonCancelar = new JButton();
                        botonCancelar.setText("Cancelar");                        

                        mainPanel.add(getPanelBotones(botonAceptar, botonCancelar), "South");                             
                        mainVentana.add(mainPanel, "Center");

                        botonCancelar.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                mainVentana.dispose();
                            }
                        });
                         botonAceptar.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    Nadador nadador = swimming.buscarNadadorPorNombre(nombreNadador);
                                    int i = caja2.getSelectedIndex();
                                    ArrayList<Marca> marcas = nadador.getMarcas();
                                    Marca marca = marcas.get(i);
                                    swimming.eliminarMarcaNadador(marca, nadador);
                                    updateTabla(swimming.getNadadores());
                                    mainVentana.dispose();                                            
                                }
                                catch(Exception ex){
                                    showMessage(ex.getMessage(), "Error", 0);
                                    mainVentana.dispose();
                                }
                            }
                         });

                    }
                    catch(DataException ex){
                        showMessage(ex.getMessage(), "Error", 0);
                        mainVentana.dispose();
                    }
                }
            });
        }
    }                                           

private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
// TODO add your handling code here:
    if(swimming.getNadadores().isEmpty()) showMessage("No hay nadadores añadidos.","Error",0);
        else{    
            final JFrame mainVentana = getVentana("Buscar");
            mainVentana.setSize(350, 100);
            mainVentana.setLocationRelativeTo(this);
            JPanel mainPanel = new JPanel(new BorderLayout());

            JButton botonAceptar = new JButton();
            botonAceptar.setText("Aceptar");
            JButton botonCancelar = new JButton();
            botonCancelar.setText("Cancelar");

            final JComboBox caja = getComboNadadores();

            JPanel panelBoxLabel = new JPanel(new GridLayout(1, 1));
            JPanel auxPanelLabel = new JPanel(new FlowLayout());
            JPanel mainPanelBox = new JPanel(new BorderLayout());
            JPanel auxPanelBox = new JPanel(new FlowLayout());
            auxPanelLabel.add(new JLabel("Seleccione Nadador: "));                        
            auxPanelBox.add(caja);
            mainPanelBox.add(auxPanelBox, "Center");
            panelBoxLabel.add(auxPanelLabel);
            panelBoxLabel.add(mainPanelBox);

            mainPanel.add(panelBoxLabel, "Center");
            mainPanel.add(getPanelBotones(botonAceptar, botonCancelar), "South");

            mainVentana.add(mainPanel);
            
            botonCancelar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    mainVentana.dispose();
                }
            });
            
            botonAceptar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        ArrayList<Nadador> list = new ArrayList<Nadador>();
                        list.add(swimming.buscarNadadorPorNombre((String)caja.getSelectedItem()));
                        updateTabla(list);
                        mainVentana.dispose();
                    }
                    catch(DataException ex){
                        showMessage(ex.getMessage(),"Error", 0);
                    }
                }
            
            });
    }
}                                          

    // Variables declaration - do not modify                     
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
    // End of variables declaration                   
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
                            swimming.loadFromFile(fich);                                  
                      }
                    } catch (Exception e1) {
                            showMessage(e1.getMessage(), "Error", 1);
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
                        swimming.saveToFile(fich);
                        saveButton.setEnabled(true);
                    }					
                } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null,"No se ha seleccionado archivo");
                }                    
            }
        });
        
        saveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){                
                try{                   
                    swimming.saveToFile();                    					
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null,"No se ha seleccionado archivo");
                }                    
            }
        });
        
        
        jMenuItem16.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(swimming==null) 
                        showMessage("Debe crear un documento nuevo o abrir uno existente.","Dar de alta",0);
                else {
                    final JFrame mainVentana = getVentana("Dar de alta nadador");   
                    mainVentana.setLayout(new BorderLayout());
                    String[] labels = {"Nombre: ", "País de Origen: ","Día de Nacimiento: ", "Mes de Nacimiento: ",
                                        "Año de Nacimiento: "};
                    JButton botonAceptar = new JButton();
                    botonAceptar.setText("Aceptar");
                    JButton botonCancelar = new JButton();
                    botonCancelar.setText("Cancelar");

                    JRadioButton boton1 = new JRadioButton("Hombre");
                    boton1.setActionCommand("Hombre");
                    boton1.setMnemonic(KeyEvent.VK_H);

                    JRadioButton boton2 = new JRadioButton("Mujer");
                    boton2.setActionCommand("Mujer");
                    boton2.setMnemonic(KeyEvent.VK_M);

                    ButtonGroup grupo = new ButtonGroup();
                    grupo.add(boton1);
                    grupo.add(boton2);

                    boton1.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            sexo = true;
                        }
                    });

                    boton2.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            sexo = false;
                        }
                    });

                    JPanel panelRadio = new JPanel(new FlowLayout());
                    JLabel l1 = new JLabel("Sexo: ");
                    panelRadio.add(l1);
                    panelRadio.add(boton1);
                    panelRadio.add(boton2);

                    mainVentana.add(panelRadio, "North");
                    mainVentana.add(getLabelsPanel(labels, botonAceptar, botonCancelar), "Center");

                    botonCancelar.addActionListener(new ActionListener(){
                        
                        public void actionPerformed(ActionEvent e) {
                            mainVentana.dispose();
                        }                
                    });                
                    botonAceptar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            
                                int[] posiciones = {1, 0};
                                JTextField[] camposTexto = getTextFields(mainVentana.getContentPane().getComponents(),
                                                                            posiciones);
                                String fecha = camposTexto[2].getText()+"-"+camposTexto[3].getText()+"-"+camposTexto[4].getText();
                                String nombre = camposTexto[0].getText();
                                String pais = camposTexto[1].getText();
                                //String ciudad = camposTexto[2].getText();
                                if(fecha.equals("---")||(nombre.equals(""))||(pais.equals("")))
                                    showMessage("Debe rellenar todos los campos.", "Error", 0);
                                else{
                                    String [] fechaAux=fecha.split("-");
                                    if(fechaAux.length!=3) showMessage("Formato de fecha no válido", "Error",0);
                                    else
                                        try{
                                            if((Integer.parseInt(fechaAux[0])<1)||(Integer.parseInt(fechaAux[0])>31)||
                                                (Integer.parseInt(fechaAux[1])<0)||(Integer.parseInt(fechaAux[1])>12)
                                                ||(Integer.parseInt(fechaAux[2])<0)||(Integer.parseInt(fechaAux[2])>9999))
                                            showMessage("El formato de la fecha es DD-MM-AAAA", "Formato de fecha no válido",0);
                                            else{
                                                swimming.darDeAltaNadador(nombre, fecha, pais,sexo);
                                                showMessage("Nadador añadido.", "Añadir", 1);
                                                updateTabla(swimming.getNadadores());
                                                mainVentana.dispose();
                                            }
                                        }
                                        catch(Exception ex){
                                            showMessage(ex.getMessage(), "Error", 0);
                                        }
                                }
                        }
                    });
                }                
            }    
        });
        
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt){
                if(swimming.getNadadores().isEmpty()) showMessage("No hay nadadores añadidos.","Error",0);
                else{
                    final JFrame mainVentana = getVentana("Añadir Marca");
                    JPanel mainPanel = new JPanel(new BorderLayout());

                    String[] labels = {"Marca: ", "Estilo: ", "Distancia: ", "Día: ", "Mes: ", "Año: " };
                    JButton botonAceptar = new JButton();
                    botonAceptar.setText("Aceptar");
                    JButton botonCancelar = new JButton();
                    botonCancelar.setText("Cancelar");
                    JPanel panelCamposBotones = getLabelsPanel(labels, botonAceptar, botonCancelar);

                    final JComboBox caja = getComboNadadores();

                    JPanel panelBoxLabel = new JPanel(new GridLayout(1, 1));
                    JPanel auxPanelLabel = new JPanel(new FlowLayout());
                    JPanel mainPanelBox = new JPanel(new BorderLayout());
                    JPanel auxPanelBox = new JPanel(new FlowLayout());
                    auxPanelLabel.add(new JLabel("Seleccione Nadador: "));                        
                    auxPanelBox.add(caja);
                    mainPanelBox.add(auxPanelBox, "Center");
                    panelBoxLabel.add(auxPanelLabel);
                    panelBoxLabel.add(mainPanelBox);

                    mainPanel.add(panelBoxLabel, "North");
                    mainPanel.add(panelCamposBotones, "Center");

                    mainVentana.add(mainPanel);
                    botonCancelar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            mainVentana.dispose();
                        }
                    });

                    botonAceptar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            try{
                                int[] posiciones = {0, 1, 0};
                                JTextField [] camposTexto = getTextFields(mainVentana.getContentPane().getComponents(),
                                                                    posiciones);
                                String nombre = (String)caja.getSelectedItem();
                                String marca = camposTexto[0].getText();
                                Estilo estilo = Estilo.getEstilo(camposTexto[1].getText());
                                int distancia = Integer.parseInt(camposTexto[2].getText());
                                String fecha = camposTexto[3].getText()+"-"+camposTexto[4].getText()+"-"+camposTexto[5].getText();
                                swimming.anadirMarcaNadador(nombre, marca, fecha, distancia, estilo);
                                updateTabla(swimming.getNadadores());
                                showMessage("Marca añadida", "Añadir Marca", 1);
                                mainVentana.dispose();
                            }
                            catch(Exception ex){
                                showMessage(ex.getMessage(), "Error", 0);
                            }
                        }
                    });
                }
            }
        });
    }


    private void showMessage(String s, String title, int typeMessage){
        JOptionPane pane = new JOptionPane(s, typeMessage);
        JDialog dialog = pane.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setIconImage(img);
        dialog.setVisible(true);
    }

    private JFrame getVentana(String title){
        JFrame mainVentana = new JFrame();
        mainVentana.setVisible(true);
        mainVentana.setSize(new Dimension(350, 275));
        mainVentana.setLocationRelativeTo(this);
        mainVentana.setAlwaysOnTop(true);
        mainVentana.setResizable(false);
        mainVentana.setIconImage(img);
        mainVentana.setTitle(title);
        return mainVentana;
    }
    
    private void updateTabla(ArrayList<Nadador> list){        
            String[] columnNames = {"Nombre", "Edad","Sexo","Nacionalidad","Estilo","Récord"};
            String[][] matriz = new String[list.size()][columnNames.length];

            for(int i=0; i<list.size(); i++){
                matriz[i][0] = list.get(i).getNombre();
                matriz[i][1] = Integer.toString( list.get(i).getEdad());
                matriz[i][2] = list.get(i).toStringSexo();
                matriz[i][3] = list.get(i).getPais().getPais();
                matriz[i][4] = list.get(i).toStringEstilos();
               if(list.get(i).getRecord()!=null)
                 matriz[i][5] = list.get(i).getRecord().getTiempo().toString();
                else matriz[i][5] = "No hay record";
            }
            
            tableModel.setDataVector(matriz, columnNames);
            tabla.getColumn("Sexo").setPreferredWidth(21);
            tabla.getColumn("Nombre").setPreferredWidth(120);
            tabla.getColumn("Edad").setPreferredWidth(10);
            tabla.getColumn("Nacionalidad").setPreferredWidth(33);
    }    


    private JComboBox getComboNadadores(){
        ArrayList<Nadador> list = swimming.getNadadores();
        String[] nadadores = new String[list.size()];
        for(int i = 0; i<nadadores.length; i++){
            nadadores[i] = list.get(i).getNombre();
        }
        return new JComboBox(nadadores);            
    }
    
    private JComboBox getComboMarcas(Nadador nadador){
        JComboBox combo = null;
        try{
            ArrayList<Marca> list = nadador.getMarcas();
            String[] marcas = new String[list.size()];
            for(int i=0; i<list.size(); i++){
                marcas[i] = list.get(i).getEstilo().toString()+": "+list.get(i).getTiempo().toString();
            }
            combo = new JComboBox(marcas);
        }
        catch(Exception ex){            
        }
        finally{     
            return combo;
        }
    }
    
    private JTextField[] getTextFields(Component[] losComponentes, int[] pos){
        JTextField[] camposTexto = null;
        JPanel p = (JPanel)losComponentes[pos[0]];
        Component[] componentes = p.getComponents();
        for(int i = 1; i< pos.length;i ++){
            p = (JPanel)componentes[pos[i]];
            componentes = p.getComponents();
        }
        
        int a = p.getComponentCount();
        componentes = p.getComponents();
        camposTexto = new JTextField[componentes.length/2];
        int cont = 0;
        for(int i = 0; i<a; i++){
            if(i%2==1){
                camposTexto[cont] = (JTextField)componentes[i];
                cont++;
            }
        }
        
        return camposTexto;
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

