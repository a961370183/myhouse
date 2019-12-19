package hnu.houseweb.service.tools;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface ImgTools {
    /*保存房源图片(待完成)*/
    public String saveHouseImg(MultipartFile file,int userId,int houseNo);
    /*裁剪并压缩图片(待完成), 参数1为文件, 参数2为文件的绝对路径的前面部份的长度(用于截取出具有实际价值的文件名)*/
    public String cutImg(File file,int width,int height) throws IOException;

    public String saveFile(MultipartFile file,String relativePath);

    public String compressImg(File file) throws IOException;

    public String deleteFile(String relativePath)  throws IOException;
}
