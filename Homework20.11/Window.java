import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Window extends JFrame {

    public Window() {

        this.setBounds(350, 200, 1000, 700); //задаем размер окна
        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE); //метод закрытия
        this.setResizable(true); //возможность изменять размер окна
        this.setLayout(null);
        this.setVisible(true); //видимость

        Animator animator = new Animator(this.getGraphics()); //создаем новый аниматор и передаем объект, который возвращается методом getGraphics()
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                animator.setXandY(e.getX(), e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.addMouseWheelListener(new MouseWheelListener() { //
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println(e.getWheelRotation());
                animator.changeCellSize(e.getWheelRotation(), e.getX(), e.getY()); //метод, который выполняется движением колеса мыши

            }
        });

        this.setVisible(true);

    }
}
