package gui.product;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Product;

public class ProductDialog extends JDialog{

	private JPanel productFormPanel;
	private JPanel productTablePanel;
	private JPanel productInfoFormPanel;
	private JPanel productFunctionFormPanel;
	private JLabel idProductLbl;
	private JTextField idProductTxt;
	private JLabel nameProductLbl;
	private JTextField nameProductTxt;
	private JLabel categoryLbl;
	private JComboBox<String> categorycbb;
	private JLabel priceLbl;
	private JTextField priceTxt;
	private JLabel amountLbl;
	private JTextField amountTxt;
	private JLabel descriptionLbl;
	private JTextArea descriptionTxtArea;
	private JTable jtable;
	private JButton addBtn;
	private JButton removeBtn;
	private JButton updateBtn;
	private JButton clearBtn;

	private ArrayList<Product> list;
	DefaultTableModel model;

	public ProductDialog() {
		initConponents();
		list = new ArrayList<Product>();
		model = (DefaultTableModel) jtable.getModel();

		setTitle("PRODUCTS");
		setBounds(120, 50, 1050, 600);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	public void initConponents() {
		productFormPanel = new JPanel();
		productTablePanel = new JPanel();
		productInfoFormPanel = new JPanel();
		productFunctionFormPanel = new JPanel();

		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add(productFormPanel, BorderLayout.WEST);
		con.add(productTablePanel, BorderLayout.CENTER);
		productFormPanel.setLayout(new BorderLayout());
		productFormPanel.add(productInfoFormPanel, BorderLayout.NORTH);
		productFormPanel.add(productFunctionFormPanel, BorderLayout.LINE_START);
		productTablePanel.setLayout(new BorderLayout());
		productTablePanel.setBorder(BorderFactory.createTitledBorder("Detail"));

		productInfoFormPanel.setBorder(BorderFactory.createTitledBorder("Infomation"));
		productFunctionFormPanel.setBorder(BorderFactory.createTitledBorder("Function"));
		String[] phoneName = { "Iphone", "Samsung", "Vinsmart", "Xiaomi", "Huawei", "Oppo", "Realme", "LG", "Sony",
				"HTC", "Vivo", "Nokia", "Other..." };

		idProductLbl = new JLabel("ID:");
		idProductTxt = new JTextField(10);
		nameProductLbl = new JLabel("Name Product:");
		nameProductTxt = new JTextField(20);
		categoryLbl = new JLabel("Category:");
		categorycbb = new JComboBox<String>(phoneName);
		priceLbl = new JLabel("Price:");
		priceTxt = new JTextField(10);
		amountLbl = new JLabel("Amount:");
		amountTxt = new JTextField(5);
		descriptionLbl = new JLabel("Description:");
		descriptionTxtArea = new JTextArea(5, 20);
		descriptionTxtArea.setWrapStyleWord(true);
		descriptionTxtArea.setLineWrap(true);
		JScrollPane scpDescriptionTxtArea = new JScrollPane(descriptionTxtArea);

		addBtn = new JButton("Add");
		removeBtn = new JButton("Remove");
		updateBtn = new JButton("Update");
		clearBtn = new JButton("Clear");

		GridBagConstraints gbc = new GridBagConstraints();
		productInfoFormPanel.setLayout(new GridBagLayout());
		productFunctionFormPanel.setPreferredSize(new Dimension(350, 700));
		gbc.insets = new Insets(10, 5, 10, 5);
		gbc.anchor = gbc.FIRST_LINE_START;

		// label
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		productInfoFormPanel.add(idProductLbl, gbc);

		gbc.gridy++;
		productInfoFormPanel.add(nameProductLbl, gbc);

		gbc.gridy++;
		productInfoFormPanel.add(categoryLbl, gbc);

		gbc.gridy++;
		productInfoFormPanel.add(priceLbl, gbc);

		gbc.gridy++;
		productInfoFormPanel.add(amountLbl, gbc);

		gbc.gridy++;
		productInfoFormPanel.add(descriptionLbl, gbc);

		// text field
		gbc.gridx = 1;
		gbc.gridy = 0;
		productInfoFormPanel.add(idProductTxt, gbc);
		idProductTxt.setEditable(false);

		gbc.gridy++;
		productInfoFormPanel.add(nameProductTxt, gbc);

		gbc.gridy++;
		productInfoFormPanel.add(categorycbb, gbc);

		gbc.gridy++;
		productInfoFormPanel.add(priceTxt, gbc);

		gbc.gridy++;
		productInfoFormPanel.add(amountTxt, gbc);

		gbc.gridy++;
		productInfoFormPanel.add(scpDescriptionTxtArea, gbc);
		
		//function form
		productFunctionFormPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		productFunctionFormPanel.add(addBtn);
		addBtn.setToolTipText("Add data into table");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addBtnActionPerformed(e);
			}
		});

		productFunctionFormPanel.add(removeBtn);
		removeBtn.setToolTipText("Remove data from table");
		removeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeBtnActionPerformed(e);
			}
		});
		
		productFunctionFormPanel.add(updateBtn);
		updateBtn.setToolTipText("Update data in the table");
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateBtnActionPerformed(e);
			}
		});
		
		productFunctionFormPanel.add(clearBtn);
		clearBtn.setToolTipText("Delete all data in the input form");
		clearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearBtnActionPerformed(e);
			}
		});

		String data[][] = { };
		String colunm[] = { "ID", "Name Product", "Category", "Price", "Amount", "Description" };
		TableModel tableModel = new DefaultTableModel(data, colunm);
		jtable = new JTable(tableModel);
		JScrollPane scpJtable = new JScrollPane(jtable);
		productTablePanel.add(scpJtable);

	}
	
	public void showResult() {
		Product product = list.get(list.size() - 1);
		model.addRow(new Object[] {product.getIdProduct() ,product.getNameProduct(), product.getCategory(),
				product.getPrice(), product.getAmount(), product.getDescription() });
	}

	private void addBtnActionPerformed(ActionEvent e) {
		String name = nameProductTxt.getText();
		String category = categorycbb.getSelectedItem().toString();
		int price = 0;
		int amount = 0;
		String description = descriptionTxtArea.getText(); 
		
		if(nameProductTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(rootPane, "Please enter name product!!!");
			nameProductTxt.requestFocus();
			return;
		}
		
		if(priceTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(rootPane, "Please enter price!!!");
			priceTxt.requestFocus();
			return;
		}
		
		try {
			price = Integer.parseInt(priceTxt.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(rootPane, "Plese enter price as a number!!!");
			priceTxt.setText("");
			priceTxt.requestFocus();
			return;
		}
		
		if(amountTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(rootPane, "Please enter amount!!!");
			amountTxt.requestFocus();
			return;
		}
		
		try {
			amount = Integer.parseInt(amountTxt.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(rootPane, "Plese enter amount as a number!!!");
			amountTxt.setText("");
			amountTxt.requestFocus();
			return;
		}
		
		Product product = new Product(name, category, price, amount, description);
		list.add(product);
		showResult();
		JOptionPane.showMessageDialog(rootPane, "Add data successfully!!!");
	}

	private void removeBtnActionPerformed(ActionEvent e) {
		
	}

	private void updateBtnActionPerformed(ActionEvent e) {
		
	}

	private void clearBtnActionPerformed(ActionEvent e) {
		nameProductTxt.setText("");
		categorycbb.setSelectedIndex(0);
		priceTxt.setText("");
		amountTxt.setText("");
		descriptionTxtArea.setText("");
	}
	
	
}
