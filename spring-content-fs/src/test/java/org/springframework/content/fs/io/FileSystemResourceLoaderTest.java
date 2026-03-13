package org.springframework.content.fs.io;

import com.github.paulcwarren.ginkgo4j.Ginkgo4jConfiguration;
import com.github.paulcwarren.ginkgo4j.Ginkgo4jRunner;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.jspecify.annotations.NonNull;
import org.junit.runner.RunWith;
import org.springframework.content.commons.io.DeletableResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.nio.file.Files;

import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Ginkgo4jRunner.class)
@Ginkgo4jConfiguration(threads = 1)
public class FileSystemResourceLoaderTest {

    private FileSystemResourceLoader loader = null;

    private String path;

    private String location;

    private File parent;
    private File file;

    private Exception ex;

    {
        Describe("FileSystemResourceLoader", () ->
                Context("#FileSystemResourceLoader", () -> {
                    JustBeforeEach(() -> {
                        try {
                            loader = new FileSystemResourceLoader(path);
                        } catch (Exception e) {
                            ex = e;
                        }
                    });
                    Context("given well formed path (has a trailing slash)", () -> {
                        BeforeEach(() -> path = getPathWithProperSeparators("/some/well-formed/path/"));
                        It("succeeds", () -> {
                            assertThat(ex, is(nullValue()));
                            final String expected = getPathWithProperSeparators("/some/well-formed/path/something");
                            assertThat(loader.getResource("/something").getFile().getPath(), is(expected));
                            assertThat(loader.getResource("/something"),
                                    instanceOf(DeletableResource.class));
                        });
                    });

                    Context("given malformed path without a trailing slash)", () -> {
                        BeforeEach(() -> path = getPathWithProperSeparators("/some/malformed/path"));
                        It("succeeds", () -> {
                            assertThat(ex, is(nullValue()));
                            final String expected = getPathWithProperSeparators("/some/malformed/path/something");
                            assertThat(loader.getResource("/something").getFile().getPath(), is(expected));
                            assertThat(loader.getResource("/something"),
                                    instanceOf(DeletableResource.class));
                        });
                    });
                })
        );

        Describe("DeletableResource", () -> Context("#delete", () -> {
            BeforeEach(() -> parent = Files.createTempDirectory("fs-").toFile());
            JustBeforeEach(() -> {
                loader = new FileSystemResourceLoader(parent.getPath() + "/");
                Resource resource = loader.getResource(location);
                assertThat(resource, instanceOf(DeletableResource.class));
                ((DeletableResource) resource).delete();
            });
            Context("given a file resource that exists", () -> {
                BeforeEach(() -> {
                    location = "FileSystemResourceLoaderTest.tmp";
                    file = new File(parent, location);
                    FileUtils.touch(file);
                    assertThat(file.exists(), is(true));
                });
                It("should delete the underlying file", () -> assertThat(file.exists(), is(false)));
            });
        }));
    }

    private String getPathWithProperSeparators(@NonNull String path) {
        if (SystemUtils.IS_OS_WINDOWS) {
            return path.replace('/', '\\');
        }
        return path;
    }
}
