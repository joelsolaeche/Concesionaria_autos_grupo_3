import model.*;


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
  public static void main(String[] args) {

    Administrador admin = new Administrador(1,"Ana","Boss","12345678","admin@mail.com", "admin123");
    Vendedor vendedor = new Vendedor(2, "Pedro", "Ventas", "23456789", "vendedor@mail.com", "venta123","Capital Federal");
    Comprador comprador = new Comprador(3, "Lucía", "Cliente", "34567890", "lucia@mail.com", "clave123", "Serrano 665","1234567894");

    List<Usuario> usuarios = new ArrayList<>();
    usuarios.add(admin);
    usuarios.add(vendedor);
    usuarios.add(comprador);

    List<Vehiculo> vehiculos = new ArrayList<>();
    vehiculos.add(new Vehiculo("Fiesta", "Ford", "Rojo", 1001, "2001", TipoVehiculo.AUTO));
    vehiculos.add(new Vehiculo("Hilux", "Toyota", "Negro", 1002, "2002", TipoVehiculo.CAMIONETA));

    List<PedidoCompra> pedidos = new ArrayList<>();

    Scanner scannner = new Scanner(System.in);
    System.out.println("=== Iniciar Sesión ===");
    System.out.println("Ingrese su email: ");
    String inputEmail = scannner.nextLine();

    System.out.println("Ingrese su contraseña: ");
    String inputPassword = scannner.nextLine();

    Usuario usuarioLogueado = null;
    boolean encontrado = false;

    for (Usuario user : usuarios) {
      if (!encontrado && user.iniciarSesion(inputEmail,inputPassword)){
        usuarioLogueado = user;
        encontrado = true;
      }
    }

    if (!encontrado){
      System.out.println("Error: Usuario o Contraseña inconrrectos. ");
      return;
    }

    //CREACION DE LOS FACADE
    if (usuarioLogueado instanceof Administrador) {
      AdministradorFacade adminFacade = new AdministradorFacade(admin, usuarios, vehiculos, pedidos);
      System.out.println("Administrador accedio correctamente");

      System.out.println("Lista de usuarios registrados: ");
      adminFacade.verTodosLosClientes();

      adminFacade.cambairColorVehiculo(vehiculos, 1001, "Azul");

      adminFacade.generarReportePedidos();
    } else if (usuarioLogueado instanceof Vendedor) {
      VendedorFacade vendedorFacade = new VendedorFacade(vendedor, vehiculos);
      System.out.println("Vendedor accedio correctamente");

      List<Vehiculo> disponibles = vendedorFacade.obtenerVehiculosDisponibles();
      System.out.println("Vehiculos Disponibles: ");
      for (Vehiculo vehiculo : disponibles) {
        System.out.println(" - " + vehiculo.getModelo() + " " + vehiculo.getColor());
      }
      if (!vehiculos.isEmpty()) {
        vendedorFacade.registrarVenta(vehiculos.get(0),comprador);
      }
      List<Comprador> clientes = vendedorFacade.obtenerClientes();
      System.out.println("Lista de clientes: ");
      for (Comprador c: clientes) {
        System.out.println(" - " + c.getNombre() + " " + c.getApellido());
      }
    }else if (usuarioLogueado instanceof Comprador) {
      CompradorFacade compradorFacade = new CompradorFacade(comprador);
      System.out.println("Comprador accedio correctamente");

      Comprador compradorActual = (Comprador) usuarioLogueado;
      System.out.println("Bienvenido " + compradorActual.getNombre() + " " + compradorActual.getApellido());
      System.out.println("Dirección: " + compradorActual.getDireccion());
      System.out.println("Teléfono: " + compradorActual.getTelefono());
    } else {
      System.out.println("Error: Usuario incorrecto.");
    }

    Vehiculo vehiculoElegido = vehiculos.get(1);


    PublicadorPedidoCompra publicadorPedidoCompra = new PublicadorPedidoCompra();


    Area entrega = new Entrega();
    Area logistica = new Logistica();
    Area embarque = new Embarque();
    Area cobranzas = new Cobranzas();
    Area ventas = new Ventas();

    publicadorPedidoCompra.agregarObservador(entrega);
    publicadorPedidoCompra.agregarObservador(logistica);
    publicadorPedidoCompra.agregarObservador(embarque);
    publicadorPedidoCompra.agregarObservador(cobranzas);
    publicadorPedidoCompra.agregarObservador(ventas);

    //DETALLES DEL PEDIDO COMPRA (PATRON BUILDER)
    PedidoCompraBuilder builder = new PedidoCompraBuilderConcreto();
    PedidoCompraDirector director = new PedidoCompraDirector(builder);

    PedidoCompra pedido = director.construirPedido(
            3001,
            new Date(),
            25000.0,
            new Cliente(3, "Lucía", "Cliente", "34567890", "lucia@mail.com", "clave123", "Serrano 665", 1234567894L, new Date()),
            vehiculoElegido,
            new Contado(), // o la forma de pago que corresponda
            new Ventas(),
            new EstadoPedido(1, new Ventas()),
            new ArrayList<HistorialPedidoCompra>(),
            publicadorPedidoCompra

    );
    System.out.println("==== Detalles del Pedido de Compra ====");
    System.out.println("Pedido creado con nro: " + pedido.getNroPedido());
    System.out.println("Costo total: $" + pedido.getCostoTotal());
    System.out.println("Cliente: " + pedido.getCliente().getNombre() + " " +pedido.getCliente().getApellido());
    System.out.println("DNI: " + pedido.getCliente().getDni());
    System.out.println("Email: " + pedido.getCliente().getEmail());
    System.out.println("Teléfono: " + pedido.getCliente().getTelefono());
    System.out.println("Dirección: " + pedido.getCliente().getDireccion());
    System.out.println("CUIT: " + pedido.getCliente().getCuit());
    System.out.println("Fecha de Alta: " + pedido.getCliente().getFechaAlta());

    Vehiculo vehiculo = pedido.getVehiculo();
    System.out.println("==== Detalles del Vehiculo vendido ====");
    System.out.println("Marca: " + vehiculo.getMarca());
    System.out.println("Modelo: " + vehiculo.getModelo());
    System.out.println("Color: " + vehiculo.getColor());
    System.out.println("Nro Chasis: " + vehiculo.getNroChasis());
    System.out.println("Nro Motor: " + vehiculo.getNroMotor());
    System.out.println("Tipo: " + vehiculo.getTipoVehiculo());

    System.out.println("==== Forma de pago ====");
    FormaPago formaPago = pedido.getFormaPago();
    System.out.println("Forma de Pago: " +formaPago.getClass().getSimpleName());

    Area area = pedido.getAreaResponsableActual();
    System.out.println("Area Responsable Actual: " + (area != null ? area.getClass().getSimpleName() : "No asignada"));
    System.out.println("Estado pedido: " + pedido.getEstadoPedido().getNumeroPedido());

    System.out.println("COMPRA EXITOSA!");
    System.out.println("=======================================");

    //IMPRESION DE OBSERVADORES REGISTRADOS Y NOTIFICACION
    System.out.println("=== Áreas registradas como observadoras ===");
    for (Area areaObs : List.of(entrega, logistica, embarque, cobranzas)) {
      System.out.println("- " + areaObs.getNombreArea());
    }

    System.out.println("\n=== Notificando áreas involucradas en el pedido ===");
    publicadorPedidoCompra.notificarObservadores();
  }
}