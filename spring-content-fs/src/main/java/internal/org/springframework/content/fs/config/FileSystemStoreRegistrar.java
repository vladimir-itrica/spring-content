package internal.org.springframework.content.fs.config;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.content.commons.config.AbstractStoreBeanDefinitionRegistrar;
import org.springframework.content.fs.config.EnableFileSystemStores;
import org.springframework.content.fs.store.FileSystemAssociativeStore;
import org.springframework.content.fs.store.FileSystemContentStore;
import org.springframework.content.fs.store.FileSystemStore;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;

public class FileSystemStoreRegistrar extends AbstractStoreBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(@NonNull AnnotationMetadata importingClassMetadata,
                                        @NonNull BeanDefinitionRegistry registry) {
        super.registerBeanDefinitions(importingClassMetadata, registry);
    }

    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return EnableFileSystemStores.class;
    }

    @Override
    protected Class<?>[] getSignatureTypes() {
        return new Class[]{FileSystemStore.class, FileSystemAssociativeStore.class, FileSystemContentStore.class};
    }

    @Override
    protected String getOverridePropertyValue() {
        return "fs";
    }
}
