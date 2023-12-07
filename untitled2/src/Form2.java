import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.xml.stream.*;

public class Form2 extends JFrame {
    private JTextField txtDers1;
    private JTextField txtDers2;
    private JTextField txtDers3;
    private JButton btnKaydet;

    private String ad;
    private String soyad;
    private String numara;

    public Form2(String ad, String soyad, String numara) {
        this.ad = ad;
        this.soyad = soyad;
        this.numara = numara;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Öğrenci Kayıt Sistemi - Form 2");

        JPanel panel = new JPanel();
        getContentPane().add(panel, null);
        panel.setLayout(null);

        JLabel lblDers1 = new JLabel("Ders 1:");
        lblDers1.setBounds(30, 30, 60, 20);
        panel.add(lblDers1);

        txtDers1 = new JTextField();
        txtDers1.setBounds(100, 30, 200, 20);
        panel.add(txtDers1);

        JLabel lblDers2 = new JLabel("Ders 2:");
        lblDers2.setBounds(30, 70, 60, 20);
        panel.add(lblDers2);

        txtDers2 = new JTextField();
        txtDers2.setBounds(100, 70, 200, 20);
        panel.add(txtDers2);

        JLabel lblDers3 = new JLabel("Ders 3:");
        lblDers3.setBounds(30, 110, 60, 20);
        panel.add(lblDers3);

        txtDers3 = new JTextField();
        txtDers3.setBounds(100, 110, 200, 20);
        panel.add(txtDers3);

        btnKaydet = new JButton("Kaydet");
        btnKaydet.setBounds(150, 180, 100, 30);
        panel.add(btnKaydet);

        btnKaydet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
                    XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileWriter("ogrenci.xml"));

                    writer.writeStartDocument();
                    writer.writeStartElement("Ogrenci");
                    writer.writeAttribute("ad", ad);
                    writer.writeAttribute("soyad", soyad);
                    writer.writeAttribute("numara", numara);
                    writer.writeStartElement("Dersler");
                    writer.writeCharacters("\n\t\t");
                    writer.writeStartElement("Ders");
                    writer.writeAttribute("ders1", txtDers1.getText());
                    writer.writeAttribute("ders2", txtDers2.getText());
                    writer.writeAttribute("ders3", txtDers3.getText());
                    writer.writeEndElement();
                    writer.writeCharacters("\n\t");
                    writer.writeEndElement();
                    writer.writeEndDocument();

                    writer.flush();
                    writer.close();

                    JOptionPane.showMessageDialog(null, "Öğrenci bilgileri XML dosyasına kaydedildi: ogrenci.xml");
                } catch (XMLStreamException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Form2 form2 = new Form2("Öğrenci Adı", "Öğrenci Soyadı", "12345");
            form2.setVisible(true);
        });
    }
}

