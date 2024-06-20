package aplicacion;

import java.util.ArrayList;
import java.util.Date;
import logicadenegocios.Cajero;
import logicadenegocios.Cliente;
import logicadenegocios.ClienteFisico;
import logicadenegocios.ClienteJuridico;
import logicadenegocios.DetalleFactura;
import logicadenegocios.Empresa;
import logicadenegocios.Empleado;
import logicadenegocios.Factura;
import logicadenegocios.FacturaContado;
import logicadenegocios.FacturaCredito;
import logicadenegocios.Item;
import logicadenegocios.Producto;
import logicadenegocios.Servicio;
import logicadenegocios.Tecnico;
import logicadenegocios.Vendedor;

/**
 * Clase principal de la aplicación que simula el entorno de gestión de una empresa. Esta clase crea
 * y maneja entidades como empresas, clientes, empleados y facturas, además de realizar
 * transacciones y reportes básicos.
 */
public class AppEmpresa {

  /**
   * Punto de entrada principal del programa. Este método simula la creación y gestión de una
   * empresa con sus clientes, empleados y transacciones comerciales como ventas y servicios.
   * 
   * @param args Argumentos pasados al programa, no utilizados en este contexto.
   */
  public static void main(String[] args) {

    // Crear empresa
    Empresa empresa = new Empresa("Empresa XYZ", "12345678-9", "Calle Falsa 123", "800-123456");

    Cliente cliente1 = new ClienteFisico("Gustavo Vargas", "Calle Cuatro 400", "555-4000",
        "cliente@correo.com", "123456789", "Ingeniero");

    Cliente cliente2 = new ClienteJuridico("Arcos Dorados S.A" + "", "Avenida Central",
        "506-8888-8888", "juridico@prueba.com", "3-101-265869", "Nombre Contacto Compras",
        "Nombre Contacto Pagos");

    Empleado vendedor1 =
        new Vendedor("Vendedor Dos", "Av Secundaria 200", "555-2000", "0002", 350000, 15);

    Empleado cajero1 =
        new Cajero("Cajero Uno", "Av Principal 100", "555-1000", "0001", 500000, 3, 25000);

    Empleado tecnico1 =
        new Tecnico("Tecnico Tres", "Av Tercera 300", "555-3000", "0003", 650000, 5625);

    Factura factura1 =
        new FacturaCredito(empresa, "Promoción especial del mes Credito", new Date(), 12, 18);

    Factura factura2 =
        new FacturaContado(empresa, "Promoción especial del mes Contado", new Date());

    factura1.asignarVendedor(vendedor1);
    factura1.asignarCajero(cajero1);
    factura2.asignarVendedor(vendedor1);
    factura2.asignarCajero(cajero1);

    factura1.asignarCliente(cliente1);
    factura2.asignarCliente(cliente2);

    Item producto1 = new Producto("TELEVISOR", 499999.0, "AEX-SEC558", "SONY", 12);
    Item producto2 = new Producto("PLAYSTATION 5", 275000.0, "PS5-SRFC23", "SONY", 24);
    Item producto3 = new Producto("MacBook Pro 14 inches ", 890000.0, "MAC-22222", "APPLE", 18);

    Item producto4 = new Servicio("Servicio de reparacion", 20000.0, 3, 5000.0);
    Item producto5 = new Servicio("Limpieza de Lector PS5", 10000.0, 1, 2500.0);

    ((Servicio) producto4).asignarTecnico(tecnico1);
    ((Servicio) producto5).asignarTecnico(tecnico1);

    DetalleFactura detalleProducto1 = new DetalleFactura(producto1, 3);
    DetalleFactura detalleProducto2 = new DetalleFactura(producto2, 2);
    DetalleFactura detalleProducto3 = new DetalleFactura(producto3, 7);
    DetalleFactura detalleServicio1 = new DetalleFactura(producto4, 1);
    DetalleFactura detalleServicio2 = new DetalleFactura(producto5, 1);

    factura1.incluirLineaDetalle(detalleProducto1);
    factura1.incluirLineaDetalle(detalleProducto2);

    factura2.incluirLineaDetalle(detalleProducto3);

    factura2.incluirLineaDetalle(detalleServicio1);
    factura2.incluirLineaDetalle(detalleServicio2);

    ArrayList<Factura> facturas = new ArrayList<>();
    facturas.add(factura1);
    facturas.add(factura2);

    for (Factura factura : facturas) {
      System.out.println(factura.toString());
    }

    double totalVendido = 0;
    for (Factura factura : facturas) {
      totalVendido += factura.calcularTotal();
    }

    System.out.println("Total vendido de todas las facturas: " + totalVendido);

  }

}
