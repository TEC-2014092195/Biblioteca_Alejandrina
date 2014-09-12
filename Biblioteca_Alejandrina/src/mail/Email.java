package mail;

/**
 Libreria mail tomada de:
 http://sanlegas-blog.blogspot.com/
 */
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



// TODO: Auto-generated Javadoc
/**
 * The Class Email.
 */
public class Email {
    
    /** The usuario correo. */
    String usuarioCorreo;
    
    /** The password. */
    String password;
    
    /** The ruta archivo. */
    String rutaArchivo;
    
    /** The nombre archivo. */
    String nombreArchivo;
    
    /** The destinatario. */
    String destinatario;
    
    /** The asunto. */
    String asunto;
    
    /** The mensaje. */
    String mensaje;
    
    /**
     * Instantiates a new email.
     *
     * @param usuarioCorreo the usuario correo
     * @param password the password
     * @param rutaArchivo the ruta archivo
     * @param nombreArchivo the nombre archivo
     * @param destinatario the destinatario
     * @param asunto the asunto
     * @param mensaje the mensaje
     */
    // Crea el objeto Email, recibe el correo remitente y la clave, el correo destino, asunto, mensaje
    // y como opcional se crea un constructor para enviar archivos adjuntos
    public Email(String usuarioCorreo, String password, String rutaArchivo, String nombreArchivo, String destinatario, String asunto,String mensaje) {
        this.usuarioCorreo = usuarioCorreo;
        this.password = password;
        this.rutaArchivo = rutaArchivo;
        this.nombreArchivo = nombreArchivo;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }
    
    /**
     * Instantiates a new email.
     *
     * @param usuarioCorre the usuario corre
     * @param password the password
     * @param destinatario the destinatario
     * @param mensaje the mensaje
     */
    public Email(String usuarioCorre,String password,String destinatario,String mensaje){
        this(usuarioCorre,password,"","",destinatario,"",mensaje);
    }
    
    /**
     * Instantiates a new email.
     *
     * @param usuarioCorre the usuario corre
     * @param password the password
     * @param destinatario the destinatario
     * @param asunto the asunto
     * @param mensaje the mensaje
     */
    public Email(String usuarioCorre,String password,String destinatario,String asunto,String mensaje){
        this(usuarioCorre,password,"","",destinatario,asunto,mensaje);
    }    

    /**
     * Send mail.
     *
     * @return true, if successful
     */
    public boolean sendMail(){
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", usuarioCorreo);
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            BodyPart adjunto = new MimeBodyPart();
            if (!rutaArchivo.equals("")){
                 adjunto.setDataHandler(
                    new DataHandler(new FileDataSource(rutaArchivo)));
                adjunto.setFileName(nombreArchivo);                
            }

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            if (!rutaArchivo.equals("")){
                multiParte.addBodyPart(adjunto);
            }

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuarioCorreo));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(destinatario));
                message.setSubject(asunto);
            message.setContent(multiParte);

            Transport t = session.getTransport("smtp");
            t.connect(usuarioCorreo, password);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }        
    }
    
/*//Ejemplo de como implementar la clase
      public static void main(String[] args){
        String clave = "TEC12345"; 
        Email e = new Email("biblioalejandrinatec@gmail.com",clave,"acejas29@gmail.com","Prueba","Biblioteca Alejandrina le está enviando una notificación"); //no cambiar el primer correo 
        if (e.sendMail()){
            System.out.println("El email se mandó correctamente");
        }
        else{
            System.out.println("El email no se mandó correctamente");
        }
    }*/

}
