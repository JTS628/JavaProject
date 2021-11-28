
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
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;



public class ReporteUsuarios {
    
    String NombreArchivo;
    String Fecha;
    String RutaImagen;
    ArrayList <Usuarios> listaUsuarios;
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;

    public ReporteUsuarios(String NombreArchivo, String Fecha, String RutaImagen , ArrayList<Usuarios> listaUsuarios) {
        this.NombreArchivo = NombreArchivo;
        this.Fecha = Fecha;
        this.RutaImagen = RutaImagen;
        this.listaUsuarios = listaUsuarios;
        documento = new Document();
        
        titulo = new Paragraph ("Reporte de Usuarios");
    }
    
    @SuppressWarnings("empty-statement")
    public void CrearReporte(){
    
          try{
              archivo = new FileOutputStream(NombreArchivo + ".pdf");
          
              PdfWriter.getInstance(documento, archivo);
          
              documento.open();
              titulo.setAlignment(1);
              documento.add(titulo);
              
              /*Image imagen1 = null;
              imagen1 = Image.getInstance(RutaImagen);
              imagen1.setAbsolutePosition(430, 760);
              imagen1.scaleAbsolute(100, 100);
              documento.add(imagen1);*/
              
              documento.add(Chunk.NEWLINE);
              documento.add(new Paragraph(" Texto de prueba, para ser modificado posteriormente"));
              documento.add(Chunk.NEWLINE);
              Paragraph Texto = new Paragraph( "Texto 2");
                            Texto.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
              documento.add(Texto);
              
              documento.add(Chunk.NEWLINE);
              documento.add(Chunk.NEWLINE);
              
              PdfPTable Tabla = new PdfPTable(6);
              
              Tabla.setWidthPercentage(100);
              PdfPCell nombre = new PdfPCell (new Phrase("Nombre"));
              nombre.setBackgroundColor(BaseColor.LIGHT_GRAY);
              
              Tabla.setWidthPercentage(100);
              PdfPCell apellido = new PdfPCell (new Phrase("Apellido"));
              nombre.setBackgroundColor(BaseColor.LIGHT_GRAY);
              
              Tabla.setWidthPercentage(100);
              PdfPCell correo = new PdfPCell (new Phrase("Correo"));
              nombre.setBackgroundColor(BaseColor.LIGHT_GRAY);
              
              Tabla.setWidthPercentage(100);
              PdfPCell usuario = new PdfPCell (new Phrase("Usuario"));
              nombre.setBackgroundColor(BaseColor.LIGHT_GRAY);
              
              Tabla.setWidthPercentage(100);
              PdfPCell contra = new PdfPCell (new Phrase("Contraseña"));
              nombre.setBackgroundColor(BaseColor.LIGHT_GRAY);
              
              Tabla.setWidthPercentage(100);
              PdfPCell rol = new PdfPCell (new Phrase("Rol"));
              nombre.setBackgroundColor(BaseColor.LIGHT_GRAY);
              
              Tabla.addCell(nombre);
              Tabla.addCell(apellido);
              Tabla.addCell(correo);
              Tabla.addCell(usuario);
              Tabla.addCell(contra);
              Tabla.addCell(rol);
              
              for (Usuarios p : listaUsuarios){
                   Tabla.addCell(p.getNombre());
                   Tabla.addCell(p.getApellido());
                   Tabla.addCell(p.getCorreo());
                   Tabla.addCell(p.getUsuario());
                   Tabla.addCell(p.getContrasena());
                   Tabla.addCell(p.getRol());
              }  
              documento.add(Tabla);
              
              
              
              BarcodeQRCode codigoqr = new BarcodeQRCode("Texto Barcode de Prueba",1,1,null);
              Image imagenQR = codigoqr.getImage();
              imagenQR.scaleAbsolute(100, 100);
              documento.add(imagenQR);
              
              documento.add(Chunk.NEWLINE);
              
              documento.add(new Paragraph(Fecha));
               
              documento.add(Chunk.NEWLINE);

             documento.close();


            JOptionPane.showMessageDialog(null, "Reporte creado");
          
          }catch(Exception e){}
              
    
    }
    
    
    
       
    
    
 
    
}
