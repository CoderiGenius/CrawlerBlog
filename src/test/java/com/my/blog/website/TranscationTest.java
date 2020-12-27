package com.my.blog.website;

import com.my.blog.website.exception.TipException;
import com.my.blog.website.modal.Vo.UserVo;
import com.my.blog.website.service.IUserService;
import com.my.blog.website.service.IOptionService;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.my.blog.website.modal.Vo.CommentVo;

import javax.annotation.Resource;

/**
 * 测试数据库事务
 * Created by BlueT on 2017/3/8.
 */
@MapperScan("com.my.blog.website.dao")
@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional(rollbackFor = TipException.class)
public class TranscationTest {

    @Resource
    private IUserService userService;

    @Resource
    private IOptionService optionService;

    @Resource
    private com.my.blog.website.service.ICommentService comment;

    @org.junit.Test
    //@Ignore
    public void test() {

        while(true) {
        CommentVo c = new CommentVo();

        c.setCid(6);
        c.setAuthor(getRandomString(5));
        c.setMail(getRandomString(3)+"@qq.com");
        c.setContent(getRandomString(30));
        c.setStatus("approved");
        c.setType("comment");
        //c.setCreated(Integer.parseInt(timestampToDate(System.currentTimeMillis())));
        comment.insertComment(c);
//            CommentVo c2 = new CommentVo();
//
//            c2.setCid(5);
//            c2.setAuthor(getRandomString(5));
//            c2.setMail(getRandomString(3)+"@qq.com");
//            c2.setContent(getRandomString(30));
//            c2.setStatus("approved");
//            c2.setType("comment");
//            //c.setCreated(Integer.parseInt(timestampToDate(System.currentTimeMillis())));
//            comment.insertComment(c2);
        }

//        UserVo user = new UserVo();
//        user.setUsername("wangqiang111");
//        user.setPassword("123456");
//        user.setEmail("8888");
//        userService.insertUser(user);
//        optionService.insertOption("site_keywords", "qwqwq");



    }
    public static String timestampToDate(long time) {
        String dateTime;
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timeLong = Long.valueOf(time);
        dateTime = simpleDateFormat.format(new java.util.Date(timeLong * 1000L));
        return dateTime;
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        java.util.Random random=new java.util.Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
