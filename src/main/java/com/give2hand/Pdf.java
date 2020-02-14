package com.give2hand;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf {

	public static void main(String[] args) {
		Document document = new Document();

		try {
			FileOutputStream fout = new FileOutputStream("C:\\Users\\User1\\Desktop\\pdf\\new1.pdf");
			PdfWriter writer = PdfWriter.getInstance(document, fout);
			document.open();
			document.add(new Paragraph("A Hello RAghu."));
			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
