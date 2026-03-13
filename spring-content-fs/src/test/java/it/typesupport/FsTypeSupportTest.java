package it.typesupport;

import com.github.f4b6a3.uuid.UuidCreator;
import com.github.paulcwarren.ginkgo4j.Ginkgo4jConfiguration;
import com.github.paulcwarren.ginkgo4j.Ginkgo4jSpringRunner;
import it.typesupport.model.*;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.UUID;

import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.*;

@RunWith(Ginkgo4jSpringRunner.class)
@Ginkgo4jConfiguration(threads = 1)
@ContextConfiguration(classes = {FsTypeSupportConfig.class})
public class FsTypeSupportTest {

    @Autowired
    protected UUIDBasedContentEntityStore uuidStore;
    @Autowired
    protected URIBasedContentEntityStore uriStore;
    @Autowired
    protected LongBasedContentEntityStore longStore;
    @Autowired
    protected BigIntegerBasedContentEntityStore bigIntStore;

    Object entity;
    Object id;

    {
        Describe("java.util.UUID", () -> {
            Context("given a content entity", () -> {
                BeforeEach(() -> entity = new UUIDBasedContentEntity());
                Context("given the Application sets the ID", () -> {
                    BeforeEach(() -> {
                        id = UuidCreator.getTimeOrdered();
                        ((UUIDBasedContentEntity) entity).setContentId((UUID) id);

                        uuidStore.setContent((UUIDBasedContentEntity) entity, new ByteArrayInputStream("uuid".getBytes()));
                    });
                    It("should store the content successfully", () -> Assert.assertTrue(IOUtils.contentEquals(
                            uuidStore.getContent((UUIDBasedContentEntity) entity),
                            IOUtils.toInputStream("uuid", Charset.defaultCharset())
                    )));
                });
                Context("given Spring Content generates the ID", () -> {
                    BeforeEach(() -> uuidStore.setContent(
                            (UUIDBasedContentEntity) entity,
                            new ByteArrayInputStream("uuid".getBytes()
                            )));
                    It("should store the content successfully", () -> Assert.assertTrue(IOUtils.contentEquals(
                            uuidStore.getContent((UUIDBasedContentEntity) entity),
                            IOUtils.toInputStream("uuid", Charset.defaultCharset())
                    )));
                });
            });
            AfterEach(() -> {
                uuidStore.unsetContent((UUIDBasedContentEntity) entity);
                Assert.assertNull(((UUIDBasedContentEntity) entity).getContentId());
            });
        });
        Describe("java.net.URI", () -> {
            Context("given a content entity", () -> {
                BeforeEach(() -> entity = new URIBasedContentEntity());
                Context("given the Application sets the ID", () -> {
                    BeforeEach(() -> {
                        id = new URI("http://some.org/deep/location.html");
                        ((URIBasedContentEntity) entity).setContentId((URI) id);

                        uriStore.setContent((URIBasedContentEntity) entity, new ByteArrayInputStream("uri".getBytes()));
                    });
                    It("should store the content successfully", () -> Assert.assertTrue(IOUtils.contentEquals(
                            uriStore.getContent((URIBasedContentEntity) entity),
                            IOUtils.toInputStream("uri", Charset.defaultCharset())
                    )));
                });
            });
            AfterEach(() -> {
                uriStore.unsetContent((URIBasedContentEntity) entity);
                Assert.assertNull(((URIBasedContentEntity) entity).getContentId());
            });
        });
        Describe("java.lang.Long", () -> {
            Context("given a content entity", () -> {
                BeforeEach(() -> entity = new LongBasedContentEntity());
                Context("given the Application sets the ID", () -> {
                    BeforeEach(() -> {
                        id = Long.MAX_VALUE;
                        ((LongBasedContentEntity) entity).setContentId((Long) id);

                        longStore.setContent((LongBasedContentEntity) entity, new ByteArrayInputStream("long".getBytes()));
                    });
                    It("should store the content successfully", () -> Assert.assertTrue(IOUtils.contentEquals(
                            longStore.getContent((LongBasedContentEntity) entity),
                            IOUtils.toInputStream("long", Charset.defaultCharset())
                    )));
                });
            });
            AfterEach(() -> {
                longStore.unsetContent((LongBasedContentEntity) entity);
                Assert.assertNull(((LongBasedContentEntity) entity).getContentId());
            });
        });
        Describe("java.math.BigInteger", () -> {
            Context("given a content entity", () -> {
                BeforeEach(() -> entity = new BigIntegerBasedContentEntity());
                Context("given the Application sets the ID", () -> {
                    BeforeEach(() -> {
                        id = BigInteger.valueOf(Long.MAX_VALUE);
                        ((BigIntegerBasedContentEntity) entity).setContentId((BigInteger) id);

                        bigIntStore.setContent((BigIntegerBasedContentEntity) entity, new ByteArrayInputStream("big-int".getBytes()));
                    });
                    It("should store the content successfully", () -> Assert.assertTrue(IOUtils.contentEquals(
                            bigIntStore.getContent((BigIntegerBasedContentEntity) entity),
                            IOUtils.toInputStream("big-int", Charset.defaultCharset())
                    )));
                });
            });
            AfterEach(() -> {
                bigIntStore.unsetContent((BigIntegerBasedContentEntity) entity);
                Assert.assertNull(((BigIntegerBasedContentEntity) entity).getContentId());
            });
        });
    }


    @Test
    public void noop() throws IOException {
    }
}
