package org.springframework.versions.jpa.boot;

import com.github.paulcwarren.ginkgo4j.Ginkgo4jRunner;
import internal.org.springframework.versions.jpa.boot.autoconfigure.JpaVersionsDatabaseInitializer;
import internal.org.springframework.versions.jpa.boot.autoconfigure.JpaVersionsProperties;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.sql.init.DatabaseInitializationMode;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;

import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.*;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;

@Ignore("This test was entirely commented out, it may not work at all. We'll ignore it for now.")
@RunWith(Ginkgo4jRunner.class)
public class JpaVersionsDatabaseInitializerTest {

    private JpaVersionsDatabaseInitializer initializer;

    private DataSource ds;
    private JpaVersionsProperties props;

    // mocks
    private Statement stmt;

    {
        Describe("ContentJpaDatabaseInitializer", () -> {
            JustBeforeEach(() -> initializer = new JpaVersionsDatabaseInitializer(ds, props));
            BeforeEach(() -> {
                ds = mock(DataSource.class);
                props = new JpaVersionsProperties();
            });
            Context("#initialize", () -> {
                BeforeEach(() -> {
                    Connection conn = mock(Connection.class);
                    when(ds.getConnection()).thenReturn(conn);
                    stmt = mock(Statement.class);
                    when(conn.createStatement()).thenReturn(stmt);
                    DatabaseMetaData metadata = mock(DatabaseMetaData.class);
                    when(conn.getMetaData()).thenReturn(metadata);
                    when(metadata.getDatabaseProductName()).thenReturn("h2");
                });
                Context("when initialization is enabled", () -> {
                    JustBeforeEach(() -> initializer.initializeDatabase());
                    It("should execute CREATE TABLE statements on the database", () ->
                            verify(stmt, atLeastOnce()).execute(argThat(containsString("CREATE TABLE"))));
                });
                Context("when initialization is disabled", () -> {
                    BeforeEach(() -> props.getInitializer().setInitializeSchema(DatabaseInitializationMode.NEVER));
                    It("should not execute any statements on the database", () ->
                            verify(stmt, never()).execute(anyString()));
                });
            });
        });
    }
}
