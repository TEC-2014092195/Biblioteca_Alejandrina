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
 * The Class Email. Maneja los eventos que suceden con enviar Email
 */
public class Email {
	
	//Strings para los mensajes que se dan al cliente
	private final String clave = "TEC12345";
	private final String correo = "biblioalejandrinatec@gmail.com";
	private final String encabezado = "Notificaci�n del sistema de control de pr�stamos";
	private final String mensajeAntes = "El sistema de control de pr�stamos le recuerda que se aproxima "
									   +"la fecha de entrega del pr�stamo que usted solicit�.\n"
									   +"Por favor revise la fecha de devoluci�n que se le indic�";
	private final String mensajeDia =   "El sistema de control de pr�stamos le recuerda que hoy es "
			   						   +"el d�a de entrega del pr�stamo que usted solicit�.\n"
			   						   +"Por favor devuelva el art�culo lo m�s pronto posible.";
	private final String mensajeDespues ="El sistema de control de pr�stamos le recuerda que exedi� el "
			   						   +"plazo de entrega del pr�stamo que usted solicit�.\n"
			   						   +"Por favor devuelva el art�culo lo m�s pronto posible "
			   						   +"y evite una multa por retrasos";
		
    
    //El correo del usuario
    String usuarioCorreo;
    
    //La clave del usuario
    String password;
    
    //La ruta del archivo
    String rutaArchivo;
    
    //El nombre del archivo
    String nombreArchivo;
    
    //El correo del destinatario
    String destinatario;
    
    //El String de asunto
    String asunto;
    
    ///String para el mensaje
    String mensaje;
    
    /**
    *Crea el objeto Email, recibe el correo remitente y la clave, el correo destino, asunto, mensaje
    *y como opcional se crea un constructor para enviar archivos adjuntos
    */
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
     * Clase Email para crear un email
     */
    public Email(String usuarioCorre,String password,String destinatario,String mensaje){
        this(usuarioCorre,password,"","",destinatario,"",mensaje);
    }
    
    /**
     * Sobreescritura del m�todo Email. Incluye asunto extra
     */
    public Email(String usuarioCorre,String password,String destinatario,String asunto,String mensaje){
        this(usuarioCorre,password,"","",destinatario,asunto,mensaje);
    }    

    /**
     * Env�a un Email
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
    
    /**
    *Env�a un correo alertando que est� proxima la fecha de entrega
    *Los m�todos �nicamente reciben el correo del destinatario ya que el de la aplicacion es fijo
    */
    public void enviarAntes(String destinatario){
    	//Se instancia un nuevo Email
    	Email e = new Email(correo,clave,destinatario,encabezado,mensajeAntes);
    	if (e.sendMail()){
    		JOptionPane.showMessageDialog(null,"El correo se envi� satisfactoriamente", "�nforme",0);
    	}
    	else{JOptionPane.showMessageDialog(null,"No fue posible enviar el correo", "�nforme",0);}
    }
    
    /**
    *Env�a un correo  alertando que es el d�a de devoluci�n del art�culo
    */
    public void enviarDia(String destinatario){
    	//Se instancia un nuevo Email
    	Email e = new Email(correo,clave,destinatario,encabezado,mensajeDia);
    	if (e.sendMail()){
    		JOptionPane.showMessageDialog(null,"El correo se envi� satisfactoriamente", "�nforme",0);
    	}
    	else{JOptionPane.showMessageDialog(null,"No fue posible enviar el correo", "�nforme",0);}
    }
    /**
    *Env�a un correo  alertando que se pas� el d�a de devoluci�n del art�culo
    */
    public void enviarDespues(String destinatario){
    	//Se instancia un nuevo Email
    	Email e = new Email(correo,clave,destinatario,encabezado,mensajeDespues);
    	if (e.sendMail()){
    		JOptionPane.showMessageDialog(null,"El correo se envi� satisfactoriamente", "�nforme",0);
    	}
    	else{JOptionPane.showMessageDialog(null,"No fue posible enviar el correo", "�nforme",0);}
    }
  }


