package internal.org.springframework.content.fs.config;

import org.springframework.content.fs.config.EnableFilesystemContentRepositories;

import java.lang.annotation.Annotation;

@SuppressWarnings("deprecation")
public class FileSystemContentRepositoriesRegistrar extends FileSystemStoreRegistrar {

	public FileSystemContentRepositoriesRegistrar() {
	}

	@Override
	protected Class<? extends Annotation> getAnnotation() {
		return EnableFilesystemContentRepositories.class;
	}
}
