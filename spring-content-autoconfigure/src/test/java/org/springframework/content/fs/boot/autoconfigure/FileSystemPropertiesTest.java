package org.springframework.content.fs.boot.autoconfigure;

import internal.org.springframework.content.fs.boot.autoconfigure.FileSystemContentAutoConfiguration;
import org.apache.commons.lang3.SystemUtils;
import org.junit.runner.RunWith;

import com.github.paulcwarren.ginkgo4j.Ginkgo4jRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.BeforeEach;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.Context;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.Describe;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.It;

@RunWith(Ginkgo4jRunner.class)
public class FileSystemPropertiesTest {

    private FileSystemContentAutoConfiguration.FileSystemProperties props;

    {
        Describe("FileSystemProperties", () -> {
            Context("given a filesystem properties with no root set", () -> {
                BeforeEach(() -> props = new FileSystemContentAutoConfiguration.FileSystemProperties());
                It("should return a JAVA.IO.TMPDIR based default", () ->
                        assertThat(props.getFileSystemRoot(), startsWith(System.getProperty("java.io.tmpdir"))));
            });
            Context("given a filesystem properties with root set", () -> {
                final String someRandomPath = SystemUtils.IS_OS_WINDOWS ?
                        "C:\\some\\random\\path" : "/some/random/path";
                BeforeEach(() -> {
                    props = new FileSystemContentAutoConfiguration.FileSystemProperties();
                    props.setFileSystemRoot(someRandomPath);
                });
                It("should return a JAVA.IO.TMPDIR based default", () ->
                        assertThat(props.getFileSystemRoot(), is(someRandomPath)));
            });
        });
    }
}
