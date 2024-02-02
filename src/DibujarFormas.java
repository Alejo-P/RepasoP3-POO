import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.util.ArrayList;

public class DibujarFormas extends JFrame {
    private JPanel panelDibujo;
    private ArrayList<Shape> formas;
    private String formaActual;
    private int xInicial, yInicial, xFinal, yFinal;

    public DibujarFormas() {
        super("Dibujando Formas");

        // Configuración de la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        // Panel de dibujo
        panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Shape forma : formas) {
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(Color.BLACK);
                    g2d.draw(forma);
                }
            }
        };
        panelDibujo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xInicial = e.getX();
                yInicial = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                xFinal = e.getX();
                yFinal = e.getY();
                switch (formaActual) {
                    case "Rectangulo":
                        formas.add(new Rectangle(xInicial, yInicial, xFinal - xInicial, yFinal - yInicial));
                        break;
                    case "Círculo":
                        formas.add(new Ellipse2D.Double(xInicial, yInicial, xFinal - xInicial, xFinal - xInicial));
                        break;
                    case "Línea":
                        formas.add(new Line2D.Double(xInicial, yInicial, xFinal, yFinal));
                        break;
                }
                panelDibujo.repaint();
            }
        });

        // Agregar el panel de dibujo a la ventana principal
        getContentPane().add(panelDibujo);

        // Botones para seleccionar la forma a dibujar
        JPanel panelBotones = new JPanel();
        JButton rectanguloButton = new JButton("Rectángulo");
        rectanguloButton.addActionListener(e -> formaActual = "Rectangulo");
        JButton circuloButton = new JButton("Círculo");
        circuloButton.addActionListener(e -> formaActual = "Círculo");
        JButton lineaButton = new JButton("Línea");
        lineaButton.addActionListener(e -> formaActual = "Línea");
        panelBotones.add(rectanguloButton);
        panelBotones.add(circuloButton);
        panelBotones.add(lineaButton);

        // Agregar el panel de botones a la ventana principal
        getContentPane().add(panelBotones, BorderLayout.SOUTH);

        formas = new ArrayList<>();

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DibujarFormas::new);
    }
}

