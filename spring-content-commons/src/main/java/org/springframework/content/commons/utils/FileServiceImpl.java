package org.springframework.content.commons.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.NonNull;
import org.springframework.util.Assert;

public class FileServiceImpl implements FileService {
    public FileServiceImpl() {
    }

    @Override
    public void mkdirs(@NonNull File file) throws IOException {
        Assert.notNull(file, "file must not be null");
        FileUtils.forceMkdir(file);
    }

    @Override
    public void rmdirs(@NonNull File from, File to) throws IOException {
        Assert.notNull(from, "file must not be null");
        if (from.isFile()) {
            throw new IOException("Not a directory");
        }
        File dir = from;
        while (dir != null && !dir.equals(to)) {
            var files = dir.listFiles();
            if (files != null && files.length == 0) {
                File temp = dir.getParentFile();
                dir.delete();
                dir = temp;
            }
        }
    }

    @Override
    public void rmdirs(@NonNull File from) throws IOException {
        Assert.notNull(from, "file must not be null");
        if (from.isFile()) {
            throw new IOException("Not a directory");
        }
        File dir = from;
        while (dir != null) {
            var files = dir.listFiles();
            if (files != null && files.length == 0) {
                File temp = dir.getParentFile();
                dir.delete();
                dir = temp;
            }
        }
    }
}
