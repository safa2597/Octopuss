package tn.esprit.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;*/

import tn.esprit.spring.entities.Certificat;
import tn.esprit.spring.services.CertificatService;
import tn.esprit.spring.services.PDFGeneratorService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;

/*import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import org.springframework.http.HttpEntity;*/
import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class PDFExportController {

	 //private final PDFGeneratorService pdfGeneratorService;
	 
	 @Autowired
	 CertificatService cs;
	 @Autowired
	 PDFGeneratorService pgs;
	 @Autowired
	 Certificat c;
	 

	   /* public PDFExportController(PDFGeneratorService pdfGeneratorService) {
	        this.pdfGeneratorService = pdfGeneratorService;
	    }

	    /*@GetMapping("/pdf/generate")
	    public void generatePDF(HttpServletResponse response) throws IOException, URISyntaxException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	        String currentDateTime = dateFormatter.format(new Date());

	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Certificat_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);

	        this.pdfGeneratorService.export(response);
	    }*/
	    
	    
	    
	    
	    
	    
	    
	    @GetMapping("/genpdf/{idCertif}")
		public void createPdf(@RequestParam("idCertif") Long idCertif,HttpServletResponse response) throws IOException, URISyntaxException {

			/* first, get and initialize an engine 
			VelocityEngine ve = new VelocityEngine();

			/* next, get the Template 
			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			ve.setProperty("classpath.resource.loader.class",
					ClasspathResourceLoader.class.getName());
			ve.init();
			Template t = ve.getTemplate("templates/CertificatTemplate.html");
			/* create a context and add data 
			VelocityContext context = new VelocityContext();
			context.put(c.getTitle(),c.getUser());
			context.put("genDateTime", LocalDateTime.now().toString());
			/* now render the template into a StringWriter 
			StringWriter writer = new StringWriter();
			t.merge(context, writer);
			/* show the World 
			System.out.println(writer.toString());
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			baos = generatePdf(writer.toString());*/

			//HttpHeaders header = new HttpHeaders();
	    	//pgs.export(idCertif, response);
	    	response.setContentType("application/pdf");
		    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	        String currentDateTime = dateFormatter.format(new Date());
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Certificat_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);

	        pgs.export(idCertif,response);

		}
	    
		/*public ByteArrayOutputStream generatePdf(String html) {

			PdfWriter pdfWriter = null;

			// create a new document
			Document document = new Document();
			try {

				document = new Document();
				// document header attributes
				document.addCreationDate();
				document.addTitle("Certification");
				document.setPageSize(PageSize.A4.rotate());

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PdfWriter.getInstance(document, baos);

				// open document
				document.open();

				XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
				xmlWorkerHelper.getDefaultCssResolver(true);
				xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(html));
				// close the document
				document.close();
				System.out.println("PDF generated successfully");

				return baos;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}*/
	    
	    
}
