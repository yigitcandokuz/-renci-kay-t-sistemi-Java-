import javax.swing.*;

public class AnaForm extends JFrame {

    private JButton başlaButton;
    private JPanel panel1;
    private JLabel öğrenciVeDersKayıtLabel;

    public AnaForm() {
        // Pencerenin özelliklerini ayarlayın
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Ana Form");

        // Swing bileşenlerinin oluşturulması ve ayarlanması
        panel1 = new JPanel();
        başlaButton = new JButton("Başla");
        öğrenciVeDersKayıtLabel = new JLabel("Öğrenci ve Ders Kayıt");

        // Başla butonuna tıklanınca Form1 penceresini göster
        başlaButton.addActionListener(e -> {
            Form1 f2 = new Form1();
            f2.setVisible(true);
        });

        // Panel bileşenlerinin panele eklenmesi
        panel1.add(öğrenciVeDersKayıtLabel);
        panel1.add(başlaButton);

        // Panelin JFrame'e eklenmesi
        add(panel1);
    }

    public static void main(String[] args) {
        // Ana formun görüntülenmesi
        SwingUtilities.invokeLater(() -> {
            AnaForm anaForm = new AnaForm();
            anaForm.setVisible(true);
        });
    }
}
