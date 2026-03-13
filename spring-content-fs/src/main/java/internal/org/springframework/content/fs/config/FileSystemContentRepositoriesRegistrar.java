package internal.org.springframework.content.fs.config;

import org.springframework.content.fs.config.EnableFileSystemContentRepositories;

import java.lang.annotation.Annotation;

public class FileSystemContentRepositoriesRegistrar extends FileSystemStoreRegistrar {

    public FileSystemContentRepositoriesRegistrar() {
    }

    @SuppressWarnings("deprecation")
    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return EnableFileSystemContentRepositories.class;
    }
}
