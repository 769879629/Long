package com.sy.controller;

import com.github.pagehelper.PageInfo;
import com.sy.model.Affiche;
import com.sy.model.Information;
import com.sy.model.base.BaseResult;
import com.sy.service.InformationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/inf")
public class InformationController {

    @Autowired
    private InformationService service;


    @RequiresPermissions("/inf/findlist.do")
    @RequestMapping("/findlist.do")
    public BaseResult findlist(int page, int limit)throws Exception{
        BaseResult baseResult = new BaseResult();
        PageInfo pageInfo = service.findlist(page, limit);
        if (pageInfo!=null){
            baseResult.setData(pageInfo);
            baseResult.setMsg("查询成功");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
            baseResult.setLimit(limit);
            baseResult.setPage(page);
            baseResult.setCount((int) pageInfo.getTotal());
        }else {
            baseResult.setMsg("查询失败");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }
        return baseResult;
    }


    @RequiresPermissions("/inf/findOne.do")
    @RequestMapping("/findOne.do")
    public Information findOne(Integer id)throws Exception{

        return service.selectOne(id);
    }

    @RequiresPermissions("/inf/addOne.do")
    @RequestMapping("/addOne.do")
    public BaseResult addOne(@RequestParam("file") MultipartFile partFile, HttpServletRequest request)throws Exception{
        System.out.println("11111111111111111111111");
        BaseResult baseResult = new BaseResult();
        String path = request.getServletContext().getRealPath("/uploads");
        String file = request.getParameter("file");
        String fileName = partFile.getOriginalFilename();
        File file1=new File("C:/uploads/"+fileName);
        InputStream inputStream = partFile.getInputStream();
        FileUtils.copyInputStreamToFile(inputStream, file1);
        if(inputStream!=null){
            inputStream.close();
        }
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String publisher = request.getParameter("publisher");
        String size1 = request.getParameter("size");
        Double size = Double.valueOf(request.getParameter("size"));

        System.out.println("file"+file1);

        Information information = new Information();
        information.setTitle(title);
        information.setContent(content);
        information.setPublisher(publisher);
        information.setTypeId(1);
        information.setTypeName("图片");
        information.setFileName(fileName);
        information.setFilePath("C:/uploads/"+fileName);
        information.setFileSize(size);

        Integer insertone = service.insertone(information);
        if (insertone>0){
            baseResult.setMsg("添加成功");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        }else {
            baseResult.setMsg("添加失败");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }
        return baseResult;
    }

    @RequiresPermissions("/inf/remove.do")
    @RequestMapping("/remove.do")
    public BaseResult remove(Integer id)throws Exception{
        BaseResult baseResult = new BaseResult();
        Integer id1 = service.deleteById(id);

        if (id1>0){
            baseResult.setMsg("删除成功");
            baseResult.setCode(BaseResult.CODE_SUCCESS);
        }else {
            baseResult.setMsg("删除失败");
            baseResult.setCode(BaseResult.CODE_FAILED);
        }
        return baseResult;
    }
    @RequiresPermissions("/inf/download.do")
    @RequestMapping("/download.do")
    public void download(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String filename = request.getParameter("fileName");
        System.out.println("fileName"+filename);
        String path = "C:/uploads";
        System.out.println("path"+path);
        FileInputStream fileInputStream = new FileInputStream(path+"/"+filename);
        ServletOutputStream outputStream = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment;filename="+filename);
        int i = 0;
        while((i=fileInputStream.read())!=-1){
            outputStream.write(i);
        }
        outputStream.flush();
        outputStream.close();
        fileInputStream.close();
    }

    @RequiresPermissions("/inf/download1.do")
    @RequestMapping("/download1.do")
    public void download(HttpServletRequest request,HttpServletResponse response,int id) throws Exception {
        Information information = service.selectOne(id);
        String fileName = information.getFileName();
        System.out.println("fileName"+fileName);
        String path = "C:/uploads";
        System.out.println("path"+path);
        FileInputStream fileInputStream = new FileInputStream(path+"/"+fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment;filename="+fileName);
        int i = 0;
        while((i=fileInputStream.read())!=-1){
            outputStream.write(i);
        }
        outputStream.flush();
        outputStream.close();
        fileInputStream.close();
    }
}
