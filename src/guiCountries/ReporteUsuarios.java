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
import static guiCountries.Paises.reptranf;

public class ReporteUsuarios {

    String NombreArchivo;
    String Fecha;
    String RutaImagen;
    ArrayList<Usuarios> listaUsuarios;
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;

    public ReporteUsuarios(String NombreArchivo, String Fecha, String RutaImagen, ArrayList<Usuarios> listaUsuarios) {
        this.NombreArchivo = NombreArchivo;
        this.Fecha = Fecha;
        this.RutaImagen = RutaImagen;
        this.listaUsuarios = listaUsuarios;
        documento = new Document();

        titulo = new Paragraph("Reporte de Usuarios");
    }

    @SuppressWarnings("empty-statement")
    public void CrearReporte() {

        try {
            archivo = new FileOutputStream(NombreArchivo + ".pdf");

            PdfWriter.getInstance(documento, archivo);

            documento.open();
            titulo.setAlignment(1);
            documento.add(titulo);

            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph(""));
            documento.add(Chunk.NEWLINE);
            Paragraph Texto = new Paragraph("El documento es confidencial y puede ser utilizado por personal autorizado. Si recibio este documento por error, por favor informelo a las autoridades pertinentes");
            Texto.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
            documento.add(Texto);

            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);

            PdfPTable Tabla = new PdfPTable(7);

            Tabla.setWidthPercentage(100);
            PdfPCell nombre = new PdfPCell(new Phrase("Nombre"));
            nombre.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell apellido = new PdfPCell(new Phrase("Apellido"));
            apellido.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell correo = new PdfPCell(new Phrase("Correo"));
            correo.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell usuario = new PdfPCell(new Phrase("Usuario"));
            usuario.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell contra = new PdfPCell(new Phrase("Contraseña"));
            contra.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell rol = new PdfPCell(new Phrase("Rol"));
            rol.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell fecha = new PdfPCell(new Phrase("Fecha"));
            fecha.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.addCell(nombre);
            Tabla.addCell(apellido);
            Tabla.addCell(correo);
            Tabla.addCell(usuario);
            Tabla.addCell(contra);
            Tabla.addCell(rol);
            Tabla.addCell(fecha);

            for (Usuarios p : listaUsuarios) {
                Tabla.addCell(p.getNombre());
                Tabla.addCell(p.getApellido());
                Tabla.addCell(p.getCorreo());
                Tabla.addCell(p.getUsuario());
                Tabla.addCell(p.getContrasena());
                Tabla.addCell(p.getRol());
                Tabla.addCell(p.getFecha());

            }
            documento.add(Tabla);

            BarcodeQRCode codigoqr = new BarcodeQRCode("Texto Barcode de Prueba", 1, 1, null);
            Image imagenQR = codigoqr.getImage();
            imagenQR.scaleAbsolute(100, 100);
            documento.add(imagenQR);

            documento.add(Chunk.NEWLINE);

            documento.add(new Paragraph(Fecha));

            documento.add(Chunk.NEWLINE);

            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (Exception e) {
        }
    }

    public void ReporteTrasferencia() {

        try {
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
            documento.add(new Paragraph(""));
            documento.add(Chunk.NEWLINE);
            Paragraph Texto = new Paragraph("El documento es confidencial y solo debe ser utilizado por personal autorizado. Si recibio este documento por error, por favor informelo a las autoridades pertinentes");
            Texto.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
            documento.add(Texto);

            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);

            PdfPTable Tabla = new PdfPTable(8);

            Tabla.setWidthPercentage(100);
            PdfPCell usuario = new PdfPCell(new Phrase("Usuario"));
            usuario.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell paisdestino = new PdfPCell(new Phrase("Pais Destino"));
            paisdestino.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell tipoenvio = new PdfPCell(new Phrase("Tipo de envio"));
            tipoenvio.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell monto = new PdfPCell(new Phrase("Monto"));
            monto.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell tarifadest = new PdfPCell(new Phrase("Tarifa Destino"));
            tarifadest.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell tarifaserv = new PdfPCell(new Phrase("Tarifa servicio"));
            tarifaserv.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell totalenv = new PdfPCell(new Phrase("Total Envio"));
            totalenv.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell fecha = new PdfPCell(new Phrase("Fecha"));
            fecha.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.addCell(usuario);
            Tabla.addCell(paisdestino);
            Tabla.addCell(tipoenvio);
            Tabla.addCell(monto);
            Tabla.addCell(tarifadest);
            Tabla.addCell(tarifaserv);
            Tabla.addCell(totalenv);
            Tabla.addCell(fecha);

            for (variableReporteTransf f : reptranf) {
                Tabla.addCell(f.getUsuario());
                Tabla.addCell(f.getPaisdestino());
                Tabla.addCell(f.getTipoenvio());
                Tabla.addCell(f.getMontoenv() + "");
                Tabla.addCell(f.getTarifdest() + "");
                Tabla.addCell(f.getTarifserv() + "");
                Tabla.addCell(f.getTottransf() + "");
                Tabla.addCell(f.getFecha());

            }
            documento.add(Tabla);

            BarcodeQRCode codigoqr = new BarcodeQRCode("Texto Barcode de Prueba", 1, 1, null);
            Image imagenQR = codigoqr.getImage();
            imagenQR.scaleAbsolute(100, 100);
            documento.add(imagenQR);

            documento.add(Chunk.NEWLINE);

            documento.add(new Paragraph(Fecha));

            documento.add(Chunk.NEWLINE);

            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte de transferencias generado");

        } catch (Exception e) {
        }
    }

    public void ReporteP() {

        try {
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
            documento.add(new Paragraph(""));
            documento.add(Chunk.NEWLINE);
            Paragraph Texto = new Paragraph("El documento es confidencial y solo debe ser utilizado por personal autorizado. Si recibio este documento por error, por favor informelo a las autoridades pertinentes");
            Texto.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
            documento.add(Texto);

            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);

            PdfPTable Tabla = new PdfPTable(7);

            Tabla.setWidthPercentage(100);
            PdfPCell paisdestino = new PdfPCell(new Phrase("Pais Destino"));
            paisdestino.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell tipoenvio = new PdfPCell(new Phrase("Tipo de envio"));
            tipoenvio.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell monto = new PdfPCell(new Phrase("Monto"));
            monto.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell tarifadest = new PdfPCell(new Phrase("Tarifa Destino"));
            tarifadest.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell tarifaserv = new PdfPCell(new Phrase("Tarifa servicio"));
            tarifaserv.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell totalenv = new PdfPCell(new Phrase("Total Envio"));
            totalenv.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.setWidthPercentage(100);
            PdfPCell fecha = new PdfPCell(new Phrase("Fecha"));
            fecha.setBackgroundColor(BaseColor.LIGHT_GRAY);

            Tabla.addCell(paisdestino);
            Tabla.addCell(tipoenvio);
            Tabla.addCell(monto);
            Tabla.addCell(tarifadest);
            Tabla.addCell(tarifaserv);
            Tabla.addCell(totalenv);
            Tabla.addCell(fecha);

            for (variableReporteTransf f : reptranf) {
                for (int i = 0; i < reptranf.size(); i++) {
                    if (reptranf.get(i).getUsuario().equalsIgnoreCase(Login.usuario)) {
                        Tabla.addCell(f.getPaisdestino());
                        Tabla.addCell(f.getTipoenvio());
                        Tabla.addCell(f.getMontoenv() + "");
                        Tabla.addCell(f.getTarifdest() + "");
                        Tabla.addCell(f.getTarifserv() + "");
                        Tabla.addCell(f.getTottransf() + "");
                        Tabla.addCell(f.getFecha());
                    }
                }
            }    
                documento.add(Tabla);

                BarcodeQRCode codigoqr = new BarcodeQRCode("Texto Barcode de Prueba", 1, 1, null);
                Image imagenQR = codigoqr.getImage();
                imagenQR.scaleAbsolute(100, 100);
                documento.add(imagenQR);

                documento.add(Chunk.NEWLINE);

                documento.add(new Paragraph(Fecha));

                documento.add(Chunk.NEWLINE);

                documento.close();

                JOptionPane.showMessageDialog(null, "Reporte de transferencias generado");

            }catch(Exception e){}
        }
    }
