import model.*;


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
  public static void main(String[] args) {

    Administrador admin = new Administrador(1, "Ana", "Gutierrez", "12345678", "admin@mail.com", "admin123");
    Vendedor vendedor = new Vendedor(2, "Pedro", "Vargas", "23456789", "vendedor@mail.com", "venta123", "Capital Federal");
    Comprador comprador = new Comprador(3, "Lucía", "De la Cruz", "34567890", "lucia@mail.com", "clave123", "Serrano 665", "1234567894", 123456785L);

    List<Usuario> usuarios = new ArrayList<>();
    usuarios.add(admin);
    usuarios.add(vendedor);
    usuarios.add(comprador);

    List<Vehiculo> vehiculos = new ArrayList<>();
    vehiculos.add(new Vehiculo("Fiesta", "Ford", "Rojo", 1001, "2001",10000, TipoVehiculo.AUTO));
    vehiculos.add(new Vehiculo("Hilux", "Toyota", "Negro", 1002, "2002",11000, TipoVehiculo.CAMIONETA));
    vehiculos.add(new Vehiculo("500X", "Fiat", "Gris", 1007, "2007",12000, TipoVehiculo.AUTO));
    vehiculos.add(new Vehiculo("Actros", "Mercedes-Benz", "Blanco", 1008, "2008",13000, TipoVehiculo.CAMIONETA));
    vehiculos.add(new Vehiculo("CBR500R", "Honda", "Rojo", 1009, "2009",14000, TipoVehiculo.MOTO));
    vehiculos.add(new Vehiculo("FH16", "Volvo", "Azul", 1010, "2010",15000 , TipoVehiculo.CAMION));

    ImpuestoStrategy nacional = new ImpuestoNacionalStrategy();
    ImpuestoStrategy provincialGral = new ImpuestoProvincialGenStrategy();
    ImpuestoStrategy ProvincialAdi = new ImpuestoProvAdiStrategy();

    Impuesto impuesto = new Impuesto(nacional);
    System.out.println("Nacional: $" + impuesto.calcularImpuestoTotal(vehiculos.get(0)));
    impuesto.setEstrategia(provincialGral);
    System.out.println("Provincial general: $" + impuesto.calcularImpuestoTotal(vehiculos.get(0)));
    impuesto.setEstrategia(ProvincialAdi);
    System.out.println("Provinvial Adicional: $" + impuesto.calcularImpuestoTotal(vehiculos.get(0)));
    System.out.println();

    Impuesto impuesto2 = new Impuesto(nacional);
    System.out.println("Nacional: $" + impuesto2.calcularImpuestoTotal(vehiculos.get(1)));
    impuesto2.setEstrategia(provincialGral);
    System.out.println("Provincial general: $" + impuesto2.calcularImpuestoTotal(vehiculos.get(1)));
    impuesto2.setEstrategia(ProvincialAdi);
    System.out.println("Provinvial Adicional: $" + impuesto2.calcularImpuestoTotal(vehiculos.get(1)));
    System.out.println();

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
      if (!encontrado && user.iniciarSesion(inputEmail, inputPassword)) {
        usuarioLogueado = user;
        encontrado = true;
      }
    }
    if (!encontrado) {
      System.out.println("Error: Usuario o Contraseña inconrrectos. ");
      return;
    }
    FormaPago formaPago = null;
    Vehiculo vehiculoElegido = null;


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
        vendedorFacade.registrarVenta(vehiculos.get(0), comprador);
      }
      List<Comprador> clientes = vendedorFacade.obtenerClientes();
      System.out.println("Lista de clientes: ");
      for (Comprador c : clientes) {
        System.out.println(" - " + c.getNombre() + " " + c.getApellido());
      }
    } else if (usuarioLogueado instanceof Comprador) {
      CompradorFacade compradorFacade = new CompradorFacade(comprador);
      System.out.println("Comprador accedio correctamente");

      Comprador compradorActual = (Comprador) usuarioLogueado;
      System.out.println("Bienvenido " + compradorActual.getNombre() + " " + compradorActual.getApellido());
      System.out.println("Dirección: " + compradorActual.getDireccion());
      System.out.println("Teléfono: " + compradorActual.getTelefono());

      System.out.println("Vehiculos disponibles para comprar: ");
      for (int i = 0; i < vehiculos.size(); i++) {
        Vehiculo v = vehiculos.get(i);
        System.out.println((i + 1) + ". " + v.getMarca() + " " + v.getModelo() + " -color: " + v.getColor());
      }

      System.out.println("Ingrese el numero del vehiculo que desea comprar: ");
      int opcionVehiculo = 0;

      boolean opcionValida = false;
      while (!opcionValida) {
        if (scannner.hasNext()) {
          opcionVehiculo = scannner.nextInt();
          scannner.nextLine();
          if (opcionVehiculo >= 1 && opcionVehiculo <= vehiculos.size()) {
            opcionValida = true;
          } else {
            System.out.println("Opcion invalida, Ingrese un numero valido: ");
          }
        } else {
          System.out.println("Ingrese un numero por favor: ");
          scannner.nextLine();
        }
      }
      vehiculoElegido = vehiculos.get(opcionVehiculo - 1);
      System.out.println("Usted eligio: " + vehiculoElegido.getMarca() + " " + vehiculoElegido.getModelo());

      System.out.println("Seleccione la forma de pago:");
      System.out.println("1. Contado");
      System.out.println("2. Transferencia");
      System.out.println("3. Tarjeta de Crédito");

      int opcionPago = 0;
      boolean pagoValido = false;

      while (!pagoValido) {
        if (scannner.hasNextInt()) {
          opcionPago = scannner.nextInt();
          scannner.nextLine();
          if (opcionPago == 1) {
            formaPago = new Contado();
            pagoValido = true;
          } else if (opcionPago == 2) {
            formaPago = new Transferencia();
            pagoValido = true;
          } else if (opcionPago == 3) {
            formaPago = new TarjetaCredito();
            pagoValido = true;
          } else {
            System.out.println("Opcion invalida, Ingrese 1,2,3:  ");
          }
        } else {
          System.out.println("Ingrese un numero valido: ");
          scannner.nextLine();
        }

      }
    } else {
      System.out.println("Error: Usuario incorrecto.");
    }



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

    if (vehiculoElegido != null && usuarioLogueado instanceof Comprador) {
      Comprador compradorActual = (Comprador) usuarioLogueado;

      Cliente clienteParaPedido = new Cliente(
              compradorActual.getId(),
              compradorActual.getNombre(),
              compradorActual.getApellido(),
              compradorActual.getDni(),
              compradorActual.getEmail(),
              compradorActual.getTelefono(),
              compradorActual.getDireccion(),
              compradorActual.getCuit(),
              new Date()
      );

      PedidoCompra pedido = director.construirPedido(
              3001,
              new Date(),
              25000.0,
              clienteParaPedido,
              vehiculoElegido,
              formaPago,
              new Ventas(),
              new EstadoPedido(1, new Ventas()),
              new ArrayList<HistorialPedidoCompra>(),
              publicadorPedidoCompra
      );

      // Mostrar detalles del pedido y vehículo
      System.out.println("==== Detalles del Pedido de Compra ====");
      System.out.println("Pedido creado con nro: " + pedido.getNroPedido());
      System.out.println("Costo total: $" + pedido.getCostoTotal());
      System.out.println("Cliente: " + pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellido());
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
      formaPago = pedido.getFormaPago();
      System.out.println("Forma de Pago: " + formaPago.getClass().getSimpleName());

      Area area = pedido.getAreaResponsableActual();
      System.out.println("Area Responsable Actual: " + (area != null ? area.getClass().getSimpleName() : "No asignada"));
      System.out.println("Estado pedido: " + pedido.getEstadoPedido().getNumeroPedido());

      System.out.println("COMPRA EXITOSA!");
      System.out.println("=======================================");

      //IMPRESION DE OBSERVADORES REGISTRADOS Y NOTIFICACION
      System.out.println("=== Áreas registradas como observadoras ===");
      for (Area areaObs : List.of(entrega, logistica, embarque, cobranzas, ventas)) {
        System.out.println("- " + areaObs.getNombreArea());
      }

      System.out.println("\n=== Notificando áreas involucradas en el pedido ===");
      publicadorPedidoCompra.notificarObservadores();
    }
  }
}