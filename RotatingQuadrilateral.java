import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotatingQuadrilateral extends JPanel implements ActionListener {
    private int angle = 0;
    private Timer timer;

    public RotatingQuadrilateral() {
        timer = new Timer(50, this); // Создаем таймер, который будет генерировать события каждые 50 миллисекунд
        timer.start(); // Запускаем таймер
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int[] xPoints = { centerX - 50, centerX + 50, centerX + 50, centerX - 50 };
        int[] yPoints = { centerY - 50, centerY - 50, centerY + 50, centerY + 50 };

        // Поворачиваем координатную систему вокруг центра тяжести
        g2d.rotate(Math.toRadians(angle), centerX, centerY);

        g2d.setColor(Color.GREEN);
        g2d.fillPolygon(xPoints, yPoints, 4);

        g2d.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += 5; // Увеличиваем угол поворота
        repaint(); // Запрашиваем перерисовку панели
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rotating Quadrilateral");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RotatingQuadrilateral());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}