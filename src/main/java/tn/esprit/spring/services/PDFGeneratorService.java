package tn.esprit.spring.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.lowagie.text.pdf.PdfPage;
//import com.lowagie.text.pdf.PdfWriter;

import tn.esprit.spring.entities.Certificat;
import tn.esprit.spring.repositories.CertificatRepository;

//import com.lowagie.text.Document;
//import com.lowagie.text.PageSize;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class PDFGeneratorService {
	@Autowired
	CertificatRepository cr;

	
	public void export(Long certifId,HttpServletResponse response) throws IOException, URISyntaxException {
		/* Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, response.getOutputStream());
       
        Path imgpath = Paths.get(ClassLoader.getSystemResource("logoOctopuss.png").toURI());
        Document image = new Document();
        image.setMarginMirroring(true);
     
        //Page page.setBackgroundImage("D:\\Desktop\\Image.jpg");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = dateFormatter.format(new Date());
        
        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC);
        fontTitle.setSize(40);
        fontTitle.setColor(198, 29, 32);

        Paragraph paragraph = new Paragraph("Certificat de formation ", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_LEFT);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(18);

        Paragraph paragraph2 = new Paragraph("Foulen a suivi avec succès une formation de programmation web le "+currentDate, fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        
        Path path = Paths.get(ClassLoader.getSystemResource("QRCode.png").toURI());

        Document imageQR = new Document();
        imageQR.setMargins(0, 1,0,100);
        imageQR.open();
        Image img = Image.getInstance(path.toAbsolutePath().toString());
        

        document.add(paragraph);
        document.add(paragraph2);
        document.add(img);
        document.close();*/
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String certificationDate = dateFormatter.format(cr.findById(certifId).get().getDateCertif());
        VelocityEngine ve = new VelocityEngine();

		/* next, get the Template */
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		ve.init();
		Template t = ve.getTemplate("templates/CertificatTemplate.html");
		/* create a context and add data */
		VelocityContext context = new VelocityContext();
		context.put("title",cr.findById(certifId).get().getTitle().toString());
		context.put("name",cr.findById(certifId).get().getUser().getFirstname());
		context.put("lastname",cr.findById(certifId).get().getUser().getLastname());
		context.put("genDateTime",certificationDate );
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		/* show the World */
		//System.out.println(writer.toString());
        
        PdfWriter pdfWriter = null;

		// create a new document
            
		try {

			Document document = new Document();
			// document header attributes
			document.addCreationDate();
			document.addTitle("Certification");
			document.setPageSize(PageSize.A4.rotate());

			PdfWriter.getInstance(document , response.getOutputStream());

			// open document
			document.open();

			Reader targetReader = new StringReader(writer.toString());
			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document,targetReader);
			// close the document
			document.close();
			System.out.println("PDF generated successfully");
    }
	catch (Exception e) {
		e.printStackTrace();
	}
	}
}
