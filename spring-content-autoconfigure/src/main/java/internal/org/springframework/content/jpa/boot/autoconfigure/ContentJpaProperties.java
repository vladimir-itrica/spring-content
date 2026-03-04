package internal.org.springframework.content.jpa.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.sql.init.DatabaseInitializationMode;

@ConfigurationProperties("spring.content.jpa")
public class ContentJpaProperties {

    private final ContentJpaProperties.Initializer initializer = new Initializer();

    private int copyBufferSize = 4096;

    public Initializer getInitializer() {
        return initializer;
    }

    public String getSchema() {
        return "optional:classpath:org/springframework/content/jpa/schema-@@platform@@.sql";
    }

    public static class Initializer {
        private DatabaseInitializationMode initializeSchema;

        public DatabaseInitializationMode getInitializeSchema() {
            return this.initializeSchema;
        }

        public void setInitializeSchema(DatabaseInitializationMode initializeSchema) {
            this.initializeSchema = initializeSchema;
        }
    }

    public void setCopyBufferSize(int copyBufferSize) {
        this.copyBufferSize = copyBufferSize;
    }

    public int getCopyBufferSize() {
        return this.copyBufferSize;
    }
}
