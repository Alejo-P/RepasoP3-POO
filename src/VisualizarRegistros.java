import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class VisualizarRegistros {
    JPanel Principal;
    private JTable TablaUsuarios;
    private JButton button1;
    private JButton button2;
    private ArrayList<Usuario> Lista;

    public VisualizarRegistros(ArrayList<Usuario> RegistroUsuarios) {
        this.Lista=RegistroUsuarios;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Genero");

        for (Usuario usuario : Lista) {
            modelo.addRow(new String[]{usuario.getNombre(), usuario.getGenero()});
        }

        TablaUsuarios = new JTable(modelo);

        //JScrollPane scroll = new JScrollPane(TablaUsuarios);
    }
}
