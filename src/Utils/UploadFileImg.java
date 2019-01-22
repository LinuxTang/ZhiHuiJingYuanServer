package Utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UploadFileImg {

    private static UploadFileImg uploadFileImg;

    public static UploadFileImg instance(){
        if(uploadFileImg == null){
            uploadFileImg = new UploadFileImg();
        }
        return uploadFileImg;
    }

    public Map<String,String> UploadImg(HttpServletRequest request,String Path, String cusFileName) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //本地地址
        String rootPath = "G:/images";
        //临时保存文件地址
        String tempPath = request.getServletContext().getRealPath("/WEB-INF/temp");
//        //判断是普通表单，还是带文件上传的表单。
//        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        //保存字段
        Map<String,String> fieldsMap = new HashMap<String,String>();

        String uploadPathName = null;

        //创建文件File类
        File tempfile = new File(tempPath);
        if(!tempfile.exists()){
            //创建临时目录
            tempfile.mkdirs();
        }

        try{
            //使用apache文件上传组件处理文件上传步骤
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置工厂的缓存大小,当上传的文件超过缓存区的大小时，就会生成一个临时文件存放到指定的临时目录中
            factory.setSizeThreshold(1024*100); //设置为100KB
            //设置上传时生成的临时文件的保存目录
            factory.setRepository(tempfile);
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
//            //监听文件上传的进度
//            upload.setProgressListener(new ProgressListener() {
//                @Override
//                public void update(long pBytesRead, long pContentLength, int arg2) {
//                    System.out.println("文件大小为： "+ pContentLength+"，当前已处理："+pBytesRead);
//
//                    double f = pBytesRead/pContentLength;
//                    try{
//                        //类似于responsebody，但更适用,手机调用不会出错
//                        response.getWriter().write(f+"");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UFT-8");
            //3、判断提交上来的是否为表单的数据
            if(!ServletFileUpload.isMultipartContent(request)){
                return null;
            }

            //设置上传单个文件的大小的最大值，目前设置为2048*2048字节，也就是4MB
            upload.setFileSizeMax(2048*2048);
            //设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为40mb
            upload.setSizeMax(2048*2048*10);

            //4、使用servletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每个FileItem对应
            //一个Form表单的选项
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    fieldsMap.put(name,value);
                }
                else{
                    //如果fileitem中封装的是上传文件
                    //得到文件的名字
                    String filename = item.getName();
                    System.out.println("文件名：" + filename);
                    if(filename == null|| filename.trim().equals("")){
                        continue;
                    }
                    //注意不同的浏览器提交的文件名是不一样的
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("/")+1);
                    //得到上传文件的扩展名
                    String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
                    //如果需要限制文件的类型，那么可以通过文件扩展名来判断
                    System.out.println("上传文件扩展名是: "+fileExtName);
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //得到保存文件的名称
                    String saveFileName = cusFileName + "." + fileExtName;
                    fieldsMap.put("saveFileName",saveFileName);
                    //得到文件的保存目录
                    String  realSavePath = makePath(rootPath ,Path);
                    System.out.println(realSavePath);
                    //创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(realSavePath  + saveFileName);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while((len=in.read(buffer))>0){
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    //获得实际保存路径
                    uploadPathName = realSavePath + saveFileName;
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fieldsMap;
    }

//    private String makePath(String filename,String savePath){
//        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
//        int hashcode = filename.hashCode();
//        int dir1 = hashcode&0xf;  //0--15
//        int dir2 = (hashcode&0xf0)>>4;  //0-15
//        //构造新的保存目录
//        String dir = savePath + "/" + dir1 + "/" + dir2;  //upload/2/3  upload/3/5
//        //File既可以代表文件也可以代表目录
//        File file = new File(dir);
//        //如果目录不存在
//        if(!file.exists()){
//            //创建目录
//            file.mkdirs();
//        }
//        return dir;
//    }
    private String makePath(String savePath,String Path){
        //构造新的保存目录
        String dir = savePath + "/" + Path;  //upload/xxx
        //File既可以代表文件也可以代表目录
        File file = new File(dir);
        //如果目录不存在
        if(!file.exists()){
            //创建目录
            file.mkdirs();
        }
        return dir;
    }

}
