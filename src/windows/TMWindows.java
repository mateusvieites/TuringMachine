package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import entities.Commands;
import model.OperationsModel;
import services.Actions;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TMWindows extends JFrame {

	private JPanel contentPane;
	OperationsModel operationsModel = new OperationsModel();
	OperationsModel operationsModel2 = new OperationsModel();
	private JTable operationTable;
	private JTable executionTable;
	private JTextField tape_textField;
	private JButton addRow_button;
	private JButton update_button;
	private JTextField command_textField;
	private JButton run_button;


	/**
	 * Create the frame.
	 */
	public TMWindows() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		setTitle("Turing Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(587, 680);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane operation_spane = new JScrollPane();
		operation_spane.setBounds(10, 107, 556, 365);
		contentPane.add(operation_spane);
		operationTable = new JTable();
		operation_spane.setViewportView(operationTable);
		operationTable.setModel(operationsModel);
		
		JScrollPane execution_spane = new JScrollPane();
		execution_spane.setBounds(10, 483, 556, 147);
		contentPane.add(execution_spane);
		executionTable = new JTable();
		execution_spane.setViewportView(executionTable);
		executionTable.setModel(operationsModel2);
		
		tape_textField = new JTextField();
		tape_textField.setText(">**** ****");
		tape_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tape_textField.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tape_textField.getText().equals("") || tape_textField.getText().equals(" ")
					|| tape_textField.getText().equals(null)) {
					tape_textField.setText(">**** ****");
				}
			}
		});
		tape_textField.setBounds(93, 22, 473, 20);
		contentPane.add(tape_textField);
		tape_textField.setColumns(10);
		
		
		command_textField = new JTextField();
		command_textField.setText("<It>,<symbol>,<next>,<value>,<direction>");
		command_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				command_textField.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(command_textField.getText().equals("") || command_textField.getText().equals(" ")
					|| command_textField.getText().equals(null)) {
					command_textField.setText("<It>,<symbol>,<next>,<value>,<direction>");
				}
			}
		});
		command_textField.setBounds(10, 74, 232, 20);
		contentPane.add(command_textField);
		command_textField.setColumns(10);
		
		JLabel tape_label = new JLabel("Tape:");
		tape_label.setHorizontalAlignment(SwingConstants.RIGHT);
		tape_label.setBounds(10, 25, 46, 14);
		contentPane.add(tape_label);
		
		addRow_button = new JButton("Add row");
		addRow_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String[] split = command_textField.getText().split(",");
				if(split.length == 5) {
					Commands i = new Commands();
					if(Actions.isInt(split[0]) != -1) {
						i.setIt(Integer.parseInt(split[0]));
						i.setSymbol(split[1].charAt(0));
						if(Actions.isInt(split[2]) != -1) {
							i.setNext(Integer.parseInt(split[2]));
							i.setValue(split[3].charAt(0));
							i.setDirection(split[4].charAt(0));
							operationsModel.addRow(i);
						}
					}
				}
			}
		});
		addRow_button.setBounds(252, 73, 89, 23);
		contentPane.add(addRow_button);
		
		update_button = new JButton("Remove");
		update_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (operationTable.getSelectedRow() != -1){
					operationsModel.removeRow(operationTable.getSelectedRow());
		        }else{
		            JOptionPane.showMessageDialog(null, "Select a single row");
		        }
			}
		});
		update_button.setBounds(351, 73, 89, 23);
		contentPane.add(update_button);
		
		run_button = new JButton("Run");
		run_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operationsModel.getLines() > 0) {
					//operationsModel.getColumnCount(); = retorna o número de colunas
					//operationsModel.getLines(); = retorna número de linhas
					//operationsModel.getValueAt(lines, column); retorna o valor do elemento
					System.out.println(operationsModel.getColumnCount());
					System.out.println(operationsModel.getLines());
					System.out.println(operationsModel.getValueAt(0, 1));
					//Ideia ler colocar o método de getValue em um loop
					//que leia todas as coisas que estiverem nele lembrem-se o máximo de colunas é 5
					//e começa com 0, ou seja um loop dentro do outro com máximo 5 e máximo de linhas
					
					//#ToDo
				}
			}
		});
		run_button.setBounds(477, 73, 89, 23);
		contentPane.add(run_button);
		
		
	}
}
