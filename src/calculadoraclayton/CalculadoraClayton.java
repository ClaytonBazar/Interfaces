/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadoraclayton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraClayton implements ActionListener{

	JFrame janela;
	JTextField texto;
	JButton[] botoesNumero = new JButton[10];
	JButton[] BotoesFuncao = new JButton[9];
	JButton botaoMais,subButao,multiButao,divButao;
	JButton decButao, eqButao, delButao, limpButao, negButao;
	JPanel painel;
	
	Font myFont = new Font("calibre",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operador;
	
	CalculadoraClayton(){
		
		janela = new JFrame("Calculator");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(420, 550);
		janela.setLayout(null);
		
		texto = new JTextField();
		texto.setBounds(50, 25, 300, 50);
		texto.setFont(myFont);
		texto.setEditable(false);
		
		botaoMais = new JButton("+");
		subButao = new JButton("-");
		multiButao = new JButton("*");
		divButao = new JButton("/");
		decButao = new JButton(".");
		eqButao = new JButton("=");
		delButao = new JButton("Del");
		limpButao = new JButton("Clr");
		negButao = new JButton("x^2");
		
		BotoesFuncao[0] = botaoMais;
		BotoesFuncao[1] = subButao;
		BotoesFuncao[2] = multiButao;
		BotoesFuncao[3] = divButao;
		BotoesFuncao[4] = decButao;
		BotoesFuncao[5] = eqButao;
		BotoesFuncao[6] = delButao;
		BotoesFuncao[7] = limpButao;
		BotoesFuncao[8] = negButao;
		
		for(int i =0;i<9;i++) {
			BotoesFuncao[i].addActionListener(this);
			BotoesFuncao[i].setFont(myFont);
			BotoesFuncao[i].setFocusable(false);
		}
		
		for(int j =0;j<10;j++) {
			botoesNumero[j] = new JButton(String.valueOf(j));
			botoesNumero[j].addActionListener(this);
			botoesNumero[j].setFont(myFont);
			botoesNumero[j].setFocusable(false);
		}
		
		negButao.setBounds(50,430,100,50);
		delButao.setBounds(150,430,100,50);
		limpButao.setBounds(250,430,100,50);
		
		painel = new JPanel();
                painel.setBackground(Color.red);
		painel.setBounds(50, 100, 300, 300);
		painel.setLayout(new GridLayout(4,4,10,10));

		painel.add(botoesNumero[1]);
		painel.add(botoesNumero[2]);
		painel.add(botoesNumero[3]);
		painel.add(botaoMais);
		painel.add(botoesNumero[4]);
		painel.add(botoesNumero[5]);
		painel.add(botoesNumero[6]);
		painel.add(subButao);
		painel.add(botoesNumero[7]);
		painel.add(botoesNumero[8]);
		painel.add(botoesNumero[9]);
		painel.add(multiButao);
		painel.add(decButao);
		painel.add(botoesNumero[0]);
		painel.add(eqButao);
		painel.add(divButao);
		
		janela.add(painel);
		janela.add(negButao);
		janela.add(delButao);
		janela.add(limpButao);
		janela.add(texto);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		CalculadoraClayton calc = new CalculadoraClayton();
	}
	
	@Override
       
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == botoesNumero[i]) {
				texto.setText(texto.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButao) {
			texto.setText(texto.getText().concat("."));
		}
		if(e.getSource()==botaoMais) {
			num1 = Double.parseDouble(texto.getText());
			operador ='+';
			texto.setText("");
		}
		if(e.getSource()==subButao) {
			num1 = Double.parseDouble(texto.getText());
			operador ='-';
			texto.setText("");
		}
		if(e.getSource()==multiButao) {
			num1 = Double.parseDouble(texto.getText());
			operador ='*';
			texto.setText("");
		}
		if(e.getSource()==divButao) {
			num1 = Double.parseDouble(texto.getText());
			operador ='/';
			texto.setText("");
		}
		if(e.getSource()==eqButao) {
			num2=Double.parseDouble(texto.getText());
			
			switch(operador) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			texto.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==limpButao) {
			texto.setText("");
		}
		if(e.getSource()==delButao) {
			String string = texto.getText();
			texto.setText("");
			for(int i=0;i<string.length()-1;i++) {
				texto.setText(texto.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negButao) {
			double x = Double.parseDouble(texto.getText());
                        for(int i= 1; i<=x;i++)
                        result = x*i;
		}
        
            
        }

}
    

