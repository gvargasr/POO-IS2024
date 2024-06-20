package crearTrivia;
  
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Write a description of class CuentaCorreo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CuentaCorreo {
  private String usuario;
  private String clave = "";    //Se quito la clave por seguridad
  private String servidor = "smtp.gmail.com";
  private String puerto = "587";
  private Properties propiedades;
  
  public CuentaCorreo(String pCorreo) {
    propiedades = new Properties();
    propiedades.put("mail.smtp.host", servidor);
    propiedades.put("mail.smtp.port", puerto);
    propiedades.put("mail.smtp.auth", "true");
    propiedades.put("mail.smtp.starttls.enable", "true");
    usuario = pCorreo;
  }
  
  private Session abrirSesion() {
    Session sesion = Session.getInstance(propiedades, 
      new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(usuario, clave);  
        }   
      });
    return sesion;
  }
  
  public void enviarCorreo(String destinatario, String tituloCorreo, String cuerpo) {
    
    Session sesion = abrirSesion();
     
    try {
      Message message = new MimeMessage(sesion);
      message.setFrom(new InternetAddress(usuario));
      message.setRecipients(
          Message.RecipientType.TO,
          InternetAddress.parse(destinatario)
      );
      message.setSubject(tituloCorreo);
      message.setText(cuerpo);

      Transport.send(message);
    } catch (MessagingException e) {
      e.printStackTrace();  
    }
  }
  
  public void enviarCorreo(String destinatario, String tituloCorreo, 
      String cuerpo, String archivosAdjuntos) {
    
    Session sesion = abrirSesion();
     
    try {
      Message message = new MimeMessage(sesion);
      message.setFrom(new InternetAddress(usuario));
      message.setRecipients(
          Message.RecipientType.TO,
          InternetAddress.parse(destinatario)
      );
      message.setSubject(tituloCorreo);
      message.setText(cuerpo);
      
      
      
      MimeBodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setText(cuerpo);
      
      MimeMultipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);


        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        FileDataSource source = new FileDataSource(archivosAdjuntos);  
        messageBodyPart2.setDataHandler(new DataHandler(source));  
        messageBodyPart2.setFileName(archivosAdjuntos);  
        multipart.addBodyPart(messageBodyPart2);
   
      
      message.setContent(multipart);

      Transport.send(message);
    } catch (MessagingException e) {
      e.printStackTrace();  
    }  
  }
}
