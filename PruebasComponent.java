package Practica1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PruebasComponent {

	public static void main(String[] args) {
		PruebaMarco Marco1= new PruebaMarco();
		Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}

class PruebaMarco extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public PruebaMarco(){
		setBounds(200,200,500,400);
		add(new PruebaLam());
		setVisible(true);
	}
	
}
class PruebaLam extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PruebaLam(){
		setLayout(new BorderLayout());
		JPanel lam1= new JPanel();
		
		mostrar.addActionListener(new Control());
		lam1.add(mostrar);
		add(lam1, BorderLayout.SOUTH);
		
		JPanel lam2= new JPanel();
		GridLayout grid= new GridLayout(2,3,10,10);
		grid.minimumLayoutSize(this);
		lam2.setLayout(grid);
		g1=new ButtonGroup();
		g2=new ButtonGroup();
		g3=new ButtonGroup();
		g4=new ButtonGroup();
		g5=new ButtonGroup();
		g6=new ButtonGroup();
		setBox(tipo,lam2,g1,bot1);
		setBox(tipoMensaje,lam2,g2,bot2);
		setBox(Mensaje,lam2,g3,bot3);
		setBox(Confirmar,lam2,g4,bot4);
		setBox(Opcion,lam2,g5,bot5);
		setBox(Entrada,lam2,g6,bot6);
		add(lam2,BorderLayout.CENTER);
	}
	
	public void setBox(String[] e, JComponent componente, ButtonGroup grupo, JRadioButton[] botones) {
		Box caja1= Box.createVerticalBox();
		borde1=BorderFactory.createTitledBorder(e[0]);
		caja1.setMinimumSize(new Dimension(50,60));
		caja1.setBorder(borde1);
		for(int i=1; i< e.length;i++) {
			JRadioButton boton= new JRadioButton(e[i]);
			caja1.add(boton);
			grupo.add(boton);
			botones[i-1]= boton;
			boton.addActionListener(new Opciones());
		}
		componente.add(caja1);
		
	}

	private JRadioButton[] bot1=new JRadioButton[5];
	private JRadioButton[] bot2=new JRadioButton[5];
	private JRadioButton[] bot3=new JRadioButton[5];
	private JRadioButton[] bot4=new JRadioButton[5];
	private JRadioButton[] bot5=new JRadioButton[5];
	private JRadioButton[] bot6=new JRadioButton[5];
	private JButton mostrar=new JButton("Mostrar");
	private TitledBorder borde1;
	private ButtonGroup g1,g2,g3,g4,g5,g6;
	private String[] tipo= {"Tipo","Mensaje","Confirmar","Opcion","Entrada"};
	private String[] tipoMensaje= {"Tipo de Mensaje","Error","Informacion","Advertencia","Pregunta","Plain"};
	private String[] Mensaje= {"Mensaje","String","Icono","Componente","Otros","Object[]"};
	private String[] Confirmar= {"Confirmar","Default","Yes/No","Yes/No/Cancel","OK/Cancel"};
	private String[] Opcion= {"Opcion","String[]","Icon[]","Object[]"};
	private String[] Entrada= {"Entrada","Campo de texto","Combo"};
	
	private class Opciones implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
			JRadioButton boton= (JRadioButton)e.getSource();
			
			if(boton==bot1[0]) {opciontipo= 0;}
			if(boton==bot1[1]) {opciontipo= 1;}
			if(boton==bot1[2]) {opciontipo= 2;}
			if(boton==bot1[3]) {opciontipo= 3;}
			
			
			if(boton==bot2[0]) {mensajetipo=0;}
			if(boton==bot2[1]) {mensajetipo=1;}
			if(boton==bot2[2]) {mensajetipo=2;}
			if(boton==bot2[3]) {mensajetipo=3;}
			if(boton==bot2[4]) {mensajetipo=4;}
			
			if(boton==bot3[0]) {mensaje= "Mensaje";}
			if(boton==bot3[1]) {mensaje= "Icono";}
			if(boton==bot3[2]) {
				panel.setBackground(new Color(0000));
				mensaje= panel;
				}
			if(boton==bot3[3]) {mensaje= "Otros";}
			if(boton==bot3[4]) {mensaje= "Object";}
			
			if(boton==bot4[0]) {optionType= 0;}
			if(boton==bot4[1]) {optionType= 0;}
			if(boton==bot4[2]) {optionType= 1;}
			if(boton==bot4[3]) {optionType= 2;}
			
			if(boton==bot5[0]) {options= options1;}
			if(boton==bot5[1]) {options= options2;}
			if(boton==bot5[2]) {options= options3;
			panel.setBackground(new Color(0000));}
			
			if(boton==bot6[0]) {signalInput= 0;}
			if(boton==bot6[1]) {signalInput= 1;}
			
		}
	}	
	private class Control implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
				
			if (opciontipo==0) {
				
				JOptionPane.showMessageDialog(PruebaLam.this, mensaje, "Mensaje", mensajetipo,null);
			}
			
			if (opciontipo==1) {
				
				JOptionPane.showConfirmDialog(PruebaLam.this, mensaje, "Confirmar",optionType, mensajetipo, null);
			}
			
			if (opciontipo==2) {
				
				JOptionPane.showOptionDialog(PruebaLam.this, mensaje, "Opciones",optionType, mensajetipo,null, options,null);
			}
			
			if (opciontipo==3 && signalInput== 0 ) {
				
				JOptionPane.showInputDialog(PruebaLam.this, mensaje, "Opciones", mensajetipo,null, null,null);
			}

			if (opciontipo==3 && signalInput== 1 ) {
				
				JOptionPane.showInputDialog(PruebaLam.this, mensaje, "Opciones", mensajetipo,null, inputext,null);
			}
			
		}
	
	}
	private	JPanel panel=new JPanel();
	
	private	int opciontipo;
	private	int mensajetipo;
	private	int confirmar;
	private int optionType;
	private	Icon icono;
	private	Object[] options1= {"Yes","No","Cancel", "jajaXD"};
	private	Object[] options2= {"Icono1","Icono2"};
	private	Object[] options3= {panel,"xd"};
	private	Object[] options;
	private	Object[] inputext= {"opcion1","opcion2"};
	private int signalInput;
	private Object mensaje;	
}


