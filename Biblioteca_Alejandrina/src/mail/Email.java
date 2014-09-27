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
import javax.swing.JOptionPane;



// TODO: Auto-generated Javadoc
/**
 * The Class Email.
 */
public class Email {
	private final String clave = "TEC12345";
	private final String correo = "biblioalejandrinatec@gmail.com";
	private final String encabezado = "Notificación del sistema de control de préstamos";
	private final String mensajeAntes = "El sistema de control de préstamos le recuerda que se aproxima "
									   +"la fecha de entrega del préstamo que usted solicitó.\n"
									   +"Por favor revise la fecha de devolución que se le indicó";
	private final String mensajeDia =   "El sistema de control de préstamos le recuerda que hoy es "
			   						   +"el día de entrega del préstamo que usted solicitó.\n"
			   						   +"Por favor devuelva el artículo lo más pronto posible.";
	private final String mensajeDespues ="El sistema de control de préstamos le recuerda que exedió el "
			   						   +"plazo de entrega del préstamo que usted solicitó.\n"
			   						   +"Por favor devuelva el artículo lo más pronto posible "
			   						   +"y evite una multa por retrasos";
		
    
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
    
//Ejemplo de como implementar la clase
      /*public static void main(String[] args){ 
        Email e = new Email("","","","","");
        	e.enviarAntes("jm95aguilar@hotmail.com"); //el parametro que requiere es el destinatario
        	e.enviarDia("jm95aguilar@hotmail.com");
        	e.enviarDespues("jm95aguilar@hotmail.com");
        }*/
    
    
    
    // Envía un correo alertando que está proxima la fecha de entrega
    //Los métodos únicamente reciben el correo del destinatario ya que el de la aplicacion es fijo
    public void enviarAntes(String destinatario){
    	Email e = new Email(correo,clave,destinatario,encabezado,mensajeAntes);
    	if (e.sendMail()){
    		JOptionPane.showMessageDialog(null,"El correo se envió satisfactoriamente", "Ïnforme",0);
    	}
    	else{JOptionPane.showMessageDialog(null,"No fue posible enviar el correo", "Ïnforme",0);}
    }
    //Envía un correo  alertando que es el día de devolución del artículo
    public void enviarDia(String destinatario){
    	Email e = new Email(correo,clave,destinatario,encabezado,mensajeDia);
    	if (e.sendMail()){
    		JOptionPane.showMessageDialog(null,"El correo se envió satisfactoriamente", "Ïnforme",0);
    	}
    	else{JOptionPane.showMessageDialog(null,"No fue posible enviar el correo", "Ïnforme",0);}
    }
  //Envía un correo  alertando que se pasó el día de devolución del artículo
    public void enviarDespues(String destinatario){
    	Email e = new Email(correo,clave,destinatario,encabezado,mensajeDespues);
    	if (e.sendMail()){
    		JOptionPane.showMessageDialog(null,"El correo se envió satisfactoriamente", "Ïnforme",0);
    	}
    	else{JOptionPane.showMessageDialog(null,"No fue posible enviar el correo", "Ïnforme",0);}
    }
  }


