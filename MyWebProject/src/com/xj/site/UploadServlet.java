package com.xj.site;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	// �ϴ��ļ��洢Ŀ¼
	private static final String UPLOAD_DIRECTORY="upload";
	// �ϴ�����
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50M
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// ����Ƿ�Ϊ��ý���ϴ�
    	if(!ServletFileUpload.isMultipartContent(req)) {
		    // ���������ֹͣ
		    PrintWriter writer = resp.getWriter();
		    writer.println("Error: ����������� enctype=multipart/form-data");
		    writer.flush();
		    return;
    	}
    	//�����ϴ�����
    	DiskFileItemFactory  factory=new DiskFileItemFactory();
    	//�����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
    	factory.setSizeThreshold(MEMORY_THRESHOLD);
    	//������ʱ�洢Ŀ¼
    	factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
    	
    	ServletFileUpload upload=new ServletFileUpload(factory);
    	
    	//��������ļ��ϴ�ֵ
    	upload.setFileSizeMax(MAX_FILE_SIZE);
    	
    	//�����������ֵ�������ļ��ͱ������ݣ�
    	upload.setSizeMax(MAX_REQUEST_SIZE);
    	
    	//���Ĵ���
    	upload.setHeaderEncoding("UTF-8");
    	
    	// ������ʱ·�����洢�ϴ����ļ�
        // ���·����Ե�ǰӦ�õ�Ŀ¼
    	String uploadPath=req.getServletContext().getRealPath("./")+File.separator+UPLOAD_DIRECTORY;
    	
    	File uploadDir=new File(uploadPath);
    	if(!uploadDir.exists()) {
    		uploadDir.mkdir();
    	}
    	
    	try {
			List<FileItem> formItems=upload.parseRequest(req);
			if (formItems != null && formItems.size() > 0) {
                // ������������
                for (FileItem item : formItems) {
                    // �������ڱ����е��ֶ�
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // �ڿ���̨����ļ����ϴ�·��
                        System.out.println(filePath);
                        // �����ļ���Ӳ��
                        item.write(storeFile);
                        req.setAttribute("message",
                            "�ļ��ϴ��ɹ�!");
                    }
                }
            }
			
		} catch (Exception e) {
            req.setAttribute("message",
                    "������Ϣ: " + e.getMessage());
		}
    	
    	req.getServletContext().getRequestDispatcher("/message.jsp").forward(req, resp);
    	
    }
}