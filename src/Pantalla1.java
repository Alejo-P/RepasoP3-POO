import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Pantalla1 {

    JPanel Pantalla1;
    private JLabel texto1;
    private JTextField ingresoNombre;
    private JComboBox comboBox1;
    private JButton registrarUsuarioButton;
    private JButton visualizarRegistrosButton;

    private ArrayList<Usuario> Registro_Uuarios;

    public Pantalla1() {
        Registro_Uuarios =new ArrayList<>();

        registrarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ingresoNombre.getText().length()!=0)
                {
                    String nombre=ingresoNombre.getText();
                    String genero=(String) comboBox1.getSelectedItem();
                    Usuario usuario = new Usuario(nombre, genero);
                    Registro_Uuarios.add(usuario);
                    JOptionPane.showMessageDialog(Pantalla1, "Usuario registrado con exito!", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

                }
                else
                {
                    JOptionPane.showMessageDialog(Pantalla1, "Ingresa un usuario antes de registrarlo!", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        visualizarRegistrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Registro_Uuarios.isEmpty())
                {
                    JFrame ventana2 = new JFrame();
                    ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    ventana2.setSize(200, 300);
                    ventana2.setContentPane(new VisualizarRegistros(Registro_Uuarios).Principal);
                    ventana2.pack();
                    ventana2.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(Pantalla1, "Registra al menos un usuario antes de poder visualizar registros!", "Sin registros", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
