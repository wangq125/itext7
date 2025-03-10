/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2022 iText Group NV
    Authors: iText Software.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License version 3
    as published by the Free Software Foundation with the addition of the
    following permission added to Section 15 as permitted in Section 7(a):
    FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY
    ITEXT GROUP. ITEXT GROUP DISCLAIMS THE WARRANTY OF NON INFRINGEMENT
    OF THIRD PARTY RIGHTS

    This program is distributed in the hope that it will be useful, but
    WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
    or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU Affero General Public License for more details.
    You should have received a copy of the GNU Affero General Public License
    along with this program; if not, see http://www.gnu.org/licenses or write to
    the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
    Boston, MA, 02110-1301 USA, or download the license from the following URL:
    http://itextpdf.com/terms-of-use/

    The interactive user interfaces in modified source and object code versions
    of this program must display Appropriate Legal Notices, as required under
    Section 5 of the GNU Affero General Public License.

    In accordance with Section 7(b) of the GNU Affero General Public License,
    a covered work must retain the producer line in every PDF that is created
    or manipulated using iText.

    You can be released from the requirements of the license by purchasing
    a commercial license. Buying such a license is mandatory as soon as you
    develop commercial activities involving the iText software without
    disclosing the source code of your own applications.
    These activities include: offering paid services to customers as an ASP,
    serving PDFs on the fly in a web application, shipping iText with a closed
    source product.

    For more information, please contact iText Software Corp. at this
    address: sales@itextpdf.com
 */
package com.itextpdf.layout;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.util.UrlUtil;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfFontFactory.EmbeddingStrategy;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.kernel.utils.CompareTool;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.FloatPropertyValue;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.ListNumberingType;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.type.IntegrationTest;

import java.io.IOException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class AlignmentTest extends ExtendedITextTest {

    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/layout/AlignmentTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/layout/AlignmentTest/";

    @BeforeClass
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }


    @Test
    public void justifyAlignmentTest01() throws IOException,  InterruptedException {
        String outFileName = DESTINATION_FOLDER + "justifyAlignmentTest01.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_justifyAlignmentTest01.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));

        Document document = new Document(pdfDocument);

        Paragraph paragraph = new Paragraph().setTextAlignment(TextAlignment.JUSTIFIED);
        for (int i = 0; i < 21; i++) {
            paragraph.add(new Text ("Hello World! Hello People! " +
                    "Hello Sky! Hello Sun! Hello Moon! Hello Stars!").setBackgroundColor(ColorConstants.RED));
        }
        document.add(paragraph);

        document.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    public void justifyAlignmentTest02() throws IOException, InterruptedException {
        String outFileName = DESTINATION_FOLDER + "justifyAlignmentTest02.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_justifyAlignmentTest02.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));

        Document document = new Document(pdfDocument);

        Paragraph paragraph = new Paragraph().setTextAlignment(TextAlignment.JUSTIFIED);
        paragraph.add(new Text("Hello World!")).add(new Text(" ")).add(new Text("Hello People! ")).add("End");
        document.add(paragraph);

        document.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    public void justifyAlignmentTest03() throws IOException,  InterruptedException {
        String outFileName = DESTINATION_FOLDER + "justifyAlignmentTest03.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_justifyAlignmentTest03.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));

        Document document = new Document(pdfDocument);

        Paragraph paragraph = new Paragraph().setTextAlignment(TextAlignment.JUSTIFIED);
        for (int i = 0; i < 21; i++) {
            paragraph.add(new Text("Hello World! Hello People! " +
                    "Hello Sky! Hello Sun! Hello Moon! Hello Stars!").setBorder(new SolidBorder(ColorConstants.GREEN, 0.1f))).setMultipliedLeading(1);
        }
        document.add(paragraph);

        document.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    public void justifyAlignmentTest04() throws IOException,  InterruptedException {
        String outFileName = DESTINATION_FOLDER + "justifyAlignmentTest04.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_justifyAlignmentTest04.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));

        Document document = new Document(pdfDocument);

        Paragraph paragraph = new Paragraph().setTextAlignment(TextAlignment.JUSTIFIED);
        for (int i = 0; i < 21; i++) {
            paragraph.add(new Text("Hello World! Hello People! " +
                    "Hello Sky! Hello Sun! Hello Moon! Hello Stars!")).setFixedLeading(24);
        }
        document.add(paragraph);

        document.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    public void justifyAlignmentForcedNewlinesTest01() throws IOException, InterruptedException {
        String outFileName = DESTINATION_FOLDER + "justifyAlignmentForcedNewlinesTest01.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_justifyAlignmentForcedNewlinesTest01.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));

        Document document = new Document(pdfDocument);

        Paragraph paragraph = new Paragraph().setTextAlignment(TextAlignment.JUSTIFIED);
        paragraph.add("Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.\n" +
                "To make your document look professionally produced, Word provides header, footer, cover page, and text box designs that complement each other. For example, you can add a matching cover page, header, and sidebar. Click Insert and then choose the elements you want from the different galleries.\n" +
                "Themes and styles also help keep your document coordinated. When you click Design and choose a new Theme, the pictures, charts, and SmartArt graphics change to match your new theme. When you apply styles, your headings change to match the new theme.\n" +
                "Save time in Word with new buttons that show up where you need them. To change the way a picture fits in your document, click it and a button for layout options appears next to it. When you work on a table, click where you want to add a row or a column, and then click the plus sign.\n" +
                "Reading is easier, too, in the new Reading view. You can collapse parts of the document and focus on the text you want. If you need to stop reading before you reach the end, Word remembers where you left off - even on another device.\n");
        document.add(paragraph);

        document.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    public void justifyAllTest01() throws IOException, InterruptedException {
        String outFileName = DESTINATION_FOLDER + "justifyAllTest01.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_justifyAllTest01.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));

        Document document = new Document(pdfDocument);

        Paragraph paragraph = new Paragraph().setTextAlignment(TextAlignment.JUSTIFIED_ALL);
        paragraph.add("Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.\n" +
                "To make your document look professionally produced, Word provides header, footer, cover page, and text box designs that complement each other. For example, you can add a matching cover page, header, and sidebar. Click Insert and then choose the elements you want from the different galleries.\n" +
                "Themes and styles also help keep your document coordinated. When you click Design and choose a new Theme, the pictures, charts, and SmartArt graphics change to match your new theme. When you apply styles, your headings change to match the new theme.\n" +
                "Save time in Word with new buttons that show up where you need them. To change the way a picture fits in your document, click it and a button for layout options appears next to it. When you work on a table, click where you want to add a row or a column, and then click the plus sign.\n" +
                "Reading is easier, too, in the new Reading view. You can collapse parts of the document and focus on the text you want. If you need to stop reading before you reach the end, Word remembers where you left off - even on another device.\n");
        document.add(paragraph);

        document.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    public void justifyAllTest02() throws IOException, InterruptedException {
        String outFileName = DESTINATION_FOLDER + "justifyAllTest02.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_justifyAllTest02.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));

        Document document = new Document(pdfDocument);
        PdfFont type0 = PdfFontFactory.createFont(SOURCE_FOLDER + "/../fonts/NotoSans-Regular.ttf", PdfEncodings.IDENTITY_H);
        PdfFont simpleFont = PdfFontFactory.createFont(
                SOURCE_FOLDER + "/../fonts/NotoSans-Regular.ttf", EmbeddingStrategy.PREFER_EMBEDDED);

        Paragraph paragraph = new Paragraph().setSpacingRatio(1).setTextAlignment(TextAlignment.JUSTIFIED_ALL);
        paragraph.add("If you need to stop reading before you reach the end");
        document.add(paragraph.setFont(type0));

        paragraph.setFont(simpleFont);
        document.add(paragraph);

        document.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    public void blockAlignmentTest01() throws IOException, InterruptedException {
        String outFileName = DESTINATION_FOLDER + "blockAlignmentTest01.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_blockAlignmentTest01.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));

        Document document = new Document(pdfDocument);

        List list = new List(ListNumberingType.GREEK_LOWER);
        for (int i = 0; i < 10; i++) {
            list.add("Item # " + (i + 1));
        }
        list.setWidth(250);
        list.setHorizontalAlignment(HorizontalAlignment.CENTER);
        list.setBackgroundColor(ColorConstants.GREEN);

        document.add(list);
        list.setHorizontalAlignment(HorizontalAlignment.RIGHT).setBackgroundColor(ColorConstants.RED);
        list.setTextAlignment(TextAlignment.CENTER);
        document.add(list);

        document.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    public void blockAlignmentTest02() throws IOException, InterruptedException {
        String outFileName = DESTINATION_FOLDER + "blockAlignmentTest02.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_blockAlignmentTest02.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));

        Document document = new Document(pdfDocument);

        Div div = new Div();
        PdfImageXObject xObject = new PdfImageXObject(ImageDataFactory.createJpeg(UrlUtil.toURL(SOURCE_FOLDER + "Desert.jpg")));
        Image image1 = new Image(xObject, 100).setHorizontalAlignment(HorizontalAlignment.RIGHT);
        Image image2 = new Image(xObject, 100).setHorizontalAlignment(HorizontalAlignment.CENTER);
        Image image3 = new Image(xObject, 100).setHorizontalAlignment(HorizontalAlignment.LEFT);

        div.add(image1).add(image2).add(image3);

        document.add(div);

        document.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    public void imageAlignmentTest01() throws IOException, InterruptedException {

        String outFileName = DESTINATION_FOLDER + "imageAlignmentTest01.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_imageAlignmentTest01.pdf";

        PdfWriter writer = new PdfWriter(outFileName);

        PdfDocument pdfDoc = new PdfDocument(writer);

        Document doc = new Document(pdfDoc);

        PdfImageXObject xObject = new PdfImageXObject(ImageDataFactory.createJpeg(UrlUtil.toURL(SOURCE_FOLDER + "Desert.jpg")));
        Image image = new Image(xObject, 100).setHorizontalAlignment(HorizontalAlignment.RIGHT);

        doc.add(image);

        doc.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    public void emptyLineJustification01() throws IOException, InterruptedException {
        String outFileName = DESTINATION_FOLDER + "emptyLineJustification01.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_emptyLineJustification01.pdf";

        PdfWriter writer = new PdfWriter(outFileName);

        PdfDocument pdfDoc = new PdfDocument(writer);

        Document doc = new Document(pdfDoc);

        doc.add(new Paragraph()
                .setTextAlignment(TextAlignment.JUSTIFIED));

        doc.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    public void floatAlignmentTest01() throws IOException, InterruptedException {

        String outFileName = DESTINATION_FOLDER + "floatAlignmentTest01.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_floatAlignmentTest01.pdf";

        PdfWriter writer = new PdfWriter(outFileName);
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.setDefaultPageSize(new PageSize(350, 450));
        Document doc = new Document(pdfDoc);

        addFloatAndText(doc, FloatPropertyValue.RIGHT);
        addFloatAndText(doc, FloatPropertyValue.LEFT);

        doc.add(new AreaBreak());
        doc.add(new Paragraph("All lines after this one have first line indent = 20. " +
                "Float left is correct, right is not."));
        doc.setProperty(Property.FIRST_LINE_INDENT, 20f);
        addFloatAndText(doc, FloatPropertyValue.RIGHT);
        addFloatAndText(doc, FloatPropertyValue.LEFT);

        doc.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    private static void addFloatAndText(Document doc, FloatPropertyValue floatPropertyValue) {
        Div div = new Div();
        div.setWidth(150).setHeight(120);
        div.setProperty(Property.FLOAT, floatPropertyValue);
        div.setBorder(new SolidBorder(1));
        doc.add(div);
        doc.add(new Paragraph("Left aligned.")
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("Right aligned.")
                .setTextAlignment(TextAlignment.RIGHT));
        doc.add(new Paragraph("Center aligned.")
                .setTextAlignment(TextAlignment.CENTER));
        doc.add(new Paragraph("Justified. " +
                "The text is laid out using the correct width, but  the alignment value uses the full width.")
                .setTextAlignment(TextAlignment.JUSTIFIED));
    }

    @Test
    public void floatAlignmentTest02() throws IOException, InterruptedException {

        String outFileName = DESTINATION_FOLDER + "floatAlignmentTest02.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_floatAlignmentTest02.pdf";

        PdfWriter writer = new PdfWriter(outFileName);
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.setDefaultPageSize(new PageSize(350, 450));
        Document doc = new Document(pdfDoc);

        doc.add(new Paragraph("All lines after this one have first line indent = 20."));
        doc.setProperty(Property.FIRST_LINE_INDENT, 20f);

        Div div = new Div().add(new Paragraph("float"));
        div.setBorder(new SolidBorder(1));

        div.setProperty(Property.FLOAT, FloatPropertyValue.LEFT);
        addInlineBlockFloatAndText(doc, div);
        doc.add(new AreaBreak());
        div.setProperty(Property.FLOAT, FloatPropertyValue.RIGHT);
        addInlineBlockFloatAndText(doc, div);

        doc.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    @Test
    //TODO DEVSIX-6490 Support verticalAlignment property in layout
    public void verticalAlignmentMiddleTest() throws IOException, InterruptedException {
        String outPdf = DESTINATION_FOLDER + "verticalAlignmentMiddle.pdf";
        String cmpPdf = SOURCE_FOLDER + "cmp_verticalAlignmentMiddle.pdf";

        createDocumentWithAlignment(outPdf, cmpPdf, VerticalAlignment.MIDDLE);
    }

    @Test
    //TODO DEVSIX-6490 Support verticalAlignment property in layout
    public void verticalAlignmentBottomTest() throws IOException, InterruptedException {
        String outPdf = DESTINATION_FOLDER + "verticalAlignmentBottom.pdf";
        String cmpPdf = SOURCE_FOLDER + "cmp_verticalAlignmentBottom.pdf";

        createDocumentWithAlignment(outPdf, cmpPdf, VerticalAlignment.BOTTOM);
    }

    @Test
    public void verticalAlignmentTopTest() throws IOException, InterruptedException {
        String outPdf = DESTINATION_FOLDER + "verticalAlignmentTop.pdf";
        String cmpPdf = SOURCE_FOLDER + "cmp_verticalAlignmentTop.pdf";

        createDocumentWithAlignment(outPdf, cmpPdf, VerticalAlignment.TOP);
    }

    @Test
    public void floatAlignmentTest03() throws IOException, InterruptedException {
        String outFileName = DESTINATION_FOLDER + "floatAlignmentTest03.pdf";
        String cmpFileName = SOURCE_FOLDER + "cmp_floatAlignmentTest03.pdf";

        PdfWriter writer = new PdfWriter(outFileName);
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.setDefaultPageSize(new PageSize(350, 450));
        Document doc = new Document(pdfDoc);

        doc.add(new Paragraph("All lines after this one have first line indent = 20."));
        doc.setProperty(Property.FIRST_LINE_INDENT, 20f);

        Text text = new Text("float");
        text.setBorder(new SolidBorder(1));

        text.setProperty(Property.FLOAT, FloatPropertyValue.LEFT);
        addInlineBlockFloatAndText(doc, text);
        doc.add(new AreaBreak());
        text.setProperty(Property.FLOAT, FloatPropertyValue.RIGHT);
        addInlineBlockFloatAndText(doc, text);

        doc.close();
        doc.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, DESTINATION_FOLDER, "diff"));
    }

    private static void createDocumentWithAlignment(String outPdf, String cmpPdf, VerticalAlignment verticalAlignment)
            throws IOException, InterruptedException {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(outPdf));
        Document doc = new Document(pdfDoc);
        Paragraph p = new Paragraph();
        p.setBackgroundColor(new DeviceRgb(189, 239, 73));
        p.setVerticalAlignment(verticalAlignment);
        p.add("vertical Alignment " + verticalAlignment + " one");
        p.add("\n vertical Alignment " + verticalAlignment + " two");
        p.add("\n vertical Alignment " + verticalAlignment + " three");
        doc.add(p);

        pdfDoc.close();

        Assert.assertNull(new CompareTool().compareByContent(outPdf, cmpPdf, DESTINATION_FOLDER));
    }

    private void addInlineBlockFloatAndText(Document doc, Div div) {
        doc.add(new Paragraph("Left aligned.").setMarginBottom(30)
                .add(div)
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("Right aligned.").setMarginBottom(30)
                .add(div)
                .setTextAlignment(TextAlignment.RIGHT));
        doc.add(new Paragraph("Center aligned.").setMarginBottom(30)
                .add(div)
                .setTextAlignment(TextAlignment.CENTER));
        doc.add(new Paragraph().add(div).add("Justified. " +
                        "The text is laid out using the correct width, but  the alignment value uses the full width.")
                .setTextAlignment(TextAlignment.JUSTIFIED));
    }

    private void addInlineBlockFloatAndText(Document doc, Text text) {
        doc.add(new Paragraph("Left aligned.").setMarginBottom(30)
                .add(text)
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("Right aligned.").setMarginBottom(30)
                .add(text)
                .setTextAlignment(TextAlignment.RIGHT));
        doc.add(new Paragraph("Center aligned.").setMarginBottom(30)
                .add(text)
                .setTextAlignment(TextAlignment.CENTER));
        doc.add(new Paragraph().add(text).add("Justified. " +
                "The text is laid out using the correct width, but  the alignment value uses the full width.")
                .setTextAlignment(TextAlignment.JUSTIFIED));
    }
}
