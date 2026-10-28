
package interfaz;



import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RegistroPacientesApp extends JFrame {

    public RegistroPacientesApp() {

        setTitle("Laboratorio Clínico - Registrar Paciente");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(24, 43, 73)); // Azul oscuro institucional
        headerPanel.setPreferredSize(new Dimension(getWidth(), 60));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JLabel lblLogo = new JLabel(" Laboratorio Clínico");
        lblLogo.setForeground(Color.WHITE);
        lblLogo.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(lblLogo, BorderLayout.WEST);

        JLabel lblUser = new JLabel(" Fernando Pérez (Administrador)");
        lblUser.setForeground(Color.WHITE);
        lblUser.setFont(new Font("Arial", Font.PLAIN, 13));
        headerPanel.add(lblUser, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);


        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(new Color(30, 41, 59)); // Gris oscuro azulado
        sidebarPanel.setPreferredSize(new Dimension(230, getHeight()));
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        String[] menuItems = {"Inicio", "Pacientes", "Toma de muestras", "Resultados", "Reportes", "Configuración"};
        for (int i = 0; i < menuItems.length; i++) {
            JButton btnMenu = new JButton(menuItems[i]);
            btnMenu.setMaximumSize(new Dimension(210, 40));
            btnMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnMenu.setFocusPainted(false);
            btnMenu.setHorizontalAlignment(SwingConstants.LEFT);
            btnMenu.setFont(new Font("Arial", Font.PLAIN, 13));

            if (i == 1) { // Seleccionado por defecto ("Pacientes")
                btnMenu.setBackground(new Color(59, 130, 246));
                btnMenu.setForeground(Color.WHITE);
            } else {
                btnMenu.setBackground(new Color(30, 41, 59));
                btnMenu.setForeground(new Color(203, 213, 225));
                btnMenu.setBorderPainted(false);
            }
            sidebarPanel.add(btnMenu);
            sidebarPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        }
        add(sidebarPanel, BorderLayout.WEST);

        // 3. CONTENEDOR CENTRAL (Formulario + Panel Derecho)
        JPanel contentArea = new JPanel(new BorderLayout(15, 15));
        contentArea.setBackground(new Color(241, 245, 249)); // Fondo gris claro
        contentArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //  FORMULARIO CENTRAL
        JPanel formContainer = new JPanel();
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));
        formContainer.setBackground(Color.WHITE);
        
        // Padding interno y bordes redondeados simulados con EmptyBorder
        JPanel formInnerPadding = new JPanel(new BorderLayout());
        formInnerPadding.setBackground(Color.WHITE);
        formInnerPadding.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel formBody = new JPanel();
        formBody.setLayout(new BoxLayout(formBody, BoxLayout.Y_AXIS));
        formBody.setBackground(Color.WHITE);

        // Título del formulario
        JLabel lblTitle = new JLabel("Registrar paciente");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(new Color(30, 41, 59));
        
        JLabel lblSubtitle = new JLabel("Complete la información del paciente para continuar con el proceso de atención.");
        lblSubtitle.setFont(new Font("Arial", Font.PLAIN, 12));
        lblSubtitle.setForeground(new Color(100, 116, 139));

        formBody.add(lblTitle);
        formBody.add(Box.createRigidArea(new Dimension(0, 4)));
        formBody.add(lblSubtitle);
        formBody.add(Box.createRigidArea(new Dimension(0, 20)));

        // Datos Personales
        formBody.add(crearSeccionTitulo("Datos personales"));
        JPanel gridDatos = new JPanel(new GridLayout(4, 2, 15, 10));
        gridDatos.setBackground(Color.WHITE);

        gridDatos.add(crearCampoConLabel("Tipo de documento *", new JComboBox<>(new String[]{"Cédula de ciudadanía", "Cédula de extranjería", "Pasaporte"})));
        gridDatos.add(crearCampoConLabel("Número de documento *", new JTextField("1234567890")));
        gridDatos.add(crearCampoConLabel("Nombres *", new JTextField("Juan Carlos")));
        gridDatos.add(crearCampoConLabel("Apellidos *", new JTextField("Ramírez López")));
        gridDatos.add(crearCampoConLabel("Fecha de nacimiento *", new JTextField("15/04/1985")));
        gridDatos.add(crearCampoConLabel("Edad", new JTextField("40 años")));
        gridDatos.add(crearCampoConLabel("Género *", new JComboBox<>(new String[]{"Masculino", "Femenino", "Otro"})));
        
        formBody.add(gridDatos);
        formBody.add(Box.createRigidArea(new Dimension(0, 20)));

        //Información de contacto
        formBody.add(crearSeccionTitulo("Información de contacto"));
        JPanel gridContacto = new JPanel(new GridLayout(2, 2, 15, 10));
        gridContacto.setBackground(Color.WHITE);

        gridContacto.add(crearCampoConLabel("Teléfono fijo", new JTextField("601 1234567")));
        gridContacto.add(crearCampoConLabel("Teléfono celular *", new JTextField("300 123 4567")));
        gridContacto.add(crearCampoConLabel("Correo electrónico", new JTextField("juan.ramirez@example.com")));
        gridContacto.add(crearCampoConLabel("Dirección de residencia *", new JTextField("Carrera 10 # 20 - 30")));

        formBody.add(gridContacto);
        formBody.add(Box.createRigidArea(new Dimension(0, 20)));

        // Información adicional
        formBody.add(crearSeccionTitulo("Información adicional"));
        JPanel gridAdicional = new JPanel(new GridLayout(3, 2, 15, 10));
        gridAdicional.setBackground(Color.WHITE);

        gridAdicional.add(crearCampoConLabel("EPS *", new JComboBox<>(new String[]{"Nueva EPS", "Sura", "Sanitas", "Compensar"})));
        gridAdicional.add(crearCampoConLabel("Régimen", new JComboBox<>(new String[]{"Contributivo", "Subsidiado"})));
        gridAdicional.add(crearCampoConLabel("Ocupación", new JTextField("Ingeniero de sistemas")));
        gridAdicional.add(crearCampoConLabel("Estado civil", new JComboBox<>(new String[]{"Soltero(a)", "Casado(a)", "Unión libre"})));
        gridAdicional.add(crearCampoConLabel("¿Tiene alguna condición médica relevante?", new JComboBox<>(new String[]{"No", "Sí"})));
        gridAdicional.add(crearCampoConLabel("Observaciones", new JTextField("Puede agregar información adicional aquí...")));

        formBody.add(gridAdicional);
        formBody.add(Box.createRigidArea(new Dimension(0, 30)));

        // Botones de acción inferiores
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        panelBotones.setBackground(Color.WHITE);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.WHITE);
        btnCancelar.setForeground(new Color(71, 85, 105));
        
        JButton btnGuardar = new JButton("Guardar paciente");
        btnGuardar.setBackground(new Color(30, 64, 175));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);

        panelBotones.add(btnCancelar);
        panelBotones.add(btnGuardar);
        formBody.add(panelBotones);

        formInnerPadding.add(formBody, BorderLayout.CENTER);
        
        JScrollPane scrollForm = new JScrollPane(formInnerPadding);
        scrollForm.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240)));
        contentArea.add(scrollForm, BorderLayout.CENTER);

        //  PANEL DERECHO (Resumen y Avisos)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(241, 245, 249));
        rightPanel.setPreferredSize(new Dimension(320, 0));

        // Tarjeta Resumen
        JPanel cardResumen = new JPanel();
        cardResumen.setLayout(new BoxLayout(cardResumen, BoxLayout.Y_AXIS));
        cardResumen.setBackground(Color.WHITE);
        cardResumen.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel lblResumenTitle = new JLabel("Resumen");
        lblResumenTitle.setFont(new Font("Arial", Font.BOLD, 15));
        cardResumen.add(lblResumenTitle);
        cardResumen.add(Box.createRigidArea(new Dimension(0, 15)));

        JLabel lblInfoResumen = new JLabel("<html><b>Juan Carlos Ramírez López</b><br><font color='gray'>CC 1234567890</font><br><br>" +
                " 15/04/1985 (40 años)<br>" +
                " 300 123 4567<br>" +
                " juan.ramirez@example.com<br>" +
                " Carrera 10 # 20 - 30<br>" +
                " Nueva EPS<br>" +
                " Contributivo</html>");
        cardResumen.add(lblInfoResumen);

        // Tarjeta Tenga en cuenta
        JPanel cardAviso = new JPanel();
        cardAviso.setLayout(new BoxLayout(cardAviso, BoxLayout.Y_AXIS));
        cardAviso.setBackground(Color.WHITE);
        cardAviso.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel lblAvisoTitle = new JLabel(" Tenga en cuenta");
        lblAvisoTitle.setFont(new Font("Arial", Font.BOLD, 14));
        cardAviso.add(lblAvisoTitle);
        cardAviso.add(Box.createRigidArea(new Dimension(0, 10)));
        
        JLabel lblAvisoText = new JLabel("<html><font color='gray'>Los datos del paciente son necesarios para la generación de la orden médica, la trazabilidad de las muestras y la entrega de resultados.</font></html>");
        cardAviso.add(lblAvisoText);

        rightPanel.add(cardResumen);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        rightPanel.add(cardAviso);

        contentArea.add(rightPanel, BorderLayout.EAST);
        add(contentArea, BorderLayout.CENTER);
    }

    // Método auxiliar para crear títulos de sección con línea divisoria
    private JPanel crearSeccionTitulo(String titulo) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
        lbl.setForeground(new Color(30, 41, 59));
        panel.add(lbl, BorderLayout.WEST);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        return panel;
    }

    // Método auxiliar para agrupar etiqueta y campo de entrada (TextField o ComboBox)
    private JPanel crearCampoConLabel(String etiqueta, JComponent campo) {
        JPanel panel = new JPanel(new BorderLayout(0, 3));
        panel.setBackground(Color.WHITE);
        JLabel lbl = new JLabel(etiqueta);
        lbl.setFont(new Font("Arial", Font.PLAIN, 11));
        lbl.setForeground(new Color(100, 116, 139));
        panel.add(lbl, BorderLayout.NORTH);
        panel.add(campo, BorderLayout.CENTER);
        return panel;
    }
        
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegistroPacientesApp().setVisible(true);
        });
    }


}
