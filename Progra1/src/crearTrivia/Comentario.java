
package crearTrivia;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Comentario extends JFrame {

  private static final long serialVersionUID = 1L;
  private final List<String> comentarios;
  private final List<String> sentimientos;
  private int contadorPositivo;
  private int contadorNegativo;
  private int contadorNeutro;

  public Comentario() {
    this.comentarios = new ArrayList<>();
    this.sentimientos = new ArrayList<>();
    this.contadorPositivo = 0;
    this.contadorNegativo = 0;
    this.contadorNeutro = 0;
    setTitle("Análisis de Sentimientos");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 300);
    setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    Comentario comentario = new Comentario();
    comentario.cargarComentariosGuardados();
    comentario.ejecutarAnalisis();
  }

  public void ejecutarAnalisis() {
    ingresarComentarios();
    analizarSentimientos();
    mostrarGraficoPastel();
    guardarComentarios();
  }

  private void ingresarComentarios() {
    JTextArea textArea = new JTextArea();
    JOptionPane.showMessageDialog(null, textArea, "Ingrese los comentarios", JOptionPane.PLAIN_MESSAGE);
    String texto = textArea.getText();
    String[] lineas = texto.split("\\r?\\n");
    for (String linea : lineas) {
      if (!linea.isEmpty()) {
        comentarios.add(linea);
      }
    }
  }

  private void analizarSentimientos() {
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize, parse, sentiment");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

    for (String comentario : comentarios) {
      if (comentario.trim().isEmpty())
        continue; // Salta comentarios vacíos

      Annotation annotation = new Annotation(comentario);
      pipeline.annotate(annotation);

      List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
      for (CoreMap sentence : sentences) {
        String sentimiento = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
        sentimientos.add(sentimiento);

        switch (sentimiento) {
          case "Positive", "Very positive" -> contadorPositivo++;
          case "Negative", "Very negative" -> contadorNegativo++;
          case "Neutral" -> contadorNeutro++;
          default -> {
            System.out.println("Sentimiento desconocido: " + sentimiento);
            contadorNeutro++;
          }
        }
    
      }
    }
  }

     public void mostrarGraficoPastel() {
        PieDataset dataset = createDataset(contadorPositivo, contadorNegativo, contadorNeutro);
        JFreeChart chart = createChart(dataset, "Análisis de Sentimientos");

        // Usar un JFrame en lugar de ApplicationFrame
        JFrame frame = new JFrame("Gráfico de Pastel");
        frame.setContentPane(new ChartPanel(chart));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Esto asegura que solo se cierre esta ventana y no la aplicación
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);
    }
  

  private PieDataset createDataset(int positivos, int negativos, int neutros) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    dataset.setValue("Positivos", positivos);
    dataset.setValue("Negativos", negativos);
    dataset.setValue("Neutros", neutros);
    return dataset;
  }

  private JFreeChart createChart(PieDataset dataset, String title) {
    JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
    PiePlot plot = (PiePlot) chart.getPlot();
    plot.setLabelFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
    plot.setNoDataMessage("No hay datos");
    plot.setCircular(false);
    plot.setLabelGap(0.02);
    return chart;
  }

  public void cargarComentariosGuardados() {
    sentimientos.clear();
    comentarios.clear();
    try {
      File archivo = new File("comentarios.txt");
      if (archivo.exists()) {
        Scanner scanner = new Scanner(archivo);
        while (scanner.hasNextLine()) {
          String linea = scanner.nextLine();
          String[] partes = linea.split(",");
          if (partes.length == 2) {
            comentarios.add(partes[0]);
            sentimientos.add(partes[1]);

          }
        }
        scanner.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

private void guardarComentarios() {
        try {
            File archivo = new File("comentarios.txt");
            Set<String> lineasExistentes = new HashSet<>();
            if (archivo.exists()) {
                Scanner scanner = new Scanner(archivo);
                while (scanner.hasNextLine()) {
                    lineasExistentes.add(scanner.nextLine());
                }
                scanner.close();
            }

            FileWriter writer = new FileWriter("comentarios.txt", true);
            for (int i = 0; i < comentarios.size(); i++) {
                String linea = comentarios.get(i) + "," + sentimientos.get(i);
                if (!lineasExistentes.contains(linea)) {
                    writer.write(linea + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
