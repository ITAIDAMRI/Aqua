package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import javax.swing.JRadioButton;
import java.awt.Choice;
import java.awt.Scrollbar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import q3.Jellyfish;
import q3.Fish;
import q3.Swimmable;

import javax.swing.UIManager;

public class AddAnimalDialog extends JDialog implements ActionListener{
	JSlider sliderVerticalSpeed = new JSlider();
	JSlider sliderHorizonalSpeed = new JSlider();
	JSlider size = new JSlider();
	JComboBox ColorComboBox = new JComboBox();
	private JComboBox TypeComboBox = new JComboBox();
	private final JPanel contentPanel = new JPanel();


	 /* Create the dialog. to add animals with speed size and colors
	 */
	public AddAnimalDialog() {
		setBounds(100, 100, 705, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			TypeComboBox.setBounds(210, 22, 64, 20);
			TypeComboBox.setBackground(Color.LIGHT_GRAY);
			TypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Jellyfish", "fish"}));
			contentPanel.add(TypeComboBox);
		}
		
		{
			
			size.setBounds(210, 56, 426, 60);
			size.setMajorTickSpacing(20);
			size.setBackground(UIManager.getColor("Button.background"));
			size.setSnapToTicks(true);
			size.setPaintTicks(true);
			size.setPaintLabels(true);
			size.setMaximum(320);
			size.setMinimum(20);
			contentPanel.add(size);
			size.setValue(20);
		}
		
		JLabel LabelType = new JLabel("Choose Type");
		LabelType.setBounds(116, 22, 84, 20);
		contentPanel.add(LabelType);
		
		JLabel LabelSize = new JLabel("Choose Size");
		LabelSize.setBounds(116, 81, 84, 20);
		contentPanel.add(LabelSize);
		
		
		sliderVerticalSpeed.setMajorTickSpacing(1);
		sliderVerticalSpeed.setMinimum(1);
		sliderVerticalSpeed.setMaximum(10);
		sliderVerticalSpeed.setValue(1);
		sliderVerticalSpeed.setSnapToTicks(true);
		sliderVerticalSpeed.setPaintTicks(true);
		sliderVerticalSpeed.setPaintLabels(true);
		sliderVerticalSpeed.setBounds(210, 147, 426, 60);
		contentPanel.add(sliderVerticalSpeed);
		
		JLabel LabelVerticalSpeed = new JLabel("Choose Vertical Speed");
		LabelVerticalSpeed.setBounds(63, 159, 137, 20);
		contentPanel.add(LabelVerticalSpeed);
		
		
		sliderHorizonalSpeed.setValue(1);
		sliderHorizonalSpeed.setMajorTickSpacing(1);
		sliderHorizonalSpeed.setMaximum(10);
		sliderHorizonalSpeed.setMinimum(1);
		sliderHorizonalSpeed.setSnapToTicks(true);
		sliderHorizonalSpeed.setPaintTicks(true);
		sliderHorizonalSpeed.setPaintLabels(true);
		sliderHorizonalSpeed.setBounds(210, 218, 426, 60);
		contentPanel.add(sliderHorizonalSpeed);
		
		JLabel LabelHorizonalSpeed = new JLabel("Choose Horizonal Speed");
		LabelHorizonalSpeed.setBounds(53, 234, 147, 20);
		contentPanel.add(LabelHorizonalSpeed);
		
		
		ColorComboBox.setModel(new DefaultComboBoxModel(new String[] {"green", "blue", "yellow", "black", "red"}));
		ColorComboBox.setBounds(210, 301, 64, 22);
		contentPanel.add(ColorComboBox);
		
		JLabel LabelColor = new JLabel("Choose Color");
		LabelColor.setBounds(116, 302, 84, 20);
		contentPanel.add(LabelColor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(Color.LIGHT_GRAY);
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setBackground(Color.LIGHT_GRAY);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "OK":
			int type=TypeComboBox.getSelectedIndex();
			int color=ColorComboBox.getSelectedIndex();
			int VerticalSpeed = sliderVerticalSpeed.getValue();
			int HorizonalSpeed = sliderHorizonalSpeed.getValue();
			int size1=size.getValue();
			Thread t;
			Swimmable s;
			if(type==0) {
				s=new Jellyfish( size1, 600, 200, HorizonalSpeed,VerticalSpeed,color);
			}
			else {
				s=new Fish( size1, 600, 400, HorizonalSpeed,VerticalSpeed,color);
			}
			t=new Thread(s);
			AquaFrame.panel_2.addAnimal(s);
			t.start();
			break;
		case "Cancel":
			break;
		}
		this.setVisible(false);
		
	}
}
