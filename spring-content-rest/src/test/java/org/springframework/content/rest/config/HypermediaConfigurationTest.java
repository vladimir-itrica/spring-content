package org.springframework.content.rest.config;

import com.github.paulcwarren.ginkgo4j.Ginkgo4jRunner;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.fs.config.EnableFileSystemStores;
import org.springframework.content.fs.io.FileSystemResourceLoader;
import org.springframework.content.fs.store.FileSystemContentStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

import java.io.IOException;
import java.nio.file.Files;

import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Ginkgo4jRunner.class)
public class HypermediaConfigurationTest {

    private AnnotationConfigWebApplicationContext context;

    {
        Describe("HypermediaConfiguration", () ->
                Context("given a context with a ContentRestConfiguration", () -> {
                    BeforeEach(() -> {
                        context = new AnnotationConfigWebApplicationContext();
                        context.setServletContext(new MockServletContext());
                        context.register(TestConfig.class,
                                DelegatingWebMvcConfiguration.class,
                                RepositoryRestMvcConfiguration.class,
                                HypermediaConfiguration.class);
                        context.refresh();
                    });

                    It("should have a content links processor bean", () ->
                            assertThat(context.getBean("contentLinksProcessor"), is(not(nullValue()))));
                }));
    }

    @Ignore("This is not a test and must not be treated as such.")
    @Configuration
    @EnableFileSystemStores
    public static class TestConfig {

        @Bean
        public FileSystemResourceLoader filesystemRoot() throws IOException {
            return new FileSystemResourceLoader(Files.createTempDirectory("").toFile().getAbsolutePath());
        }
    }

    @Ignore("This is not a test and must not be treated as such.")
    @Document
    public static class TestEntity {
        @Id
        private String id;
        @ContentId
        private String contentId;
    }

    public interface TestEntityRepository extends MongoRepository<TestEntity, String> {
    }

    public interface TestEntityContentStore extends FileSystemContentStore<TestEntity, String> {
    }
}
