package hnu.houseweb.serviceImpl.tools;

import hnu.houseweb.service.tools.ImgTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImgToolsImpl implements ImgTools {

    @Override
    /*操作：调用裁剪函数以及压缩函数, 得到宽750和高400的压缩图片, 返回的是图片的相对访问路径*/
    public String saveHouseImg(MultipartFile file,int userId,int houseNo) {
        String requestImgUrl = "";
        String fileSufix = file.getContentType().split("/")[1];
        try {
        String path = ResourceUtils.getURL("classpath:").getPath();
        String directoryPath = "/nginx/static/images/house/" + userId + "/" + houseNo;
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
                System.out.println("mkdir done");
            }
            String fileName = UUID.randomUUID().toString().replace("-", "").toLowerCase();
//            System.out.println(fileName);
            String realPath = directoryPath + "/" + fileName + "." + fileSufix;
//            System.out.println(realPath);
            File imgFile = new File(realPath);
            file.transferTo(imgFile);
            requestImgUrl = cutImg(imgFile,750,400);
            File destFile = new File(requestImgUrl);
            requestImgUrl = compressImg(destFile);
            requestImgUrl = getRequestImgUrl(requestImgUrl);
        }catch (Exception e){
            System.out.println("图片裁剪和存储过程发生二次元错误");
            e.printStackTrace();
        }
        return requestImgUrl;
    }

    @Override
    /*操作：存储文件通用，不管是图片还是视频，设置好位置就行, 参数2为文件相对/static/的路径 */
    /* 例如：想要存一个视频文件到 video/house/1/2/xxxxxx.mp4 ,
        只需设置relativePath文件夹名为 video/house/1/2 , 文件名是UUID生成的随机名字, 文件后缀类型是字符串截取的*/
    public String saveFile(MultipartFile file,String relativePath){
        String requestFileUrl = "";
        String fileSufix = file.getContentType().split("/")[1];
        try {
//            String path = ResourceUtils.getURL("classpath:").getPath();
            String directoryPath = "/nginx/static/"+relativePath;
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
                System.out.println("mkdir done");
            }
            String fileName = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            String realPath = directoryPath + "/" + fileName + "." + fileSufix;
            File imgFile = new File(realPath);
            file.transferTo(imgFile);
            requestFileUrl = getRequestImgUrl(imgFile.getPath());
            System.out.println(requestFileUrl);
        }catch (IOException e){
            System.out.println("SaveFile 发生错误");
            e.printStackTrace();
        }
        return requestFileUrl;
    }

    @Override
    /* 把File图像裁剪成指定宽高 , 返回的是文件的绝对路径 */
    public String cutImg(File file,int width,int height) throws IOException {
        String result = "";
        //将图片转成BufferedImage
        BufferedImage image = ImageIO.read(file);
        //获取原图宽、高
        int srcWidth = image.getWidth(null);
        int srcHeight = image.getHeight(null);
        int newWidth = 0, newHeight = 0;
        //x,y 为图片的左上角坐标
        int x = 0, y = 0;
        //算出宽高缩放比
        double scale_w = (double) width / srcWidth;
        double scale_h = (double) height / srcHeight;
//        System.out.println("scale_w=" + scale_w + ",scale_h=" + scale_h);
        // 按原比例缩放图片
        if (scale_w < scale_h) {
            newHeight = height;
            newWidth = (int) (srcWidth * scale_h);
            x = (newWidth - width) / 2;
        } else {
//            /*此版本为高>宽时仍裁剪*/
//            newHeight = (int) (srcHeight * scale_w);
//            newWidth = width;
//            y = (newHeight - height) / 2;
            /*此版本为不裁剪*/
            newHeight = height;
            newWidth = width;
            y = (newHeight - height) / 2;
        }

        BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        newImage.getGraphics()
                .drawImage(image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
        // 保存缩放后的图片,即原图保存
        String fileSufix = file.getName().substring(
                file.getName().lastIndexOf(".") + 1);
        String string = UUID.randomUUID().toString();

        File destFile = new File(file.getParent(), string + "." + fileSufix);

//        System.out.println(fileSufix);
//        System.out.println(destFile);
        // 保存裁剪后的图片
        ImageIO.write(newImage.getSubimage(x, y, width, height), fileSufix,
                destFile);
        file.delete();      //删除未裁剪的图片
        result = destFile.getPath();
        return result;
    }

    @Override
    /*压缩图片，之后删除以上两个版本的图片，保留压缩后的*/
    /* 对裁剪后的图片进行压缩质量, 并且把前面两个版本的图片删除 , 只保留这个压缩版本*/
    public String compressImg(File destFile) throws IOException{

        String requestImgUrl = "";
        ImageWriter imgWriter;
        ImageWriteParam imgWriteParams;
//        System.out.println("开始设定压缩图片参数");
        // 指定写图片的方式为 jpg(!!!之后要更改为适配所有图片类型的)
        imgWriter = ImageIO.getImageWritersByFormatName("jpg").next();
        imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
        // 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
        imgWriteParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        // 这里指定压缩的程度，参数Quality是取值0~1范围
        imgWriteParams.setCompressionQuality((float) 0.5);
        imgWriteParams.setProgressiveMode(ImageWriteParam.MODE_DISABLED);
        ColorModel colorModel = ImageIO.read(destFile).getColorModel();// ColorModel.getRGBDefault();
        imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(
                colorModel, colorModel.createCompatibleSampleModel(32, 32)));
//        System.out.println("结束设定压缩图片参数");
        if (!destFile.exists()) {
            System.out.println("Not Found Img File,文件不存在");
            throw new FileNotFoundException("Not Found Img File,文件不存在");
        } else {
//            System.out.println("图片转换前大小" + destFile.length() + "字节");
            // 保存压缩后的图片newFile
            String fileSufix = destFile.getName().substring(
                    destFile.getName().lastIndexOf(".") + 1);
            String string = UUID.randomUUID().toString();
            File newFile = new File(destFile.getParent(), string +"."+ fileSufix);
            FileOutputStream out = new FileOutputStream(newFile);
            imgWriter.reset();
            // 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何
            // OutputStream构造
            imgWriter.setOutput(ImageIO.createImageOutputStream(out));
            // 调用write方法，就可以向输入流写图片
            imgWriter.write(null, new IIOImage(ImageIO.read(destFile), null, null),
                    imgWriteParams);
            destFile.delete();
            out.flush();
            out.close();
            requestImgUrl = newFile.getPath();
            System.out.println(requestImgUrl);
//            System.out.println("图片转换后大小" + newFile.length() + "字节");
        }
        return requestImgUrl;
    }

    //  /nginx/static作为根目录
    /*操作： 根据相对于路径/static/删除文件*/
    @Override
    public String deleteFile(String relativePath) throws IOException{
        String result = "0";
//        String path = ResourceUtils.getURL("classpath:").getPath();
        String filePath = "/nginx/static/"+relativePath;
        File file = new File(filePath);
        if(file.exists()){
            file.delete();
            result="1";
        }
        return result;
    }


    /* 删除绝对路径前的一堆东西, 留下 /images/xxxx 这样的访问路径*/
    private String getRequestImgUrl(String path){
        int cutIndex = path.lastIndexOf("static") + 6;
//        System.out.println(path.substring(cutIndex));
        return path.substring(cutIndex);
    }
}
