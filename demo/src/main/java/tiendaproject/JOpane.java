
package tiendaproject;
import javax.swing.JOptionPane;

/**
 * Métodos para leer diferentes tipos de datos usando JOptionPane.
 * 
 * @author saori
 */
public class JOpane {
    
    public static byte leerByte(String mensaje){
        return Byte.parseByte(JOptionPane.showInputDialog(null, mensaje, 
                "Byte " + Byte.MIN_VALUE + " - " + Byte.MAX_VALUE, JOptionPane.INFORMATION_MESSAGE));
    }
    
    public static short leerShort(String mensaje){
        return Short.parseShort(JOptionPane.showInputDialog(null, mensaje, 
                "Short " + Short.MIN_VALUE + " - " + Short.MAX_VALUE, JOptionPane.INFORMATION_MESSAGE));
    }
        public static String leerString(String mensaje){
        return JOptionPane.showInputDialog(null, mensaje, 
                "String " + Short.MIN_VALUE + " - " + Short.MAX_VALUE, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean leerBolean(String mensaje){
        return Boolean.parseBoolean(JOptionPane.showInputDialog(null, mensaje, 
                "Boolean true/false", JOptionPane.INFORMATION_MESSAGE));
    }
    
    public static int leerInt(String mensaje){
        return Integer.parseInt(JOptionPane.showInputDialog(null, mensaje, 
                "Int " + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE, JOptionPane.INFORMATION_MESSAGE));
    }
    
    public static long leerLong(String mensaje){
        return Long.parseLong(JOptionPane.showInputDialog(null, mensaje, 
                "Long " + Long.MIN_VALUE + " - " + Long.MAX_VALUE, JOptionPane.INFORMATION_MESSAGE));
    }
    
    public static float leerFloat(String mensaje){
        return Float.parseFloat(JOptionPane.showInputDialog(null, mensaje, 
                "Float " + Float.MIN_VALUE + " - " + Float.MAX_VALUE, JOptionPane.INFORMATION_MESSAGE));
    }
    
    public static double leerDouble(String mensaje){
        return Double.parseDouble(JOptionPane.showInputDialog(null, mensaje, 
                "Double " + Double.MIN_VALUE + " - " + Double.MAX_VALUE, JOptionPane.INFORMATION_MESSAGE));
    }
    
    public static void imprimeSalida(String mensaje, String mensaje1){
     JOptionPane.showMessageDialog(null, mensaje, mensaje1,JOptionPane.QUESTION_MESSAGE);
    }
    
    public static void salidaError(String mensaje, String mensaje1){
         
        JOptionPane.showMessageDialog(null, mensaje, "error !", JOptionPane.ERROR_MESSAGE);
     }
    
    public static double verDouble (String mensaje){
       return Double.parseDouble(JOptionPane.showInputDialog(null, mensaje," Double" + Double.MIN_VALUE+ "...."+ Double.MAX_VALUE, JOptionPane.INFORMATION_MESSAGE));
    }

    
   
    public static String opcionesListaDesplegable(String menu) {
        String valores[] = menu.split(",");
        String res = (String) JOptionPane.showInputDialog(
                null,
                "Opciones del Menú",
                "Selecciona una opción",
                JOptionPane.QUESTION_MESSAGE,
                null,
                valores,
                valores[0]
        );
        return res;
    }

    public static String botonOpciones(String menu) {
        String valores[] = menu.split(",");
        int n;

        n = JOptionPane.showOptionDialog(null, "SELECCIONA" + "DANDO CLICK", "M E N U", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);

        return (valores[n]);
    }
   
}