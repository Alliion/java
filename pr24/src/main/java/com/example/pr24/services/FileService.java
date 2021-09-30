package com.example.pr24.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@Service
public class FileService {
    /**
     * Удаляет все файлы в указанной директории
     * @param path путь до директории
     */
    public void deleteAllFilesFolder(String path) {
        File folder = new File(path);
        File[] fileList = folder.listFiles();

        if (fileList == null) {
            return;
        }

        for (File myFile : fileList)
            if (myFile.isFile()) myFile.delete();
    }

    /**
     * Записывает data в файл, распологающийся по пути fileName, если файла нет, то создаст
     * @param fileName путь до файла
     * @param data текстовые данные которые будут записаны в файл
     */
    public void writeToFile(String fileName, String data) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.print(data);
        writer.close();
    }
}
