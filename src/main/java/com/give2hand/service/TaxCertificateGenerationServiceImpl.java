package com.give2hand.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;

import com.give2hand.entity.UserDonationScheme;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class TaxCertificateGenerationServiceImpl implements TaxCertificateGenerationService {

	/**
	 * 
	 * @author Raghu.
	 * 
	 *         This method will generate tax certificate file as pdf format for
	 *         donar.
	 * 
	 * @since 2020-02-14.
	 * @param donar details, like name, donarId, panNumber and tax percentage.
	 * @return the location of pdf file generated.
	 * 
	 */
	@Override
	public String generateTaxCertificate(UserDonationScheme userDonationScheme)
			throws DocumentException, FileNotFoundException {
		Document document = new Document();

		FileOutputStream fout = new FileOutputStream(
				"C:\\Users\\User1\\Desktop\\pdf\\tax" + userDonationScheme.getDonationId() + ".pdf");
		PdfWriter writer = PdfWriter.getInstance(document, fout);
		document.open();
		document.add(new Paragraph("Hello " + userDonationScheme.getName()));
		document.close();
		writer.close();
		return "C:\\Users\\User1\\Desktop\\pdf\\tax" + userDonationScheme.getDonationId() + ".pdf";
	}

}
