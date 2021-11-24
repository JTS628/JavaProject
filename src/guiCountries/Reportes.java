
package guiCountries;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import javax.swing.JOptionPane; 

public class Reportes {
    
    String nombreArchivo;
    String fecha;
    String rutaImagen;
    String rutaImagen2;
    ArrayList<Usuarios> personas;
    
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;
    
    public Reportes(String nombreArchivo, String fecha, String rutaImagen, String rutaImagen2, ArrayList<Usuarios> personas) {
        this.nombreArchivo = nombreArchivo;
        this.fecha = fecha;
        this.rutaImagen = rutaImagen;
        this.rutaImagen2 = rutaImagen2;
        this.personas = personas;
        
        documento = new Document();
        titulo = new Paragraph("Reporte de usuarios registrados");
     
    }  

    public void CrearReporte(){
        
        try {
        archivo = new FileOutputStream(nombreArchivo + ".pdf");
        
        PdfWriter.getInstance(documento, archivo);
        
        documento.open();
        
        titulo.setAlignment(1);
        documento.add(titulo);
        
        Image imagen = null;
        Image imagen2 = null;
            try {
                imagen = Image.getInstance(rutaImagen);
                imagen.scaleAbsolute(100, 100);
                imagen.setAbsolutePosition(450, 750);
                
                imagen2 = Image.getInstance(rutaImagen2);
                imagen2.scaleAbsolute(200, 200);
                imagen2.setAbsolutePosition(250,200);
            } catch (Exception e) {
            }

        documento.add(imagen);
        documento.add(imagen2);
        
        documento.add(Chunk.NEWLINE);
        documento.add(new Paragraph("Esto es un reporte de confirmación para nuevos usuarios"));
        documento.add(Chunk.NEWLINE);
        Paragraph textolargo = new Paragraph("Este reporte genera todos los datos del usuario que recientemete se registre en la plataforma, generará una tabla donde se podrá observar todos los datos sin su contraseña.");
        documento.add(Chunk.NEWLINE);
        textolargo.setAlignment(Element.ALIGN_JUSTIFIED);
        documento.add(textolargo);
        
        PdfPTable tabla = new PdfPTable(5);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
        
        tabla.setWidthPercentage(100);
            PdfPCell nombre = new PdfPCell(new Phrase("Nombre"));
            nombre.setBackgroundColor(BaseColor.LIGHT_GRAY);

            PdfPCell apellido = new PdfPCell(new Phrase("Apellido"));
            apellido.setBackgroundColor(BaseColor.LIGHT_GRAY);

            PdfPCell correo = new PdfPCell(new Phrase("Correo"));
            correo.setBackgroundColor(BaseColor.LIGHT_GRAY);

            PdfPCell usuario = new PdfPCell(new Phrase("Usuario"));
            usuario.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            PdfPCell rol = new PdfPCell(new Phrase("Roll"));
            rol.setBackgroundColor(BaseColor.LIGHT_GRAY);
        
        tabla.addCell(nombre);
        tabla.addCell(apellido);
        tabla.addCell(correo);
        tabla.addCell(usuario);
        tabla.addCell(rol);
        
            for (Usuarios p : Registro.listaUsuarios) {
                tabla.addCell(p.getNombre());
                tabla.addCell(p.getApellido());
                tabla.addCell(p.getCorreo()+"");
                tabla.addCell(p.getUsuario());
                tabla.addCell(p.getRol());
            }
        
        documento.add(tabla);
        
        documento.add(Chunk.NEWLINE);
//        BarcodeQRCode codigoqr = new BarcodeQRCode("Prueba de codigo QR", 1, 1, null);
//        Image qrimagen = codigoqr.getImage();
//        qrimagen.scalePercent(300);
//        documento.add(qrimagen);
        
        documento.add(Chunk.NEWLINE);
        documento.add( new Paragraph("Fecha: " + fecha));
        
        documento.close();
        
        JOptionPane.showMessageDialog(null, "El Reporte se ha creado correctamente"); 

        } catch (Exception e) {
        }

    }
        
}

