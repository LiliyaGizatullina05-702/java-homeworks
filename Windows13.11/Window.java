import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Window extends JFrame {
    public Window() {
        this.setVisible(true);
        this.setBounds(150, 300, 600, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        JButton button = new JButton();
        button.setBounds(400, 300, 150, 70);
        button.setText("Кнопка");
        this.add(button);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 600, 270);
        panel.setBackground(Color.WHITE);
        this.add(panel);
        Animator a = new Animator(panel.getGraphics());
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                a.draw(mouseEvent.getX(), mouseEvent.getY());

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                button.setText(" Ты молодец!");
                //button.setSize(button.getWidth()+10, button.getHeight()+10);

            }
        });
        button.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                int x = mouseEvent.getX();
                int y = mouseEvent.getY();
                Random random = new Random();
                boolean b = false;
                int newX = 0;
                int newY = 0;
                while (b == false) {
                    newX = random.nextInt(450);
                    newY = random.nextInt(320);
                    if ((x > newX && x < newX + button.getWidth()) && ((y > newY && y < newY + button.getHeight()))) {
                        b = false;
                    } else{
                        b = true;
                    }

                }

                button.setBounds(random.nextInt(450), random.nextInt(320), button.getWidth(), button.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

    }
}
