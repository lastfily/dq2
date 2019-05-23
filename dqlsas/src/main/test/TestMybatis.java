import com.yt.dql.mapper.ClassMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith( SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-db.xml"})
public class TestMybatis {
    @Resource
    public ClassMapper clam;
    @Test
    public void duoQuery(){

        System.out.println(clam.selectByPrimaryKey(3));

    }
}
