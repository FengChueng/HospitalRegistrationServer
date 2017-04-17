package com.zyl.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.zyl.bean.ResponseEntity;
import com.zyl.utils.Constant;

/**
 * 文件上传与下载
 * 
 * @author Administrator
 *
 */
@RestController
//@RequestMapping(value = "/")
public class FileController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
	
	@Value("${file.upload-path}")
    private String path;//文件路径
	
	@RequestMapping("/")    
    public ModelAndView index(){    
		return new ModelAndView("index");
  } 

//	/**
//	 * 上传文件
//	 * 
//	 * @param file
//	 * @return
//	 */
//	@RequestMapping("/upload")
//	@ResponseBody
//	public String uploadFile(@RequestParam("file") MultipartFile file) {
//		if (!file.isEmpty()) {
//			try {
//				/*
//				 * 这段代码执行完毕之后，图片上传到了工程的跟路径； 大家自己扩散下思维，如果我们想把图片上传到
//				 * d:/files大家是否能实现呢？ 等等;
//				 * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如： 1、文件路径； 2、文件名；
//				 * 3、文件格式; 4、文件大小的限制;
//				 */
//				BufferedOutputStream out = new BufferedOutputStream(
//						new FileOutputStream(new File(file.getOriginalFilename())));
//				out.write(file.getBytes());
//				out.flush();
//				out.close();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//				return "上传失败," + e.getMessage();
//			} catch (IOException e) {
//				e.printStackTrace();
//				return "上传失败," + e.getMessage();
//			}
//			return "上传成功";
//		} else {
//			return "上传失败，因为文件是空的.";
//		}
//	}

	/**
	 * 上传用户头像
	 * @param file
	 * @return
	 */
	@RequestMapping("/upload/userportrait")
	@ResponseBody
	public ResponseEntity<String> upload(@RequestParam("roncooFile") MultipartFile file) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>();
		if (file.isEmpty()) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg("文件内容为空");
			responseEntity.setData("");
			return responseEntity;
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		LOGGER.info("上传的文件名为:{}" + fileName);
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		LOGGER.info("上传的后缀名为:{}" + suffixName);
		// 文件上传路径
		String filePath = path;
		// 解决中文问题，liunx下中文路径，图片显示问题
		fileName = UUID.randomUUID() + suffixName;
		//将文件路径存至角色表中
		//TODO
		
		File dest = new File(filePath,fileName);
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			responseEntity.setStatus(Constant.SUCCESS);
			responseEntity.setMsg("上传成功!");
			responseEntity.setData(dest.getAbsolutePath());
		} catch (IllegalStateException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg("上传失败:"+e.getMessage());
			return responseEntity;
		} catch (IOException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg("上传失败:"+e.getMessage());
			return responseEntity;
		}
		return responseEntity;
	}

	// 多文件上传
	@Transactional
	@RequestMapping(value = "/upload/multi", method = RequestMethod.POST)  
    @ResponseBody  
    public ResponseEntity<String> handleFileUpload(HttpServletRequest request) {  
		ResponseEntity<String> responseEntity = new ResponseEntity<>();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)  
                .getFiles("file");  
        MultipartFile file = null;  
        BufferedOutputStream stream = null;  
        for (int i = 0; i < files.size(); ++i) {  
            file = files.get(i);  
            if (!file.isEmpty()) {  
                try {  
                    byte[] bytes = file.getBytes();  
                    stream = new BufferedOutputStream(new FileOutputStream(  
                            new File(file.getOriginalFilename())));  
                    stream.write(bytes);  
                    stream.close();  
                } catch (Exception e) {  
                    stream = null;  
                    responseEntity.setStatus(Constant.FIAL);
                    responseEntity.setMsg("上传第"+i+"失败:"+e.getMessage());
                    return responseEntity;
                }  
            } else {  
            	responseEntity.setStatus(Constant.FIAL);
                responseEntity.setMsg("上传失败:第"+i+"张图片为空");
                return responseEntity;
            }  
        }  
        return responseEntity;  
    }

	// 文件下载相关代码
	@RequestMapping("/download/apk")
	@ResponseBody
	public ResponseEntity<String> downloadFile(org.apache.catalina.servlet4preview.http.HttpServletRequest request,
			HttpServletResponse response) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>();
		String fileName = "test.apk";
		if (fileName != null) {
			// 当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
			String realPath = request.getServletContext().getRealPath("//static//");
			File file = new File(realPath, fileName);
			if (file.exists()) {
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					responseEntity.setMsg("success");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return responseEntity;
	}

}
