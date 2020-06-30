package stackjava.com.bookstore.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class FileController {

    @GetMapping("/file/{fileName}")
    public ResponseEntity<InputStreamResource> file(@PathVariable("fileName") String fileName) throws IOException {
        HttpHeaders responseHeader = new HttpHeaders();
        try {
            String filePath = stackjava.com.bookstore.util.FileUtils.getFolderUpload().getAbsolutePath() +"/"+fileName;
            File file = ResourceUtils.getFile(filePath);
            byte[] data = FileUtils.readFileToByteArray(file);
            // Set mimeType trả về
            responseHeader.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            // Thiết lập thông tin trả về
            responseHeader.set("Content-disposition", "attachment; filename=" + file.getName());
            responseHeader.setContentLength(data.length);
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            return new ResponseEntity<>(inputStreamResource, responseHeader, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
