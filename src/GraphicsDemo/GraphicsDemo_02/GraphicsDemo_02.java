package GraphicsDemo.GraphicsDemo_02;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 Изменение размеров вывода, чтобы он умещался: в текущие размеры окна.
 */
public class GraphicsDemo_02 extends Frame {
    final int inc = 25;
    int max = 500;
    int min = 200;
    Dimension d;

    public GraphicsDemo_02() {
        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                int w = (d.width + inc) > max ? min : (d.width + inc);
                int h = (d.height + inc) > max ? min : (d.height + inc);
                setSize(new Dimension(w, h));
            }
        });
        // Анонимный внутренний класс для обработки событий закрытия окна.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        Insets i = getInsets();
        System.out.println("i = " + i);
        d = getSize();
        g.drawLine(i.left, i.top, d.width - i.right, d.height - i.bottom);
        g.drawLine(i.left,d.width - i.bottom,d.width - i.right,i.top);
    }

    public static void main(String[] args) {
        GraphicsDemo_02 app = new GraphicsDemo_02();
        app.setSize(new Dimension(200,200));
        app.setTitle("ResizeMe");
        app.setVisible(true);
    }
}
