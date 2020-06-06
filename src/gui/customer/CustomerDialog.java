package gui.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Customer;
//import sun.jvm.hotspot.ci.ciSymbol;

public class CustomerDialog extends JDialog implements ActionListener {

//	private JPanel contentPanel;
	private JPanel leftPanel;
	private JPanel customerFormPanel;
	private JPanel customerFuncPanel;
	private JPanel customerTablePanel;
	private JButton addBtn;
	private JButton removeBtn;
	private JButton editBtn;
	private JButton clearBtn;
	private JTable Table;
	private JLabel idLbl;
	private JLabel nameLbl;
	private JLabel birthYearLbl;
	private JLabel sexLbl;
	private JLabel phoneNumberLbl;
	private JLabel addressLbl;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField birthYearTextField;
	private JTextField phoneNumberTextField;
	private JTextArea addressTextArea;
	private JComboBox<String> sexComboBox;
	private Controller controller;
	private CustomerTableModel1 model;

	public CustomerDialog() {
		controller = new Controller();
		setBounds(120, 50, 1050, 600);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("CUSTOMERS");
		getContentPane().setLayout(new BorderLayout());
//* a. Panel của các Label - TextField và Button
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		customerFormPanel = new JPanel();
		getContentPane().add(leftPanel, BorderLayout.WEST);
		Border inside = BorderFactory.createLineBorder(Color.black);
		Border outside = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		customerFormPanel.setBorder(BorderFactory.createCompoundBorder(outside, inside));
		GridBagConstraints gbc = new GridBagConstraints();
		customerFormPanel.setLayout(new GridBagLayout());
		leftPanel.add(customerFormPanel, BorderLayout.CENTER);
		customerTablePanel = new JPanel();
		getContentPane().add(customerTablePanel, BorderLayout.CENTER);
		customerTablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		customerTablePanel.setLayout(new BorderLayout());
//* b. Tạo bảng
		// Table không chứa dữ liệu chỉ chứa model.
		Table = new JTable();
		model = new CustomerTableModel1();
		Table.setModel(model);
		JScrollPane sp = new JScrollPane(Table);
		customerTablePanel.add(sp, BorderLayout.CENTER);

		Table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = Table.rowAtPoint(e.getPoint());

				Table.getSelectionModel().setSelectionInterval(row, row);
				if (e.getButton() == MouseEvent.BUTTON1) {
					int rowIndex = Table.getSelectedRow();
//					Customer cus = model.getCustomerAt(row);
//					CustomerFormEvent cusFormEvent = new CustomerFormEvent(this, cus.getId(), cus.getName(),
//							cus.getBirthYear(), cus.getSex(), cus.getPhoneNumber(), cus.getAddress());
//					tableListener.tableEventOccurred(cusFormEvent);
					System.out.println("dassd");

				}
			}
		});

//* c. Xữ lý phần TextField - Label
		idLbl = new JLabel("ID");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0.2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(20, 5, 1, 1);
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		customerFormPanel.add(idLbl, gbc);
		nameLbl = new JLabel("Name");
		gbc.gridy++;
		customerFormPanel.add(nameLbl, gbc);
		birthYearLbl = new JLabel("Birth Year");
		gbc.gridy++;
		customerFormPanel.add(birthYearLbl, gbc);
		sexLbl = new JLabel("Sex");
		gbc.gridy++;
		customerFormPanel.add(sexLbl, gbc);
		phoneNumberLbl = new JLabel("Phone Number");
		gbc.gridy++;
		customerFormPanel.add(phoneNumberLbl, gbc);
		addressLbl = new JLabel("Address");
		gbc.gridy++;
		customerFormPanel.add(addressLbl, gbc);
		idTextField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weighty = 0.2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		idTextField.setEditable(false);
		customerFormPanel.add(idTextField, gbc);
		nameTextField = new JTextField(15);
		gbc.gridy++;
		customerFormPanel.add(nameTextField, gbc);
		birthYearTextField = new JTextField(15);
		gbc.gridy++;
		customerFormPanel.add(birthYearTextField, gbc);
		String[] sexList = { "Male", "Female", "Orther" };
		sexComboBox = new JComboBox<String>(sexList);
		gbc.gridy++;
		customerFormPanel.add(sexComboBox, gbc);
		phoneNumberTextField = new JTextField(15);
		gbc.gridy++;
		customerFormPanel.add(phoneNumberTextField, gbc);
		addressTextArea = new JTextArea(5, 15);
		gbc.gridy++;
		customerFormPanel.add(addressTextArea, gbc);
//* d. Xữ lý phần Button
		customerFuncPanel = new JPanel();
		customerFuncPanel.setLayout(new GridBagLayout());
		leftPanel.add(customerFuncPanel, BorderLayout.SOUTH);
		customerFuncPanel.setPreferredSize(new Dimension(325, 90));
		Border inside1 = BorderFactory.createLineBorder(Color.black);
		Border outside1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		customerFuncPanel.setBorder(BorderFactory.createCompoundBorder(outside1, inside1));
		addBtn = new JButton("Add");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.insets = new Insets(20, 5, 1, 1);
		customerFuncPanel.add(addBtn, gbc);
		addBtn.addActionListener(this);

		removeBtn = new JButton("Remove");
		gbc.gridx = 1;
		gbc.gridy = 6;
		customerFuncPanel.add(removeBtn, gbc);
		removeBtn.addActionListener(this);

		editBtn = new JButton("Edit");
		gbc.gridx = 2;
		gbc.gridy = 6;
		customerFuncPanel.add(editBtn, gbc);
		editBtn.addActionListener(this);

		clearBtn = new JButton("Clear");
		gbc.gridx = 3;
		gbc.gridy = 6;
		customerFuncPanel.add(clearBtn, gbc);
		clearBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == addBtn) {
			// lấy dữ liệu từ textfield đưa dô CustomerFormEvent
			String name = nameTextField.getText();
			int birthYear = 0;
			String sex = sexComboBox.getSelectedItem().toString();
			String phoneNumber = phoneNumberTextField.getText();
			String address = addressTextArea.getText();
			try {
				birthYear = Integer.parseInt(birthYearTextField.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(rootPane, "BirthYear Number");
				birthYearTextField.setText("");
				birthYearTextField.requestFocus();
				return;
			}

			CustomerFormEvent event = new CustomerFormEvent(this, name, birthYear, sex, phoneNumber, address);
			controller.addCustomer(event);
			model.fireTableDataChanged();
			model.setData(controller.getListCustomer());
		}

		if (btn == removeBtn) {
			CustomerTableModel1 model = (CustomerTableModel1) Table.getModel();

		}

		if (btn == clearBtn) {
			idTextField.setText(null);
			nameTextField.setText(null);
			birthYearTextField.setText(null);
			sexComboBox.setSelectedIndex(0);
			phoneNumberTextField.setText(null);
			addressTextArea.setText(null);
			;
		}

	}

}
