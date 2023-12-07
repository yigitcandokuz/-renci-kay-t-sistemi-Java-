import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.xml.stream.*;

public class Form1 extends JFrame {
    private JTextField txtAd;
    private JTextField txtSoyad;
    private JTextField txtNumara;
    private JButton btnDevam;

    public Form1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Öğrenci Kayıt Sistemi - Form 1");

        JPanel panel = new JPanel();
        getContentPane().add(panel, null);
        panel.setLayout(null);

        JLabel lblAd = new JLabel("Ad:");
        lblAd.setBounds(30, 30, 60, 20);
        panel.add(lblAd);

        txtAd = new JTextField();
        txtAd.setBounds(100, 30, 200, 20);
        panel.add(txtAd);

        JLabel lblSoyad = new JLabel("Soyad:");
        lblSoyad.setBounds(30, 70, 60, 20);
        panel.add(lblSoyad);

        txtSoyad = new JTextField();
        txtSoyad.setBounds(100, 70, 200, 20);
        panel.add(txtSoyad);

        JLabel lblNumara = new JLabel("Numara:");
        lblNumara.setBounds(30, 110, 60, 20);
        panel.add(lblNumara);

        txtNumara = new JTextField();
        txtNumara.setBounds(100, 110, 200, 20);
        panel.add(txtNumara);

        btnDevam = new JButton("Devam");
        btnDevam.setBounds(150, 180, 100, 30);
        panel.add(btnDevam);

        btnDevam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Form2 form2 = new Form2(txtAd.getText(), txtSoyad.getText(), txtNumara.getText());
                form2.setVisible(true);
                dispose(); // Form1'i kapat
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Form1 form1 = new Form1();
            form1.setVisible(true);
        });
    }
}

