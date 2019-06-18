/**
 * 测试dao层的工作
 * 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 * 3、直接autowired要使用的组件即可
 */

import com.cqut.crud.bean.Admin;
import com.cqut.crud.dao.*;
import com.cqut.crud.util.AesUtil;
import com.cqut.crud.util.ParseSystemUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    StudentStatusMapper studentStatusMapper;

    @Autowired
    SchoolMapper schoolMapper;

    @Autowired
    FamilyMemberMapper familyMemberMapper;

    @Autowired
    SqlSession sqlSession;


    /**
     * 测试DepartmentMapper
     */


    @Test
    public void testCRUD() {
        String content = "123456";
        String password = "123";
        // 加密
        byte[] encrypt = AesUtil.encrypt(content, password);

        //如果想要加密内容不显示乱码，可以先将密文转换为16进制
        String hexStrResult = ParseSystemUtil.parseByte2HexStr(encrypt);
        System.out.println("16进制的密文："  + hexStrResult);


        adminMapper.insertSelective(new Admin(2,"管理员小张","002",hexStrResult,"phone","002@qq.com"));

        /*StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        for (int i = 0; i < 10; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            String idCard = IdCardGeneration.generate();
            studentMapper.insertSelective(new Student(null, uid, 1,idCard, VeDate.idCardToDate(idCard), null,
                    null, null, null, null, null, null, null, null,
                    null, null, uid + "@qq.com", null, "123456", null, new Date(), null, 1));
        }*/

       /* String uid = UUID.randomUUID().toString().substring(0,5);

        schoolMapper.insertSelective(new School(null,uid,"巴南实验中学","初中",1,1));*/


    }

}
