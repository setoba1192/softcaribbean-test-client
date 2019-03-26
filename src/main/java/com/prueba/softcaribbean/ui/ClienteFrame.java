package com.prueba.softcaribbean.ui;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.softcaribbean.exception.ObjetoNoEncontradoException;
import com.prueba.softcaribbean.exception.ValidacionDominioException;
import com.prueba.softcaribbean.model.Cliente;
import com.prueba.softcaribbean.service.ClienteRestService;
import com.prueba.softcaribbean.util.JsonTransformer;
import com.prueba.softcaribbean.util.Mensaje;
import com.prueba.softcaribbean.util.Utils;

@Component
public class ClienteFrame extends JFrame {

	@Autowired
	private ClienteRestService clienteRestService;

	private SimpleDateFormat simpleDateFormat;

	private Cliente cliente;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_buscar;
	private JTextField textField_id;
	private JTextField textField_cliente;
	private JTextField textField_nombre;
	private JTextField textField_direccion;
	private JTextField textField_email;
	private JTextField textField_fechaRegistro;
	private JTextField textField_fechaBaja;
	private JTextField textField_usuario;
	private JTextField textField_activo;
	private JTextField textField_contacto;
	private JTextField textField_logo;
	private JTextField textField_telefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteFrame frame = new ClienteFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteFrame() {

		simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 828);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_buscar = new JTextField();
		textField_buscar.setColumns(10);
		textField_buscar.setBounds(29, 49, 109, 20);
		contentPane.add(textField_buscar);

		JLabel label = new JLabel("Usuario:");
		label.setBounds(29, 24, 109, 14);
		contentPane.add(label);

		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cliente = clienteRestService.buscarPorId(Integer.parseInt(textField_buscar.getText()));
				if (cliente == null) {
					return;
				}

				llenarFormulario(cliente);

			}
		});
		buttonBuscar.setBounds(148, 48, 89, 23);
		contentPane.add(buttonBuscar);

		JLabel label_1 = new JLabel("Id:");
		label_1.setBounds(29, 80, 46, 14);
		contentPane.add(label_1);

		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setColumns(10);
		textField_id.setBounds(29, 103, 86, 20);
		contentPane.add(textField_id);

		JLabel label_2 = new JLabel("Cliente:");
		label_2.setBounds(29, 134, 135, 14);
		contentPane.add(label_2);

		textField_cliente = new JTextField();
		textField_cliente.setColumns(10);
		textField_cliente.setBounds(29, 159, 379, 20);
		contentPane.add(textField_cliente);

		JLabel label_3 = new JLabel("Nombre:");
		label_3.setBounds(29, 190, 122, 14);
		contentPane.add(label_3);

		textField_nombre = new JTextField();
		textField_nombre.setColumns(10);
		textField_nombre.setBounds(29, 215, 379, 20);
		contentPane.add(textField_nombre);

		JLabel label_4 = new JLabel("Direcci\u00F3n:");
		label_4.setBounds(29, 246, 135, 14);
		contentPane.add(label_4);

		textField_direccion = new JTextField();
		textField_direccion.setColumns(10);
		textField_direccion.setBounds(29, 271, 379, 20);
		contentPane.add(textField_direccion);

		JLabel label_5 = new JLabel("Email");
		label_5.setBounds(29, 302, 135, 14);
		contentPane.add(label_5);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(29, 327, 379, 20);
		contentPane.add(textField_email);

		JLabel label_6 = new JLabel("Fecha de Registro:");
		label_6.setBounds(29, 358, 308, 14);
		contentPane.add(label_6);

		textField_fechaRegistro = new JTextField();
		textField_fechaRegistro.setEditable(false);
		textField_fechaRegistro.setColumns(10);
		textField_fechaRegistro.setBounds(29, 383, 379, 20);
		contentPane.add(textField_fechaRegistro);

		JLabel label_7 = new JLabel("Fecha de baja:");
		label_7.setBounds(29, 414, 352, 14);
		contentPane.add(label_7);

		textField_fechaBaja = new JTextField();
		textField_fechaBaja.setToolTipText("Fecha en formato dd/mm/yyyy");
		textField_fechaBaja.setColumns(10);
		textField_fechaBaja.setBounds(29, 439, 379, 20);
		contentPane.add(textField_fechaBaja);

		JLabel label_8 = new JLabel("Usuario:");
		label_8.setBounds(29, 470, 86, 14);
		contentPane.add(label_8);

		textField_usuario = new JTextField();
		textField_usuario.setColumns(10);
		textField_usuario.setBounds(29, 495, 379, 20);
		contentPane.add(textField_usuario);

		JLabel label_9 = new JLabel("Activo");
		label_9.setBounds(29, 526, 158, 14);
		contentPane.add(label_9);

		textField_activo = new JTextField();
		textField_activo.setColumns(10);
		textField_activo.setBounds(29, 551, 86, 20);
		contentPane.add(textField_activo);

		JLabel label_10 = new JLabel("Contacto:");
		label_10.setBounds(29, 646, 182, 14);
		contentPane.add(label_10);

		textField_contacto = new JTextField();
		textField_contacto.setColumns(10);
		textField_contacto.setBounds(29, 671, 379, 20);
		contentPane.add(textField_contacto);

		JLabel label_11 = new JLabel("Logo:");
		label_11.setBounds(29, 702, 109, 14);
		contentPane.add(label_11);

		textField_logo = new JTextField();
		textField_logo.setColumns(10);
		textField_logo.setBounds(29, 727, 379, 20);
		contentPane.add(textField_logo);

		JButton button_limpiarFormulario = new JButton("Limpiar Formulario");
		button_limpiarFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limpiarFormulario();
			}
		});
		button_limpiarFormulario.setBounds(10, 758, 154, 23);
		contentPane.add(button_limpiarFormulario);

		JButton button_crearUsuario = new JButton("Crear Usuario");
		button_crearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				crearYRegistrarCliente();

			}
		});
		button_crearUsuario.setBounds(174, 758, 131, 23);
		contentPane.add(button_crearUsuario);

		JButton button_actualizarUsuario = new JButton("Actualizar Usuario");
		button_actualizarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					actualizarCliente();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_actualizarUsuario.setBounds(315, 758, 142, 23);
		contentPane.add(button_actualizarUsuario);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(29, 582, 276, 14);
		contentPane.add(lblTelfono);

		textField_telefono = new JTextField();
		textField_telefono.setBounds(29, 607, 379, 20);
		contentPane.add(textField_telefono);
		textField_telefono.setColumns(10);
	}

	private void crearYRegistrarCliente() {

		if (cliente != null) {

			JOptionPane.showMessageDialog(getContentPane(), "Debe limpiar el formulario para crear un nuevo cliente",
					"Información", JOptionPane.WARNING_MESSAGE);
			return;
		}

		validarCliente();

		Cliente cliente = new Cliente();
		cliente.setCliente(this.textField_cliente.getText());
		cliente.setNombre(this.textField_nombre.getText());
		cliente.setDireccion(this.textField_direccion.getText());
		cliente.setMail(this.textField_email.getText());
		cliente.setUsuario(this.textField_usuario.getText());
		cliente.setActivo(this.textField_activo.getText());
		cliente.setTelefono(this.textField_telefono.getText());
		cliente.setContacto(this.textField_contacto.getText());
		cliente.setLogo(this.textField_logo.getText());

		Mensaje mensaje = clienteRestService.crear(cliente);
		if (mensaje != null) {

			this.cliente = (Cliente) JsonTransformer.fromJSON(JsonTransformer.toJson(mensaje.getBody()), Cliente.class);
			llenarFormulario(this.cliente);

			JOptionPane.showMessageDialog(getContentPane(), mensaje.getMensaje(), "Información",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private void actualizarCliente() throws ParseException {

		if (cliente == null) {

			throw new ObjetoNoEncontradoException("Debe buscar un Cliente para actualizar", getContentPane());
		}

		validarCliente();

		if (!Utils.validateDateFormat("dd/mm/yyyy", this.textField_fechaBaja.getText())) {

			throw new ValidacionDominioException("El formato de fecha no corresponde a dd/mm/yyy", getContentPane());
		}

		this.cliente.setCliente(this.textField_cliente.getText());
		this.cliente.setNombre(this.textField_nombre.getText());
		this.cliente.setDireccion(this.textField_direccion.getText());
		this.cliente.setMail(this.textField_email.getText());
		this.cliente.setUsuario(this.textField_usuario.getText());
		this.cliente.setActivo(this.textField_activo.getText());
		this.cliente.setTelefono(this.textField_telefono.getText());
		this.cliente.setFechaBaja(
				new Timestamp(((java.util.Date) simpleDateFormat.parse(this.textField_fechaBaja.getText())).getTime()));
		this.cliente.setContacto(this.textField_contacto.getText());
		this.cliente.setLogo(this.textField_logo.getText());

		Mensaje mensaje = clienteRestService.actualizar(cliente);
		if (mensaje != null) {

			this.cliente = (Cliente) JsonTransformer.fromJSON(JsonTransformer.toJson(mensaje.getBody()), Cliente.class);
			llenarFormulario(this.cliente);

			JOptionPane.showMessageDialog(getContentPane(), mensaje.getMensaje(), "Información",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void validarCliente() {

		Utils.validateEmptyStringAndLength(this.textField_cliente.getText(), 15, "Cliente", getContentPane());
		Utils.validateEmptyStringAndLength(this.textField_nombre.getText(), 120, "Nombre", getContentPane());
		Utils.validateEmptyStringAndLength(this.textField_direccion.getText(), 120, "Dirección", getContentPane());
		Utils.validateEmptyStringAndLength(this.textField_email.getText(), 120, "Email", getContentPane());
		Utils.validateEmptyStringAndLength(this.textField_usuario.getText(), 120, "Usuario", getContentPane());
		Utils.validateEmptyStringAndLength(this.textField_activo.getText(), 1, "Activo", getContentPane());
		Utils.validateEmptyStringAndLength(this.textField_telefono.getText(), 60, "Teléfono", getContentPane());
		Utils.validateEmptyStringAndLength(this.textField_contacto.getText(), 120, "Contacto", getContentPane());
		Utils.validateEmptyStringAndLength(this.textField_logo.getText(), 50, "Logo", getContentPane());
	}

	private void limpiarFormulario() {

		Container con = getContentPane();
		for (java.awt.Component c : con.getComponents()) {
			if (c instanceof JTextField) {
				JTextField j = (JTextField) c;
				j.setText("");
			}
		}
		cliente = null;
	}

	private void llenarFormulario(Cliente cliente) {

		this.textField_id.setText(String.valueOf(cliente.getId()));
		this.textField_cliente.setText(cliente.getCliente());
		this.textField_nombre.setText(cliente.getNombre());
		this.textField_direccion.setText(cliente.getDireccion());
		this.textField_email.setText(cliente.getMail());
		this.textField_fechaRegistro
				.setText(cliente.getFechaRegistro() == null ? "" : simpleDateFormat.format(cliente.getFechaRegistro()));
		this.textField_fechaBaja
				.setText(cliente.getFechaBaja() == null ? "" : simpleDateFormat.format(cliente.getFechaBaja()));
		this.textField_usuario.setText(cliente.getUsuario());
		this.textField_activo.setText(cliente.getActivo());
		this.textField_telefono.setText(cliente.getTelefono());
		this.textField_contacto.setText(cliente.getContacto());
		this.textField_logo.setText(cliente.getLogo());

	}

}
