package modelo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Clase PDF, es la que se encarga de crear el archivo PDF y darle formato a
 * la informacion que se guarda en el archivo.
 * @author Gustavo Vargas
 * 
 */

public class PDF {
  private String pNombreEscuela;
  private String pPlan;
  private String pContenido;

  public PDF(String pNombreEscuela, String pPlan, String pContenido) {
    this.pNombreEscuela = pNombreEscuela;
    this.pPlan = pPlan;
    this.pContenido = pContenido;
  }

  public void crearPDF() {
    FileOutputStream archivo = null;
    try {
      archivo = new FileOutputStream("Plan de estudio " + pPlan + ".pdf");
    } catch (FileNotFoundException ex) {
      Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
    }

    Document documento = new Document();
    try {
      PdfWriter.getInstance(documento, archivo);
    } catch (DocumentException ex) {
      Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
    }

    documento.open();
    try {
      documento.add(new Paragraph(pNombreEscuela + "\n" + pContenido));
    } catch (DocumentException ex) {
      Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
    }
    documento.close();
  }
}
