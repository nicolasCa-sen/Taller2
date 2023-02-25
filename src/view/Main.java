package view;

import Logic.LinkedListDouble;
import Logic.Person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.*;
import java.util.List;

public class Main extends JFrame implements ActionListener {

    private JLabel texto1;
    private JLabel texto2;
    private JLabel texto3;
    private JLabel texto4;
    private JTextField caja1;
    private JTextField caja2;
    private JTextField caja3;
    private JTextField caja4;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;

    private JScrollPane scrollPane;

    private javax.swing.JTextArea jtxaLista;

    private LinkedListDouble list = new LinkedListDouble<>(Character::compare);



    public Main() {
        super();
        configurarVentana();
        inicializarComponentes();
    }

    private void llenarPanelLista() {
        this.jtxaLista.setText("");


        List<Person> arreglo = list.getLinkedList(true);
        for (int i = 0; i < arreglo.size(); i++) {
                this.jtxaLista.append( i+1  +"\n"+
                                "  Nombre :" + arreglo.get(i).getName()+"\n"+
                        "  Cedula :" + arreglo.get(i).getCedula()+"\n"+
                        "  Direccion :" + arreglo.get(i).getCedula()+"\n"+
                        "  Telefono :" + arreglo.get(i).getCedula()+
                        "\n"+"\n");
        }

        System.out.println(arreglo);




        }


    private void configurarVentana() {
        this.setTitle("Formulario personas");
        this.setSize(900, 620);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        // creamos los componentes
        texto1 = new JLabel();
        texto2 = new JLabel();
        texto3 = new JLabel();
        texto4 = new JLabel();
        caja1 = new JTextField();
        caja2 = new JTextField();
        caja3 = new JTextField();
        caja4 = new JTextField();
        boton1 = new JButton();
        boton2 = new JButton();
        boton3 = new JButton();
        boton4 = new JButton();
        boton5 = new JButton();
        boton6 = new JButton();
        jtxaLista = new JTextArea();
        scrollPane = new JScrollPane(jtxaLista);


        //jtxaLista.setBounds(30,30,400,520);
        scrollPane.setVisible(true);
        scrollPane.setBounds(30,30,400,520);
        texto1.setText("Nombre");
        texto1.setBounds(480, 50, 100, 25);
        caja1.setBounds(560, 50, 150, 25);
        boton1.setText("Agregar al principio");
        boton1.setBounds(740, 50, 150, 30);
        boton1.addActionListener(this);

        texto2.setText("Cedula");
        texto2.setBounds(480, 100, 100, 25);
        caja2.setBounds(560, 100, 150, 25);
        boton2.setText("agregar al final");
        boton2.setBounds(740, 100, 150, 30);
        // boton2.addActionListener(this);

        texto3.setText("Direccion");
        texto3.setBounds(480, 150, 100, 25);
        caja3.setBounds(560, 150, 150, 25);
        boton3.setText("agregar antes de");
        boton3.setBounds(740, 150, 150, 30);
        // boton3.addActionListener(this);
        texto4.setText("Telefono");
        texto4.setBounds(480, 200, 100, 25);
        caja4.setBounds(560, 200, 150, 25);
        boton4.setText("agregar despues de");
        boton4.setBounds(740, 200, 150, 30);
        // boton4.addActionListener(this);

        boton5.setText("Borrar");
        boton5.setBounds(740, 250, 150, 30);
        // boton5.addActionListener(this);

        // boton6.addActionListener(this);

        this.add(texto1);
        this.add(texto2);
        this.add(texto3);
        this.add(texto4);
        this.add(caja1);
        this.add(caja2);
        this.add(caja3);
        this.add(caja4);
        this.add(boton1);
        this.add(boton2);
        this.add(boton3);
        this.add(boton4);
        this.add(boton5);
        this.add(boton6);
        this.jtxaLista.setEditable(false);

        this.add(scrollPane, FlowLayout.CENTER);


        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = caja1.getText();
                String cedula = caja2.getText();
                String direccion = caja3.getText();
                String telefono = caja4.getText();
                list.addNodeFirst(new Person(nombre,cedula,direccion,telefono));
                caja1.setText("");
                caja2.setText("");
                caja3.setText("");
                caja4.setText("");
                JOptionPane.showMessageDialog(null,"usuario agregado correctamente");

                llenarPanelLista();
            }

            public void JBT(java.awt.event.MouseEvent evt) {
                boton1.setBackground(new Color(321, 3123, 3123));
            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ced=JOptionPane.showInputDialog(null,"Digite la cedula despues de la que quiere agregar");
                String nombre = caja1.getText();
                String cedula = caja2.getText();
                String direccion = caja3.getText();
                String telefono = caja4.getText();
                list.addNodeBeforeTo(list.findNode(new Person(null,ced,null,null)),new Person(nombre,cedula,direccion,telefono));
                caja1.setText("");
                caja2.setText("");
                caja3.setText("");
                caja4.setText("");
                JOptionPane.showMessageDialog(null,"usuario agregado correctamente");

                llenarPanelLista();

            }
        });
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ced=JOptionPane.showInputDialog(null,"Digite la cedula antes de la que quiere agregar");
                String nombre = caja1.getText();
                String cedula = caja2.getText();
                String direccion = caja3.getText();
                String telefono = caja4.getText();
                list.addNodeAfterTo(list.findNode(new Person(null,ced,null,null)),new Person(nombre,cedula,direccion,telefono));
                caja1.setText("");
                caja2.setText("");
                caja3.setText("");
                caja4.setText("");
                JOptionPane.showMessageDialog(null,"usuario agregado correctamente");

                llenarPanelLista();

            }
        });
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ced=JOptionPane.showInputDialog(null,"Digite la cedula que desea  eleminar");
                list.deleteNode(list.findNode(new Person(null,ced,null,null)));
                caja1.setText("");
                caja2.setText("");
                caja3.setText("");
                caja4.setText("");

                llenarPanelLista();

            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = caja1.getText();
                String cedula = caja2.getText();
                String direccion = caja3.getText();
                String telefono = caja4.getText();
                list.addNodeLast(new Person(nombre,cedula,direccion,telefono));
                caja1.setText("");
                caja2.setText("");
                caja3.setText("");
                caja4.setText("");
                JOptionPane.showMessageDialog(null,"usuario agregado correctamente");

                llenarPanelLista();

            }
        });
    }


    // @Override
    // public void actionPerformed(ActionEvent e) {

    // Listado_Personas list_p = new Listado_Personas();
    // boton1.setText(e.getActionCommand());
    // String nombre = caja1.getText();
    // String telefono = caja2.getText();
    // int edad = Integer.parseInt(caja3.getText());
    // Persona persona = new Persona(nombre, telefono, edad);
    // list_p.ingresar_usuario(persona);
    // JOptionPane.showMessageDialog(this, "el usuario : " + nombre + " ha sido
    // registrado");

    // boton2.setText(e.getActionCommand());
    // for (int i = 0; i < list_p.tamanho(); i++) {
    // list_p.msj(i);
    // }

    // }

    // public static void ingresar_persona(String nombre,String telefono,int
    // edad,Persona persona,Listado_Personas list_p){
    // }

    public static void main(String[] args) {
        Main V = new Main();
        V.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}
