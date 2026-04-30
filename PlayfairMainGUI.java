
package com.mycompany.playfairmaingui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

/**
 *
 * @author vip_1
 */
public class PlayfairMainGUI extends JFrame {

  
    private JTextField txtKey;
    private JTextArea txtInput, txtOutput;
    private JButton EncryptButton, DecryptButton;

    public PlayfairMainGUI() {
      
        setTitle("Playfair Cipher System");
      
        Color bgColor = new Color(30, 0, 60); 

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(20, 25, 20, 25));
        mainPanel.setBackground(bgColor);
        add(mainPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.insets = new Insets(7, 0, 7, 0);

      
        gbc.gridy = 0;
        try {
            URL imageUrl = getClass().getResource("/playfair.png");
            if (imageUrl != null) {
                Image img = new ImageIcon(imageUrl).getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
                mainPanel.add(new JLabel(new ImageIcon(img)), gbc);
            }
        } catch (Exception e) {}

       
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 15, 0);
        JLabel lblTitle = new JLabel("PLAYFAIR CIPHER", JLabel.CENTER);
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lblTitle.setForeground(Color.WHITE);
        mainPanel.add(lblTitle, gbc);

       
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 0, 5, 0);
        JLabel l1 = new JLabel("KEY:");
        l1.setForeground(Color.WHITE);
        mainPanel.add(l1, gbc);

        txtKey = new JTextField(20); 
        gbc.gridy = 3;
        mainPanel.add(txtKey, gbc);

       
        gbc.gridy = 4;
        JLabel l2 = new JLabel("PLAINTEXT:");
        l2.setForeground(Color.WHITE);
        mainPanel.add(l2, gbc);

        txtInput = new JTextArea(5, 20); 
        txtInput.setLineWrap(true);
        gbc.gridy = 5;
        mainPanel.add(new JScrollPane(txtInput), gbc);

        
        gbc.gridy = 6;
        gbc.insets = new Insets(20, 0, 20, 0);
        JPanel btnPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        btnPanel.setOpaque(false);

        EncryptButton = new JButton("ENCRYPT");
        DecryptButton = new JButton("DECRYPT");

       
        Color lightPurple = new Color(150, 80, 255);
        Color darkPurple = new Color(100, 30, 200);
        
        applyButtonStyle(EncryptButton, lightPurple, Color.WHITE);
        applyButtonStyle(DecryptButton, darkPurple, Color.WHITE);

        btnPanel.add(EncryptButton);
        btnPanel.add(DecryptButton);
        mainPanel.add(btnPanel, gbc);

      
        gbc.gridy = 7;
        gbc.insets = new Insets(5, 0, 5, 0);
        JLabel l3 = new JLabel("RESULT:");
        l3.setForeground(Color.WHITE);
        mainPanel.add(l3, gbc);

        txtOutput = new JTextArea(5, 20);
        txtOutput.setEditable(false);
        txtOutput.setLineWrap(true);
        txtOutput.setBackground(new Color(255, 255, 240)); 
        gbc.gridy = 8;
        mainPanel.add(new JScrollPane(txtOutput), gbc);

       
        EncryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { handleAction(true); }
        });

        DecryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { handleAction(false); }
        });
    }

    private void applyButtonStyle(JButton btn, Color bg, Color fg) {
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

      
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) { btn.setBackground(bg.brighter()); }
            public void mouseExited(java.awt.event.MouseEvent e) { btn.setBackground(bg); }
        });

        btn.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(c.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 25, 25);
                super.paint(g2, c);
                g2.dispose();
            }
        });
    }

    private void handleAction(boolean isEncrypt) {
        String key = txtKey.getText().trim();
        String text = txtInput.getText().trim();
        if (key.isEmpty() || text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            
            return;
        }
        try {
            char[][] matrix = PlayfairPart1.generateMatrix(key);
            if (isEncrypt) {
                txtOutput.setText(PlayfairPart2.encrypt(PlayfairPart1.prepareText(text), matrix));
            } else {
                String clean = text.toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
                txtOutput.setText(PlayfairPart2.decrypt(clean, matrix));
            }
        } catch (Exception ex) {
            txtOutput.setText("Invalid input please try again.");
        }
    }

    public static void main(String[] args) {
        PlayfairMainGUI gui = new PlayfairMainGUI();
        gui.pack(); 
        gui.setLocationRelativeTo(null); 
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
