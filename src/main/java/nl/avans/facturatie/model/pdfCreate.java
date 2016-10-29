package nl.avans.facturatie.model;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;



/**
 * Simple pdf example.
 */
public class pdfCreate {
 
	// Generating random String to save pdf	
	/**private static String FILE = "results/Factuur.pdf";
	DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss"); 
	String filename = FILE.split(".")[0] + df.format(new Date()) + FILE.split(".")[1];
	*/
    public static final String DEST = "results/Factuur.pdf";
 
    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new pdfCreate().createPdf(DEST);
    }
 
    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);
 
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
 
        // Initialize document
        Document document = new Document(pdf);
        
        //Add paragraph to the document
        document.add(new Paragraph("Factuur"));
        document.add(new Paragraph("---------------------------------------------------"));
        
        //Add Date to document
        document.add(new Paragraph(new Date().toString()));
        document.add(new Paragraph("---------------------------------------------------"));
        
        // Customer section
        // Add new list of Customer details
        document.add(new Paragraph("Klantgegevens"));
        List list = new List();
        list.setListSymbol("");
        list.add(new ListItem("Naam: "));
        list.add(new ListItem("Adres: "));
        list.add(new ListItem("Woonplaats: "));
        list.add(new ListItem("Tel: "));
        list.add(new ListItem("-------------------------"));
        
        document.add(list);
        
        //Add new list of Invoice details
        document.add(new Paragraph("Factuurgegevens"));
        List list2 = new List();
        list2.setListSymbol("");
        list2.add(new ListItem("Factuurnummer: "));
        list2.add(new ListItem("Klantnummer: "));
        list2.add(new ListItem("Factuurdatum: "));
        list2.add(new ListItem("Verloopdatum: "));
        list2.add(new ListItem("-------------------------"));
        
        document.add(list2);
 
        //Close document
        document.close();
    }
}