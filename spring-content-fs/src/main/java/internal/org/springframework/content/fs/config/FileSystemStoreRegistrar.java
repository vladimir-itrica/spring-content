package internal.org.springframework.content.fs.config;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.content.commons.config.AbstractStoreBeanDefinitionRegistrar;
import org.springframework.content.fs.config.EnableFilesystemStores;
import org.springframework.content.fs.store.FilesystemAssociativeStore;
import org.springframework.content.fs.store.FilesystemContentStore;
import org.springframework.content.fs.store.FilesystemStore;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;

public class FilesystemStoreRegistrar extends AbstractStoreBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(@NonNull AnnotationMetadata importingClassMetadata,
                                        @NonNull BeanDefinitionRegistry registry) {
        super.registerBeanDefinitions(importingClassMetadata, registry);
    }

    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return EnableFilesystemStores.class;
    }

    @Override
    protected Class<?>[] getSignatureTypes() {
        return new Class[]{FilesystemStore.class, FilesystemAssociativeStore.class, FilesystemContentStore.class};
    }

    @Override
    protected String getOverridePropertyValue() {
        return "fs";
    }
}
