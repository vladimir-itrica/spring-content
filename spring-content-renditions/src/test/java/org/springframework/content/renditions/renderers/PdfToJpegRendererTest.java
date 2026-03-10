package org.springframework.content.renditions.renderers;

import com.github.paulcwarren.ginkgo4j.Ginkgo4jConfiguration;
import com.github.paulcwarren.ginkgo4j.Ginkgo4jRunner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.runner.RunWith;
import org.springframework.content.commons.renditions.RenditionProvider;
import org.springframework.content.renditions.RenditionException;
import org.springframework.renditions.poi.PDFService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@RunWith(Ginkgo4jRunner.class)
@Ginkgo4jConfiguration(threads = 1)
public class PdfToJpegRendererTest {

    private PDFService pdf;
    private PDDocument doc;
    private PDFRenderer pdfRenderer;

    private RenditionProvider renderer;

    private InputStream input;
    private String mimeType;

    private Exception e;

    {
        Describe("WordToJpegRenderer", () -> {
            BeforeEach(() -> {
                pdf = mock(PDFService.class);
                renderer = new PdfToJpegRenderer(pdf);
            });
            Context("#consumes", () -> It("should return word ml mimetype", () ->
                    assertThat(renderer.consumes(), is("application/pdf"))));
            Context("#produces", () -> It("should return jpeg mimetype", () ->
                    assertThat(renderer.produces(), hasItemInArray("image/jpg"))));
            Context("#convert", () -> {
                JustBeforeEach(() -> {
                    try {
                        renderer.convert(input, mimeType);
                    } catch (Exception e) {
                        this.e = e;
                    }
                });
                Context("given an input stream and a mimetype", () -> {
                    BeforeEach(() -> {
                        doc = mock(PDDocument.class);
                        when(pdf.load(any())).thenReturn(doc);
                        pdfRenderer = mock(PDFRenderer.class);
                        when(pdf.renderer(doc)).thenReturn(pdfRenderer);

                        input = new ByteArrayInputStream("".getBytes());
                    });
                    Context("when the pdf has more than one page", () -> {
                        BeforeEach(() -> when(doc.getNumberOfPages()).thenReturn(1));
                        It("should get the embedded thumbnail from the XWPFDocument's properties", () ->
                                verify(pdfRenderer).renderImageWithDPI(0, 300, ImageType.RGB));
                        It("should output the rendered image", () ->
                                verify(pdf).writeImage(any(), eq("jpeg"), isA(OutputStream.class)));
                        Context("when the pdf document fails to return a thumbnail", () -> {
                            BeforeEach(() -> doThrow(IOException.class).when(pdfRenderer)
                                    .renderImageWithDPI(0, 300, ImageType.RGB));
                            It("should throw a RenditionException", () -> {
                                assertThat(e, is(not(nullValue())));
                                assertThat(e, is(instanceOf(RenditionException.class)));
                            });
                            It("should close the document", () -> verify(doc).close());
                        });
                    });
                    Context("when the input stream is not a valid pdf file", () -> {
                        BeforeEach(() -> doThrow(IOException.class).when(pdf).load(any()));
                        It("should throw a RenditionException", () -> {
                            assertThat(e, is(not(nullValue())));
                            assertThat(e, is(instanceOf(RenditionException.class)));
                        });
                    });
                });
                Context("given a null input stream", () ->
                        It("should get the embedded thumbnail from the XWPFDocument's properties",
                                () -> assertThat(e, is(not(nullValue())))
                        ));
            });
        });
    }
}
