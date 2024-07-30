public class TestFactoryMethod {
  public static void main(String[] args) {
    DocumentFactory wordFactory = new WordDocumentFactory();
    Document wordDoc = wordFactory.createDocument();
    wordDoc.open();
    wordDoc.edit();
    wordDoc.save();
    wordDoc.close();

    DocumentFactory pdfFactory = new PdfDocumentFactory();
    Document pdfDoc = pdfFactory.createDocument();
    pdfDoc.open();
    pdfDoc.edit();
    pdfDoc.save();
    pdfDoc.close();
    System.out.println();

    DocumentFactory excelFactory = new ExcelDocumentFactory();
    Document excelDoc = excelFactory.createDocument();
    excelDoc.open();
    excelDoc.edit();
    excelDoc.save();
    excelDoc.close();
  }
}